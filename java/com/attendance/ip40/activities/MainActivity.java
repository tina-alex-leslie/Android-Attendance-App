package com.attendance.ip40.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.widget.Button;
import android.widget.Toast;

import com.attendance.ip40.R;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent mainIntent = new Intent(MainActivity.this, DashboardActivity.class);
                    MainActivity.this.startActivity(mainIntent);
                    MainActivity.this.finish();
                }
            }, 2000);
        }
        catch (Exception e){
            Toast.makeText(this,"splash not working",Toast.LENGTH_LONG);
        }
    }



}
