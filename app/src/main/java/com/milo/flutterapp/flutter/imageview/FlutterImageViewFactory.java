package com.milo.flutterapp.flutter.imageview;

import android.content.Context;

import java.util.Map;

import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

/**
 * Title：
 * Describe：
 * Remark：
 * <p>
 * Created by Milo
 * E-Mail : 303767416@qq.com
 * 8/12/21
 */
public class FlutterImageViewFactory extends PlatformViewFactory {

    /**
     * @param createArgsCodec the codec used to decode the args parameter of {@link #create}.
     */
    public FlutterImageViewFactory(MessageCodec<Object> createArgsCodec) {
        super(createArgsCodec);
    }

    @Override
    public PlatformView create(Context context, int viewId, Object args) {
        Map<String, String> map = (Map<String, String>) args;
        return new FlutterImageView(context, viewId, map.get("url"));
    }

}
