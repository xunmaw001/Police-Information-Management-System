package com.entity.vo;

import com.entity.JiechexinxiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 借车记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiechexinxi")
public class JiechexinxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 警车
     */

    @TableField(value = "jingche_id")
    private Integer jingcheId;


    /**
     * 警员
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 借车原因
     */

    @TableField(value = "jiechexinxi_text")
    private String jiechexinxiText;


    /**
     * 借车日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jiechexinxi_time")
    private Date jiechexinxiTime;


    /**
     * 借车时间/天
     */

    @TableField(value = "jiechexinxi_num")
    private Integer jiechexinxiNum;


    /**
     * 借车状态
     */

    @TableField(value = "jiechexinxi_yesno_types")
    private Integer jiechexinxiYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "jiechexinxi_yesno_text")
    private String jiechexinxiYesnoText;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：警车
	 */
    public Integer getJingcheId() {
        return jingcheId;
    }


    /**
	 * 获取：警车
	 */

    public void setJingcheId(Integer jingcheId) {
        this.jingcheId = jingcheId;
    }
    /**
	 * 设置：警员
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：警员
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：借车原因
	 */
    public String getJiechexinxiText() {
        return jiechexinxiText;
    }


    /**
	 * 获取：借车原因
	 */

    public void setJiechexinxiText(String jiechexinxiText) {
        this.jiechexinxiText = jiechexinxiText;
    }
    /**
	 * 设置：借车日期
	 */
    public Date getJiechexinxiTime() {
        return jiechexinxiTime;
    }


    /**
	 * 获取：借车日期
	 */

    public void setJiechexinxiTime(Date jiechexinxiTime) {
        this.jiechexinxiTime = jiechexinxiTime;
    }
    /**
	 * 设置：借车时间/天
	 */
    public Integer getJiechexinxiNum() {
        return jiechexinxiNum;
    }


    /**
	 * 获取：借车时间/天
	 */

    public void setJiechexinxiNum(Integer jiechexinxiNum) {
        this.jiechexinxiNum = jiechexinxiNum;
    }
    /**
	 * 设置：借车状态
	 */
    public Integer getJiechexinxiYesnoTypes() {
        return jiechexinxiYesnoTypes;
    }


    /**
	 * 获取：借车状态
	 */

    public void setJiechexinxiYesnoTypes(Integer jiechexinxiYesnoTypes) {
        this.jiechexinxiYesnoTypes = jiechexinxiYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getJiechexinxiYesnoText() {
        return jiechexinxiYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setJiechexinxiYesnoText(String jiechexinxiYesnoText) {
        this.jiechexinxiYesnoText = jiechexinxiYesnoText;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
