package com.oyelabs.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.oyelabs.Pojo.GroceriecsModel;
import com.oyelabs.ProductDetailActivity;
import com.oyelabs.R;

import java.util.ArrayList;
import java.util.List;

public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.MyViewHolder> {

    private Context context;
    private List<GroceriecsModel> groceriecsModelList = new ArrayList<>();
    private GroceryAdapter.ProductItemClicked productItemClicked;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.groceries_item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryAdapter.MyViewHolder holder, final int position) {

        GroceriecsModel groceriecsModel = groceriecsModelList.get(position);



        holder.productTitle.setText(groceriecsModel.getProductTitle());
        holder.grocery_cardview.setCardBackgroundColor(groceriecsModel.getProductBackgroundColor());


        Glide.with(holder.grocery_product_imageView)
                .load(groceriecsModel.getProductImageUrl())
                //.load(R.mipmap.ic_veubi_icon)
                .fitCenter()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.grocery_product_imageView);

        holder.grocery_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailActivity.class);
                intent.putExtra("ProductTitle",groceriecsModel.getProductTitle());
                intent.putExtra("ProductQuentity",groceriecsModel.getProductQuentity());
                context.startActivity(intent);
            }
        });


        /*
        holder.product_item_constraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productItemClicked.onNavItemClick(position);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return groceriecsModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout linear_navigation;
        private ConstraintLayout product_item_constraint;

        public TextView productTitle;
        public ImageView grocery_product_imageView;
        public CardView grocery_cardview;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //product_item_constraint = (ConstraintLayout) itemView.findViewById(R.id.product_item_constraint);
            grocery_product_imageView = (ImageView) itemView.findViewById(R.id.grocery_product_imageView);
            productTitle = (TextView) itemView.findViewById(R.id.productTitle);
            grocery_cardview = (CardView) itemView.findViewById(R.id.grocery_cardview);
        }
    }

    public GroceryAdapter(Context context, List<GroceriecsModel> groceriecsModelList,ProductItemClicked productItemClicked) {
        this.context = context;
        this.groceriecsModelList = groceriecsModelList;
        this.productItemClicked = productItemClicked;
    }

    public interface ProductItemClicked {
        public void onNavItemClick(int position);
    }

}
