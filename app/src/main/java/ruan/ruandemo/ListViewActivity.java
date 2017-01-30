package ruan.ruandemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import ruan.ruandemo.Adapter.ListViewAdapter;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initialView();
            }

    private void initialView() {
        listView= (ListView) findViewById(R.id.List_view);
        ListViewAdapter listViewAdapter= new ListViewAdapter(this);
        listView.setAdapter(listViewAdapter);
    }

}
