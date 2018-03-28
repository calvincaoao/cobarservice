package com.ross53.cobar.localservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "completeitem")
public class CompleteItem implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3047444830474700199L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "order_id", insertable=false, updatable=false)
    private Orderinfo order;

    @Column(name="orderNumber")
    private String orderNumber;

    @Column(name="item_id")
    private int item_id;

    @Column(name="completed_quantity")
    private int completed_quantity = 1;

    @Column(name="item_status")
    private int item_status;

    @Column(name="position_number")
    private int position_number;

    @Column(name="position")
    private int position;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Orderinfo getOrder() {
        return order;
    }
    public void setOrder(Orderinfo order) {
        this.order = order;
    }
    public String getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    public int getItem_id() {
        return item_id;
    }
    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }
    public int getCompleted_quantity() {
        return completed_quantity;
    }
    public void setCompleted_quantity(int completed_quantity) {
        this.completed_quantity = completed_quantity;
    }
    public int getItem_status() {
        return item_status;
    }
    public void setItem_status(int item_status) {
        this.item_status = item_status;
    }

    public int getPosition_number() {
        return position_number;
    }
    public void setPosition_number(int position_number) {
        this.position_number = position_number;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

}

