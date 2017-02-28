package ruan.ruandemo;

import ruan.ruandemo.R;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import ruan.ruandemo.Adapter.ViewPagerAdapter;
import ruan.ruandemo.Util.UtilLog;
import ruan.ruandemo.bean.Book;
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

        Intent intent= getIntent();
        Bundle bundle= intent.getExtras();

        String message= intent.getStringExtra("key");
        UtilLog.logD("ViewPagerActivity, value is:",message);
        int number= bundle.getInt("Integer",0);
        int fakeNumber= bundle.getInt("fake", 0);
        Book book = (Book) bundle.getSerializable("book");
        UtilLog.logD("ViewPagerActivity, number is:",""+ number);
        UtilLog.logD("ViewPagerActivity, fake number is:",String.valueOf(fakeNumber));
        UtilLog.logD("ViewPagerActivity, book author is:",book.getAuthor());
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

    @Override
    public void onBackPressed() {
        Intent intent= new Intent();
        intent.putExtra("message","ViewPager" );
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }
}
