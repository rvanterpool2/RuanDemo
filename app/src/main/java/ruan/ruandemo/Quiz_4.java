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
    private int checkedID;

    @BindView(R.id.rdg)
    RadioGroup radioGroup;

    @OnClick(R.id.dialog_ok)
    public void okClick(){
        if(checkedID==R.id.rb1){
            listener.onClickListener();
        }
        else if(checkedID==R.id.rb2){
            listener.onClick2Listener();
        }
        dismiss();
    }

    @OnClick(R.id.bt_cancel)
    public void cancelClick(){
        listener.onClickCancel();
        dismiss();
    }

    private Quiz4.ICustomDialogEventListener listener;

    public interface ICustomDialogEventListener{
        public void onClickListener();
        public void onClick2Listener();
        public void onClickCancel();

    }


    public Quiz_4(@NonNull Context context, Quiz4.ICustomDialogEventListener listener) {
        super(context, dialog);
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checkedID = checkedId;

            }
        });
    }
}

