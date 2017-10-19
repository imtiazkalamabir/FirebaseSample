package com.nextdot.firebasesample.firebaseServices;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.support.v4.app.NotificationCompat;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.nextdot.firebasesample.R;

import java.util.Map;

import static android.app.Notification.FLAG_HIGH_PRIORITY;
import static android.app.Notification.PRIORITY_HIGH;
import static android.app.NotificationManager.IMPORTANCE_HIGH;

/**
 * Created by imtiazkalamabir on 10/15/17.
 */

public class FireBaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";
    private static int count = 0;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //Displaying data in log
        //It is optional
//        Log.d(TAG, "Notification Message TITLE: " + remoteMessage.getNotification().getTitle());
//        Log.d(TAG, "Notification Message BODY: " + remoteMessage.getNotification().getBody());
//        Log.d(TAG, "Notification Message DATA: " + remoteMessage.getData().toString());
//Calling method to generate notification

        Log.d("NotificationMsg","------"+remoteMessage.getNotification());

//        sendNotification(remoteMessage.getNotification().getTitle(),
//                remoteMessage.getNotification().getBody(), remoteMessage.getData());
    }
    //This method is only generating push notification
    private void sendNotification(String messageTitle, String messageBody, Map<String, String> row) {
        PendingIntent contentIntent = null;
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(messageTitle)
                .setContentText(messageBody)
                .setAutoCancel(true)
//                .setPriority(IMPORTANCE_HIGH)
                .setPriority(PRIORITY_HIGH)
                .setSound(defaultSoundUri)
                .setNumber(3)
                .setContentIntent(contentIntent);
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        count++;

        notificationManager.notify(count, notificationBuilder.build());


    }

}
