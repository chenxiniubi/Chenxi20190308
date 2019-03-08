package bwei.com.chenxi20190308.di.presenter;

import java.lang.ref.SoftReference;

import bwei.com.chenxi20190308.di.contract.ShopContract;
import bwei.com.chenxi20190308.di.model.ShopModelImpl;

public class ShopPresenterImpl implements ShopContract.ShopPresenter<ShopContract.ShopView> {
    ShopContract.ShopView shopView;
    private SoftReference<ShopContract.ShopView> reference;
    private ShopContract.ShopModel model;

    @Override
    public void attachView(ShopContract.ShopView shopView) {
       this.shopView = shopView;
       //软引用包裹
        reference = new SoftReference<>(shopView);
        //创建M层对象
        model = new ShopModelImpl();
    }

    @Override
    public void detachView(ShopContract.ShopView shopView) {
        reference.clear();
    }

    @Override
    public void requestShopData() {
//        model.containShopData(new ShopContract.ShopModel.CallBack() {
//            @Override
//            public void onShopCallBack(String s) {
//                shopView.showData(s);
//            }
//        });
        model.containShopData(new ShopContract.ShopModel.CallBack() {
            @Override
            public void onShopCallBack(String a) {
                shopView.showData(a);
            }
        });
    }
}
