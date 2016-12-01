package com.example.espino.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class TabActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AdapterViewPager adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //se deben inicializar el TabLayout y crear las pestañas
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        //tabLayout.addTab(tabLayout.newTab().setText("Tab1"));

        for(String title : getResources().getStringArray(R.array.tabs)){
            tabLayout.addTab(tabLayout.newTab().setText(title).setIcon(R.drawable.alert));
        }
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new AdapterViewPager(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(false, new CubeInTransformer());
        //tabLayout.setupWithViewPager(viewPager);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //tabLayout.getTabAt(position).select();
                tabLayout.setScrollPosition(position,0f,true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
