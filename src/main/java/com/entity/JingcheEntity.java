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
 * 警车信息
 *
 * @author 
 * @email
 */
@TableName("jingche")
public class JingcheEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JingcheEntity() {

	}

	public JingcheEntity(T t) {
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
     * 警车编号
     */
    @ColumnInfo(comment="警车编号",type="varchar(200)")
    @TableField(value = "jingche_uuid_number")

    private String jingcheUuidNumber;


    /**
     * 警车名称
     */
    @ColumnInfo(comment="警车名称",type="varchar(200)")
    @TableField(value = "jingche_name")

    private String jingcheName;


    /**
     * 警车类型
     */
    @ColumnInfo(comment="警车类型",type="int(11)")
    @TableField(value = "jingche_types")

    private Integer jingcheTypes;


    /**
     * 警车状态
     */
    @ColumnInfo(comment="警车状态",type="int(11)")
    @TableField(value = "status_types")

    private Integer statusTypes;


    /**
     * 警车详情
     */
    @ColumnInfo(comment="警车详情",type="longtext")
    @TableField(value = "jingche_content")

    private String jingcheContent;


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
        return "Jingche{" +
            ", id=" + id +
            ", jingcheUuidNumber=" + jingcheUuidNumber +
            ", jingcheName=" + jingcheName +
            ", jingcheTypes=" + jingcheTypes +
            ", statusTypes=" + statusTypes +
            ", jingcheContent=" + jingcheContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
