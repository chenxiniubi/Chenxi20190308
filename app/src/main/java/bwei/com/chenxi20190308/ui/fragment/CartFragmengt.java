package bwei.com.chenxi20190308.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import bwei.com.chenxi20190308.R;
import bwei.com.chenxi20190308.data.bean.ShopBean;
import bwei.com.chenxi20190308.di.contract.ShopContract;
import bwei.com.chenxi20190308.di.presenter.ShopPresenterImpl;
import bwei.com.chenxi20190308.ui.adapter.ShopAdapter;

public class CartFragmengt extends Fragment implements ShopContract.ShopView, View.OnClickListener {

    private ShopContract.ShopPresenter presenter;
    private View view;
    private RecyclerView mRvBusiness;
    private SmartRefreshLayout mSrlContainer;
    /**
     * 全选
     */
    private CheckBox mCbAll;
    /**
     * 结算
     */
    private Button mBtnPrice;
    /**
     * 总计:0元
     */
    private TextView mTvCount;
    private List<ShopBean.DataBean> beanData;
    private ShopAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cart_fragment, container, false);
        presenter = new ShopPresenterImpl();
        //绑定
        presenter.attachView(this);
        presenter.requestShopData();
        initView(view);
        return view;
    }

//    @Override
//    public void showData(String s) {
//        ShoppBean shoppBean = new Gson().fromJson(s, ShoppBean.class);
//        beanData = shoppBean.getData();
//        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
//        mRvBusiness.setLayoutManager(manager);
//        ShopAdapter adapter = new ShopAdapter(R.layout.shop_item, beanData);
//        mRvBusiness.setAdapter(adapter);
//    }
    //解绑

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView(this);
    }


    private void initView(View view) {
        mRvBusiness = view.findViewById(R.id.rv_business);
        mSrlContainer = view.findViewById(R.id.srl_container);
        mCbAll = view.findViewById(R.id.cb_all);
        mBtnPrice = view.findViewById(R.id.btn_price);
        mTvCount = view.findViewById(R.id.tv_count);
    }

    @Override
    public void showData(String a) {
        //全选反选
        mCbAll.setOnCheckedChangeListener(null);
        mCbAll.setOnClickListener(this);

        Gson gson = new Gson();
        ShopBean shoppBean = gson.fromJson(a, ShopBean.class);
        beanData = shoppBean.getData();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
       mRvBusiness.setLayoutManager(manager);
        adapter = new ShopAdapter(R.layout.shop_item, beanData);
        mRvBusiness.setAdapter(adapter);
        adapter.setOnBusinessItemClickLisenter(new ShopAdapter.OnBusinessItemClickLisenter() {
            @Override
            public void onCallBack() {
                boolean result = true;
                for (int i = 0; i < beanData.size(); i++) {
                    //外层选中状态
                    boolean shopChecked = beanData.get(i).isShopChecked();
                    result = result & shopChecked;
                    for (int j = 0; j < beanData.get(i).getSpus().size(); j++) {
                        //里层选中状态
                        boolean goodsChecked = beanData.get(i).getSpus().get(j).isGoodsChecked();
                        result = result & goodsChecked;
                    }
                }
                mCbAll.setChecked(result);
                calculateTotalCount();
            }
        });
    }

    private void calculateTotalCount() {
        //外层条目 //对总价进行计算
        double totalCount = 0;
        for (int i = 0; i < beanData.size(); i++) {
            //内层条目
            for (int j = 0; j < beanData.get(i).getSpus().size(); j++) {
                //判断内层条目是否勾选
                if (beanData.get(i).getSpus().get(j).isGoodsChecked() == true){
                    //获取商品数据*商品价格
                    double price = beanData.get(i).getSpus().get(j).getPrice();
                    int defalutNumber = beanData.get(i).getSpus().get(j).getDefalutNumber();
                    double goodsPrice = price * defalutNumber;
                    totalCount = totalCount+goodsPrice;
                }
            }
        }
        mTvCount.setText("总价是："+String.valueOf(totalCount));//外层条目 //对总价进行计算
//        double totalCount = 0;
        for (int i = 0; i < beanData.size(); i++) {
            //内层条目
            for (int j = 0; j < beanData.get(i).getSpus().size(); j++) {
                //判断内层条目是否勾选
                if (beanData.get(i).getSpus().get(j).isGoodsChecked() == true){
                    //获取商品数据*商品价格
                    double price = beanData.get(i).getSpus().get(j).getPrice();
                    int defalutNumber = beanData.get(i).getSpus().get(j).getDefalutNumber();
                    double goodsPrice = price * defalutNumber;
                    totalCount = totalCount+goodsPrice;
                }
            }
        }
        mTvCount.setText("总价是："+String.valueOf(totalCount));
    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < beanData.size(); i++) {
            //首先让外层的商家条目全部选中
            beanData.get(i).setShopChecked(mCbAll.isChecked());
            //然后让里层的商品条目全部选中
            for (int j = 0; j < beanData.get(i).getSpus().size(); j++) {
                beanData.get(i).getSpus().get(j).setGoodsChecked(mCbAll.isChecked());
            }
        }
        adapter.notifyDataSetChanged();
        calculateTotalCount();
    }
}
