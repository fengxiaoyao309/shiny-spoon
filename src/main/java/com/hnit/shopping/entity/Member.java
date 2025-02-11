package com.hnit.shopping.entity;

import java.util.Date;

/**
 * 会员表tb_member对应的实体类
 * @author Lydia
 *
 */
public class Member {

	private Integer mno;//会员号
	private String nickName;//昵称
	private String sex;//性别 
	private String password;//密码
	private String tel;//手机号
	private String mpic;//图像
	private Integer state;//状态 1可用  0 冻结 
	private String temp01;//备用字段
	private Date registerTime; // 注册时间
	public Integer getMno() {
		return mno;
	}
	public void setMno(Integer mno) {
		this.mno = mno;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMpic() {
		return mpic;
	}
	public void setMpic(String mpic) {
		this.mpic = mpic;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getTemp01() {
		return temp01;
	}
	public void setTemp01(String temp01) {
		this.temp01 = temp01;
	}
	@Override
	public String toString() {
		return "Member [mno=" + mno + ", nickName=" + nickName + ", sex=" + sex + ", password=" + password + ", tel="
				+ tel + ", mpic=" + mpic + ", state=" + state + ", temp01=" + temp01 + "]";
	}
	public Member(Integer mno, String nickName, String sex, String password, String tel, String mpic, Integer state,
			String temp01) {
		super();
		this.mno = mno;
		this.nickName = nickName;
		this.sex = sex;
		this.password = password;
		this.tel = tel;
		this.mpic = mpic;
		this.state = state;
		this.temp01 = temp01;
	}
	public Member() {
		super();
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	
	
	
}
