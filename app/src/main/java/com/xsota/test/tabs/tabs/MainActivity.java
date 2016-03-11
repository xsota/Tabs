package com.xsota.test.tabs.tabs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity {

  @Bind(R.id.tab_layout)
  TabLayout tabLayout;
  @Bind(R.id.view_pager)
  ViewPager viewPager;

  ViewPagerAdapter viewPagerAdapter;
  FragmentManager fragmentManager;

int i = 0 ;

  @OnClick(R.id.un)
  public void un(){
    if(i >= 3){
      i = 0;
    }
//    viewPagerAdapter.emptyFragment.unko();
    viewPagerAdapter.fragments.get(i).unko();
    Log.d("aaaaa","lkjas;flkjas");
    viewPagerAdapter.notifyDataSetChanged();
    i ++;

  }

  @OnClick(R.id.unun)
  public void unun() {
    viewPagerAdapter.fragments.get(0).back();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);

    TabLayout.Tab tab = tabLayout.newTab();

    fragmentManager= getSupportFragmentManager();
    tab.setText("うんこ");
    tabLayout.addTab(tab);
    tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
    tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
    viewPagerAdapter = new ViewPagerAdapter(fragmentManager);
    viewPager.setAdapter(viewPagerAdapter);
    tabLayout.setupWithViewPager(viewPager);



  }

  public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ArrayList<EmptyFragment> fragments;


    public ViewPagerAdapter(FragmentManager fm) {
      super(fm);

      fragments = new ArrayList<EmptyFragment>();
      fragments.add(new EmptyFragment());
      fragments.add(new EmptyFragment());
      fragments.add(new EmptyFragment());
    }




    @Override
    public int getItemPosition(Object object) {
      return POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
      //if(position == 0){
      //  emptyFragment = new EmptyFragment();
      //  return emptyFragment;
      //}

     return fragments.get(position);
      // return new UnkoFragment();
    }

    @Override
    public int getCount() {
      return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return "Tab " + position;
    }
  }
}
