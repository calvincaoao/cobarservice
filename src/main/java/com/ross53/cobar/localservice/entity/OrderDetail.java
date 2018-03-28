package com.ross53.cobar.localservice.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orderdetail")
public class OrderDetail  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2333136359946480821L;

	@Id
	@GeneratedValue
	@JsonIgnore
	private Integer id;


	@Column
	private int product_id;
	
	
	@Column(name = "item_id", nullable = false, unique=true)
	private int item_id;
	
	@Column
	private boolean customize;
	
	@Column(name = "itemstatus",  columnDefinition = "int default 0")
	@Enumerated(value = EnumType.ORDINAL)
	private ItemStatus itemstatus;
	
	@Column
	private int count;
	
	@Column(name = "completecount",  columnDefinition = "int default 0")
	@JsonIgnore
	private int completecount;
	
	@Column(name = "price", length=255) // Maps to money
	private BigDecimal price;
	
	@Column(name = "total_price", length=255) // Maps to money
	private BigDecimal total_price;
	
	@Column
	private String remark;
	
	@Column
	private String message;
	
	@Column
	private String guest_name;
	
	@Column
	private String c_name_en;
	
	@Column
	private String c_name_cn;
	
	@Column
	private String p_name_en;
	
	@Column
	private String p_name_cn;
	
	@Column
	private String p_intro_en;
	
	@Column
	private String p_intro_cn;
	
	@Column
	private String p_imgurl;
	
	@Column
	private String u_name_en;
	
	@Column
	private String u_name_cn;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="command", joinColumns=@JoinColumn(name="orderdetail_id"))
	@Column(name="command")
	private List<String> command = new ArrayList<String>();

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public boolean isCustomize() {
		return customize;
	}

	public void setCustomize(boolean customize) {
		this.customize = customize;
	}

	public ItemStatus getItemstatus() {
		return itemstatus;
	}

	public void setItemstatus(ItemStatus itemstatus) {
		this.itemstatus = itemstatus;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCompletecount() {
		return completecount;
	}

	public void setCompletecount(int completecount) {
		this.completecount = completecount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getTotal_price() {
		return total_price;
	}

	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getGuest_name() {
		return guest_name;
	}

	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}

	public String getC_name_en() {
		return c_name_en;
	}

	public void setC_name_en(String c_name_en) {
		this.c_name_en = c_name_en;
	}

	public String getC_name_cn() {
		return c_name_cn;
	}

	public void setC_name_cn(String c_name_cn) {
		this.c_name_cn = c_name_cn;
	}

	public String getP_name_en() {
		return p_name_en;
	}

	public void setP_name_en(String p_name_en) {
		this.p_name_en = p_name_en;
	}

	public String getP_name_cn() {
		return p_name_cn;
	}

	public void setP_name_cn(String p_name_cn) {
		this.p_name_cn = p_name_cn;
	}

	public String getP_intro_en() {
		return p_intro_en;
	}

	public void setP_intro_en(String p_intro_en) {
		this.p_intro_en = p_intro_en;
	}

	public String getP_intro_cn() {
		return p_intro_cn;
	}

	public void setP_intro_cn(String p_intro_cn) {
		this.p_intro_cn = p_intro_cn;
	}

	public String getP_imgurl() {
		return p_imgurl;
	}

	public void setP_imgurl(String p_imgurl) {
		this.p_imgurl = p_imgurl;
	}

	public String getU_name_en() {
		return u_name_en;
	}

	public void setU_name_en(String u_name_en) {
		this.u_name_en = u_name_en;
	}

	public String getU_name_cn() {
		return u_name_cn;
	}

	public void setU_name_cn(String u_name_cn) {
		this.u_name_cn = u_name_cn;
	}

	public List<String> getCommand() {
		return command;
	}

	public void setCommand(List<String> command) {
		this.command = command;
	}

}
