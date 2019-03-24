package com.laifeng.sopcastsdk.stream.sender.rtmp.io;

import com.laifeng.sopcastsdk.stream.sender.rtmp.Util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;



public class StoreChunk {
    private ByteArrayOutputStream baos = new ByteArrayOutputStream(1024 * 128);

    public boolean storeChunk(InputStream in, int messageLength, int chunkSize) throws IOException {
        final int remainingBytes = messageLength - baos.size();
        byte[] chunk = new byte[Math.min(remainingBytes, chunkSize)];
        Util.readBytesUntilFull(in, chunk);
        baos.write(chunk);
        return (baos.size() == messageLength);
    }

    public ByteArrayInputStream getStoredInputStream() {
        ByteArrayInputStream bis = new ByteArrayInputStream(baos.toByteArray());
        baos.reset();
        return bis;
    }

    /** Clears all currently-stored packet chunks (used when an ABORT packet is received) */
    public void clearStoredChunks() {
        baos.reset();
    }
}
