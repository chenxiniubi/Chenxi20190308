package bwei.com.chenxi20190308.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import bwei.com.chenxi20190308.R;
import bwei.com.chenxi20190308.ui.fragment.CartFragmengt;
import bwei.com.chenxi20190308.ui.fragment.MineFragment;

public class MainActivity extends AppCompatActivity {

    private CartFragmengt cartFragmengt;
    private MineFragment mineFragment;
    private FragmentManager manager;
    private FragmentTransaction fragmentTransaction;
    private FrameLayout mMainFrameLayout;
    /**
     * 购物车
     */
    private RadioButton mRbCart;
    /**
     * 我的
     */
    private RadioButton mRbMine;
    private RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //创建fragment对象
        cartFragmengt = new CartFragmengt();
        mineFragment = new MineFragment();
        //开启事务
        manager = getSupportFragmentManager();
        fragmentTransaction = manager.beginTransaction();

        //radiogroup的切换
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                FragmentTransaction transaction = manager.beginTransaction();
                switch (i){
                    case R.id.rb_cart:
                        transaction.replace(R.id.main_frame_layout,cartFragmengt);
                        break;
                    case R.id.rb_mine:
                        transaction.replace(R.id.main_frame_layout,mineFragment);
                        break;
                }
                transaction.commit();
            }
        });
    }

    private void initView() {
        mMainFrameLayout = findViewById(R.id.main_frame_layout);
        mRbCart = findViewById(R.id.rb_cart);
        mRbMine = findViewById(R.id.rb_mine);
        mRadioGroup = findViewById(R.id.radio_group);
    }
}
