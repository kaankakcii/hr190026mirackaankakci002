package com.hr190026.mirac_kaan_kakci_final.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;

import com.hr190026.mirac_kaan_kakci_final.util.Constants;
import com.hr190026.mirac_kaan_kakci_final.R;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        timerStart();
    }


    private void timerStart() {


        CountDownTimer countDownTimer = new CountDownTimer(Constants.INTERVAR, Constants.MILISECOND) {
            @Override
            public void onTick(long l) {
            }
            @Override
            public void onFinish() {

                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
                if (activeNetwork != null) {

                    switchScreen();

                } else {

                    warningMessage();

                }
            }
        };
        countDownTimer.start();
    }


    private void warningMessage()

    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.alert_title));
        builder.setMessage(getResources().getString(R.string.alert_message));
        builder.setPositiveButton(getResources().getString(R.string.alert_positive_button), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
            }
        });

        builder.setNegativeButton(getResources().getString(R.string.alert_negative_button), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                finish();
            }
        });

        builder.show();
    }

    private void switchScreen(){

        Intent ListActivity = new Intent(getApplicationContext(), com.hr190026.mirac_kaan_kakci_final.activity.ListActivity.class);
        startActivity(ListActivity);
        finish();

    }

}