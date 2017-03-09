package com.ustc.sse.asisstant.fragment;

import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.ustc.sse.asisstant.NewThreadActivity;
import com.ustc.sse.asisstant.NewThreadPage;
import com.ustc.sse.asisstant.R;
import com.ustc.sse.asisstant.adapter.ForumDisplayAdapter;
import com.ustc.sse.asisstant.widget.RefreshActionBtn;
import com.ustc.sse.asisstant.widget.XListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.InetAddress;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Callback;

/**
 * Created by Thinkpad on 2016/12/19.
 */

public class PagerFragment3 extends Fragment {



        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.pager_page3,container,false);
            return  view;
//        return super.onCreateView(inflater, container, savedInstanceState);
        }


}
