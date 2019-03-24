package com.test.video_play.server.tcp.interf;


import com.test.video_play.entity.Frame;



public interface OnAcceptBuffListener {
    void acceptBuff(Frame frame);
}
