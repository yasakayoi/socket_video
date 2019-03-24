package com.test.video_play.utils;


public class ByteUtil {

    public static byte[] int2Bytes(int length) {
        byte[] result = new byte[4];
        result[0] = (byte) length;
        result[1] = (byte) (length >> 8);
        result[2] = (byte) (length >> 16);
        result[3] = (byte) (length >> 24);
        return result;
    }

    //转成2个字节
    public static byte[] short2Bytes(short size) {
        byte[] result = new byte[2];
        result[0] = (byte) size;
        result[1] = (byte) (size >> 8);
        return result;
    }


    public static int bytesToInt(byte[] src) {
        int value;
        value = (int) ((src[0] & 0xFF)
                | ((src[1] & 0xFF) << 8)
                | ((src[2] & 0xFF) << 16)
                | ((src[3] & 0xFF) << 24));
        return value;
    }

    public static short bytesToShort(byte[] src) {
        short value;
        value = (short) ((src[0] & 0xFF)
                | ((src[1] & 0xFF) << 8));
        return value;
    }



    public static byte getCheckCode(byte[] bytes) {
        byte b = 0x00;
        for (int i = 0; i < bytes.length; i++) {
            b ^= bytes[i];
        }
        return b;
    }
}
