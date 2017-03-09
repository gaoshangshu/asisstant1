package com.ustc.sse.asisstant.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ustc.sse.asisstant.R;

/**
 * Created by gaodengji on 2017/2/19.
 */

public class PagerFragment4 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pager_page4,container,false);
        return  view;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
