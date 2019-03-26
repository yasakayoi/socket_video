package com.example.realtimevideo.ui;

import android.os.Environment;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.laifeng.sopcastsdk.configuration.AudioConfiguration;
import com.laifeng.sopcastsdk.configuration.VideoConfiguration;
import com.laifeng.sopcastsdk.stream.packer.tcp.TcpPacker;
import com.laifeng.sopcastsdk.stream.sender.OnSenderListener;
import com.laifeng.sopcastsdk.stream.sender.tcp.TcpSender;
import com.example.realtimevideo.Constant;
import com.example.realtimevideo.R;

import java.io.File;
import java.io.IOException;

public class LaifengScreenRecordActivity extends com.laifeng.sopcastsdk.screen.ScreenRecordActivity implements OnSenderListener {
    private AppCompatButton btn_start;
    private String ip;
    private VideoConfiguration mVideoConfiguration;
    private TcpSender tcpSender;
    private final static String TAG = "LaifengScreenRecord";
    private boolean isRecord = false;
    private EditText et_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ip = Constant.ip;
        initialView();
    }

    private void initialView() {
        btn_start = findViewById(R.id.btn_start);
        et_main = findViewById(R.id.et_main);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isRecord) {
                    if (!TextUtils.isEmpty(et_main.getText().toString())) {
                        ip = et_main.getText().toString();
                    }
                    requestRecording();
                    Log.e(TAG, "Ip = " + ip + "start record");
                    btn_start.setText("start record");
                } else {
                    stopRecording();
                    Log.e("Test", "stop record");
                    btn_start.setText("stop record");
                }
            }
        });
    }

    private void initialData() {
        String path = Environment.getExternalStorageDirectory() + "/test";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file1 = new File(file, "test.h264");
        if (file1.exists()) {
            file1.delete();
        }
        try {
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Test", "" + e.toString());
        }
    }

    @Override
    protected void requestRecordSuccess() {
        super.requestRecordSuccess();
        isRecord = true;
        startRecord();
    }

    @Override
    protected void requestRecordFail() {
        super.requestRecordFail();
    }

    private void startRecord() {
        TcpPacker packer = new TcpPacker();
        packer.setSendAudio(true);
        packer.initAudioParams(AudioConfiguration.DEFAULT_FREQUENCY, 16, false);
        mVideoConfiguration = new VideoConfiguration.Builder().build();
        setVideoConfiguration(mVideoConfiguration);
        setRecordPacker(packer);

        tcpSender = new TcpSender(ip, Constant.port);
        tcpSender.setSenderListener(this);
        tcpSender.setVideoParams(mVideoConfiguration);
        tcpSender.connect();
        setRecordSender(tcpSender);
        startRecording();
    }

    @Override
    public void onConnecting() {
        Log.e(TAG, "onConnecting ...");
    }

    @Override
    public void onConnected() {
        Log.e(TAG, "onConnected");
    }

    @Override
    public void onDisConnected() {
        Log.e(TAG, "onDisConnected");
    }

    @Override
    public void onPublishFail() {
        Log.e(TAG, "onPublishFail");
    }

    @Override
    public void onNetGood() {

    }

    @Override
    public void onNetBad() {

    }


    @Override
    protected void onDestroy() {
        tcpSender.stop();
        super.onDestroy();
    }

}
