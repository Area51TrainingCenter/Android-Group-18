package com.jcodee.niv1mod2class3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jcodee.utils.GPSTracker;

public class MainActivity extends AppCompatActivity {
    private TextView lblLatitud, lblLongitud;
    private Button btnObtener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblLatitud = (TextView) findViewById(R.id.lblLatitud);
        lblLongitud = (TextView) findViewById(R.id.lblLongitud);
        btnObtener = (Button) findViewById(R.id.btnObtener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GPSTracker gpsTracker = new GPSTracker(MainActivity.this);
                if (gpsTracker.canGetLocation()) {
                    lblLatitud.setText(String.valueOf(gpsTracker.getLatitude()));
                    lblLongitud.setText(String.valueOf(gpsTracker.getLongitude()));
                } else {
                    gpsTracker.showSettingsAlert();
                }
            }
        });
    }
}
