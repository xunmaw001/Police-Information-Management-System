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
 * 行政人员
 *
 * @author 
 * @email
 */
@TableName("xingzhengrenyuan")
public class XingzhengrenyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XingzhengrenyuanEntity() {

	}

	public XingzhengrenyuanEntity(T t) {
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
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 人员名称
     */
    @ColumnInfo(comment="人员名称",type="varchar(200)")
    @TableField(value = "xingzhengrenyuan_name")

    private String xingzhengrenyuanName;


    /**
     * 人员手机号
     */
    @ColumnInfo(comment="人员手机号",type="varchar(200)")
    @TableField(value = "xingzhengrenyuan_phone")

    private String xingzhengrenyuanPhone;


    /**
     * 人员身份证号
     */
    @ColumnInfo(comment="人员身份证号",type="varchar(200)")
    @TableField(value = "xingzhengrenyuan_id_number")

    private String xingzhengrenyuanIdNumber;


    /**
     * 人员头像
     */
    @ColumnInfo(comment="人员头像",type="varchar(200)")
    @TableField(value = "xingzhengrenyuan_photo")

    private String xingzhengrenyuanPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 人员邮箱
     */
    @ColumnInfo(comment="人员邮箱",type="varchar(200)")
    @TableField(value = "xingzhengrenyuan_email")

    private String xingzhengrenyuanEmail;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "xingzhengrenyuan_delete")

    private Integer xingzhengrenyuanDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：人员名称
	 */
    public String getXingzhengrenyuanName() {
        return xingzhengrenyuanName;
    }
    /**
	 * 设置：人员名称
	 */

    public void setXingzhengrenyuanName(String xingzhengrenyuanName) {
        this.xingzhengrenyuanName = xingzhengrenyuanName;
    }
    /**
	 * 获取：人员手机号
	 */
    public String getXingzhengrenyuanPhone() {
        return xingzhengrenyuanPhone;
    }
    /**
	 * 设置：人员手机号
	 */

    public void setXingzhengrenyuanPhone(String xingzhengrenyuanPhone) {
        this.xingzhengrenyuanPhone = xingzhengrenyuanPhone;
    }
    /**
	 * 获取：人员身份证号
	 */
    public String getXingzhengrenyuanIdNumber() {
        return xingzhengrenyuanIdNumber;
    }
    /**
	 * 设置：人员身份证号
	 */

    public void setXingzhengrenyuanIdNumber(String xingzhengrenyuanIdNumber) {
        this.xingzhengrenyuanIdNumber = xingzhengrenyuanIdNumber;
    }
    /**
	 * 获取：人员头像
	 */
    public String getXingzhengrenyuanPhoto() {
        return xingzhengrenyuanPhoto;
    }
    /**
	 * 设置：人员头像
	 */

    public void setXingzhengrenyuanPhoto(String xingzhengrenyuanPhoto) {
        this.xingzhengrenyuanPhoto = xingzhengrenyuanPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：人员邮箱
	 */
    public String getXingzhengrenyuanEmail() {
        return xingzhengrenyuanEmail;
    }
    /**
	 * 设置：人员邮箱
	 */

    public void setXingzhengrenyuanEmail(String xingzhengrenyuanEmail) {
        this.xingzhengrenyuanEmail = xingzhengrenyuanEmail;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getXingzhengrenyuanDelete() {
        return xingzhengrenyuanDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setXingzhengrenyuanDelete(Integer xingzhengrenyuanDelete) {
        this.xingzhengrenyuanDelete = xingzhengrenyuanDelete;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：添加时间
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
        return "Xingzhengrenyuan{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", xingzhengrenyuanName=" + xingzhengrenyuanName +
            ", xingzhengrenyuanPhone=" + xingzhengrenyuanPhone +
            ", xingzhengrenyuanIdNumber=" + xingzhengrenyuanIdNumber +
            ", xingzhengrenyuanPhoto=" + xingzhengrenyuanPhoto +
            ", sexTypes=" + sexTypes +
            ", xingzhengrenyuanEmail=" + xingzhengrenyuanEmail +
            ", xingzhengrenyuanDelete=" + xingzhengrenyuanDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
