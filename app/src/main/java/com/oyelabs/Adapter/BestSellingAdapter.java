package com.oyelabs.Adapter;

import android.content.Context;
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
import com.oyelabs.Pojo.BestSellingModel;
import com.oyelabs.R;

import java.util.ArrayList;
import java.util.List;

public class BestSellingAdapter extends RecyclerView.Adapter<BestSellingAdapter.MyViewHolder> {

    private Context context;
    private List<BestSellingModel> bestSellingModelList = new ArrayList<>();
    private BestSellingAdapter.ProductItemClicked productItemClicked;
    private int count = 0;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bestselling_item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BestSellingAdapter.MyViewHolder holder, final int position) {

        //CategoriesDatum  categoriesDatum = categoriesList.get(position);
        //ProductModel productModel = productModelList.get(position);

        //MarketDatum marketDatum = marketDatumList.get(position);

        BestSellingModel bestSellingModel = bestSellingModelList.get(position);



        holder.best_productTitle.setText(bestSellingModel.getProductTitle());
        //holder.productQuentity.setText(exclusiveModel.getProductQuentity());
        holder.best_productprice.setText(bestSellingModel.getProductPrice());

        Glide.with(holder.bestSelling_imageView)
                .load(bestSellingModel.getProductImageUrl())
                //.load(R.mipmap.ic_veubi_icon)
                .fitCenter()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.bestSelling_imageView);

        holder.add_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    holder.add_card.setVisibility(View.GONE);
                    holder.show_linear.setVisibility(View.VISIBLE);

            }
        });
        holder.show_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.add_card.setVisibility(View.VISIBLE);
                holder.show_linear.setVisibility(View.GONE);
            }
        });

        /*holder.product_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productItemClicked.onNavItemClick(position);
                *//*Intent intent = new Intent(context, ProductPagerActivity.class);
                context.startActivity(intent);*//*
            }
        });
        holder.product_item_constraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productItemClicked.onNavItemClick(position);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return bestSellingModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout linear_navigation;
        private ConstraintLayout product_item_constraint;

        public TextView best_productTitle;
        public TextView productQuentity;
        public TextView best_productprice;
        public ImageView bestSelling_imageView;
        public CardView add_card;
        public LinearLayout show_linear;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //product_item_constraint = (ConstraintLayout) itemView.findViewById(R.id.product_item_constraint);
            bestSelling_imageView = (ImageView) itemView.findViewById(R.id.bestSelling_imageView);
            best_productTitle = (TextView) itemView.findViewById(R.id.best_productTitle);
            productQuentity = (TextView) itemView.findViewById(R.id.productQuentity);
            best_productprice = (TextView) itemView.findViewById(R.id.best_productprice);
            add_card = (CardView) itemView.findViewById(R.id.add_card);
            show_linear = (LinearLayout) itemView.findViewById(R.id.show_linear);
            //linear_navigation = (linearLayout) itemView.findViewById(R.id.linear_navigation);
        }
    }

    /*public ProductAdapter(Context context, List<MarketDatum> marketDatumList, ProductItemClicked productItemClicked) {
        this.context = context;
        this.marketDatumList = marketDatumList;
        this.productItemClicked = productItemClicked;

    }*/

    public BestSellingAdapter(Context context, List<BestSellingModel> bestSellingModelList,ProductItemClicked productItemClicked) {
        this.context = context;
        this.bestSellingModelList = bestSellingModelList;
        this.productItemClicked = productItemClicked;
    }

    public interface ProductItemClicked {
        public void onNavItemClick(int position);
    }

}
