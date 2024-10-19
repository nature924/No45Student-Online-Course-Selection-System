
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 选课
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xuanke")
public class XuankeController {
    private static final Logger logger = LoggerFactory.getLogger(XuankeController.class);

    @Autowired
    private XuankeService xuankeService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private KechengService kechengService;
    @Autowired
    private XueshengService xueshengService;

    @Autowired
    private LaoshiService laoshiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("老师".equals(role))
            params.put("laoshiId",request.getSession().getAttribute("userId"));
        else if("学生".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = xuankeService.queryPage(params);

        //字典表数据转换
        List<XuankeView> list =(List<XuankeView>)page.getList();
        for(XuankeView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XuankeEntity xuanke = xuankeService.selectById(id);
        if(xuanke !=null){
            //entity转view
            XuankeView view = new XuankeView();
            BeanUtils.copyProperties( xuanke , view );//把实体数据重构到view中

                //级联表
                KechengEntity kecheng = kechengService.selectById(xuanke.getKechengId());
                if(kecheng != null){
                    BeanUtils.copyProperties( kecheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setKechengId(kecheng.getId());
                }
                //级联表
                XueshengEntity xuesheng = xueshengService.selectById(xuanke.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XuankeEntity xuanke, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xuanke:{}",this.getClass().getName(),xuanke.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            xuanke.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XuankeEntity> queryWrapper = new EntityWrapper<XuankeEntity>()
            .eq("xuesheng_id", xuanke.getXueshengId())
            .eq("kecheng_id", xuanke.getKechengId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuankeEntity xuankeEntity = xuankeService.selectOne(queryWrapper);
        if(xuankeEntity==null){
            KechengEntity kechengEntity = kechengService.selectById(xuanke.getKechengId());
            if(kechengEntity == null)
                return R.error("查不到此课程");
            Integer kechengRenshu = kechengEntity.getKechengRenshu();
            List<XuankeEntity> xuankeEntities = xuankeService.selectList(new EntityWrapper<XuankeEntity>().eq("kecheng_id", xuanke.getKechengId()));
            if(xuankeEntities.size() >=kechengRenshu)
                return R.error("课程选课人数已满,请选择其他课程");

            xuanke.setInsertTime(new Date());
            xuanke.setCreateTime(new Date());
            xuankeService.insert(xuanke);
            return R.ok();
        }else {
            return R.error(511,"该学生已经选过此课程了,无法重复选课");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XuankeEntity xuanke, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xuanke:{}",this.getClass().getName(),xuanke.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            xuanke.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<XuankeEntity> queryWrapper = new EntityWrapper<XuankeEntity>()
            .notIn("id",xuanke.getId())
            .andNew()
            .eq("xuesheng_id", xuanke.getXueshengId())
            .eq("kecheng_id", xuanke.getKechengId())
            .eq("xuanke_uuid_number", xuanke.getXuankeUuidNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuankeEntity xuankeEntity = xuankeService.selectOne(queryWrapper);
        if(xuankeEntity==null){
            KechengEntity kechengEntity = kechengService.selectById(xuanke.getKechengId());
            if(kechengEntity == null)
                return R.error("查不到此课程");
            Integer kechengRenshu = kechengEntity.getKechengRenshu();
            List<XuankeEntity> xuankeEntities = xuankeService.selectList(new EntityWrapper<XuankeEntity>().eq("kecheng_id", xuanke.getKechengId()));
            if(xuankeEntities.size() >=kechengRenshu)
                return R.error("课程选课人数已满,请选择其他课程");


            xuankeService.updateById(xuanke);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该学生已经选过此课程了,无法重复选课");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xuankeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<XuankeEntity> xuankeList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XuankeEntity xuankeEntity = new XuankeEntity();
//                            xuankeEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            xuankeEntity.setKechengId(Integer.valueOf(data.get(0)));   //课程 要改的
//                            xuankeEntity.setXuankeUuidNumber(data.get(0));                    //选课编号 要改的
//                            xuankeEntity.setInsertTime(date);//时间
//                            xuankeEntity.setCreateTime(date);//时间
                            xuankeList.add(xuankeEntity);


                            //把要查询是否重复的字段放入map中
                                //选课编号
                                if(seachFields.containsKey("xuankeUuidNumber")){
                                    List<String> xuankeUuidNumber = seachFields.get("xuankeUuidNumber");
                                    xuankeUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xuankeUuidNumber = new ArrayList<>();
                                    xuankeUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xuankeUuidNumber",xuankeUuidNumber);
                                }
                        }

                        //查询是否重复
                         //选课编号
                        List<XuankeEntity> xuankeEntities_xuankeUuidNumber = xuankeService.selectList(new EntityWrapper<XuankeEntity>().in("xuanke_uuid_number", seachFields.get("xuankeUuidNumber")));
                        if(xuankeEntities_xuankeUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XuankeEntity s:xuankeEntities_xuankeUuidNumber){
                                repeatFields.add(s.getXuankeUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [选课编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xuankeService.insertBatch(xuankeList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
