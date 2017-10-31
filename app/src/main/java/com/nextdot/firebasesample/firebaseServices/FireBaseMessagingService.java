package com.nextdot.firebasesample.firebaseServices;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.support.v4.app.NotificationCompat;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.nextdot.firebasesample.AppointmentDetailsActivity;
import com.nextdot.firebasesample.MainActivity;
import com.nextdot.firebasesample.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import static android.app.Notification.FLAG_HIGH_PRIORITY;
import static android.app.Notification.PRIORITY_HIGH;
import static android.app.NotificationManager.IMPORTANCE_HIGH;

/**
 * Created by imtiazkalamabir on 10/15/17.
 */

public class FireBaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";
    Bitmap bitmap;
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


        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        String title = remoteMessage.getData().get("title");
        String body = remoteMessage.getData().get("body");
        String activity_action = remoteMessage.getData().get("activity_action");
        String activity_id = remoteMessage.getData().get("activity_id");



        //imageUri will contain URL of the image to be displayed with Notification
        String imageUrl = remoteMessage.getData().get("img_url");

        Log.d("IMAGEURL", imageUrl);

        //To get a Bitmap image from the URL received
        bitmap = getBitmapfromUrl(imageUrl);

        Log.d("BITMAPIMG", "----"+bitmap);

        //To get Circular bitmap from the generated bitmap
        Bitmap circularbitmap = getCircleBitmap(bitmap);


//      Showing the notification in the system tray and implementing logic to handle notification onclick.
        sendNotification(title, body, activity_action, activity_id, circularbitmap);


    }
    //This method is only generating push notification
    private void sendNotification(String messageTitle, String messageBody, String activityAction, String activityID, Bitmap bitmap) {

//      Putting some logic to set the right activity on intent to start when notification is clicked

        PendingIntent pendingIntent = null;

        if(activityAction.equals("appointment")){

            Intent intent = new Intent(this, AppointmentDetailsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("appointment_id", activityID);
            pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                    PendingIntent.FLAG_ONE_SHOT);


            // Do something here to handle the notification count to show on the notification badge.

        }else{

            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("some_id", "Put some value here to pass");
            pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                    PendingIntent.FLAG_ONE_SHOT);


        }


        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setLargeIcon(bitmap)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(messageTitle)
                .setContentText(messageBody)
                .setAutoCancel(true)
//                .setPriority(IMPORTANCE_HIGH)
                .setPriority(PRIORITY_HIGH)
                .setSound(defaultSoundUri)
//                .setNumber(3)
                .setContentIntent(pendingIntent);


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        count++;

        notificationManager.notify(count, notificationBuilder.build());


    }


    /*
   *To get a Bitmap image from the URL received
   * */
    public Bitmap getBitmapfromUrl(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            return bitmap;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;

        }
    }




    /*
   *To get a Circular Bitmap image from the converted Bitmap
   * */
    private Bitmap getCircleBitmap(Bitmap bitmap) {
        final Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(output);

        final int color = Color.RED;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawOval(rectF, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        bitmap.recycle();

        return output;
    }

}
