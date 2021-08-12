package com.milo.flutterapp;

import android.app.Application;

import com.milo.flutterapp.flutter.FlutterEngineManager;

/**
 * Title：
 * Describe：
 * Remark：
 * <p>
 * Created by Milo
 * E-Mail : 303767416@qq.com
 * 8/11/21
 */
public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FlutterEngineManager.getInstance().initFlutterEngine(this);
    }

    @Override
    public void onTerminate() {
        FlutterEngineManager.getInstance().getFlutterEngine().destroy();
        super.onTerminate();
    }

}
