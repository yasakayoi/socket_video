package com.test.video_play;


public class ScreenRecordApi {
    public static final byte encodeVersion1 = 0x00;       //版本号1

    public class RECORD {   //录屏指令
        public static final int MAIN_CMD = 1; //录屏主指令
        public static final int SEND_BUFF = 11;//发送声音的BUFF
    }

    public class SERVER {//服务端与客户端交互指令
        public static final int MAIN_CMD = 0xA0; //投屏回传主指令
        public static final int INITIAL_SUCCESS = 0x01;//服务端初始化成功
    }

}
