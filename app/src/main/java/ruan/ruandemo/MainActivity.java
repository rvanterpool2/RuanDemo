package ruan.ruandemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import butterknife.BindView;
import ruan.ruandemo.R;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ruan.ruandemo.Util.UtilLog;
import ruan.ruandemo.bean.Book;
import ruan.ruandemo.dialog.Quiz4;

import static android.widget.Toast.makeText;
import static ruan.ruandemo.R.id.text;

public class MainActivity extends BaseActivity implements View.OnTouchListener {
private ImageButton bt1;
    private ImageButton bt3;

    private GestureDetector mGestureDetector;
    @BindView(R.id.main_fl)FrameLayout fl;

    @OnClick(R.id.bt2)
public void button2Click(){
        Intent intent= new Intent(this , DialogActivity.class);
        startActivityForResult(intent, 2);
    }
    @OnClick(R.id.right_button)
    public void rightButtonClick(){
        Intent intent= new Intent(this ,Activity_A.class);
        startActivityForResult(intent, 2);
    }
    @OnClick(R.id.main_timer_bt)
    public void toTimer(){
        toActivity(ActivityTimer.class);

    }
    @OnClick(R.id.animamtion_bt)
    public void toAnimator() {
        toActivity(activity_Animation.class);
    }
    @OnClick(R.id.animator_bt)
    public void toAnimation() {
        toActivity(AnimatorActivity.class);
    }
    @OnClick(R.id.Quiz_bt)
    public void toQuiz4() {toActivity(Quiz4.class);
    }
        @Override
    protected void onStart(){
        super.onStart();
        toastShort("onStart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        ButterKnife.bind(this);
        mGestureDetector= new GestureDetector(this, new SimpleGestureListener());
        fl.setOnTouchListener(this);

    }
    private void initialView() {
        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeText(v.getContext(), "Button1 was clicked", Toast.LENGTH_LONG).show();
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
        makeText(this ,"Button2 was clicked",Toast.LENGTH_LONG).show();
        toastLong("Button2 was clicked");
        UtilLog.logD("testD", "Toast");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        mGestureDetector.onTouchEvent(event);
        return true;
    }
    private class SimpleGestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onDown(MotionEvent e) {
           // UtilLog.logD("MyGesture", "onDown");
           toastShort("onDown");
            return false;
        }
        @Override
        public void onShowPress(MotionEvent e) {
            //UtilLog.logD("MyGesture", "onShowPress");
            toastShort("onShowPress");
        }
        @Override
        public void onLongPress(MotionEvent e) {
            //UtilLog.logD("MyGesture", "onLongPress");
            toastShort("onLongPress");
        }
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e){
            UtilLog.logD("MyGesture","onSingleTap"+ e);
            toastShort("onSingleTap");
            return true;
        }
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            UtilLog.logD("MyGesture", "onScroll:" + (e1.getY() - e2.getY() + " " + distanceX));
            Context context= getApplicationContext();
            Toast toast = Toast.makeText(context, "onScroll" ,Toast.LENGTH_SHORT);
           // toastShort("onScroll");
            toast.show();
            return true;

        }
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            UtilLog.logD("MyGestures", "onFling: "+(e1.getY() - e2.getY() + " " + velocityX) );
            Context context= getApplicationContext();
            Toast toast = Toast.makeText(context, "onFling" ,Toast.LENGTH_SHORT);
            //toastShort("onFling");
            toast.show();
            return true;
        }
        @Override
        public boolean onDoubleTap(MotionEvent e){
            toastShort("onDoubleTap");
            return true;
        }
        @Override
        public boolean onDoubleTapEvent(MotionEvent e){
       toastShort("onDoubleTapEvent");
            return true;
        }
    }
}


