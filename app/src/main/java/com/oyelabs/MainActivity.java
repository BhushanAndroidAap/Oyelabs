package com.oyelabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.oyelabs.Adapter.BestSellingAdapter;
import com.oyelabs.Adapter.ExculiceveAdapter;
import com.oyelabs.Adapter.GroceryAdapter;
import com.oyelabs.Adapter.SliderAdapterExample;
import com.oyelabs.Pojo.BestSellingModel;
import com.oyelabs.Pojo.ExclusiveModel;
import com.oyelabs.Pojo.GroceriecsModel;
import com.oyelabs.Pojo.SliderItemModel;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView exclusiveoffeer_recycleview,groceries_recycleview
            ,bestSelling_recycleview;

    SliderView sliderView;
    private SliderAdapterExample adapter;
    private ArrayList<SliderItemModel> sliderItemList = new ArrayList<>();

    private ExculiceveAdapter exculiceveAdapter;
    private List<ExclusiveModel> exclusiveModelList = new ArrayList<>();

    private GroceryAdapter groceryAdapter;
    private List<GroceriecsModel> groceriecsModelList = new ArrayList<>();

    private BestSellingAdapter bestSellingAdapter;
    private List<BestSellingModel> bestSellingModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderView = findViewById(R.id.imageSlider);
        adapter = new SliderAdapterExample(this);

        exclusiveoffeer_recycleview = findViewById(R.id.exclusiveoffeer_recycleview);
        groceries_recycleview = findViewById(R.id.groceries_recycleview);
        bestSelling_recycleview = findViewById(R.id.bestSelling_recycleview);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false);
        exclusiveoffeer_recycleview.setLayoutManager(linearLayoutManager);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false);
        groceries_recycleview.setLayoutManager(linearLayoutManager1);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false);
        bestSelling_recycleview.setLayoutManager(linearLayoutManager2);

        SliderData();
        exculisiveData();
        groceryData();
        bestSellingData();
        //renewItems(sliderView);
    }

    private void SliderData(){

        //Smart Slider


        adapter = new SliderAdapterExample(MainActivity.this);
        sliderView.setSliderAdapter(adapter);

        //sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(getResources().getColor(R.color.selloll_green));
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();


        /*sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                Log.i("GGG", "onIndicatorClicked: " + sliderView.getCurrentPagePosition());
            }
        });*/

        //Smaret Slider

        SliderItemModel sliderItem = new SliderItemModel("","https://cdn.getir.com/misc/606db40605772c1795efaebb_banner_tr_1617951913412.jpeg");
        sliderItemList.add(sliderItem);

        sliderItem = new SliderItemModel("","https://cdn.getir.com/misc/606db4b9274c154a3b499edf_banner_tr_1617951960749.jpeg");
        sliderItemList.add(sliderItem);

        sliderItem = new SliderItemModel("","https://cdn.getir.com/misc/6069cee3f7be2b6472dc8b5f_banner_tr_1617546995647.jpeg");
        sliderItemList.add(sliderItem);

        sliderItem = new SliderItemModel("","https://cdn.getir.com/misc/606765d0f7ac3c3bc2c84764_banner_tr_1617389030292.jpeg");
        sliderItemList.add(sliderItem);

        sliderItem = new SliderItemModel("","https://cdn.getir.com/misc/6066e191beddbc0fb855b9f1_banner_tr_1617355642020.jpeg");
        sliderItemList.add(sliderItem);

        adapter.renewItems(sliderItemList);
        sliderView.setSliderAdapter(adapter);
        adapter.notifyDataSetChanged();

                             // customerNamelist.add(allCustomer.getCustomerName() + " (" + allCustomer.getCustomerMobile() + ")");
                        }

    //Smart Slider
    public void renewItems(View view) {
        List<SliderItemModel> sliderItemList = new ArrayList<>();
        //dummy data
        for (int i = 0; i < 5; i++) {
            SliderItemModel sliderItem = new SliderItemModel("","");
            sliderItem.setDescription("Slider Item " + i);
            if (i % 2 == 0) {
                sliderItem.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
            } else {
                sliderItem.setImageUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
            }
            sliderItemList.add(sliderItem);
        }
        adapter.renewItems(sliderItemList);
    }

    public void removeLastItem(View view) {
        if (adapter.getCount() - 1 >= 0)
            adapter.deleteItem(adapter.getCount() - 1);
    }

    /*public void addNewItem(View view) {
        SliderItem sliderItem = new SliderItem("","");
        sliderItem.setDescription("Slider Item Added Manually");
        sliderItem.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
        adapter.addItem(sliderItem);
    }*/


    //Smart Slider

    private void exculisiveData(){

        ExclusiveModel exclusiveModel = new ExclusiveModel(getResources().getDrawable(R.drawable.banana),"Organic Bananas","7pcs, Priceg","$4.99");
        exclusiveModelList.add(exclusiveModel);

        exclusiveModel = new ExclusiveModel(getResources().getDrawable(R.drawable.apple),"Red Apple","1kg, Priceg","$4.99");
        exclusiveModelList.add(exclusiveModel);

        exclusiveModel = new ExclusiveModel(getResources().getDrawable(R.drawable.banana),"Organic Bananas","7pcs, Priceg","$4.99");
        exclusiveModelList.add(exclusiveModel);

        exclusiveModel = new ExclusiveModel(getResources().getDrawable(R.drawable.apple),"Red Apple","1kg, Priceg","$4.99");
        exclusiveModelList.add(exclusiveModel);

        exculiceveAdapter = new ExculiceveAdapter(MainActivity.this, exclusiveModelList, new ExculiceveAdapter.ProductItemClicked() {
            @Override
            public void onNavItemClick(int position) {

            }
        });
        exclusiveoffeer_recycleview.setAdapter(exculiceveAdapter);
        exculiceveAdapter.notifyDataSetChanged();
    }

    private void groceryData(){

        GroceriecsModel groceriecsModel = new GroceriecsModel(getResources().getDrawable(R.drawable.pulse_small_icon),"Pulse","1kg Price",getResources().getColor(R.color.light_orrange10));
        groceriecsModelList.add(groceriecsModel);

        groceriecsModel = new GroceriecsModel(getResources().getDrawable(R.drawable.rice_icon),"Rice","5kg Price",getResources().getColor(R.color.light_green));
        groceriecsModelList.add(groceriecsModel);

        groceriecsModel = new GroceriecsModel(getResources().getDrawable(R.drawable.pulse_small_icon),"Pulse","1kg Price",getResources().getColor(R.color.light_orrange10));
        groceriecsModelList.add(groceriecsModel);

        groceriecsModel = new GroceriecsModel(getResources().getDrawable(R.drawable.rice_icon),"Rice","5kg Price",getResources().getColor(R.color.light_green));
        groceriecsModelList.add(groceriecsModel);

        groceryAdapter = new GroceryAdapter(MainActivity.this, groceriecsModelList, new GroceryAdapter.ProductItemClicked() {
            @Override
            public void onNavItemClick(int position) {

            }
        });
        groceries_recycleview.setAdapter(groceryAdapter);
        groceryAdapter.notifyDataSetChanged();

    }

    private void bestSellingData(){

        BestSellingModel bestSellingModel = new BestSellingModel(getResources().getDrawable(R.drawable.simalmirch_icon),"Bell Pepper Red","$4.99");
        bestSellingModelList.add(bestSellingModel);

        bestSellingModel = new BestSellingModel(getResources().getDrawable(R.drawable.veg),"Ginger","$4.99");
        bestSellingModelList.add(bestSellingModel);

        bestSellingModel = new BestSellingModel(getResources().getDrawable(R.drawable.simalmirch_icon),"Bell Pepper Red","$4.99");
        bestSellingModelList.add(bestSellingModel);

        bestSellingModel = new BestSellingModel(getResources().getDrawable(R.drawable.veg),"Ginger","$4.99");
        bestSellingModelList.add(bestSellingModel);

        bestSellingAdapter = new BestSellingAdapter(MainActivity.this, bestSellingModelList, new BestSellingAdapter.ProductItemClicked() {
            @Override
            public void onNavItemClick(int position) {

            }
        });
        bestSelling_recycleview.setAdapter(bestSellingAdapter);
        bestSellingAdapter.notifyDataSetChanged();
    }

}