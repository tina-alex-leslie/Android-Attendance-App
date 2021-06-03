package com.attendance.ip40.activities;

import android.content.Intent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.attendance.ip40.R;

public class DashboardActivity extends AppCompatActivity {
    Button admin, student, teacher,info;
    private static long back_pressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        admin = findViewById(R.id.buttonAdmin);
        student = findViewById(R.id.buttonStudent);
        teacher = findViewById(R.id.buttonTeacher);
        info = findViewById(R.id.buttonInfo);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, adminLoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, loginstudent.class);
                startActivity(intent);
                finish();
            }
        });

        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, loginteacherActivity.class);
                startActivity(intent);
                finish();
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.buttonInfo:
                        alertDialog();
                        break;
                }
            }
            private void alertDialog()
            {
                AlertDialog.Builder dialog= new AlertDialog.Builder(DashboardActivity.this);
                String messageText = "It has three Sections:"+
                        "\n1) Admin"+
                        "\n2) Faculty"+
                        "\n3) Student"+
                        "\n\n If you have'nt registered please contact Admin or Faculty";
                dialog.setMessage(messageText);
                dialog.setTitle("Welcome to  Online Attendance Management System");
                AlertDialog alertDialog=dialog.create();
                alertDialog.show();
            }
        });
    }
    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
            finish();
            ActivityCompat.finishAffinity(this);
            System.exit(0);
        }
        else {
            Toast.makeText(getBaseContext(), "Press once again to exit", Toast.LENGTH_SHORT).show();
            back_pressed = System.currentTimeMillis();
        }
    }


}