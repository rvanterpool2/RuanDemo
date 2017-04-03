package ruan.ruandemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ruan.ruandemo.R;

import static ruan.ruandemo.R.style.dialog;

/**
 * Created by Ruan on 3/8/2017.
 */

public class Quiz4 extends Dialog {
    private int checkedID;
    @BindView(R.id.rdg) RadioGroup radioGroup;
    @OnClick(R.id.dialog_ok2)
    public void okClick(){
        if(checkedID==R.id.rb1){
            listener.onOk1();
        }
        else if(checkedID==R.id.rb2){
            listener.onOk2();
        }
    }

    @OnClick(R.id.dialog_cancel)
    public void cancelClick()
    {
        listener.onCancel();
    }

    private Quiz4.ICustomDialogEventListener listener;
    public interface ICustomDialogEventListener{
        public void onOk1();
        public void onOk2();
        public void onCancel();


    }
    public Quiz4(@NonNull Context context, Quiz4.ICustomDialogEventListener listener) {
        super(context,R.style.dialog);
        this.listener= listener;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        ButterKnife.bind(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group,@IdRes int checkedId) {
                checkedID= checkedId;
            }
        });
    }
}


