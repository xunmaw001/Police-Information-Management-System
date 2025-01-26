package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 借车记录
 *
 * @author 
 * @email
 */
@TableName("jiechexinxi")
public class JiechexinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiechexinxiEntity() {

	}

	public JiechexinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 警车
     */
    @ColumnInfo(comment="警车",type="int(11)")
    @TableField(value = "jingche_id")

    private Integer jingcheId;


    /**
     * 警员
     */
    @ColumnInfo(comment="警员",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 借车原因
     */
    @ColumnInfo(comment="借车原因",type="longtext")
    @TableField(value = "jiechexinxi_text")

    private String jiechexinxiText;


    /**
     * 借车日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="借车日期",type="date")
    @TableField(value = "jiechexinxi_time")

    private Date jiechexinxiTime;


    /**
     * 借车时间/天
     */
    @ColumnInfo(comment="借车时间/天",type="int(11)")
    @TableField(value = "jiechexinxi_num")

    private Integer jiechexinxiNum;


    /**
     * 借车状态
     */
    @ColumnInfo(comment="借车状态",type="int(11)")
    @TableField(value = "jiechexinxi_yesno_types")

    private Integer jiechexinxiYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "jiechexinxi_yesno_text")

    private String jiechexinxiYesnoText;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：警车
	 */
    public Integer getJingcheId() {
        return jingcheId;
    }
    /**
	 * 设置：警车
	 */

    public void setJingcheId(Integer jingcheId) {
        this.jingcheId = jingcheId;
    }
    /**
	 * 获取：警员
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：警员
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：借车原因
	 */
    public String getJiechexinxiText() {
        return jiechexinxiText;
    }
    /**
	 * 设置：借车原因
	 */

    public void setJiechexinxiText(String jiechexinxiText) {
        this.jiechexinxiText = jiechexinxiText;
    }
    /**
	 * 获取：借车日期
	 */
    public Date getJiechexinxiTime() {
        return jiechexinxiTime;
    }
    /**
	 * 设置：借车日期
	 */

    public void setJiechexinxiTime(Date jiechexinxiTime) {
        this.jiechexinxiTime = jiechexinxiTime;
    }
    /**
	 * 获取：借车时间/天
	 */
    public Integer getJiechexinxiNum() {
        return jiechexinxiNum;
    }
    /**
	 * 设置：借车时间/天
	 */

    public void setJiechexinxiNum(Integer jiechexinxiNum) {
        this.jiechexinxiNum = jiechexinxiNum;
    }
    /**
	 * 获取：借车状态
	 */
    public Integer getJiechexinxiYesnoTypes() {
        return jiechexinxiYesnoTypes;
    }
    /**
	 * 设置：借车状态
	 */

    public void setJiechexinxiYesnoTypes(Integer jiechexinxiYesnoTypes) {
        this.jiechexinxiYesnoTypes = jiechexinxiYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getJiechexinxiYesnoText() {
        return jiechexinxiYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setJiechexinxiYesnoText(String jiechexinxiYesnoText) {
        this.jiechexinxiYesnoText = jiechexinxiYesnoText;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jiechexinxi{" +
            ", id=" + id +
            ", jingcheId=" + jingcheId +
            ", yonghuId=" + yonghuId +
            ", jiechexinxiText=" + jiechexinxiText +
            ", jiechexinxiTime=" + DateUtil.convertString(jiechexinxiTime,"yyyy-MM-dd") +
            ", jiechexinxiNum=" + jiechexinxiNum +
            ", jiechexinxiYesnoTypes=" + jiechexinxiYesnoTypes +
            ", jiechexinxiYesnoText=" + jiechexinxiYesnoText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
