/*

package com.ross53.cobar.localservice.service;


import com.ross53.cobar.localservice.entity.CompleteItem;
import com.ross53.cobar.localservice.entity.OrderStatus;
import com.ross53.cobar.localservice.entity.Orderinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemUpdateService {

    @Autowired
    private OrderinfoService orderinfoService;

    @Autowired
    private CompleteItemService completeItemService;

    public void itemupdatetoCloud(){

        List<Orderinfo> orderinfos =  orderinfoService.FindOrderinfoByStatus(OrderStatus.COMPLETE);

        if(orderinfos.size()>0){

            Orderinfo orderInfo = orderinfos.get(0);

            List<CompleteItem> completeItems = completeItemService.FindByorderNumber(orderInfo.getOrderNumber());

            if(completeItems.size()>0){
                CompleteItem completeItem = completeItems.get(0);

                System.out.println("orderNumber:"+orderInfo.getOrderNumber()+";item_id:"+completeItem.getItem_id());
            }

        }
    }

}

*/


