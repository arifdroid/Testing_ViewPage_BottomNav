package com.example.testing_viewpage_bottomnav;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // https://github.com/jaisonfdo/BottomNavigation/blob/master/app/src/main/java/droidmentor/bnv_with_viewpager/MainActivity.java

    //viewpager
    private ViewPager viewPager;

    //fragments
    Fragment_A fragment_a;
    Fragment_B fragment_b;

    //menu
    MenuItem prevMenuItem;





    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_dashboard:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //    mTextMessage = (TextView) findViewById(R.id.message);

        viewPager = findViewById(R.id.viewPageriD);

        setupViewPager(viewPager);
        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                if(prevMenuItem!=null){

                    prevMenuItem.setChecked(false);

                }else {

                    navigation.getMenu().getItem(0).setChecked(false);


                }

                navigation.getMenu().getItem(i).setChecked(true);
                prevMenuItem = navigation.getMenu().getItem(i);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        fragment_a = new Fragment_A();
        fragment_b = new Fragment_B();

        viewPagerAdapter.addFragment(fragment_a);
        viewPagerAdapter.addFragment(fragment_b);

        viewPager.setAdapter(viewPagerAdapter);


    }

}
