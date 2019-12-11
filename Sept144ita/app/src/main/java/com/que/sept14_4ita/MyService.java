package com.que.sept14_4ita;

import android.app.IntentService;
import android.util.Log;
import android.content.Intent;

public class MyService extends IntentService {
    public MyService() {
        super("MyService");
    }
    protected void onHandleIntent(Intent intent) {
        for (int i=0;i<10;i++)
        Log.d("MyService", "Hello " + (i+1));
    }
}
