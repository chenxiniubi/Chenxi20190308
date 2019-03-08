package bwei.com.chenxi20190308.di.contract;

public interface ShopContract {
    //V层接口
    public interface ShopView {
        //展示数据
        void showData(String s);
    }

    //P层接口
    public interface ShopPresenter<T> {
        //绑定
        void attachView(T t);
        //解绑
        void detachView(T t);
        //请求数据
        void requestShopData();
    }

    //M层接口
    public interface ShopModel {
        //展示
        void containShopData(CallBack callBack);
        //接口回调
        public interface CallBack{
            //回显
            void onShopCallBack(String s);
        }
    }
}
