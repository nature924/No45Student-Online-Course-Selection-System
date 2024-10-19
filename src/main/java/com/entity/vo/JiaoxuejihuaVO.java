package com.entity.vo;

import com.entity.JiaoxuejihuaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 教学计划
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiaoxuejihua")
public class JiaoxuejihuaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 课程
     */

    @TableField(value = "kecheng_id")
    private Integer kechengId;


    /**
     * 教学计划编号
     */

    @TableField(value = "jiaoxuejihua_uuid_number")
    private String jiaoxuejihuaUuidNumber;


    /**
     * 教学计划名称
     */

    @TableField(value = "jiaoxuejihua_name")
    private String jiaoxuejihuaName;


    /**
     * 计划类型
     */

    @TableField(value = "jiaoxuejihua_types")
    private Integer jiaoxuejihuaTypes;


    /**
     * 计划详情
     */

    @TableField(value = "jiaoxuejihua_content")
    private String jiaoxuejihuaContent;


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
	 * 设置：课程
	 */
    public Integer getKechengId() {
        return kechengId;
    }


    /**
	 * 获取：课程
	 */

    public void setKechengId(Integer kechengId) {
        this.kechengId = kechengId;
    }
    /**
	 * 设置：教学计划编号
	 */
    public String getJiaoxuejihuaUuidNumber() {
        return jiaoxuejihuaUuidNumber;
    }


    /**
	 * 获取：教学计划编号
	 */

    public void setJiaoxuejihuaUuidNumber(String jiaoxuejihuaUuidNumber) {
        this.jiaoxuejihuaUuidNumber = jiaoxuejihuaUuidNumber;
    }
    /**
	 * 设置：教学计划名称
	 */
    public String getJiaoxuejihuaName() {
        return jiaoxuejihuaName;
    }


    /**
	 * 获取：教学计划名称
	 */

    public void setJiaoxuejihuaName(String jiaoxuejihuaName) {
        this.jiaoxuejihuaName = jiaoxuejihuaName;
    }
    /**
	 * 设置：计划类型
	 */
    public Integer getJiaoxuejihuaTypes() {
        return jiaoxuejihuaTypes;
    }


    /**
	 * 获取：计划类型
	 */

    public void setJiaoxuejihuaTypes(Integer jiaoxuejihuaTypes) {
        this.jiaoxuejihuaTypes = jiaoxuejihuaTypes;
    }
    /**
	 * 设置：计划详情
	 */
    public String getJiaoxuejihuaContent() {
        return jiaoxuejihuaContent;
    }


    /**
	 * 获取：计划详情
	 */

    public void setJiaoxuejihuaContent(String jiaoxuejihuaContent) {
        this.jiaoxuejihuaContent = jiaoxuejihuaContent;
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
