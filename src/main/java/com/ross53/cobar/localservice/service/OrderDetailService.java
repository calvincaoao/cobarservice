package com.ross53.cobar.localservice.service;


import com.ross53.cobar.localservice.entity.OrderDetail;
import com.ross53.cobar.localservice.repositories.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailService {

	@Autowired
	private OrderDetailRepository detailRespository;
	
	public long Count() {
		return detailRespository.count();
	}
	
	public OrderDetail save(OrderDetail d) {
		
		return detailRespository.save(d);
		
	}
}
