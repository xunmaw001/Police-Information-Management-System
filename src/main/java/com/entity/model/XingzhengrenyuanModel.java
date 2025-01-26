package com.entity.model;

import com.entity.XingzhengrenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 行政人员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XingzhengrenyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 人员名称
     */
    private String xingzhengrenyuanName;


    /**
     * 人员手机号
     */
    private String xingzhengrenyuanPhone;


    /**
     * 人员身份证号
     */
    private String xingzhengrenyuanIdNumber;


    /**
     * 人员头像
     */
    private String xingzhengrenyuanPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 人员邮箱
     */
    private String xingzhengrenyuanEmail;


    /**
     * 逻辑删除
     */
    private Integer xingzhengrenyuanDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
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

    }
