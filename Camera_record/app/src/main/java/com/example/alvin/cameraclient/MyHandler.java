package com.example.alvin.cameraclient;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;


class MyHandler extends Handler {
    private final WeakReference<MainActivity> mActivity;

    public MyHandler(MainActivity activity) {
        mActivity = new WeakReference<MainActivity>(activity);
    }

    @Override
    public void handleMessage(Message msg) {
        MainActivity activity = mActivity.get();
        if (activity != null) {
            try {
                activity.mLastFrame = (Bitmap) msg.obj;
            } catch (Exception e) {
                e.printStackTrace();
            }
            super.handleMessage(msg);
        }
    }
}