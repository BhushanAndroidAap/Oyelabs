package com.oyelabs.Pojo;

import android.graphics.drawable.Drawable;

public class GroceriecsModel {

    private Drawable productImageUrl;
    private String productTitle;
    private String productQuentity;
    private int productBackgroundColor;

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

    public int getProductBackgroundColor() {
        return productBackgroundColor;
    }

    public void setProductBackgroundColor(int productBackgroundColor) {
        this.productBackgroundColor = productBackgroundColor;
    }

    public String getProductQuentity() {
        return productQuentity;
    }

    public void setProductQuentity(String productQuentity) {
        this.productQuentity = productQuentity;
    }

    public GroceriecsModel(Drawable productImageUrl, String productTitle,String productQuentity, int productBackgroundColor) {
        this.productImageUrl = productImageUrl;
        this.productTitle = productTitle;
        this.productQuentity = productQuentity;
        this.productBackgroundColor = productBackgroundColor;
    }
}

