package com.brite.product.domain;

import jakarta.persistence.*;


@Entity
@Table(name="inventory")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productid")
    private Integer productId;
    @Column(name="productname")
    private String productName;
   @Column(name="quantitiy")
    private String quantity;
   @Column(name="price")
    private float  price;

    public Product(String productName, String quantity, float price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(Integer productId, String productName, String quantity, float price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public Product() {

    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
