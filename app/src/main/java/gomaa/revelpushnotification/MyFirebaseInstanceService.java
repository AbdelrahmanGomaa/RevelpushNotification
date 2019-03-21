package gomaa.revelpushnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MyFirebaseInstanceService extends FirebaseMessagingService {


    @Override
    public void onNewToken(String s) {

        super.onNewToken(s);

        Log.d("TOKEN", s);

    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        if (remoteMessage.getData() != null ){
            SendNotification(remoteMessage);
        }
    }

    private void SendNotification(RemoteMessage remoteMessage) {

       // Map<String,String> data = remoteMessage.getData();
       // String title= data.get("title");
      //  String content= data.get("content");

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNAL="CHANNAL_1";

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,NOTIFICATION_CHANNAL);
        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(android.support.v4.R.drawable.notification_icon_background)
                .setTicker("Heart365")
                //.setContentTitle(title)
                //.setContentText(content)
                .setContentInfo("info");
        notificationManager.notify(1,notificationBuilder.build());

    }
}
