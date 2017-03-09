package com.ustc.sse.asisstant.fragment;

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

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Thinkpad on 2016/12/19.
 */

public class PagerFragment2 extends Fragment implements AdapterView.OnItemClickListener {
    private RefreshActionBtn refreshbtn;
    private ImageButton newThreadBtn;

    private ProgressBar progressBar;
    private XListView xListView;
    private String localHost;
    private String jsonresult1;
    private String result="";
    String titleArray[]={"中科大Adroid课如何","nba 假如马刺和骑士打总决赛","哪只球队赢得希望大","2016实习单位介绍","文慧哪家理发店质量好",
            "独墅湖图书馆借书多久归还","如果你用过Visual Studio的自动补全功能后，再来用eclipse的自动补全功能，相信大家会有些许失望。","顺性别"};
    String autorArray[]={"周星星的大斧头","AngleBaby","沃斯沙哔","戈比牢罔","云贵高原","Lebron James","Kobe Brant","Kevin Durant"};
    int lightBBS[]={10,12,12,14,15,13,12,20,20,20,20,20};
    int responseBBS[]={233,321,345,12,354,566,233,455,434,234};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.forum_display_page,container,false);
        xListView=(XListView)view.findViewById(R.id.forumDisplayListView);
        xListView.setAdapter(new ForumDisplayAdapter(getActivity(),""));
        xListView.setOnItemClickListener(this);

        xListView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() throws IOException {
                Log.e("onRefresh1","onRefresh1");
                int count=0;result="ddd";
                while(result.length()==0&&count<2){
                    try {
                        Log.e("onRefresh2","onRefresh2");

                        Log.e("onRefresh3",result);
                        Thread.sleep(600);count++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                result="{\"test\":[{\"lightBBS\":10,\"title\":\"中科大Adroid课如何\",\"responseBBS\":233,\"autor\":\"周星星的大斧头\"},{\"lightBBS\":12,\"title\":\"nba 假如马刺和骑士打总决赛\",\"responseBBS\":321,\"autor\":\"AngleBaby\"},{\"lightBBS\":12,\"title\":\"哪只球队赢得希望大\",\"responseBBS\":345,\"autor\":\"沃斯沙哔\"},{\"lightBBS\":14,\"title\":\"2016实习单位介绍\",\"responseBBS\":12,\"autor\":\"戈比牢罔\"},{\"lightBBS\":15,\"title\":\"文慧哪家理发店质量好\",\"responseBBS\":354,\"autor\":\"云贵高原\"},{\"lightBBS\":13,\"title\":\"独墅湖图书馆借书多久归还\",\"responseBBS\":566,\"autor\":\"Lebron James\"},{\"lightBBS\":12,\"title\":\"如果你用过Visual Studio的自动补全功能后，再来用eclipse的自动补全功能，相信大家会有些许失望。\",\"responseBBS\":233,\"autor\":\"Kobe Brant\"},{\"lightBBS\":20,\"title\":\"顺性别\",\"responseBBS\":455,\"autor\":\"Kevin Durant\"}]}\n";
                Log.e("test",result);
                xListView.setAdapter(new ForumDisplayAdapter(getActivity(),result));
                xListView.stopLoadMore();
                //停止刷新
                xListView.stopRefresh();
            }
            @Override
            public void onLoadMore() {
                Log.d("onLoadMore","onLoadMore");
                //停止加载更多
                xListView.stopLoadMore();
                //停止刷新
                xListView.stopRefresh();
            }
        });
        result="{\"test\":[{\"lightBBS\":10,\"title\":\"中科大Adroid课如何\",\"responseBBS\":233,\"autor\":\"周星星的大斧头\"},{\"lightBBS\":12,\"title\":\"nba 假如马刺和骑士打总决赛\",\"responseBBS\":321,\"autor\":\"AngleBaby\"},{\"lightBBS\":12,\"title\":\"哪只球队赢得希望大\",\"responseBBS\":345,\"autor\":\"沃斯沙哔\"},{\"lightBBS\":14,\"title\":\"2016实习单位介绍\",\"responseBBS\":12,\"autor\":\"戈比牢罔\"},{\"lightBBS\":15,\"title\":\"文慧哪家理发店质量好\",\"responseBBS\":354,\"autor\":\"云贵高原\"},{\"lightBBS\":13,\"title\":\"独墅湖图书馆借书多久归还\",\"responseBBS\":566,\"autor\":\"Lebron James\"},{\"lightBBS\":12,\"title\":\"如果你用过Visual Studio的自动补全功能后，再来用eclipse的自动补全功能，相信大家会有些许失望。\",\"responseBBS\":233,\"autor\":\"Kobe Brant\"},{\"lightBBS\":20,\"title\":\"顺性别\",\"responseBBS\":455,\"autor\":\"Kevin Durant\"}]}\n";
        xListView.setAdapter(new ForumDisplayAdapter(getActivity(),result));
        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        JSONArray jsonArray = null;
        JSONObject jsonObject;
        JSONObject obj = null;
        String title=null,author = null,response=null;
        try {
            jsonObject=new JSONObject(result);
            jsonArray=jsonObject.getJSONArray("test");
            obj = jsonArray.getJSONObject(position - 1);
            title=obj.getString("title");
            author=obj.getString("author");

        }
        catch (Exception e)
        {

        }




        Bundle data = new Bundle();
        // listview有header,position做减一处理
        data.putString("id", author);
        data.putString("open", title);
        Intent intent = new Intent(getActivity(), NewThreadPage.class);
        intent.putExtras(data);
        this.startActivity(intent);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        progressBar=(ProgressBar)getActivity().findViewById(R.id.forumDisplayProgressBar);

        refreshbtn=(RefreshActionBtn)getActivity().findViewById(R.id.forumDisplayRefreshBtn);
        refreshbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.GONE);
            }
        });
        newThreadBtn=(ImageButton)getActivity().findViewById(R.id.forumDisplayNewThreadBtn);
        newThreadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), NewThreadActivity.class);
                startActivity(intent);
            }
        });


    }


    public String zhuyejson() throws IOException {

        Request.Builder builder =new Request.Builder();

        localHost= "http://192.168.31.105:8080/httpclient/";

        Request request= builder.get().url(localHost+"zhuyejson?sessionid=1").build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("test","我错了");
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String res=response.body().string();
                jsonresult1=res.toString();

                Log.e("test","222  "+jsonresult1);
            }
        });

        return  jsonresult1;
    }


}

