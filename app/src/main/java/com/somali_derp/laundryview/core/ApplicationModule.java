package com.somali_derp.laundryview.core;

import android.os.Handler;
import android.os.Looper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.HandlerThreadScheduler;

/**
 * Created by mammothbane on 8/29/2014.
 */

@Module(library = true)
public class ApplicationModule {
    @Provides @Singleton @MainThread Scheduler provideMainThread() {
        final Handler handler = new Handler(Looper.getMainLooper());
        return new HandlerThreadScheduler(handler);
    }

}
