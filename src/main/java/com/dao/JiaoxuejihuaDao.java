package com.dao;

import com.entity.JiaoxuejihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaoxuejihuaView;

/**
 * 教学计划 Dao 接口
 *
 * @author 
 */
public interface JiaoxuejihuaDao extends BaseMapper<JiaoxuejihuaEntity> {

   List<JiaoxuejihuaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
