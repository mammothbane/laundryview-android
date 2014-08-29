package com.somali_derp.laundryview;

import android.app.Application;

import com.somali_derp.laundryview.core.ApplicationModule;

import dagger.ObjectGraph;
import mortar.Mortar;
import mortar.MortarScope;

/**
 * Created by mammothbane on 8/29/2014.
 */
public class App extends Application {
    private MortarScope rootScope;

    @Override
    public void onCreate() {
        super.onCreate();
        rootScope = Mortar.createRootScope(BuildConfig.DEBUG, ObjectGraph.create(new ApplicationModule()));
    }

    @Override
    public Object getSystemService(String name) {
        return (Mortar.isScopeSystemService(name)) ? rootScope : super.getSystemService(name);
    }
}
