package ruan.ruandemo;

import android.app.Application;

import ruan.ruandemo.Util.UtilLog;

/**
 * Created by Ruan on 2/6/2017.
 */

public class RuanApplication extends Application
{
    public void onCreate(){
        super.onCreate();
        UtilLog.setDebug(true);

    }
}
