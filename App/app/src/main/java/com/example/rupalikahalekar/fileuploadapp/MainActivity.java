package com.example.rupalikahalekar.fileuploadapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    final String myTag = "DocsUpload";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(myTag, "OnCreate()");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                postData();

            }
        });
        t.start();
    }

    public void postData() {

        String fullUrl = "https://docs.google.com/forms/d/e/1FAIpQLSfBW6s1zUaQ1s3s8rgDilxGXU1rYse9aSVCRR1b2VTa8k39qQ/formResponse";
        HttpRequest mReq = new HttpRequest();
        String col1 = "Hello";
        String col2 = "World";

        String data = "entry.669111814=" + URLEncoder.encode(col1) + "&" +
                "entry.1636579451=" + URLEncoder.encode(col2);
        String response = mReq.sendPost(fullUrl, data);
        Log.i(myTag, response);
    }
}
