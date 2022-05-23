package com.zhangjinyang.model;

import java.io.Serializable;

public class Item implements Serializable {
    private com.zhangjinyang.model.Product product;
    private int quantity;

    public Item() {
    }

    public Item(com.zhangjinyang.model.Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public com.zhangjinyang.model.Product getProduct() {
        return product;
    }

    public void setProduct(com.zhangjinyang.model.Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}