package com.laifeng.sopcastsdk.stream.amf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



public interface AmfData {

    void writeTo(OutputStream out) throws IOException;


    void readFrom(InputStream in) throws IOException;

    int getSize();

    byte[] getBytes();
}
