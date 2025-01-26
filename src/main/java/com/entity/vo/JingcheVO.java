package com.entity.vo;

import com.entity.JingcheEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 警车信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jingche")
public class JingcheVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 警车编号
     */

    @TableField(value = "jingche_uuid_number")
    private String jingcheUuidNumber;


    /**
     * 警车名称
     */

    @TableField(value = "jingche_name")
    private String jingcheName;


    /**
     * 警车类型
     */

    @TableField(value = "jingche_types")
    private Integer jingcheTypes;


    /**
     * 警车状态
     */

    @TableField(value = "status_types")
    private Integer statusTypes;


    /**
     * 警车详情
     */

    @TableField(value = "jingche_content")
    private String jingcheContent;


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
	 * 设置：警车编号
	 */
    public String getJingcheUuidNumber() {
        return jingcheUuidNumber;
    }


    /**
	 * 获取：警车编号
	 */

    public void setJingcheUuidNumber(String jingcheUuidNumber) {
        this.jingcheUuidNumber = jingcheUuidNumber;
    }
    /**
	 * 设置：警车名称
	 */
    public String getJingcheName() {
        return jingcheName;
    }


    /**
	 * 获取：警车名称
	 */

    public void setJingcheName(String jingcheName) {
        this.jingcheName = jingcheName;
    }
    /**
	 * 设置：警车类型
	 */
    public Integer getJingcheTypes() {
        return jingcheTypes;
    }


    /**
	 * 获取：警车类型
	 */

    public void setJingcheTypes(Integer jingcheTypes) {
        this.jingcheTypes = jingcheTypes;
    }
    /**
	 * 设置：警车状态
	 */
    public Integer getStatusTypes() {
        return statusTypes;
    }


    /**
	 * 获取：警车状态
	 */

    public void setStatusTypes(Integer statusTypes) {
        this.statusTypes = statusTypes;
    }
    /**
	 * 设置：警车详情
	 */
    public String getJingcheContent() {
        return jingcheContent;
    }


    /**
	 * 获取：警车详情
	 */

    public void setJingcheContent(String jingcheContent) {
        this.jingcheContent = jingcheContent;
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
