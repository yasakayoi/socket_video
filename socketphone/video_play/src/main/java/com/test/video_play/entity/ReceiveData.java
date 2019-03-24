package com.test.video_play.entity;



public class ReceiveData {
    private ReceiveHeader header;
    private byte[] buff;

    public ReceiveHeader getHeader() {
        return header;
    }

    public void setHeader(ReceiveHeader header) {
        this.header = header;
    }

    public byte[] getBuff() {
        return buff;
    }

    public void setBuff(byte[] buff) {
        this.buff = buff;
    }
}
