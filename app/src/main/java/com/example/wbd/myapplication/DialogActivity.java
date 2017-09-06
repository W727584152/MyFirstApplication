package com.example.wbd.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        Button btnOne=(Button)findViewById(R.id.button1);
        Button btnTwo=(Button)findViewById(R.id.button2);
        btnOne.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(DialogActivity.this, "请点击登录", Toast.LENGTH_LONG).show();
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.login_dialog,null);
                final EditText UserName = (EditText)view.findViewById(R.id.editTextUserId);
                final EditText Password = (EditText)view.findViewById(R.id.editTextPwd);
                AlertDialog.Builder Builder = new AlertDialog.Builder(DialogActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                Builder.setView(view).setTitle("Login").setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        if (UserName.getText().toString().equals("abc") &&Password.getText().toString().equals("123")) {
                            Toast.makeText(DialogActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(DialogActivity.this, "账号或密码错误", Toast.LENGTH_LONG).show();
                        }
                }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
                Builder.show();
            }
        });

    }
}
