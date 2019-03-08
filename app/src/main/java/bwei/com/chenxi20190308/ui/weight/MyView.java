package bwei.com.chenxi20190308.ui.weight;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import bwei.com.chenxi20190308.R;

public class MyView extends LinearLayout implements View.OnClickListener {

    private final Button btn_add;
    private final Button btn_decrease;
    private final TextView tv_number;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View rootView = LayoutInflater.from(context).inflate(R.layout.my_view, this);
        btn_add = rootView.findViewById(R.id.btn_add);
        btn_decrease = rootView.findViewById(R.id.btn_decrease);
        tv_number = rootView.findViewById(R.id.tv_number);
        btn_add.setOnClickListener(this);
        btn_decrease.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String numberString = tv_number.getText().toString();
        int number = Integer.parseInt(numberString);
        switch (v.getId()){
            case R.id.btn_decrease:
                number = number - 1;
                if (number < 0) {
                    number = 0;
                    //最小数量为0
                    tv_number.setText(String.valueOf(number));
                }
                tv_number.setText(String.valueOf(number));
                //接口回调回传数字
                onCalCulatorLisenter.onDecrese(number);
                break;
            case R.id.btn_add:
                number = number + 1;
                tv_number.setText(String.valueOf(number));
                //接口回调回传数字
                onCalCulatorLisenter.onAdd(number);
                break;
        }
    }
    OnCalCulatorLisenter onCalCulatorLisenter;

    public interface OnCalCulatorLisenter {
        //减少
        public void onDecrese(int number);

        //增加
        public void onAdd(int number);
    }

    public void setOnCalCulatorLisenter(OnCalCulatorLisenter onCalCulatorLisenter) {
        this.onCalCulatorLisenter = onCalCulatorLisenter;
    }
}
