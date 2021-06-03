package com.attendance.ip40.activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.attendance.ip40.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class studentlogin extends AppCompatActivity {
    String message;
    String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    Toolbar mToolbar;
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Teacher");
    private static long back_pressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlogin);

        Bundle bundle = getIntent().getExtras();
        message = bundle.getString("message");
        mToolbar=(Toolbar)findViewById(R.id.ftoolbar);
        mToolbar.setTitle(message+"'s Dashboard"+"("+date+")");
        TextView txtView = (TextView) findViewById(R.id.textView1);


        txtView.setText("Welcome :"+message);

    }
    public void viewAttendance(View v){
        Bundle basket = new Bundle();
        basket.putString("sid", message);
        Intent intent = new Intent(this, studentAttendanceActivity.class);
        intent.putExtras(basket);
        startActivity(intent);
    }

    public void logoutStudent(View view) {
        Intent logoutStudent=new Intent(studentlogin.this,DashboardActivity.class);
        logoutStudent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(logoutStudent);
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
