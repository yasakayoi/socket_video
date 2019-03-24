package com.test.video_play.server.tcp.interf;


public abstract class OnServerStateChangeListener {
    //接收到客户端的Tcp连接
    public abstract void acceptH264TcpConnect();

    /**
     * by wt
     * 接收到客户端的Tcp断开连接
     */
    public abstract void acceptH264TcpDisConnect(Exception e);

    //读数据的时间
    public void acceptH264TcpNetSpeed(String netSpeed) {

    }

    public abstract void exception();

}
