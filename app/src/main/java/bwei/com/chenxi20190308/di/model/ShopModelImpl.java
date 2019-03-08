package bwei.com.chenxi20190308.di.model;

import android.util.Log;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.io.IOException;

import bwei.com.chenxi20190308.data.constant.MyConstant;
import bwei.com.chenxi20190308.data.utils.OKHttpUtils;
import bwei.com.chenxi20190308.di.contract.ShopContract;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ShopModelImpl implements ShopContract.ShopModel {
    @Override
    public void containShopData(final CallBack callBack) {
//        OKHttpUtils.getInstance().get(MyConstant.SHOP_URL, new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String s = response.body().toString();
//                callBack.onShopCallBack(s);
//                Log.i("cx", "onResponse: ======"+s);
//            }
//        });
        OkGo.<String>get(MyConstant.SHOP_URL).execute(new StringCallback() {
            @Override
            public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                String a = response.body().toString();
                callBack.onShopCallBack(a);
            }
        });
    }
}
