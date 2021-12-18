package com.example.notificationtask;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void notify(View view) {
        int notificationId = 100;
        String CHANNEL_ID = "my_ch";
        String CHANNEL_NAME = "my_Channel";
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel notificationChannel = new
                NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance);
        NotificationManager notificationManager =(NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(notificationChannel);
        Intent intent = new Intent(this,SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                0);
        NotificationCompat.Builder builder = new
                NotificationCompat.Builder(this,CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentIntent(pendingIntent);
        builder.setContentTitle("My Notification");
        builder.setContentText("this is my simple notification");
        notificationManager.notify(notificationId,builder.build());
    }
}