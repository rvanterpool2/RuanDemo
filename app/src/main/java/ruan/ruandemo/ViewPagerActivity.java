package ruan.ruandemo;

import ruan.ruandemo.R;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import ruan.ruandemo.Adapter.ViewPagerAdapter;
import ruan.ruandemo.fragment.ContentFragment;
import ruan.ruandemo.fragment.HistoryFragment;
import ruan.ruandemo.fragment.LoginFragment;

public class ViewPagerActivity extends AppCompatActivity {
private ViewPager viewPager;
    private ArrayList<Fragment>fragmentList=new ArrayList<Fragment>();
    private TabLayout tabLayout;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
    initiew();

    }
    public void initiew(){
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        fragmentList.add(new LoginFragment());
        fragmentList.add(new ContentFragment());
        fragmentList.add(new HistoryFragment());
        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout=(TabLayout)findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

    }
}
