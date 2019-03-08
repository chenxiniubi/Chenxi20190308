package bwei.com.chenxi20190308.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import bwei.com.chenxi20190308.R;
import bwei.com.chenxi20190308.data.bean.ShopBean;
import bwei.com.chenxi20190308.ui.weight.MyView;

public class GoodsAdapter extends BaseQuickAdapter<ShopBean.DataBean.SpusBean,BaseViewHolder> {

    OnGoodsItemClickLisenter onGoodsItemClickLisenter;
    public void setOnGoodsItemClickLisenter(OnGoodsItemClickLisenter onGoodsItemClickLisenter) {
        this.onGoodsItemClickLisenter = onGoodsItemClickLisenter;
    }

    //接口回调
    public interface OnGoodsItemClickLisenter {
        public void onCallBack();
    }

    public GoodsAdapter(int layoutResId, @Nullable List<ShopBean.DataBean.SpusBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final ShopBean.DataBean.SpusBean item) {
        helper.setText(R.id.tv_goodsPrice,"￥:"+item.getPrice());
        helper.setText(R.id.tv_goodsTitle,item.getName());
        ImageView iv_goodsIcon = helper.getView(R.id.iv_goodsIcon);
        String pic_url = item.getPic_url();
        Glide.with(mContext).load(pic_url).into(iv_goodsIcon);

        //避免焦点抢占
        final CheckBox cb_goods = helper.getView(R.id.cb_goods);
        cb_goods.setOnCheckedChangeListener(null);
        //判断是否选中
        cb_goods.setChecked(item.isGoodsChecked());
        cb_goods.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 //对bean对象进行更新
                item.setGoodsChecked(isChecked);
                onGoodsItemClickLisenter.onCallBack();
            }
        });
        //加减器
        MyView myView = helper.getView(R.id.cv_calculatorView);
        myView.setOnCalCulatorLisenter(new MyView.OnCalCulatorLisenter() {
            @Override
            public void onDecrese(int number) {
                //对新增的字段进行改动
                item.setDefalutNumber(number);
                onGoodsItemClickLisenter.onCallBack();
            }

            @Override
            public void onAdd(int number) {
                //对新增的字段进行改动
                item.setDefalutNumber(number);
                onGoodsItemClickLisenter.onCallBack();
            }
        });
    }
}
