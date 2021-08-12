package com.milo.flutterapp.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;

/**
 * Title：
 * Describe：
 * Remark：
 * <p>
 * Created by Milo
 * E-Mail : 303767416@qq.com
 * 8/11/21
 */
public class DemoFlutterActivity extends FlutterActivity {
    private static final String TAG = "DemoFlutterActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        Log.d(TAG, "configureFlutterEngine");
//        GeneratedPluginRegistrant.registerWith(flutterEngine);
    }

//    @Override
//    protected void onDestroy() {
//        FlutterEngine flutterEngine = getFlutterEngine();
//        if (flutterEngine != null) {
//            PlatformViewsController viewsController = flutterEngine.getPlatformViewsController();
//            if (viewsController != null) {
//                viewsController.onFlutterViewDestroyed();
//            }
//        }
//        super.onDestroy();
//    }

}
