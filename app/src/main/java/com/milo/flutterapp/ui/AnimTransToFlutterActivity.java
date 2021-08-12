package com.milo.flutterapp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.milo.flutterapp.R;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.android.TransparencyMode;
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
public class AnimTransToFlutterActivity extends FlutterActivity {

    private String router;

    public static void start(Context context, String router) {
        Intent intent = new Intent(context, AnimTransToFlutterActivity.class);
        intent.putExtra("router", router);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        router = getIntent().getStringExtra("router");
        startActivity(FlutterActivity
                .withNewEngine()
                .initialRoute(router)
                .build(this));
        finish();
    }

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        overridePendingTransition(R.anim.pageup_enter, R.anim.pageup_exit);
    }

    @Override
    public TransparencyMode getTransparencyMode() {
        return TransparencyMode.transparent;
    }
}

