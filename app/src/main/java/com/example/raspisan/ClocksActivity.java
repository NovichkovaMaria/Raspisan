package com.example.raspisan;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ClocksActivity extends AppCompatActivity {

    private String tag = "ClockActivity";
    private AlarmManagerBroadcastReceiver alarmReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clocks);
        alarmReceiver = new AlarmManagerBroadcastReceiver();
    }

    public void onClick_SetAlarm(View view){
        Log.d(tag, "onClick_Set");
        Context context = this.getApplicationContext();
        if (alarmReceiver != null){
            Calendar now = Calendar.getInstance();
            Calendar begin = Calendar.getInstance();
            RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
            int i = radioGroup.getCheckedRadioButtonId();
            RadioButton rb = (RadioButton)findViewById(i);
            Log.d(tag, rb.toString());
            switch(rb.getId()){
                case R.id.radioButton_1:
                    begin.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH), 8, 0, 0);
                    break;
                case R.id.radioButton_2:
                    begin.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH), 9, 40, 0);
                    break;
                case R.id.radioButton_3:
                    begin.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH), 11, 30, 0);
                    break;
                case R.id.radioButton_4:
                    begin.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH), 13, 10, 0);
                    break;
                case R.id.radioButton_5:
                    begin.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH), 14,50, 0);
                    break;
                case R.id.radioButton_6:
                    begin.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH), 16, 30, 0);
                    break;
                case R.id.radioButton_7:
                    begin.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH), 18, 10, 0);
                    break;
                case R.id.radioButton_8:
                    begin.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH), 19, 50, 0);
                    break;
                default:
                    Log.d(tag, "default");
                    break;
            }
            if (begin.before(now)){
                begin.add(Calendar.DAY_OF_MONTH, 1);
                Log.d(tag, "begin before now");
            }

            alarmReceiver.SetAlarm(context, begin);
        } else{
            Log.d(tag + " set", "Alarm is null");
        }
    }

    public void onClick_DeleteAlarm(View view){
        Log.d(tag, "onClick_Delete");
        Context context = this.getApplicationContext();
        if (alarmReceiver != null){
            alarmReceiver.CancelAlarm(context);
        } else {
            Log.d(tag + " cancel", "Alarm is null");
        }
    }
}
