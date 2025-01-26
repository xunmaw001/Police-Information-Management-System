package com.dao;

import com.entity.JiechexinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiechexinxiView;

/**
 * 借车记录 Dao 接口
 *
 * @author 
 */
public interface JiechexinxiDao extends BaseMapper<JiechexinxiEntity> {

   List<JiechexinxiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
