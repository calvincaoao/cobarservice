package com.ross53.cobar.localservice.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "orderinfo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Orderinfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8948626412588264392L;

	@Id
	@GeneratedValue
	@JsonIgnore
	private Integer id;


	@Column(name = "orderNumber", nullable = false, unique=true)
	private String orderNumber;
	
	@Column(name = "tableNumber")
	private int tableNumber;
	
	@Column(name = "price", length=255) // Maps to money
	private BigDecimal price;
	
	@Column
	private String store_id;
	
	@Column
	private int count;
	
	@Column
	private String openid;
	
	@Column
	private String nickname;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createtime", nullable = true, columnDefinition="timestamp default CURRENT_TIMESTAMP", insertable=false, updatable=false)
	@Type(type="java.sql.Timestamp")		
	private Timestamp creatTime;			
	
	@Column
	private boolean pay_status;
	
	@Column
	@Type(type="date")
	private Date pay_success_date;
	
	@Column
	private boolean orderStatus;
	
	@Column(name="status", columnDefinition = "int default 0")
	@Enumerated(value = EnumType.ORDINAL)	
	private OrderStatus status = OrderStatus.START;
	
	@Column
	private int comefrom;
	
	@OneToMany(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
    @JoinColumn(name="detail_id")
	private List<OrderDetail> orderDetail = new ArrayList<OrderDetail>();

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	public String getStore_id() {
		return store_id;
	}

	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Timestamp getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Timestamp creatTime) {
		this.creatTime = creatTime;
	}

	public boolean isPay_status() {
		return pay_status;
	}

	public void setPay_status(boolean pay_status) {
		this.pay_status = pay_status;
	}

	public Date getPay_success_date() {
		return pay_success_date;
	}

	public void setPay_success_date(Date pay_success_date) {
		this.pay_success_date = pay_success_date;
	}

	public boolean isOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public int getComefrom() {
		return comefrom;
	}

	public void setComefrom(int comefrom) {
		this.comefrom = comefrom;
	}

	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

}
