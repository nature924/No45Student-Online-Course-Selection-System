package com.entity.model;

import com.entity.KechengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 课程
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KechengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 老师
     */
    private Integer laoshiId;


    /**
     * 课程编号
     */
    private String kechengUuidNumber;


    /**
     * 课程名称
     */
    private String kechengName;


    /**
     * 课程代码
     */
    private String kechengDaima;


    /**
     * 院系
     */
    private Integer yuanxiTypes;


    /**
     * 课程性质
     */
    private Integer kechengXingzhiTypes;


    /**
     * 课程学分
     */
    private Integer kechengXuefen;


    /**
     * 总学时
     */
    private Integer kechengZongxueshi;


    /**
     * 考核方式
     */
    private Integer kechengKaoheTypes;


    /**
     * 最大选课人数
     */
    private Integer kechengRenshu;


    /**
     * 选课截止时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jiezhiTime;


    /**
     * 课程详情
     */
    private String kechengContent;


    /**
     * 录入时间
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
	 * 获取：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 设置：老师
	 */
    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 获取：课程编号
	 */
    public String getKechengUuidNumber() {
        return kechengUuidNumber;
    }


    /**
	 * 设置：课程编号
	 */
    public void setKechengUuidNumber(String kechengUuidNumber) {
        this.kechengUuidNumber = kechengUuidNumber;
    }
    /**
	 * 获取：课程名称
	 */
    public String getKechengName() {
        return kechengName;
    }


    /**
	 * 设置：课程名称
	 */
    public void setKechengName(String kechengName) {
        this.kechengName = kechengName;
    }
    /**
	 * 获取：课程代码
	 */
    public String getKechengDaima() {
        return kechengDaima;
    }


    /**
	 * 设置：课程代码
	 */
    public void setKechengDaima(String kechengDaima) {
        this.kechengDaima = kechengDaima;
    }
    /**
	 * 获取：院系
	 */
    public Integer getYuanxiTypes() {
        return yuanxiTypes;
    }


    /**
	 * 设置：院系
	 */
    public void setYuanxiTypes(Integer yuanxiTypes) {
        this.yuanxiTypes = yuanxiTypes;
    }
    /**
	 * 获取：课程性质
	 */
    public Integer getKechengXingzhiTypes() {
        return kechengXingzhiTypes;
    }


    /**
	 * 设置：课程性质
	 */
    public void setKechengXingzhiTypes(Integer kechengXingzhiTypes) {
        this.kechengXingzhiTypes = kechengXingzhiTypes;
    }
    /**
	 * 获取：课程学分
	 */
    public Integer getKechengXuefen() {
        return kechengXuefen;
    }


    /**
	 * 设置：课程学分
	 */
    public void setKechengXuefen(Integer kechengXuefen) {
        this.kechengXuefen = kechengXuefen;
    }
    /**
	 * 获取：总学时
	 */
    public Integer getKechengZongxueshi() {
        return kechengZongxueshi;
    }


    /**
	 * 设置：总学时
	 */
    public void setKechengZongxueshi(Integer kechengZongxueshi) {
        this.kechengZongxueshi = kechengZongxueshi;
    }
    /**
	 * 获取：考核方式
	 */
    public Integer getKechengKaoheTypes() {
        return kechengKaoheTypes;
    }


    /**
	 * 设置：考核方式
	 */
    public void setKechengKaoheTypes(Integer kechengKaoheTypes) {
        this.kechengKaoheTypes = kechengKaoheTypes;
    }
    /**
	 * 获取：最大选课人数
	 */
    public Integer getKechengRenshu() {
        return kechengRenshu;
    }


    /**
	 * 设置：最大选课人数
	 */
    public void setKechengRenshu(Integer kechengRenshu) {
        this.kechengRenshu = kechengRenshu;
    }
    /**
	 * 获取：选课截止时间
	 */
    public Date getJiezhiTime() {
        return jiezhiTime;
    }


    /**
	 * 设置：选课截止时间
	 */
    public void setJiezhiTime(Date jiezhiTime) {
        this.jiezhiTime = jiezhiTime;
    }
    /**
	 * 获取：课程详情
	 */
    public String getKechengContent() {
        return kechengContent;
    }


    /**
	 * 设置：课程详情
	 */
    public void setKechengContent(String kechengContent) {
        this.kechengContent = kechengContent;
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

    }
