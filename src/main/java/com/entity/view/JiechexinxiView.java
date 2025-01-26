package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JiechexinxiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 借车记录
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jiechexinxi")
public class JiechexinxiView extends JiechexinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 借车状态的值
	*/
	@ColumnInfo(comment="借车状态的字典表值",type="varchar(200)")
	private String jiechexinxiYesnoValue;

	//级联表 警车信息
		/**
		* 警车编号
		*/

		@ColumnInfo(comment="警车编号",type="varchar(200)")
		private String jingcheUuidNumber;
		/**
		* 警车名称
		*/

		@ColumnInfo(comment="警车名称",type="varchar(200)")
		private String jingcheName;
		/**
		* 警车类型
		*/
		@ColumnInfo(comment="警车类型",type="int(11)")
		private Integer jingcheTypes;
			/**
			* 警车类型的值
			*/
			@ColumnInfo(comment="警车类型的字典表值",type="varchar(200)")
			private String jingcheValue;
		/**
		* 警车状态
		*/
		@ColumnInfo(comment="警车状态",type="int(11)")
		private Integer statusTypes;
			/**
			* 警车状态的值
			*/
			@ColumnInfo(comment="警车状态的字典表值",type="varchar(200)")
			private String statusValue;
		/**
		* 警车详情
		*/

		@ColumnInfo(comment="警车详情",type="longtext")
		private String jingcheContent;
	//级联表 警员
		/**
		* 警员名称
		*/

		@ColumnInfo(comment="警员名称",type="varchar(200)")
		private String yonghuName;
		/**
		* 警员手机号
		*/

		@ColumnInfo(comment="警员手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 警员身份证号
		*/

		@ColumnInfo(comment="警员身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 警员头像
		*/

		@ColumnInfo(comment="警员头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 警员邮箱
		*/

		@ColumnInfo(comment="警员邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;



	public JiechexinxiView() {

	}

	public JiechexinxiView(JiechexinxiEntity jiechexinxiEntity) {
		try {
			BeanUtils.copyProperties(this, jiechexinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 借车状态的值
	*/
	public String getJiechexinxiYesnoValue() {
		return jiechexinxiYesnoValue;
	}
	/**
	* 设置： 借车状态的值
	*/
	public void setJiechexinxiYesnoValue(String jiechexinxiYesnoValue) {
		this.jiechexinxiYesnoValue = jiechexinxiYesnoValue;
	}


	//级联表的get和set 警车信息

		/**
		* 获取： 警车编号
		*/
		public String getJingcheUuidNumber() {
			return jingcheUuidNumber;
		}
		/**
		* 设置： 警车编号
		*/
		public void setJingcheUuidNumber(String jingcheUuidNumber) {
			this.jingcheUuidNumber = jingcheUuidNumber;
		}

		/**
		* 获取： 警车名称
		*/
		public String getJingcheName() {
			return jingcheName;
		}
		/**
		* 设置： 警车名称
		*/
		public void setJingcheName(String jingcheName) {
			this.jingcheName = jingcheName;
		}
		/**
		* 获取： 警车类型
		*/
		public Integer getJingcheTypes() {
			return jingcheTypes;
		}
		/**
		* 设置： 警车类型
		*/
		public void setJingcheTypes(Integer jingcheTypes) {
			this.jingcheTypes = jingcheTypes;
		}


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
		/**
		* 获取： 警车状态
		*/
		public Integer getStatusTypes() {
			return statusTypes;
		}
		/**
		* 设置： 警车状态
		*/
		public void setStatusTypes(Integer statusTypes) {
			this.statusTypes = statusTypes;
		}


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

		/**
		* 获取： 警车详情
		*/
		public String getJingcheContent() {
			return jingcheContent;
		}
		/**
		* 设置： 警车详情
		*/
		public void setJingcheContent(String jingcheContent) {
			this.jingcheContent = jingcheContent;
		}
	//级联表的get和set 警员

		/**
		* 获取： 警员名称
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 警员名称
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 警员手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 警员手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 警员身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 警员身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 警员头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 警员头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 警员邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 警员邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "JiechexinxiView{" +
			", jiechexinxiYesnoValue=" + jiechexinxiYesnoValue +
			", jingcheUuidNumber=" + jingcheUuidNumber +
			", jingcheName=" + jingcheName +
			", jingcheContent=" + jingcheContent +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
