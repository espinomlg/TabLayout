package com.example.espino.tablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by espino on 30/11/16.
 */
public class AdapterViewPager extends FragmentStatePagerAdapter{

    private int tabCount;

    public AdapterViewPager(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        CustomFragment fragment = null;
        Bundle arguments = new Bundle();


        switch (position){
            case 0:
                arguments.putString(CustomFragment.KEY_REG_TEXT,"Tab 1");
                fragment = (CustomFragment) CustomFragment.newInstance(arguments);
                break;
            case 1:
                arguments.putString(CustomFragment.KEY_REG_TEXT,"Tab 2");
                fragment = (CustomFragment) CustomFragment.newInstance(arguments);
                break;
            case 2:
                arguments.putString(CustomFragment.KEY_REG_TEXT,"Tab 3");
                fragment = (CustomFragment) CustomFragment.newInstance(arguments);
                break;
            case 3:
                arguments.putString(CustomFragment.KEY_REG_TEXT,"Tab 4");
                fragment = (CustomFragment) CustomFragment.newInstance(arguments);
                break;
            case 4:
                arguments.putString(CustomFragment.KEY_REG_TEXT,"Tab 5");
                fragment = (CustomFragment) CustomFragment.newInstance(arguments);
                break;

        }

        return fragment;
    }
/*
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;

        switch (position){
            case 0:
                title = "Pcs";
                break;
            case 1:
                title = "Pantallas";
                break;
            case 2:
                title = "Micros";
                break;
            case 3:
                title = "Teclados";
                break;
            case 4:
                title = "Ratones";
                break;
        }

        return title;
    }
*/

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
