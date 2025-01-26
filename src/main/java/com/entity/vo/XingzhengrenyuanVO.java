package com.entity.vo;

import com.entity.XingzhengrenyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 行政人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xingzhengrenyuan")
public class XingzhengrenyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 人员名称
     */

    @TableField(value = "xingzhengrenyuan_name")
    private String xingzhengrenyuanName;


    /**
     * 人员手机号
     */

    @TableField(value = "xingzhengrenyuan_phone")
    private String xingzhengrenyuanPhone;


    /**
     * 人员身份证号
     */

    @TableField(value = "xingzhengrenyuan_id_number")
    private String xingzhengrenyuanIdNumber;


    /**
     * 人员头像
     */

    @TableField(value = "xingzhengrenyuan_photo")
    private String xingzhengrenyuanPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 人员邮箱
     */

    @TableField(value = "xingzhengrenyuan_email")
    private String xingzhengrenyuanEmail;


    /**
     * 逻辑删除
     */

    @TableField(value = "xingzhengrenyuan_delete")
    private Integer xingzhengrenyuanDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：人员名称
	 */
    public String getXingzhengrenyuanName() {
        return xingzhengrenyuanName;
    }


    /**
	 * 获取：人员名称
	 */

    public void setXingzhengrenyuanName(String xingzhengrenyuanName) {
        this.xingzhengrenyuanName = xingzhengrenyuanName;
    }
    /**
	 * 设置：人员手机号
	 */
    public String getXingzhengrenyuanPhone() {
        return xingzhengrenyuanPhone;
    }


    /**
	 * 获取：人员手机号
	 */

    public void setXingzhengrenyuanPhone(String xingzhengrenyuanPhone) {
        this.xingzhengrenyuanPhone = xingzhengrenyuanPhone;
    }
    /**
	 * 设置：人员身份证号
	 */
    public String getXingzhengrenyuanIdNumber() {
        return xingzhengrenyuanIdNumber;
    }


    /**
	 * 获取：人员身份证号
	 */

    public void setXingzhengrenyuanIdNumber(String xingzhengrenyuanIdNumber) {
        this.xingzhengrenyuanIdNumber = xingzhengrenyuanIdNumber;
    }
    /**
	 * 设置：人员头像
	 */
    public String getXingzhengrenyuanPhoto() {
        return xingzhengrenyuanPhoto;
    }


    /**
	 * 获取：人员头像
	 */

    public void setXingzhengrenyuanPhoto(String xingzhengrenyuanPhoto) {
        this.xingzhengrenyuanPhoto = xingzhengrenyuanPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：人员邮箱
	 */
    public String getXingzhengrenyuanEmail() {
        return xingzhengrenyuanEmail;
    }


    /**
	 * 获取：人员邮箱
	 */

    public void setXingzhengrenyuanEmail(String xingzhengrenyuanEmail) {
        this.xingzhengrenyuanEmail = xingzhengrenyuanEmail;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getXingzhengrenyuanDelete() {
        return xingzhengrenyuanDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setXingzhengrenyuanDelete(Integer xingzhengrenyuanDelete) {
        this.xingzhengrenyuanDelete = xingzhengrenyuanDelete;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
