package com.milo.flutterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.milo.flutterapp.data.ActionEvent;
import com.milo.flutterapp.data.AppConstants;
import com.milo.flutterapp.flutter.EventBusMethodCallHandler;
import com.milo.flutterapp.flutter.FlutterEngineManager;
import com.milo.flutterapp.ui.DemoFlutterActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.LinkedList;
import java.util.List;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends AppCompatActivity {

    private FlutterEngine flutterEngine;
    private final String flutter_router = "demo/DemoGusture";
//    private final String flutter_router = "demo/Landscape";

    private TextView tvEvent;

    private List<String> list = new LinkedList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvEvent = findViewById(R.id.tv_event);

        flutterEngine = FlutterEngineManager.getInstance().getRouterFlutterEngine(this, flutter_router);
        EventBusMethodCallHandler callHandler = new EventBusMethodCallHandler();
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), callHandler.channelName())
                .setMethodCallHandler(callHandler);

        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        flutterEngine.destroy();
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBus(ActionEvent event){
        list.add(0, event.action);
        StringBuilder builder = new StringBuilder();
        for (String s : list) {
            builder.append(s);
            builder.append("\n");
        }
        tvEvent.setText(builder.toString());
    }

    public void showBigPic(View view) {
    }

    public void gotoFlutterMain(View view) {
        startActivity(DemoFlutterActivity
                .withCachedEngine(AppConstants.flutter_engine_id)
                .build(MainActivity.this));
//        startActivity(DemoFlutterActivity.createDefaultIntent(this));
    }

    public void gotoFlutterByRouter(View view) {
        startActivity(DemoFlutterActivity
                .withCachedEngine(flutter_router)
                .build(MainActivity.this));
    }

}