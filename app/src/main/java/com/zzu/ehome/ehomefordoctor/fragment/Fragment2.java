package com.zzu.ehome.ehomefordoctor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzu.ehome.ehomefordoctor.R;

import butterknife.ButterKnife;

/**
 * Created by Mersens on 2016/9/28.
 */

public class Fragment2 extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_fragment2,null);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    public static Fragment getInstance(){

        return new Fragment2();
    }

    @Override
    public void init() {

    }
}
