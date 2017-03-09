package com.ustc.sse.asisstant;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ustc.sse.asisstant.widget.ImageViewWithCache;
import com.ustc.sse.asisstant.widget.RefreshActionBtn;
import com.ustc.sse.asisstant.widget.ThreadItemFooter;
import com.ustc.sse.asisstant.widget.XListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by gaodengji on 2017/2/22.
 */

public class NewThreadPage extends AppCompatActivity implements XListView.IXListViewListener, AdapterView.OnItemClickListener {
    private XListView m_listView;
    private ShowthreadAdapter m_adapter;
    private int m_currentPage = 1;
    private int m_totalPage = 0;
    private int m_id = 0;
    private ProgressBar m_pBar;
    private JSONArray m_model = null;
    private ProgressDialog m_pd = null;
    private RefreshActionBtn m_refreshBtn;
    private TextView m_titleView;
    private long m_lastUpdateTime = 0;
    private EditText m_subject;
    private String result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_thread_page);
        m_listView = (XListView) this.findViewById(R.id.showthreadListview);
        m_listView.setPullLoadEnable(false);
        m_listView.setPullRefreshEnable(true);
        m_listView.setXListViewListener(this);
        m_listView.setOnItemClickListener(this);
        View titleHeaderView = LayoutInflater.from(this).inflate(R.layout.show_thread_title_header, null);
        m_listView.addHeaderView(titleHeaderView);
        m_titleView = (TextView) titleHeaderView.findViewById(R.id.showThreadTitle);
        m_titleView.setVisibility(View.GONE);
        m_adapter = new ShowthreadAdapter(this);
        m_listView.setAdapter(m_adapter);
        m_listView.requestFocus();

//        m_pBar = (ProgressBar) this.findViewById(R.id.showThreadProgressBar);
        m_refreshBtn = (RefreshActionBtn) this.findViewById(R.id.showThreadRefreshBtn);

        Bundle data = this.getIntent().getExtras();
        m_id = data.getInt("id");
        if (data.getInt("open") == 0) {
            this.findViewById(R.id.showThreadReplyBar).setVisibility(View.GONE);
        }
    }

    @Override
    public void onRefresh() throws IOException {

    }

    @Override
    public void onLoadMore() {

    }
    public  void onBackBtnClick(View view)
    {
        Intent intent=new Intent(this,NewThreadActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(this,ResponseActivity.class);
        startActivity(intent);
    }
}
 class ShowthreadAdapter  extends  BaseAdapter{

     private  Activity context;
   private  JSONObject jsonObject=null;
     String titleArray[]={"朱老师讲的很好的，就是作业有点多","作业太多了 每周必须通宵，不过能够学到知识也是不错的","学到了很多东西 作业还好吧 不是太难","有基础就好","美得很啊",
             "独墅湖图书馆借书多久归还","如果你用过Visual Studio的自动补全功能后，再来用eclipse的自动补全功能，相信大家会有些许失望。","顺性别"};
     String autorArray[]={"美好的祝福","我最美","沃斯沙哔","Curt Cohain","云贵高原","Lebron James","Kobe Brant","Kevin Durant"};
     JSONArray jsonArray=null;


     public ShowthreadAdapter(Activity context) {
        this.context=context;

     }

     @Override
     public int getCount() {

         return Math.min(titleArray.length,autorArray.length);
     }

     @Override
     public Object getItem(int position) {
         return position;
     }

     @Override
     public long getItemId(int position) {
         return position;
     }

     @Override
     public View getView(int position, View convertView, ViewGroup parent) {

         if (convertView == null) {
             convertView = context.getLayoutInflater().inflate(R.layout.show_thread_item, null);
         }

         TextView username = (TextView)convertView.findViewById(R.id.showthreadUsername);
         TextView floorNum = (TextView)convertView.findViewById(R.id.showThreadFloorNum);
         floorNum.setText((position + 1) + "#");
         TextView posttime = (TextView)convertView.findViewById(R.id.showthreadPosttime);
         final TextView msg = (TextView)convertView.findViewById(R.id.showthreadMsg);
         ImageViewWithCache img = (ImageViewWithCache)convertView.findViewById(R.id.showthreadHeadImg);
         ThreadItemFooter itemFooter = (ThreadItemFooter)convertView.findViewById(R.id.showthreadLoadTip);
         username.setText(autorArray[position]);
         posttime.setText(titleArray[position]);
         img.setImageResource(R.mipmap.default_user_head_img);
         return convertView;
     }

}
