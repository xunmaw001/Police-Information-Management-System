package com.entity.model;

import com.entity.RenliziyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 人力资源
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class RenliziyuanModel implements Serializable {
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
    private String renliziyuanName;


    /**
     * 人员手机号
     */
    private String renliziyuanPhone;


    /**
     * 人员身份证号
     */
    private String renliziyuanIdNumber;


    /**
     * 人员头像
     */
    private String renliziyuanPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 人员邮箱
     */
    private String renliziyuanEmail;


    /**
     * 逻辑删除
     */
    private Integer renliziyuanDelete;


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
    public String getRenliziyuanName() {
        return renliziyuanName;
    }


    /**
	 * 设置：人员名称
	 */
    public void setRenliziyuanName(String renliziyuanName) {
        this.renliziyuanName = renliziyuanName;
    }
    /**
	 * 获取：人员手机号
	 */
    public String getRenliziyuanPhone() {
        return renliziyuanPhone;
    }


    /**
	 * 设置：人员手机号
	 */
    public void setRenliziyuanPhone(String renliziyuanPhone) {
        this.renliziyuanPhone = renliziyuanPhone;
    }
    /**
	 * 获取：人员身份证号
	 */
    public String getRenliziyuanIdNumber() {
        return renliziyuanIdNumber;
    }


    /**
	 * 设置：人员身份证号
	 */
    public void setRenliziyuanIdNumber(String renliziyuanIdNumber) {
        this.renliziyuanIdNumber = renliziyuanIdNumber;
    }
    /**
	 * 获取：人员头像
	 */
    public String getRenliziyuanPhoto() {
        return renliziyuanPhoto;
    }


    /**
	 * 设置：人员头像
	 */
    public void setRenliziyuanPhoto(String renliziyuanPhoto) {
        this.renliziyuanPhoto = renliziyuanPhoto;
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
    public String getRenliziyuanEmail() {
        return renliziyuanEmail;
    }


    /**
	 * 设置：人员邮箱
	 */
    public void setRenliziyuanEmail(String renliziyuanEmail) {
        this.renliziyuanEmail = renliziyuanEmail;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getRenliziyuanDelete() {
        return renliziyuanDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setRenliziyuanDelete(Integer renliziyuanDelete) {
        this.renliziyuanDelete = renliziyuanDelete;
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
