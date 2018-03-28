package com.ross53.cobar.localservice.service;


import com.ross53.cobar.localservice.entity.CompleteItem;
import com.ross53.cobar.localservice.repositories.CompleteItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompleteItemService {

	@Autowired
	private CompleteItemRepository completeitemRepository;
	
	public CompleteItem save(CompleteItem item) {
		return completeitemRepository.save(item);
	}
	
	public List<CompleteItem> FindByorderNumber(String orderNumber) {
		return completeitemRepository.FindByorderNumber(orderNumber);
		
	}

}