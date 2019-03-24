package com.laifeng.sopcastsdk.stream.sender;



public interface OnSenderListener {
    void onConnecting();
    void onConnected();
    void onDisConnected();
    void onPublishFail();
    void onNetGood();
    void onNetBad();
}
