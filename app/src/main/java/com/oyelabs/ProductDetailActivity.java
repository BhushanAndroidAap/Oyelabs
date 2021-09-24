package com.oyelabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProductDetailActivity extends AppCompatActivity {

    TextView productTitleDetail,productQuentityDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        productTitleDetail = findViewById(R.id.productTitleDetail);
        productQuentityDetail = findViewById(R.id.productQuentityDetail);

        String pro = getIntent().getStringExtra("ProductTitle");
        String que = getIntent().getStringExtra("ProductQuentity");
        productTitleDetail.setText(pro);
        productQuentityDetail.setText(que);
    }
}