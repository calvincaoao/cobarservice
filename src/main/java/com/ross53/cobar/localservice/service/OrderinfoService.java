package com.ross53.cobar.localservice.service;


import com.ross53.cobar.localservice.entity.OrderStatus;
import com.ross53.cobar.localservice.entity.Orderinfo;
import com.ross53.cobar.localservice.repositories.OrderInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderinfoService {

	@Autowired
	private OrderInfoRepository orderinfoRepository;
	
	public List<Orderinfo> FindOrderinfoByStatus(OrderStatus status) {
		
		return orderinfoRepository.FindOrderinfoByStatus(status);
	}
	
	public Orderinfo FindByOrderNumber(String orderNumber) {
		
		return orderinfoRepository.FindByOrderNumber(orderNumber);
	}
	
	public List<Orderinfo> FindAll() {
		
		return orderinfoRepository.findAll();
	}
	
	public Orderinfo save(Orderinfo o) {
		return orderinfoRepository.save(o);
	}
	
	public long queryCount() {
		return orderinfoRepository.count();
	}
}

