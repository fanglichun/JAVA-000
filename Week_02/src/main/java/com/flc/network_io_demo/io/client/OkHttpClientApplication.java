package com.flc.network_io_demo.io.client;


import okhttp3.*;

import java.io.IOException;

public class OkHttpClientApplication {

    public static void main(String[] args) {
        String url = "http://127.0.0.1:8801";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        aSync(call);
//        sync(call);
    }

    private static void sync(Call call) {
        new Thread(() -> {
            try {
                Response response = call.execute();
                System.out.println("sync response:" + response.body().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void aSync(Call call ) {
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("线程Id为:" + Thread.currentThread().getId());
                System.out.println("response:" + response);
                System.out.println("headers:" + response.headers());
                System.out.println("message:"+ response.message());
                System.out.println("body:" + response.body());
                System.out.println("code:" + response.code());
            }
        });
    }
}
