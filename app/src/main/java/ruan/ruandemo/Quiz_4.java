package ruan.ruandemo;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ruan.ruandemo.dialog.Quiz4;

import static ruan.ruandemo.R.style.dialog;

public class Quiz_4 extends Dialog {
    public void okClick(){
        dismiss();
    }
    private Quiz4.ICustomDialogEventListener listener;
    public interface ICustomDialogEventListener{
        public void onClickListener();


    }
    public Quiz_4(@NonNull Context context, Quiz4.ICustomDialogEventListener listener) {
        super(context,R.style.dialog);
        this.listener= listener;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        ButterKnife.bind(this);
    }
}
