package com.ninjahoahong.readmore;

import android.app.Application;
import android.content.Context;


public class AndroidApp extends Application {

    private static AppComponent appComponent;
    private static AndroidApp INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        if (INSTANCE == null) {
            INSTANCE = this;
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(getApplicationContext()))
                    .netModule(new NetModule(BuildConfig.API_BASE_URL))
                    .build();
        }
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static AndroidApp get(Context context) {
        return (AndroidApp) context.getApplicationContext();
    }

    public static AndroidApp get() {
        return INSTANCE;
    }
}
