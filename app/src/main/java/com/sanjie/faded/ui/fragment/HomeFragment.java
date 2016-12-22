package com.sanjie.faded.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sanjie.faded.R;
import com.sanjie.faded.base.BaseFragment;

/**
 * Created by LangSanJie on 2016/12/7.
 */

public class HomeFragment extends BaseFragment {

    public static final String TAG = "HomeFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }
}
