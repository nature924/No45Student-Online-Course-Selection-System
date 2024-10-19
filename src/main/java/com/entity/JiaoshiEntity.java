package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 教室
 *
 * @author 
 * @email
 */
@TableName("jiaoshi")
public class JiaoshiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaoshiEntity() {

	}

	public JiaoshiEntity(T t) {
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
    @TableField(value = "id")

    private Integer id;


    /**
     * 教室编号
     */
    @TableField(value = "jiaoshi_uuid_number")

    private String jiaoshiUuidNumber;


    /**
     * 教室名称
     */
    @TableField(value = "jiaoshi_name")

    private String jiaoshiName;


    /**
     * 教室位置
     */
    @TableField(value = "jiaoshi_address")

    private String jiaoshiAddress;


    /**
     * 教室详情
     */
    @TableField(value = "jiaoshi_content")

    private String jiaoshiContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：教室编号
	 */
    public String getJiaoshiUuidNumber() {
        return jiaoshiUuidNumber;
    }
    /**
	 * 获取：教室编号
	 */

    public void setJiaoshiUuidNumber(String jiaoshiUuidNumber) {
        this.jiaoshiUuidNumber = jiaoshiUuidNumber;
    }
    /**
	 * 设置：教室名称
	 */
    public String getJiaoshiName() {
        return jiaoshiName;
    }
    /**
	 * 获取：教室名称
	 */

    public void setJiaoshiName(String jiaoshiName) {
        this.jiaoshiName = jiaoshiName;
    }
    /**
	 * 设置：教室位置
	 */
    public String getJiaoshiAddress() {
        return jiaoshiAddress;
    }
    /**
	 * 获取：教室位置
	 */

    public void setJiaoshiAddress(String jiaoshiAddress) {
        this.jiaoshiAddress = jiaoshiAddress;
    }
    /**
	 * 设置：教室详情
	 */
    public String getJiaoshiContent() {
        return jiaoshiContent;
    }
    /**
	 * 获取：教室详情
	 */

    public void setJiaoshiContent(String jiaoshiContent) {
        this.jiaoshiContent = jiaoshiContent;
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

    @Override
    public String toString() {
        return "Jiaoshi{" +
            "id=" + id +
            ", jiaoshiUuidNumber=" + jiaoshiUuidNumber +
            ", jiaoshiName=" + jiaoshiName +
            ", jiaoshiAddress=" + jiaoshiAddress +
            ", jiaoshiContent=" + jiaoshiContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
