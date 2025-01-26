package com.entity.model;

import com.entity.JingcheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 警车信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JingcheModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 警车编号
     */
    private String jingcheUuidNumber;


    /**
     * 警车名称
     */
    private String jingcheName;


    /**
     * 警车类型
     */
    private Integer jingcheTypes;


    /**
     * 警车状态
     */
    private Integer statusTypes;


    /**
     * 警车详情
     */
    private String jingcheContent;


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
	 * 获取：警车编号
	 */
    public String getJingcheUuidNumber() {
        return jingcheUuidNumber;
    }


    /**
	 * 设置：警车编号
	 */
    public void setJingcheUuidNumber(String jingcheUuidNumber) {
        this.jingcheUuidNumber = jingcheUuidNumber;
    }
    /**
	 * 获取：警车名称
	 */
    public String getJingcheName() {
        return jingcheName;
    }


    /**
	 * 设置：警车名称
	 */
    public void setJingcheName(String jingcheName) {
        this.jingcheName = jingcheName;
    }
    /**
	 * 获取：警车类型
	 */
    public Integer getJingcheTypes() {
        return jingcheTypes;
    }


    /**
	 * 设置：警车类型
	 */
    public void setJingcheTypes(Integer jingcheTypes) {
        this.jingcheTypes = jingcheTypes;
    }
    /**
	 * 获取：警车状态
	 */
    public Integer getStatusTypes() {
        return statusTypes;
    }


    /**
	 * 设置：警车状态
	 */
    public void setStatusTypes(Integer statusTypes) {
        this.statusTypes = statusTypes;
    }
    /**
	 * 获取：警车详情
	 */
    public String getJingcheContent() {
        return jingcheContent;
    }


    /**
	 * 设置：警车详情
	 */
    public void setJingcheContent(String jingcheContent) {
        this.jingcheContent = jingcheContent;
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
