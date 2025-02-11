package com.hnit.shopping.entity;
/**
 * tb_product表 对应的实体类
 * @author Lydia
 *
 */
public class Product {

	private Integer pno;//商品编号
	private Integer tno;//商品类型
	private String pname;//商品名称
	private Float price;//价格
	private Float salePrice;//销售价格
	private String unit;//单位
	private String weight;//净重
	private String pics;//图片
	private  Integer balance;//库存
	private String mark;//商品描述信息
	private Integer  state;//商品状态  0 下架  1 上架 
	private String pro_temp;//备用字段
	public Integer getPno() {
		return pno;
	}
	public void setPno(Integer pno) {
		this.pno = pno;
	}
	public Integer getTno() {
		return tno;
	}
	public void setTno(Integer tno) {
		this.tno = tno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Float salePrice) {
		this.salePrice = salePrice;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getPics() {
		return pics;
	}
	public void setPics(String pics) {
		this.pics = pics;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getPro_temp() {
		return pro_temp;
	}
	public void setPro_temp(String pro_temp) {
		this.pro_temp = pro_temp;
	}
	public Product(Integer pno, Integer tno, String pname, Float price, Float salePrice, String unit, String weight,
			String pics, Integer balance, String mark, Integer state, String pro_temp) {
		super();
		this.pno = pno;
		this.tno = tno;
		this.pname = pname;
		this.price = price;
		this.salePrice = salePrice;
		this.unit = unit;
		this.weight = weight;
		this.pics = pics;
		this.balance = balance;
		this.mark = mark;
		this.state = state;
		this.pro_temp = pro_temp;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [pno=" + pno + ", tno=" + tno + ", pname=" + pname + ", price=" + price + ", salePrice="
				+ salePrice + ", unit=" + unit + ", weight=" + weight + ", pics=" + pics + ", balance=" + balance
				+ ", mark=" + mark + ", state=" + state + ", pro_temp=" + pro_temp + "]";
	}
	
	
	
	
}
