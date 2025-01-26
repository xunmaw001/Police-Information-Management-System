package com.dao;

import com.entity.XingzhengrenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XingzhengrenyuanView;

/**
 * 行政人员 Dao 接口
 *
 * @author 
 */
public interface XingzhengrenyuanDao extends BaseMapper<XingzhengrenyuanEntity> {

   List<XingzhengrenyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
