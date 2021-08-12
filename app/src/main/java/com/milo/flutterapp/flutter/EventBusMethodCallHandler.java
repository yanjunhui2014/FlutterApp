package com.milo.flutterapp.flutter;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;

import com.milo.flutterapp.data.ActionEvent;

import org.greenrobot.eventbus.EventBus;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

/**
 * Title：
 * Describe：
 * Remark：
 * <p>
 * Created by Milo
 * E-Mail : 303767416@qq.com
 * 8/11/21
 */
public class EventBusMethodCallHandler implements MethodChannel.MethodCallHandler, AndroidMethodCallHandler {

    private long lastTime;

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {
        String methodName = call.method;

        if (System.currentTimeMillis() - lastTime < 300) {
            result.success("fail");
            return;
        }
        lastTime = System.currentTimeMillis();

        if ("move".equals(methodName)) {
            result.success("success");
            EventBus.getDefault().post(new ActionEvent("用户 >> 移动 << 了红点"));
        } else if ("click".equals(methodName)) {
            result.success("success");
            EventBus.getDefault().post(new ActionEvent("用户 >> 点击 << 了屏幕"));
        } else {
            result.notImplemented();
        }
    }

    @Override
    public String channelName() {
        return "com.milo.flutterapp.flutter/EventBusMethodCallHandler";
    }

}
