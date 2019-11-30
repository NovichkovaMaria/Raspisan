package com.example.raspisan;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class AlarmManagerBroadcastReceiver extends BroadcastReceiver {

    private String tag = "AlarmManager";

    public AlarmManagerBroadcastReceiver(){
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        PowerManager powerManager = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                "raspisan:wakelock");
        wakeLock.acquire();
        Log.d(tag, "onReceive WakeLock");

        wakeLock.release();
    }

    public void SetAlarm(Context context, Calendar begin){
        Log.d(tag, "SetAlarm");
        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        alarmManager.set(AlarmManager.RTC_WAKEUP, begin.getTimeInMillis(), pendingIntent);

        Log.d(tag, "Month = " + Integer.toString(begin.get(Calendar.MONTH) + 1));
        Log.d(tag, "Day = " + Integer.toString(begin.get(Calendar.DAY_OF_MONTH)));
        Log.d(tag, "Hour = " + Integer.toString(begin.get(Calendar.HOUR_OF_DAY)));
        Log.d(tag, "Minute = " + Integer.toString(begin.get(Calendar.MINUTE)));

        String output = Integer.toString(begin.get(Calendar.DAY_OF_MONTH)) + "." + Integer.toString(begin.get(Calendar.MONTH)) +
                "\n" + Integer.toString(begin.get(Calendar.HOUR_OF_DAY)) + ":" + Integer.toString(begin.get(Calendar.MINUTE));
        Toast toast = Toast.makeText(context, output, Toast.LENGTH_LONG);
        toast.show();
    }

    public void CancelAlarm(Context context){
        Log.d(tag, "CancelAlarm");
        Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
        Toast toast = Toast.makeText(context, "Будильник выключен", Toast.LENGTH_SHORT);
        toast.show();

    }
}
