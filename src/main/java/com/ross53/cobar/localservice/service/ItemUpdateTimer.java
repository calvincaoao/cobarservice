package com.ross53.cobar.localservice.service;

import com.ross53.cobar.localservice.entity.CompleteItem;
import com.ross53.cobar.localservice.entity.ItemStatus;
import com.ross53.cobar.localservice.entity.OrderStatus;
import com.ross53.cobar.localservice.entity.Orderinfo;
import com.ross53.cobar.localservice.utils.BuildRequestWithValidateHeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.List;
import java.util.TimerTask;

@Component
public class ItemUpdateTimer extends TimerTask {

    @Autowired
    OrderinfoService orderinfoService;

    @Autowired
    CompleteItemService completeItemService;

    @Value("${clouduri.itemcompleteuri}")
    private String cloudItemCompleteUrl;

    private boolean orderResolved = false;

    @Override
    public void run(){
        updateUnfinishedItem();
    }


    //retry update completed item back to cloud
    private void updateUnfinishedItem(){

        //System.out.println("running...");

        List<Orderinfo> orderinfos = orderinfoService.FindOrderinfoByStatus(OrderStatus.COMPLETE);

        if (orderinfos.size() > 0) {

            for (Orderinfo orderInfo : orderinfos) {

                //System.out.println("orderinfo："+orderInfo.getOrderNumber());

                List<CompleteItem> completeItems = completeItemService.FindByorderNumber(orderInfo.getOrderNumber());

                if (completeItems.size() > 0) {

                    for (CompleteItem completeItem : completeItems) {

                        //System.out.println("item:"+completeItem.getItem_id());

                        if (completeItem.getItem_status() == ItemStatus.COMPLETED.getIndex()) {

                            orderResolved = false;

                            try {
                                final String uri = cloudItemCompleteUrl;//"http://brand.fugumobile.cn/q/cobarapi/order/update";

                                HttpEntity<String> request =
                                        BuildRequestWithValidateHeaderUtil.getItemCompleteUpdateRestTemplate(completeItem);

                                RestTemplate restTemplate = new RestTemplate();
                                restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

                                ResponseEntity<String> resp = restTemplate.postForEntity(uri, request, String.class);

                                completeItem.setItem_status(ItemStatus.FINISHED.getIndex());

                                completeItemService.save(completeItem);

                                orderResolved = true;
                            }catch (Exception e){
                                System.out.println("error:"+e.getMessage());
                            }

                            //System.out.println("orderNumber:" + orderInfo.getOrderNumber() + ";item_id:" + completeItem.getItem_id());
                        }
                    }
                }

                if (orderResolved) {
                    orderInfo.setStatus(OrderStatus.FINISHED);
                    //orderInfo.setOrderStatus(false);
                    orderinfoService.save(orderInfo);
                }
            }
        }
    }
}
