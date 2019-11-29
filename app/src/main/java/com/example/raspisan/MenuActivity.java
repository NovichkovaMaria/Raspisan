package com.example.raspisan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClick_Clocks(View v) {
        switch (v.getId()) {
            case R.id.button_Clocks:
                Intent intent = new Intent(this, ClocksActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void onClick_Raspisan(View v) {
        switch (v.getId()) {
            case R.id.button_Raspisan:
                Intent intent = new Intent(this, RaspisanActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
