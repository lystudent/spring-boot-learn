package com.xingheng.ai.BigDataAnalysis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author: lym
 * @Date:2019/1/9 12 18
 * @Description:
 */
public class User {


	private Integer id;

	private Integer age;

	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonIgnore   // 序列化忽略密码 ,序列化以后的json不包括pwd
	private String pwd;

	@JsonInclude(JsonInclude.Include.NON_NULL) //空值不返回
	@JsonProperty("account")  //别名映射，尽量暴露少的信息，防止黑客获取表结构
	private String phone;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "zh", timezone = "GMT+8")  //日期格式 zh 中国
	private Date createTime;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public User(Integer age, String name, String pwd, String phone, Date createTime) {
		this.age = age;
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
		this.createTime = createTime;
	}
	public User() {

	}
}
