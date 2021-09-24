package com.oyelabs.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.oyelabs.R;
import com.oyelabs.Pojo.SliderItemModel;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapterExample extends
        SliderViewAdapter<SliderAdapterExample.SliderAdapterVH> {

    private Context context;
    private List<SliderItemModel> mSliderItems = new ArrayList<>();
    //private List<Medium> sliderImageList = new ArrayList<>();
    public SliderAdapterExample.sliderItemclicked sliderItemclicked;

    public SliderAdapterExample(Context context) {
        this.context = context;
    }

    public void renewItems(List<SliderItemModel> sliderImages) {
        this.mSliderItems = sliderImages;
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        this.mSliderItems.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(SliderItemModel sliderImage) {
        this.mSliderItems.add(sliderImage);
        notifyDataSetChanged();
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(final SliderAdapterVH viewHolder, final int position) {

        SliderItemModel sliderItem = mSliderItems.get(position);
        //Medium sliderImage = sliderImageList.get(position);

        //viewHolder.textViewDescription.setText(sliderItem.getDescription());
        //viewHolder.textViewDescription.setTextSize(16);
        //viewHolder.textViewDescription.setTextColor(Color.WHITE);
        Glide.with(viewHolder.itemView)
                .load(sliderItem.getImageUrl())
                //.centerCrop()
                //.load("https://static.remove.bg/remove-bg-web/ad5bb40e8ada6fca658b7a6da9ae4eb718ac2aba/assets/start_remove-c851bdf8d3127a24e2d137a55b1b427378cd17385b01aec6e59d5d4b5f39d2ec.png")
                .fitCenter()
                .placeholder(R.mipmap.ic_launcher)
                .into(viewHolder.imageViewBackground);

       /* viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ProductDetailActivity.class);
                context.startActivity(intent);

                Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mSliderItems.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        ImageView imageGifContainer;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            //imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
            //textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }
    }

    public SliderAdapterExample(Context context,List<SliderItemModel>sliderItemList
    ,sliderItemclicked sliderItemclicked){
        this.context =context;
        this.mSliderItems = sliderItemList;
        this.sliderItemclicked = sliderItemclicked;
    }

    public interface sliderItemclicked{
        public void onItemonClicked(int postion);
    }

}
