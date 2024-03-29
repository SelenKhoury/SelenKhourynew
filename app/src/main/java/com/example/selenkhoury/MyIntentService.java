package com.example.selenkhoury;
//
//import  android.app.IntentService;
//import  android.app.PendingIntent;
//import  android.app.Notification;
//import  android.app.NotificationChannel;
//import  android.app.NotificationManager;
//import  android.content.Intent;
//import  android.os.Build;
//import  androidx.annotation.Nullable;
//import  androidx.core.app.NotificationManagerCompat;
//
//public class MyIntentService extends IntentService{
//    private static final String CHANNEL_ID = "CHANNEL_3";
//    private static final int REQUEST_CODE = 1;
//    private static final int NOTIFICATION_ID = 1;
//    /**
//     * @deprecated
//     */
//    public MyIntentService(){
//        super("MyIntentService");
//    }
//    @Override
//    protected void onHandleIntent(@Nullable Intent intent) {
//        createNotificationChannel();
//        Notification.Builder nBuilder = new Notification.Builder(this);
//        nBuilder.setContentTitle("WELCOME TO MY APP");
//        nBuilder.setContentText("WELCOME TO MY APP");
//        nBuilder.setSmallIcon(R.drawable.ic_baseline_warning_24);
//
//        //what to do when the notification is clicked
//        Intent intent1 = new Intent(this, MainActivity.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, REQUEST_CODE, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
//        //connects the pending intent with the notification object,
//        // when the user clicks the on the notification the pending intent is called
//        nBuilder.setContentIntent(pendingIntent);
//
//        nBuilder.setChannelId(CHANNEL_ID);
//
//        Notification notification = nBuilder.build();
//        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
//        managerCompat.notify(NOTIFICATION_ID, notification);
//    }
//    /**
//     * create notification channel and set notification importance required for version 8.0 and above
//     * or sdk 26+
//     */
//    private void createNotificationChannel() {
//        // Create the NotificationChannel, but only on API 26+ because
//        // the NotificationChannel class is new and not in the support library
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            CharSequence name = getString(R.string.channel_name);
//            String description = getString(R.string.channel_description);
//            int importance = NotificationManager.IMPORTANCE_DEFAULT;
//            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
//            channel.setDescription(description);
//            // Register the channel with the system; you can't change the importance
//            // or other notification behaviors after this
//
//        }
//        NotificationManager notificationManager = getSystemService(NotificationManager.class);
//        notificationManager.createNotificationChannel(channel);
//    }
//
//}
//

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationManagerCompat;


public class MyIntentService extends IntentService {
    //this is the channel id for notification management uses
    private static final String CHANNEL_ID = "CHANNEL_3";
    private static final int REQUEST_CODE = 1;
    private static final int NOTIFICATION_ID = 1;

    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        Notification.Builder nBuilder = new Notification.Builder(this);
        nBuilder.setContentTitle("WELCOME TO MY APP");
        nBuilder.setContentText("WELCOME TO MY APP");
        nBuilder.setSmallIcon(R.drawable.ic_baseline_warning_24);

        //this intent will be pending until the user clicks on the notification
        //and will activate the activity specified in the intent
        Intent noIntent1 = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,REQUEST_CODE,noIntent1,PendingIntent.FLAG_UPDATE_CURRENT);
        nBuilder.setContentIntent(pendingIntent);

        Notification notification = nBuilder.build();
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(NOTIFICATION_ID,notification);

        NotificationManager mNotificationManager;
        mNotificationManager =
                (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

        //this is required for SDK version 26 and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_HIGH);
            mNotificationManager.createNotificationChannel(channel);
            nBuilder.setChannelId(CHANNEL_ID);
        }
        nBuilder.build();
        mNotificationManager.notify(NOTIFICATION_ID,notification);



    }


}
