package com.ross53.cobar.localservice.repositories;


import com.ross53.cobar.localservice.entity.OrderStatus;
import com.ross53.cobar.localservice.entity.Orderinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderInfoRepository extends JpaRepository<Orderinfo, Integer> {

	@Query("SELECT o FROM Orderinfo o WHERE o.orderNumber = :orderNumber")
	public Orderinfo FindByOrderNumber(@Param("orderNumber")String orderNumber);
	
	@Query("SELECT o FROM Orderinfo o WHERE o.status = :status ORDER BY o.orderNumber ASC")
	public List<Orderinfo> FindOrderinfoByStatus(@Param("status")OrderStatus status);
}

