package com.somali_derp.laundryview.models;

/**
 * Created by mammothbane on 8/29/2014.
 */
public class Machine {
    public static final boolean WASHER = true;
    public static final boolean DRYER = false;

    public int id;
    public boolean type;
    public boolean top = false;
    public int above;

    public Status status;

    public static class Status {
        int code;
        int timeLeft;
        int cycleLength;
        String message;
    }
}
