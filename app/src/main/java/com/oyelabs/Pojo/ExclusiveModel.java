package com.oyelabs.Pojo;

import android.graphics.drawable.Drawable;

public class ExclusiveModel {
    private Drawable productUrlImage;
    private String productTitle;
    private String productQuentity;
    private String productPrice;

    public Drawable getProductUrlImage() {
        return productUrlImage;
    }

    public void setProductUrlImage(Drawable productUrlImage) {
        this.productUrlImage = productUrlImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductQuentity() {
        return productQuentity;
    }

    public void setProductQuentity(String productQuentity) {
        this.productQuentity = productQuentity;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public ExclusiveModel(Drawable productUrlImage, String productTitle, String productQuentity, String productPrice) {
        this.productUrlImage = productUrlImage;
        this.productTitle = productTitle;
        this.productQuentity = productQuentity;
        this.productPrice = productPrice;
    }
}
