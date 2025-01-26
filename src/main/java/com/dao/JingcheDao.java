package com.dao;

import com.entity.JingcheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JingcheView;

/**
 * 警车信息 Dao 接口
 *
 * @author 
 */
public interface JingcheDao extends BaseMapper<JingcheEntity> {

   List<JingcheView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
