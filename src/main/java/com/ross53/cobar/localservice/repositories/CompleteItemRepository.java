package com.ross53.cobar.localservice.repositories;


import com.ross53.cobar.localservice.entity.CompleteItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompleteItemRepository extends JpaRepository<CompleteItem, Integer> {

	@Query("SELECT ci FROM CompleteItem ci WHERE ci.orderNumber = :orderNumber AND ci.item_status = 1")
	public List<CompleteItem> FindByorderNumber(@Param("orderNumber")String orderNumber);
}

