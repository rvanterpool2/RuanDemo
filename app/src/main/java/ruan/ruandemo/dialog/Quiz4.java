package ruan.ruandemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
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

    private ICustomDialogEventListener listener;

    public interface ICustomDialogEventListener{
        public void onClickListener();
        public void onClick2Listener();
        public void onClickCancel();

    }


    public Quiz4(@NonNull Context context, ICustomDialogEventListener listener) {
        super(context, dialog);
        this.listener = listener;
        //dialog.show();
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

