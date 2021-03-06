package com.maning.gankmm.ui.fragment.collect;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maning.gankmm.R;
import com.maning.gankmm.ui.adapter.CollectPagerAdapter;
import com.maning.gankmm.ui.base.BaseFragment;
import com.umeng.analytics.MobclickAgent;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 收藏Fragment
 */
public class CollectFragment extends BaseFragment {


    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    public static CollectFragment newInstance() {
        return new CollectFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collect, container, false);
        ButterKnife.bind(this, view);

        //初始化ViewPager
        initViewPager();

        return view;
    }

    private void initViewPager() {
        CollectPagerAdapter collectPagerAdapter = new CollectPagerAdapter(getChildFragmentManager());
        //关闭预加载，默认一次只加载一个Fragment
        viewPager.setAdapter(collectPagerAdapter);
        viewPager.setPageMargin(20);
        //设置tablayout为滑动模式
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("CollectFragment");
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("CollectFragment");
    }

}
