package com.ustc.sse.asisstant.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ustc.sse.asisstant.R;
import com.ustc.sse.asisstant.widget.ImageViewWithCache;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by gaodengji on 2017/2/21.
 */

public class ForumDisplayAdapter extends BaseAdapter {

    String hhhhhh[]=new String[]{
            "gaodengji","xiaya","forever","tomorrow"
    };
    int count=20;
    private Activity context;
    private String result;
    private JSONObject jsonObject;
    private JSONArray jsonArray;
    public ForumDisplayAdapter(Activity context,String result) {
        this.context=context;
        this.result=result;
        Log.e("test",result);
        try {

            jsonObject=new JSONObject(result);
            jsonArray=jsonObject.getJSONArray("test");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.e("test",result);
        }
    }

    @Override
    public int getCount() {
        if (jsonArray==null)
            return 0;
        return jsonArray.length();
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

        if(convertView==null)
        {
            convertView=context.getLayoutInflater().inflate(R.layout.forum_display_item,null);
        }
        TextView title = (TextView) convertView
                .findViewById(R.id.forumDisplayTitle);
        TextView replyCnt = (TextView) convertView
                .findViewById(R.id.replyCnt);
        TextView viewsCnt = (TextView) convertView
                .findViewById(R.id.viewsCnt);
        TextView userName = (TextView) convertView
                .findViewById(R.id.postUserName);
        ImageViewWithCache img = (ImageViewWithCache) convertView
                .findViewById(R.id.headImg);

//        JSONObject item = m_model.getJSONObject(position);
//        String threadTitle = item.getString("threadtitle");
        // 如果当前为新贴版块，不加置顶帖提示信息
//        if (m_id != Api.NEW_FORUM_ID) {
//            if (item.getInteger("globalsticky") == Api.GLOBAL_TOP_FORUM) {
//                threadTitle = "<font color=\"red\">[总顶] </font>"
//                        + threadTitle;
//            } else if (item.getInteger("globalsticky") == Api.AREA_TOP_FORUM) {
//                threadTitle = "<font color=\"red\">[区顶] </font>"
//                        + threadTitle;
//            } else if (item.getInteger("sticky") == Api.TOP_FORUM) {
//                threadTitle = "<font color=\"red\">[置顶] </font>"
//                        + threadTitle;
//            }
//        }
        String title_1=null,autor=null;
        int point_count,sorce;
        title.setText("信息");

        try {


            //这里获取的是装载有所有test对象的数组
            JSONObject jsonpet = jsonArray.getJSONObject(position);//获取这个数组中第一个pet对象
            //   Log.e(String.valueOf(jsonArray.length()),"length");
            title_1=jsonpet.getString("title");//获取pet对象的参数
            autor=jsonpet.getString("autor");
            point_count=jsonpet.getInt("lightBBS");
            sorce=jsonpet.getInt("responseBBS");
            title.setText(title_1);
            replyCnt.setText(sorce+"");
            viewsCnt.setText(point_count+"");
            userName.setText(autor);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        img.setImageResource(R.mipmap.default_user_head_img);
//        convertView.findViewById(R.id.forumDisplayLock).setVisibility(
//                (View.VISIBLE));

        return convertView;
    }
}

