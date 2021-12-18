package com.example.notificationtask;
import androidx.appcompat.app.AppCompatActivity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(100);
    }
}