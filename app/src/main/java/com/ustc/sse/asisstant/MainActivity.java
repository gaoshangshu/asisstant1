package com.ustc.sse.asisstant;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import com.ustc.sse.asisstant.adapter.MainPagerAdapter;
import com.ustc.sse.asisstant.fragment.*;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private ViewPager viewPager=null;
    private TabLayout tabLayout=null;
    private  List<Fragment> list=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=(ViewPager)findViewById(R.id.main_pager);
        tabLayout=(TabLayout)findViewById(R.id.main_tablayout) ;
        LayoutInflater layoutInflater=LayoutInflater.from(this);


        list=new ArrayList<Fragment>();

        //加载视图
        list.add(new PagerFragment1());
        list.add(new PagerFragment2());
        list.add(new PagerFragment3());
        list.add(new PagerFragment4());

        //绑定适配器
        MainPagerAdapter mainAdapter=new MainPagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(mainAdapter);
        tabLayout.setupWithViewPager(viewPager);

        //设置tab图片导航
        tabLayout.getTabAt(0).setIcon(R.drawable.location);
        tabLayout.getTabAt(1).setIcon(R.drawable.bbs);
        tabLayout.getTabAt(2).setIcon(R.drawable.tool);
        tabLayout.getTabAt(3).setIcon(R.drawable.user);




    }
}
