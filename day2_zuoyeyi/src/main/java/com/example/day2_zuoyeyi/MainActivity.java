package com.example.day2_zuoyeyi;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.day2_zuoyeyi.adapter.MyFragmentAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTab;
    private String[]strings={"我的","收藏"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);
        Vp();
    }

    private void Vp() {
        final BlankFragment fragment = new BlankFragment();
        BlankFragment2 fragment2 = new BlankFragment2();
        final ArrayList<Fragment> list = new ArrayList<>();
        list.add(fragment);
        list.add(fragment2);
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(),list);
        mVp.setAdapter(myFragmentAdapter);
        mTab.setupWithViewPager(mVp);
        for (int i = 0; i <list.size() ; i++) {
            mTab.getTabAt(i).setText(strings[i]);
        }
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position==1){
                    BlankFragment2 fragment1 = (BlankFragment2) list.get(position);
                    fragment1.we();
                }
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
