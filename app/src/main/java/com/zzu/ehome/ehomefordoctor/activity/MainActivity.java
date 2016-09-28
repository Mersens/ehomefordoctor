package com.zzu.ehome.ehomefordoctor.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zzu.ehome.ehomefordoctor.R;
import com.zzu.ehome.ehomefordoctor.fragment.Fragment1;
import com.zzu.ehome.ehomefordoctor.fragment.Fragment2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.image_msg)
    ImageView imageMsg;
    @BindView(R.id.tv_msg)
    TextView tvMsg;
    @BindView(R.id.layout_msg)
    RelativeLayout layoutMsg;
    @BindView(R.id.img_hz)
    ImageView imgHz;
    @BindView(R.id.tv_hz)
    TextView tvHz;
    @BindView(R.id.layout_hz)
    RelativeLayout layoutHz;
    private int index=0;
    private int selectColor;
    private int unSelectColor;
    private int currentTabIndex;
    private Fragment[] fragments;
    private RelativeLayout[] mTabs;
    private Fragment msgFragment,hzFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    @Override
    public void init() {
        selectColor=getResources().getColor(R.color.bottom_text_color_pressed);
        unSelectColor=getResources().getColor(R.color.bottom_text_color_normal);
        mTabs = new RelativeLayout[2];
        mTabs[0] = layoutMsg;
        mTabs[1] = layoutHz;
        msgFragment= Fragment1.getInstance();
        hzFragment= Fragment2.getInstance();
        fragments = new Fragment[]{msgFragment, hzFragment};
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragments[0])
                .commit();
    }

    @OnClick({R.id.layout_msg, R.id.layout_hz})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_msg:
                index=0;
                setTabs(index);
                break;
            case R.id.layout_hz:
                index=1;
                setTabs(index);
                break;
        }
        selectItem(index);
    }
    private void selectItem(int index){
        if (currentTabIndex != index) {
            FragmentTransaction trx = getSupportFragmentManager()
                    .beginTransaction();
            trx.hide(fragments[currentTabIndex]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.fragment_container, fragments[index]);
            }
            trx.show(fragments[index]).commit();
        }
        mTabs[currentTabIndex].setSelected(false);
        mTabs[index].setSelected(true);
        currentTabIndex = index;
    }

    public void setTabs(int index){
        resetImgs();
        switch (index){
            case 0:
                tvMsg.setTextColor(selectColor);
                imageMsg.setImageResource(R.mipmap.icon_message_pressed);
                break;
            case 1:
                tvHz.setTextColor(selectColor);
                imgHz.setImageResource(R.mipmap.icon_huanzhe_pressed);
                break;
        }

    }

    public void resetImgs(){
        tvMsg.setTextColor(unSelectColor);
        tvHz.setTextColor(unSelectColor);
        imageMsg.setImageResource(R.mipmap.icon_message_normal);
        imgHz.setImageResource(R.mipmap.icon_huanzhe_normal);
    }
}
