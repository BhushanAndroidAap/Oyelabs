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
import com.oyelabs.Pojo.ExclusiveModel;
import com.oyelabs.R;

import java.util.ArrayList;
import java.util.List;

public class ExculiceveAdapter extends RecyclerView.Adapter<ExculiceveAdapter.MyViewHolder> {

    private Context context;
    private List<ExclusiveModel> exclusiveModelList = new ArrayList<>();
    private ExculiceveAdapter.ProductItemClicked productItemClicked;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.exculisve_item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExculiceveAdapter.MyViewHolder holder, final int position) {

        //CategoriesDatum  categoriesDatum = categoriesList.get(position);
        //ProductModel productModel = productModelList.get(position);

        //MarketDatum marketDatum = marketDatumList.get(position);

        ExclusiveModel exclusiveModel = exclusiveModelList.get(position);



        holder.productTitle.setText(exclusiveModel.getProductTitle());
        holder.productQuentity.setText(exclusiveModel.getProductQuentity());
        holder.productprice.setText(exclusiveModel.getProductPrice());

        Glide.with(holder.product_imageView)
                .load(exclusiveModel.getProductUrlImage())
                //.load(R.mipmap.ic_veubi_icon)
                .fitCenter()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.product_imageView);


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
        return exclusiveModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout linear_navigation;
        private ConstraintLayout product_item_constraint;

        public TextView productTitle;
        public TextView productQuentity;
        public TextView productprice;
        public ImageView product_imageView;
        public CardView add_cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //product_item_constraint = (ConstraintLayout) itemView.findViewById(R.id.product_item_constraint);
            product_imageView = (ImageView) itemView.findViewById(R.id.product_imageView);
            productTitle = (TextView) itemView.findViewById(R.id.productTitle);
            productQuentity = (TextView) itemView.findViewById(R.id.productQuentity);
            productprice = (TextView) itemView.findViewById(R.id.productprice);
            add_cardView = (CardView) itemView.findViewById(R.id.add_cardView);
            //linear_navigation = (linearLayout) itemView.findViewById(R.id.linear_navigation);
        }
    }

    /*public ProductAdapter(Context context, List<MarketDatum> marketDatumList, ProductItemClicked productItemClicked) {
        this.context = context;
        this.marketDatumList = marketDatumList;
        this.productItemClicked = productItemClicked;

    }*/

    public ExculiceveAdapter(Context context, List<ExclusiveModel> exclusiveModelList,ProductItemClicked productItemClicked) {
        this.context = context;
        this.exclusiveModelList = exclusiveModelList;
        this.productItemClicked = productItemClicked;
    }

    public interface ProductItemClicked {
        public void onNavItemClick(int position);
    }

}
