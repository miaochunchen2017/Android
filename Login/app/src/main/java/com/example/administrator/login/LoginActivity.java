package com.example.administrator.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button btn_logout;
    String welecome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_logout = (Button) findViewById(R.id.btn_login_logout);


        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView text_welecome = (TextView) findViewById(R.id.text_login_welecome);
                text_welecome.setText("dfsfsfs");

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                //启动
                startActivity(intent);
            }
        });


    }
}
