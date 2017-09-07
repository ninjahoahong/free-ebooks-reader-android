package com.ninjahoahong.readmore;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.ninjahoahong.readmore.utils.ForceUpdateChecker;

import java.util.HashMap;
import java.util.Map;


public class AndroidApp extends Application {

    private static AppComponent appComponent;
    private static AndroidApp INSTANCE;

    private static final String TAG = AndroidApp.class.getSimpleName();
    private static final long FETCHING_DATA_PERIODICITY_IN_SECOND = 30;

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

        final FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();

        // set in-app defaults
        Map<String, Object> remoteConfigDefaults = new HashMap<>();
        remoteConfigDefaults.put(ForceUpdateChecker.KEY_UPDATE_REQUIRED, false);
        remoteConfigDefaults.put(ForceUpdateChecker.KEY_CURRENT_VERSION, "1.0.0");
        remoteConfigDefaults.put(ForceUpdateChecker.KEY_UPDATE_URL,
                "https://play.google.com/store/apps/details?id=com.ninjahoahong.readmore");

        firebaseRemoteConfig.setDefaults(remoteConfigDefaults);
        firebaseRemoteConfig.fetch(FETCHING_DATA_PERIODICITY_IN_SECOND)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "remote config is fetched.");
                        firebaseRemoteConfig.activateFetched();
                    }
                });
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
