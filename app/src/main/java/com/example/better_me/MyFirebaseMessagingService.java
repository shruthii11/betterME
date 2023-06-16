package com.example.better_me;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // Handle incoming messages here
        // You can customize the notification and trigger it once a day
    }
    @Override
    public void onNewToken(String token) {
        Log.d("FCM Token", token);
    }

}
