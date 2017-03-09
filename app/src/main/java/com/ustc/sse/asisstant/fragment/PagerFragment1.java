package com.ustc.sse.asisstant.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.ustc.sse.asisstant.R;
import com.ustc.sse.asisstant.adapter.TitlePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Thinkpad on 2016/12/19.
 */

public class PagerFragment1 extends Fragment {

    private List<View> list=null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.pager_page1,container,false);
        //设置广告栏
        ViewPager viewPager=(ViewPager)view.findViewById(R.id.title_pic);
        list=new ArrayList<View>();

        ImageView imageView=new ImageView(getContext());
        imageView.setImageResource(R.drawable.title_commercial);
        list.add(imageView);
        imageView=new ImageView(getContext());
        imageView.setImageResource(R.drawable.title_commercial1);
        list.add(imageView);
        imageView=new ImageView(getContext());
        imageView.setImageResource(R.drawable.title_commercial2);
        list.add(imageView);
        imageView=new ImageView(getContext());
        imageView.setImageResource(R.drawable.title_commercial3);
        list.add(imageView);

        TitlePagerAdapter titlePagerAdapter=new TitlePagerAdapter(list);
        viewPager.setAdapter(titlePagerAdapter);





        //设置菜单
        List<Map<String,Object>> item=new ArrayList<Map<String,Object>>();
        String []name=new String[] {"美食推荐","生活指南","热门景点","园区出行","园区新闻","高校专栏","科研动态","二手交易"};
        int []image=new int[]{R.drawable.menu_food,R.drawable.menu_life,R.drawable.menu_view,R.drawable.menu_transport,R.drawable.menu_news,R.drawable.menu_school,R.drawable.menu_research,R.drawable.menu_recycle};

        for (int i=0;i<8;i++)
        {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name",name[i]);
            map.put("icon",image[i]);
            item.add(map);
        }

        GridView gridView=(GridView)view.findViewById(R.id.main_gridview);

        SimpleAdapter simpleAdapter=new SimpleAdapter(getContext(),item,R.layout.main_menu,new String[]{"name","icon"},new int[]{R.id.menu_text,R.id.menu_image});

        gridView.setAdapter(simpleAdapter);

        return  view;
    }
}
