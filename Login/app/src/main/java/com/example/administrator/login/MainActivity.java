package com.example.administrator.login;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_submit = null;
    Button btn_signUp = null;
    String userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_signUp = (Button) findViewById(R.id.btn_signUp);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //测试用户名密码输入框内容
                //Toast.makeText(MainActivity.this, userName, Toast.LENGTH_SHORT).show();

                //用户名
                EditText text_userName = (EditText) findViewById(R.id.text_userName);
                userName = text_userName.getText().toString();
                //密码
                EditText text_password = (EditText) findViewById(R.id.text_password);
                password = text_password.getText().toString();

                if (userName.length() != 0 && password.length() != 0) {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    //启动
                    startActivity(intent);
                } else {

                    Toast.makeText(MainActivity.this, "输入的用户名或密码为空", Toast.LENGTH_SHORT).show();
                    //System.out.print("输入的用户名为空");
                }
            }
        });

        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                //启动
                startActivity(intent);
            }
        });

    }
}
