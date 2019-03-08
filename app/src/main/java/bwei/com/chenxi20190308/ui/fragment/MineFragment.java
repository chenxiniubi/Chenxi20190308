package bwei.com.chenxi20190308.ui.fragment;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.scwang.smartrefresh.header.waveswipe.WaveView;

import bwei.com.chenxi20190308.R;

public class MineFragment extends Fragment implements View.OnClickListener {
    private View view;
    /**
     * 开启动画
     */
    private Button mBtnStart;
    private ImageView mImaView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mBtnStart = view.findViewById(R.id.btn_start);
        mBtnStart.setOnClickListener(this);
        mImaView = view.findViewById(R.id.ima_view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                ObjectAnimator animator = ObjectAnimator.ofFloat(mImaView, "translationY", 0f, 300f);
                animator.setDuration(5000);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImaView, "alpha", 1.0f, 0.3f);
                animator2.setDuration(5000);
                animator.start();
                animator2.start();
                break;
        }
    }

}
