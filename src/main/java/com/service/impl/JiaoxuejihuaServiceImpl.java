package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.dao.JiaoxuejihuaDao;
import com.entity.JiaoxuejihuaEntity;
import com.service.JiaoxuejihuaService;
import com.entity.view.JiaoxuejihuaView;

/**
 * 教学计划 服务实现类
 */
@Service("jiaoxuejihuaService")
@Transactional
public class JiaoxuejihuaServiceImpl extends ServiceImpl<JiaoxuejihuaDao, JiaoxuejihuaEntity> implements JiaoxuejihuaService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<JiaoxuejihuaView> page =new Query<JiaoxuejihuaView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
