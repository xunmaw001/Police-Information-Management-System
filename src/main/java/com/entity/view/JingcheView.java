package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JingcheEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 警车信息
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jingche")
public class JingcheView extends JingcheEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 警车类型的值
	*/
	@ColumnInfo(comment="警车类型的字典表值",type="varchar(200)")
	private String jingcheValue;
	/**
	* 警车状态的值
	*/
	@ColumnInfo(comment="警车状态的字典表值",type="varchar(200)")
	private String statusValue;




	public JingcheView() {

	}

	public JingcheView(JingcheEntity jingcheEntity) {
		try {
			BeanUtils.copyProperties(this, jingcheEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 警车类型的值
	*/
	public String getJingcheValue() {
		return jingcheValue;
	}
	/**
	* 设置： 警车类型的值
	*/
	public void setJingcheValue(String jingcheValue) {
		this.jingcheValue = jingcheValue;
	}
	//当前表的
	/**
	* 获取： 警车状态的值
	*/
	public String getStatusValue() {
		return statusValue;
	}
	/**
	* 设置： 警车状态的值
	*/
	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}




	@Override
	public String toString() {
		return "JingcheView{" +
			", jingcheValue=" + jingcheValue +
			", statusValue=" + statusValue +
			"} " + super.toString();
	}
}
