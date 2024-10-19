package com.entity.view;

import com.entity.KechengEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 课程
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("kecheng")
public class KechengView extends KechengEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 院系的值
		*/
		private String yuanxiValue;
		/**
		* 课程性质的值
		*/
		private String kechengXingzhiValue;
		/**
		* 考核方式的值
		*/
		private String kechengKaoheValue;



		//级联表 laoshi
			/**
			* 老师姓名
			*/
			private String laoshiName;
			/**
			* 老师手机号
			*/
			private String laoshiPhone;
			/**
			* 老师头像
			*/
			private String laoshiPhoto;
			/**
			* 电子邮箱
			*/
			private String laoshiEmail;
			/**
			* 擅长
			*/
			private String laoshiShanchang;
			/**
			* 所获荣誉
			*/
			private String laoshiRongyu;
			/**
			* 老师介绍
			*/
			private String laoshiContent;

	public KechengView() {

	}

	public KechengView(KechengEntity kechengEntity) {
		try {
			BeanUtils.copyProperties(this, kechengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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














				//级联表的get和set laoshi

					/**
					* 获取： 老师姓名
					*/
					public String getLaoshiName() {
						return laoshiName;
					}
					/**
					* 设置： 老师姓名
					*/
					public void setLaoshiName(String laoshiName) {
						this.laoshiName = laoshiName;
					}

					/**
					* 获取： 老师手机号
					*/
					public String getLaoshiPhone() {
						return laoshiPhone;
					}
					/**
					* 设置： 老师手机号
					*/
					public void setLaoshiPhone(String laoshiPhone) {
						this.laoshiPhone = laoshiPhone;
					}

					/**
					* 获取： 老师头像
					*/
					public String getLaoshiPhoto() {
						return laoshiPhoto;
					}
					/**
					* 设置： 老师头像
					*/
					public void setLaoshiPhoto(String laoshiPhoto) {
						this.laoshiPhoto = laoshiPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getLaoshiEmail() {
						return laoshiEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setLaoshiEmail(String laoshiEmail) {
						this.laoshiEmail = laoshiEmail;
					}

					/**
					* 获取： 擅长
					*/
					public String getLaoshiShanchang() {
						return laoshiShanchang;
					}
					/**
					* 设置： 擅长
					*/
					public void setLaoshiShanchang(String laoshiShanchang) {
						this.laoshiShanchang = laoshiShanchang;
					}

					/**
					* 获取： 所获荣誉
					*/
					public String getLaoshiRongyu() {
						return laoshiRongyu;
					}
					/**
					* 设置： 所获荣誉
					*/
					public void setLaoshiRongyu(String laoshiRongyu) {
						this.laoshiRongyu = laoshiRongyu;
					}

					/**
					* 获取： 老师介绍
					*/
					public String getLaoshiContent() {
						return laoshiContent;
					}
					/**
					* 设置： 老师介绍
					*/
					public void setLaoshiContent(String laoshiContent) {
						this.laoshiContent = laoshiContent;
					}






}
