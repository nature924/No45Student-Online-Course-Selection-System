package com.entity.view;

import com.entity.JiaoxuejihuaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 教学计划
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jiaoxuejihua")
public class JiaoxuejihuaView extends JiaoxuejihuaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 计划类型的值
		*/
		private String jiaoxuejihuaValue;



		//级联表 kecheng
			/**
			* 课程 的 老师
			*/
			private Integer kechengLaoshiId;
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
				* 院系的值
				*/
				private String yuanxiValue;
			/**
			* 课程性质
			*/
			private Integer kechengXingzhiTypes;
				/**
				* 课程性质的值
				*/
				private String kechengXingzhiValue;
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
				* 考核方式的值
				*/
				private String kechengKaoheValue;
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

	public JiaoxuejihuaView() {

	}

	public JiaoxuejihuaView(JiaoxuejihuaEntity jiaoxuejihuaEntity) {
		try {
			BeanUtils.copyProperties(this, jiaoxuejihuaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 计划类型的值
			*/
			public String getJiaoxuejihuaValue() {
				return jiaoxuejihuaValue;
			}
			/**
			* 设置： 计划类型的值
			*/
			public void setJiaoxuejihuaValue(String jiaoxuejihuaValue) {
				this.jiaoxuejihuaValue = jiaoxuejihuaValue;
			}












				//级联表的get和set kecheng

					/**
					* 获取：课程 的 老师
					*/
					public Integer getKechengLaoshiId() {
						return kechengLaoshiId;
					}
					/**
					* 设置：课程 的 老师
					*/
					public void setKechengLaoshiId(Integer kechengLaoshiId) {
						this.kechengLaoshiId = kechengLaoshiId;
					}


					/**
					* 获取： 课程编号
					*/
					public String getKechengUuidNumber() {
						return kechengUuidNumber;
					}
					/**
					* 设置： 课程编号
					*/
					public void setKechengUuidNumber(String kechengUuidNumber) {
						this.kechengUuidNumber = kechengUuidNumber;
					}

					/**
					* 获取： 课程名称
					*/
					public String getKechengName() {
						return kechengName;
					}
					/**
					* 设置： 课程名称
					*/
					public void setKechengName(String kechengName) {
						this.kechengName = kechengName;
					}

					/**
					* 获取： 课程代码
					*/
					public String getKechengDaima() {
						return kechengDaima;
					}
					/**
					* 设置： 课程代码
					*/
					public void setKechengDaima(String kechengDaima) {
						this.kechengDaima = kechengDaima;
					}

					/**
					* 获取： 院系
					*/
					public Integer getYuanxiTypes() {
						return yuanxiTypes;
					}
					/**
					* 设置： 院系
					*/
					public void setYuanxiTypes(Integer yuanxiTypes) {
						this.yuanxiTypes = yuanxiTypes;
					}


						/**
						* 获取： 院系的值
						*/
						public String getYuanxiValue() {
							return yuanxiValue;
						}
						/**
						* 设置： 院系的值
						*/
						public void setYuanxiValue(String yuanxiValue) {
							this.yuanxiValue = yuanxiValue;
						}

					/**
					* 获取： 课程性质
					*/
					public Integer getKechengXingzhiTypes() {
						return kechengXingzhiTypes;
					}
					/**
					* 设置： 课程性质
					*/
					public void setKechengXingzhiTypes(Integer kechengXingzhiTypes) {
						this.kechengXingzhiTypes = kechengXingzhiTypes;
					}


						/**
						* 获取： 课程性质的值
						*/
						public String getKechengXingzhiValue() {
							return kechengXingzhiValue;
						}
						/**
						* 设置： 课程性质的值
						*/
						public void setKechengXingzhiValue(String kechengXingzhiValue) {
							this.kechengXingzhiValue = kechengXingzhiValue;
						}

					/**
					* 获取： 课程学分
					*/
					public Integer getKechengXuefen() {
						return kechengXuefen;
					}
					/**
					* 设置： 课程学分
					*/
					public void setKechengXuefen(Integer kechengXuefen) {
						this.kechengXuefen = kechengXuefen;
					}

					/**
					* 获取： 总学时
					*/
					public Integer getKechengZongxueshi() {
						return kechengZongxueshi;
					}
					/**
					* 设置： 总学时
					*/
					public void setKechengZongxueshi(Integer kechengZongxueshi) {
						this.kechengZongxueshi = kechengZongxueshi;
					}

					/**
					* 获取： 考核方式
					*/
					public Integer getKechengKaoheTypes() {
						return kechengKaoheTypes;
					}
					/**
					* 设置： 考核方式
					*/
					public void setKechengKaoheTypes(Integer kechengKaoheTypes) {
						this.kechengKaoheTypes = kechengKaoheTypes;
					}


						/**
						* 获取： 考核方式的值
						*/
						public String getKechengKaoheValue() {
							return kechengKaoheValue;
						}
						/**
						* 设置： 考核方式的值
						*/
						public void setKechengKaoheValue(String kechengKaoheValue) {
							this.kechengKaoheValue = kechengKaoheValue;
						}

					/**
					* 获取： 最大选课人数
					*/
					public Integer getKechengRenshu() {
						return kechengRenshu;
					}
					/**
					* 设置： 最大选课人数
					*/
					public void setKechengRenshu(Integer kechengRenshu) {
						this.kechengRenshu = kechengRenshu;
					}

					/**
					* 获取： 选课截止时间
					*/
					public Date getJiezhiTime() {
						return jiezhiTime;
					}
					/**
					* 设置： 选课截止时间
					*/
					public void setJiezhiTime(Date jiezhiTime) {
						this.jiezhiTime = jiezhiTime;
					}

					/**
					* 获取： 课程详情
					*/
					public String getKechengContent() {
						return kechengContent;
					}
					/**
					* 设置： 课程详情
					*/
					public void setKechengContent(String kechengContent) {
						this.kechengContent = kechengContent;
					}








}
