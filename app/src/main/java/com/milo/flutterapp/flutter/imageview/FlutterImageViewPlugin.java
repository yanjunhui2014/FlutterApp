package com.milo.flutterapp.flutter.imageview;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformViewRegistry;

/**
 * Title：
 * Describe：
 * Remark：
 * <p>
 * Created by Milo
 * E-Mail : 303767416@qq.com
 * 8/12/21
 */
public class FlutterImageViewPlugin implements FlutterPlugin {

    public void registerWith(FlutterEngine engine) {
        engine.getPlugins().add(this);
    }

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
        PlatformViewRegistry registry = binding.getPlatformViewRegistry();

        // 消息解码器类型，我们没有特殊的要求，使用默认的即可。
        StandardMessageCodec codec = StandardMessageCodec.INSTANCE;
        FlutterImageViewFactory factory = new FlutterImageViewFactory(codec);

        // 第一个字符串参数对应着一个类型的原生控件，在 Dart 中需要用相同的字符串创建 MapView。
        String viewType = FlutterImageView.ViewType;
        registry.registerViewFactory(viewType, factory);
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {

    }

}
