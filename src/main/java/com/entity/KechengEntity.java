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
 * 课程
 *
 * @author 
 * @email
 */
@TableName("kecheng")
public class KechengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KechengEntity() {

	}

	public KechengEntity(T t) {
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
     * 老师
     */
    @TableField(value = "laoshi_id")

    private Integer laoshiId;


    /**
     * 课程编号
     */
    @TableField(value = "kecheng_uuid_number")

    private String kechengUuidNumber;


    /**
     * 课程名称
     */
    @TableField(value = "kecheng_name")

    private String kechengName;


    /**
     * 课程代码
     */
    @TableField(value = "kecheng_daima")

    private String kechengDaima;


    /**
     * 院系
     */
    @TableField(value = "yuanxi_types")

    private Integer yuanxiTypes;


    /**
     * 课程性质
     */
    @TableField(value = "kecheng_xingzhi_types")

    private Integer kechengXingzhiTypes;


    /**
     * 课程学分
     */
    @TableField(value = "kecheng_xuefen")

    private Integer kechengXuefen;


    /**
     * 总学时
     */
    @TableField(value = "kecheng_zongxueshi")

    private Integer kechengZongxueshi;


    /**
     * 考核方式
     */
    @TableField(value = "kecheng_kaohe_types")

    private Integer kechengKaoheTypes;


    /**
     * 最大选课人数
     */
    @TableField(value = "kecheng_renshu")

    private Integer kechengRenshu;


    /**
     * 选课截止时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "jiezhi_time")

    private Date jiezhiTime;


    /**
     * 课程详情
     */
    @TableField(value = "kecheng_content")

    private String kechengContent;


    /**
     * 录入时间
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
	 * 设置：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }
    /**
	 * 获取：老师
	 */

    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 设置：课程编号
	 */
    public String getKechengUuidNumber() {
        return kechengUuidNumber;
    }
    /**
	 * 获取：课程编号
	 */

    public void setKechengUuidNumber(String kechengUuidNumber) {
        this.kechengUuidNumber = kechengUuidNumber;
    }
    /**
	 * 设置：课程名称
	 */
    public String getKechengName() {
        return kechengName;
    }
    /**
	 * 获取：课程名称
	 */

    public void setKechengName(String kechengName) {
        this.kechengName = kechengName;
    }
    /**
	 * 设置：课程代码
	 */
    public String getKechengDaima() {
        return kechengDaima;
    }
    /**
	 * 获取：课程代码
	 */

    public void setKechengDaima(String kechengDaima) {
        this.kechengDaima = kechengDaima;
    }
    /**
	 * 设置：院系
	 */
    public Integer getYuanxiTypes() {
        return yuanxiTypes;
    }
    /**
	 * 获取：院系
	 */

    public void setYuanxiTypes(Integer yuanxiTypes) {
        this.yuanxiTypes = yuanxiTypes;
    }
    /**
	 * 设置：课程性质
	 */
    public Integer getKechengXingzhiTypes() {
        return kechengXingzhiTypes;
    }
    /**
	 * 获取：课程性质
	 */

    public void setKechengXingzhiTypes(Integer kechengXingzhiTypes) {
        this.kechengXingzhiTypes = kechengXingzhiTypes;
    }
    /**
	 * 设置：课程学分
	 */
    public Integer getKechengXuefen() {
        return kechengXuefen;
    }
    /**
	 * 获取：课程学分
	 */

    public void setKechengXuefen(Integer kechengXuefen) {
        this.kechengXuefen = kechengXuefen;
    }
    /**
	 * 设置：总学时
	 */
    public Integer getKechengZongxueshi() {
        return kechengZongxueshi;
    }
    /**
	 * 获取：总学时
	 */

    public void setKechengZongxueshi(Integer kechengZongxueshi) {
        this.kechengZongxueshi = kechengZongxueshi;
    }
    /**
	 * 设置：考核方式
	 */
    public Integer getKechengKaoheTypes() {
        return kechengKaoheTypes;
    }
    /**
	 * 获取：考核方式
	 */

    public void setKechengKaoheTypes(Integer kechengKaoheTypes) {
        this.kechengKaoheTypes = kechengKaoheTypes;
    }
    /**
	 * 设置：最大选课人数
	 */
    public Integer getKechengRenshu() {
        return kechengRenshu;
    }
    /**
	 * 获取：最大选课人数
	 */

    public void setKechengRenshu(Integer kechengRenshu) {
        this.kechengRenshu = kechengRenshu;
    }
    /**
	 * 设置：选课截止时间
	 */
    public Date getJiezhiTime() {
        return jiezhiTime;
    }
    /**
	 * 获取：选课截止时间
	 */

    public void setJiezhiTime(Date jiezhiTime) {
        this.jiezhiTime = jiezhiTime;
    }
    /**
	 * 设置：课程详情
	 */
    public String getKechengContent() {
        return kechengContent;
    }
    /**
	 * 获取：课程详情
	 */

    public void setKechengContent(String kechengContent) {
        this.kechengContent = kechengContent;
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
        return "Kecheng{" +
            "id=" + id +
            ", laoshiId=" + laoshiId +
            ", kechengUuidNumber=" + kechengUuidNumber +
            ", kechengName=" + kechengName +
            ", kechengDaima=" + kechengDaima +
            ", yuanxiTypes=" + yuanxiTypes +
            ", kechengXingzhiTypes=" + kechengXingzhiTypes +
            ", kechengXuefen=" + kechengXuefen +
            ", kechengZongxueshi=" + kechengZongxueshi +
            ", kechengKaoheTypes=" + kechengKaoheTypes +
            ", kechengRenshu=" + kechengRenshu +
            ", jiezhiTime=" + jiezhiTime +
            ", kechengContent=" + kechengContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
