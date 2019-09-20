package com.example.divar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    FloatingActionButton floatingActionButton;
    ViewPagerAdapter adapter;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_pager);
        floatingActionButton = findViewById(R.id.floating_action);
        tabLayout = findViewById(R.id.tab);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(ListAllFragment.newInstance(),"all");
        adapter.addFragment(ListSpecialFragment.newInstance(),"special");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDialogFragment fragment = AddDialogFragment.newInstance();
                fragment.show(getSupportFragmentManager(),"dialog");
            }
        });
    }


}
