package com.example.administrator.login;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_signUp_backToMain,btn_signUp_submit;
    String userName,password,email,phone;
    //数据库
    private Context mContext;                   //上下文，用于标识项目进度
    private SQLiteDatabase db;
    private MyDBOpenHelper myDBHelper;
    private StringBuilder sb;
    private int i = 1;



    //首先创建一个数据的帮助类，继承SQLiteOpenHelper
    public class MyDBOpenHelper extends SQLiteOpenHelper {
        public MyDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                              int version) {super(context, "my.db", null, 1); }
        @Override
        //数据库第一次创建时被调用
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE person(personid INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(20),password VARCHAR(20),emil VARCHAR(30),phone VARCHAR(15)");
        }
        //软件版本号发生改变时调用
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("ALTER TABLE person ADD phone VARCHAR(12) NULL");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mContext = SignUpActivity.this;
        myDBHelper = new MyDBOpenHelper(mContext, "my.db", null, 1);
        bindViews();
    }

    private void bindViews() {
        btn_signUp_submit = (Button) findViewById(R.id.btn_signUp_submit);
        btn_signUp_backToMain = (Button) findViewById(R.id.btn_signUp_backToMain);

        btn_signUp_submit.setOnClickListener(this);
        btn_signUp_backToMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        db = myDBHelper.getWritableDatabase();
        switch(v.getId()){
            case R.id.btn_signUp_backToMain:
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                //启动
                startActivity(intent);
                break;
            case R.id.btn_signUp_submit:
                ContentValues values1 = new ContentValues();
                values1.put("name", "呵呵~" + i);
                i++;
                //参数依次是：表名，强行插入null值得数据列的列名，一行记录的数据
                db.insert("person", null, values1);
                Toast.makeText(mContext, "插入完毕~", Toast.LENGTH_SHORT).show();
                break;

        }


    }




//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_signup);
//        mContext = SignUpActivity.this;
//        myDBHelper = new MyDBOpenHelper(mContext, "my.db", null, 1);
//
//        btn_backToMain = (Button)findViewById(R.id.btn_signUp_backToMain);
//        btn_backToMain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
//                //启动
//                startActivity(intent);
//            }
//        });
//    }


}
