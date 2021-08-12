package com.milo.flutterapp.flutter;

import android.app.Application;
import android.content.Context;

import com.milo.flutterapp.data.AppConstants;
import com.milo.flutterapp.flutter.imageview.FlutterImageViewPlugin;

import java.util.HashMap;
import java.util.Map;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;

/**
 * Title：
 * Describe：
 * Remark：
 * <p>
 * Created by Milo
 * E-Mail : 303767416@qq.com
 * 8/11/21
 */
public class FlutterEngineManager {

    private static FlutterEngineManager instance;

    private FlutterEngine fe;

    private Map<String, FlutterEngine> routerMapFe = new HashMap<>();

    private FlutterEngineManager() {
    }

    public static FlutterEngineManager getInstance() {
        if (instance == null) {
            synchronized (FlutterEngineManager.class) {
                instance = new FlutterEngineManager();
            }
        }
        return instance;
    }

    public void initFlutterEngine(Application application) {
        //Flutter引擎
        fe = new FlutterEngine(application);
        fe.getDartExecutor().executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault());

        new FlutterImageViewPlugin().registerWith(fe);

        //通过engine_id唯一标识来缓存
        FlutterEngineCache.getInstance().put(AppConstants.flutter_engine_id, fe);
    }

    public FlutterEngine getFlutterEngine() {
        return fe;
    }

    public FlutterEngine getRouterFlutterEngine(Context context, String router) {
        FlutterEngine fe = routerMapFe.get(router);
        if (fe == null) {
            fe = new FlutterEngine(context);
            fe.getNavigationChannel().setInitialRoute(router);
            fe.getDartExecutor().executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault());
            FlutterEngineCache.getInstance().put(router, fe);
            routerMapFe.put(router, fe);
        }
        return fe;
    }

}
