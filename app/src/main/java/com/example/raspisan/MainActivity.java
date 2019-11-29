package com.example.raspisan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void Clocks(View v) {
        switch (v.getId()) {
            case R.id.button_set:
                Intent intent = new Intent(this, Clocks.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void Raspisan(View v) {
        switch (v.getId()) {
            case R.id.button_raspisan:
                Intent intent = new Intent(this, Raspisan.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void onClick_Set(View view) {

    }
}
