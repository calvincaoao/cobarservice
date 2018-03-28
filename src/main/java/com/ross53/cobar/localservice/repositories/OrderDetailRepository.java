package com.ross53.cobar.localservice.repositories;


import com.ross53.cobar.localservice.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

}
