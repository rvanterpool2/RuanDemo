package ruan.ruandemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ruan.ruandemo.Adapter.ListViewAdapter;
import ruan.ruandemo.Adapter.ViewPagerAdapter;
import ruan.ruandemo.fragment.ContentFragment;
import ruan.ruandemo.fragment.HistoryFragment;
import ruan.ruandemo.fragment.LoginFragment;
import ruan.ruandemo.R;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private ViewPager viewPager;
    private ArrayList<Fragment>fragmentList=new ArrayList<Fragment>();
    private  ArrayList<String>listResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listResult = new ArrayList<String>() ;
        initialView();
    createFakeResult();
    }
private void createFakeResult(){
    listResult.add("AAAAAAAAAA");
    listResult.add("BBBBB");
    listResult.add("C");
    listResult.add("D");
    listResult.add("E");
    listResult.add("F");
    listResult.add("GGG");
    listResult.add("H");
    listResult.add("I");
    listResult.add("j");
    listResult.add("K");
    listResult.add("L");
    listResult.add("M");
    listResult.add("N");
    listResult.add("O");
    listResult.add("P");
    listResult.add("Q");
}
    private void initialView() {
        listView= (ListView) findViewById(R.id.List_view);
        View view= getLayoutInflater().inflate(R.layout.list_view_header, null);
        listView= (ListView) findViewById(R.id.List_view);
        LinearLayout listViewHeader=(LinearLayout)view.findViewById(R.id.list_view_header);
        ListViewAdapter listViewAdapter= new ListViewAdapter(this, listResult);
        listView.addHeaderView(listViewHeader);
        TextView tv =new TextView(this);
        tv.setText("We have no more content");
        tv.setTextSize(28);
        tv.setGravity(Gravity.CENTER);
        listView.addFooterView(tv);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this,"listView was clicked at position"+position , Toast.LENGTH_LONG).show();
        Log.d("testListViewActivity",  String.valueOf(position));
    }

    @Override
    public void onBackPressed() {
        Intent intent= new Intent();
        intent.putExtra("message","ListView");
        setResult(RESULT_OK,intent);
        super.onBackPressed();
    }
}
