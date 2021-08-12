package com.milo.flutterapp.flutter.imageview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.platform.PlatformView;

/**
 * Title：
 * Describe：
 * Remark：
 * <p>
 * Created by Milo
 * E-Mail : 303767416@qq.com
 * 8/12/21
 */
public class FlutterImageView implements PlatformView, PluginRegistry.ActivityResultListener {
    public static final String ViewType = "com.milo.flutterapp.flutter/flutterimageview";

    private ImageView imageView;

    public FlutterImageView(Context context, int viewId, String url) {
        imageView = new ImageView(context);
        Glide.with(context)
                .load(url)
                .placeholder(Color.GRAY)
                .into(imageView);
    }

    @Override
    public View getView() {
        return imageView;
    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        return false;
    }

}
