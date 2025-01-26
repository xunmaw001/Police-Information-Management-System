package com.entity.model;

import com.entity.JiechexinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 借车记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiechexinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 警车
     */
    private Integer jingcheId;


    /**
     * 警员
     */
    private Integer yonghuId;


    /**
     * 借车原因
     */
    private String jiechexinxiText;


    /**
     * 借车日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jiechexinxiTime;


    /**
     * 借车时间/天
     */
    private Integer jiechexinxiNum;


    /**
     * 借车状态
     */
    private Integer jiechexinxiYesnoTypes;


    /**
     * 审核回复
     */
    private String jiechexinxiYesnoText;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
