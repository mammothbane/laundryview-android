package com.somali_derp.laundryview.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by mammothbane on 8/29/2014.
 */

@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface MainThread {}
