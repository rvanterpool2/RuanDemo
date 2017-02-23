package ruan.ruandemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageButton;
import android.widget.Toast;
import ruan.ruandemo.R;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ruan.ruandemo.Util.UtilLog;
import ruan.ruandemo.bean.Book;

public class MainActivity extends BaseActivity {
private ImageButton bt1;
    private ImageButton bt3;
    @OnClick(R.id.bt2)
public void button2Click(){
        Intent intent= new Intent(this , DialogActivity.class);
        startActivityForResult(intent, 2);
    }
    @OnClick(R.id.right_button)
    public void rightbuttonClick(){
        Intent intent= new Intent(this , LaunchModeActivity.class);
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        toastShort("onStart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        ButterKnife.bind(this);

    }
    private void initialView() {
        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Button1 was clicked", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(v.getContext(), ViewPagerActivity.class);
                intent.putExtra("key", "value");
                Bundle bundle= new Bundle();
                bundle.putInt("integer",12345);
                intent.putExtras(bundle);
                Book book= new Book();
                book.setName("Android");
                book.setAuthor("Yan");
                bundle.putSerializable("book", book);
                intent.putExtras(bundle);
                startActivityForResult(intent,1);
            }
        });
        bt3 = (ImageButton) findViewById(R.id.bt3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(ListViewActivity.class);
                Intent intent = new Intent(v.getContext(), ListViewActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case 1:
                String message= data.getStringExtra("message");
                toastShort(message);
                break;
            case 2:
                toastShort("Dialog");
            case 3:
                toastShort("ListView");
                break;
            default:


        }
    }

    public void onClick(View v) {
        Toast.makeText(this ,"Button2 was clicked",Toast.LENGTH_LONG).show();
        toastLong("Button2 was clicked");
        UtilLog.logD("testD", "Toast");
    }
}

