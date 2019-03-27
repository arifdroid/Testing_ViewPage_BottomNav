package com.example.testing_viewpage_bottomnav;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();


    public ViewPagerAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);


    }

    @Override
    public Fragment getItem(int i) {
        //return null;

        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addFragment(Fragment fragment){

        fragmentList.add(fragment);

    }
}
