package com.que.sep_21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

// VALIDATE USERS USING SHAREDPREFERENCES
public class MainActivity extends AppCompatActivity {

    EditText etUser, etPwd;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUser = findViewById(R.id.et_User);
        etPwd = findViewById(R.id.et_Pwd);

    }

    public void saveData(View v){
        //SharedPreferences sp = getApplicationContext().getSharedPreferences("data1", MODE_PRIVATE);
        //^If not yet on main activity^
        SharedPreferences sp = getSharedPreferences("data1" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String user = etUser.getText().toString();
        String pwd = etPwd.getText().toString();
        editor.putString("user", user);
        editor.putString("password", pwd);
        editor.commit();
        Toast.makeText(this, "data saved in data1.xml", Toast.LENGTH_LONG).show();
    }

    public void validateData(View v){
        sp = getSharedPreferences("data1", MODE_PRIVATE);
        String userSP = sp.getString("user", null);
        String pwdSP = sp.getString("password", null);
        String user = etUser.getText().toString();
        String pwd = etPwd.getText().toString();
        if(userSP.equals(user) && pwdSP.equals(pwd)){
            Toast.makeText(this, "user is valid...", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "user is invalid...", Toast.LENGTH_LONG).show();
        }
    }

    public void display(View v){
        String userSP = sp.getString("user", null);
        String pwdSP = sp.getString("password", null);
        Toast.makeText(this, "Hello " +userSP, Toast.LENGTH_LONG).show();
    }

}
