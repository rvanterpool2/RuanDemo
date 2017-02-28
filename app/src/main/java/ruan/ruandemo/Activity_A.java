package ruan.ruandemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Ruan on 2/23/2017.
 */

public class Activity_A extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case R.id.bt1:
                startActivity(new Intent(this, Activity_A.class));
                break;

            case R.id.bt2b:
                startActivity(new Intent(this, Activity_B.class));
                break;

            case R.id.bt3a:
                startActivity(new Intent(this, Activity_C.class));
                break;

            case R.id.bt4a:
                startActivity(new Intent(this, Activity_D.class));
                break;

        }
    }
}