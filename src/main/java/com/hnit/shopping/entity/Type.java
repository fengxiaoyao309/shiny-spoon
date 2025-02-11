package com.hnit.shopping.entity;
/**
 * tb_type 类型表对应的实体类 
 * @author Lydia
 *
 */
public class Type {

	private Integer tno ;//类型编号
	private String  tname;//类型名称
	private Integer state;//状态  1上架   0 下架 
	public Integer getTno() {
		return tno;
	}
	public void setTno(Integer tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Type [tno=" + tno + ", tname=" + tname + ", state=" + state + "]";
	}
	public Type(Integer tno, String tname, Integer state) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.state = state;
	}
	public Type() {
		super();
	}
	
	
}
