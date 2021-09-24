package com.oyelabs.Pojo;

import android.graphics.drawable.Drawable;

public class BestSellingModel {
    private Drawable productImageUrl;
    private String productTitle;
    private String productPrice;

    public Drawable getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(Drawable productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public BestSellingModel(Drawable productImageUrl, String productTitle, String productPrice) {
        this.productImageUrl = productImageUrl;
        this.productTitle = productTitle;
        this.productPrice = productPrice;
    }
}
