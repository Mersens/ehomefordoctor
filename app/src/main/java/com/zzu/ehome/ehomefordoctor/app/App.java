package com.zzu.ehome.ehomefordoctor.app;

import android.app.Application;

/**
 * Created by Mersens on 2016/9/28.
 */

public class App extends Application {
    private static App mApp;
    public static App getInstance(){
        if(mApp==null){
            synchronized (App.class){
                if(mApp==null){
                    mApp=new App();
                }
            }
        }
        return mApp;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mApp=this;
    }
}
