package com.example.healthcare;

public class LabTestDetailDataBase {
    String userName ,product;
    String price;

    public String getUerName() {
        return userName;
    }

    public void setUerName(String userName) {
        this.userName = userName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public LabTestDetailDataBase(String userName, String product, String price) {
        this.userName = userName;
        this.product = product;
        this.price = price;
    }

    public LabTestDetailDataBase() {
    }
}
