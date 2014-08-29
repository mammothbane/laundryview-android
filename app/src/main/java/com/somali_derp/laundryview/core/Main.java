package com.somali_derp.laundryview.core;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Provides;
import flow.Flow;
import flow.HasParent;
import flow.Parcer;
import mortar.Blueprint;

/**
 * Created by mammothbane on 8/29/2014.
 */
public class Main implements Blueprint {

    @Override
    public String getMortarScopeName() {
        return getClass().getName();
    }

    @Override
    public Object getDaggerModule() {
        return new Module();
    }

    public static class Module {
        @Provides @MainScope Flow provideFlow(Presenter presenter) {
            return presenter.getFlow();
        }
    }

    @Singleton
    public static class Presenter extends FlowOwner<Blueprint, MainView> {

        @Inject
        Presenter(Parcer<Object> flowParcer) {
            super(flowParcer);
        }

        @Override public void showScreen(Blueprint newScreen, Flow.Direction direction) {
            boolean hasUp = newScreen instanceof HasParent;
            String title = newScreen.getClass().getSimpleName();

            super.showScreen(newScreen, direction);
        }

        @Override protected Blueprint getFirstScreen() {
            return new ChatListScreen();
        }

        public void onFriendsListPicked() {
            getFlow().goTo(new FriendListScreen());
        }
    }

}
