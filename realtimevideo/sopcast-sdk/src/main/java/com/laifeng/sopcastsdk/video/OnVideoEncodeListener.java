package com.laifeng.sopcastsdk.video;

import android.media.MediaCodec;
import java.nio.ByteBuffer;


public interface OnVideoEncodeListener {
    void onVideoEncode(ByteBuffer bb, MediaCodec.BufferInfo bi);
}
