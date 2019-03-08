package bwei.com.chenxi20190308.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import bwei.com.chenxi20190308.R;
import bwei.com.chenxi20190308.data.bean.ShopBean;

public class ShopAdapter extends BaseQuickAdapter<ShopBean.DataBean,BaseViewHolder> {

    OnBusinessItemClickLisenter onBusinessItemClickLisenter;
    public interface OnBusinessItemClickLisenter{
        public void onCallBack();
    }

    public void setOnBusinessItemClickLisenter(OnBusinessItemClickLisenter onBusinessItemClickLisenter) {
        this.onBusinessItemClickLisenter = onBusinessItemClickLisenter;
    }

    public ShopAdapter(int layoutResId, @Nullable List<ShopBean.DataBean> data) {
        super(layoutResId, data);  
    }

    @Override
    protected void convert(BaseViewHolder helper, final ShopBean.DataBean item) {
         helper.setText(R.id.tv_business_name,item.getName());
        RecyclerView rv_goods = helper.getView(R.id.rv_goods);
        //避免焦点抢占
        final CheckBox cb_business = helper.getView(R.id.cb_business);
        cb_business.setOnCheckedChangeListener(null);
        //获取商家是否选中
        cb_business.setChecked(item.isShopChecked());
        
        //数据元
        List<ShopBean.DataBean.SpusBean> spusBeanList = item.getSpus();
        //布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        rv_goods.setLayoutManager(manager);
        //设置适配器
        final GoodsAdapter adapter = new GoodsAdapter(R.layout.goods_item, spusBeanList);
        rv_goods.setAdapter(adapter);

        //处理自条目控制商家
        adapter.setOnGoodsItemClickLisenter(new GoodsAdapter.OnGoodsItemClickLisenter() {
            @Override
            public void onCallBack() {
                boolean result = true;
                for (int i = 0; i < item.getSpus().size(); i++) {
                    result = result & item.getSpus().get(i).isGoodsChecked();
                }
                cb_business.setChecked(result);
                adapter.notifyDataSetChanged();
                //把最后的状态进行回传
                onBusinessItemClickLisenter.onCallBack();
            }
        });
        //然后外层控制内层
        cb_business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取商品类别勾选状态
                //外层商品类别条目获取的关键：cb_business.isChecked()
                for (int i = 0; i < item.getSpus().size(); i++) {
                    item.getSpus().get(i).setGoodsChecked(cb_business.isChecked());
                }
                item.setShopChecked(cb_business.isChecked());
                notifyDataSetChanged();
                //把最后的状态进行回传
                onBusinessItemClickLisenter.onCallBack();
            }
        });
    }
}
