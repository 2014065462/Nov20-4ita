package com.que.internal_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.editText);
    }

    public void writeData(View v){
        FileOutputStream writer = null;
        String data = input.getText().toString();
        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            writer.write(data.getBytes());
        } catch (FileNotFoundException e) {
            Log.d("error", "File not found.");
        } catch (IOException e) {
            Log.d("error", "IO error");
        }
        finally{
            try {
                writer.close();
            } catch (IOException e) {
                Log.d("error", "IO error");
            }
        }
        Toast.makeText(this,"data saved in internal storage..", Toast.LENGTH_LONG).show();
    }
    public void saveData(View v){
        StringBuffer msg = null;
        try{
            int token;
            msg = new StringBuffer();
            FileInputStream reader = openFileInput("data1.txt");
            while((token=reader.read()) != -1){
                msg.append((char)token);
            }
        }catch(FileNotFoundException e){
            Log.d("error", "File not found.");
        } catch (IOException e) {
            Log.d("error", "IO error");
        }
        Toast.makeText(this, msg.toString(), Toast.LENGTH_LONG).show();
    }
    public void showData(View v){
        String msg = "";
        try{
            int token;
            FileInputStream reader = openFileInput("data1.txt");
            while((token=reader.read()) != -1){
                msg = msg + (char)token;
        }
    } catch (FileNotFoundException e) {
            Log.d("error", "File not found.");
        } catch (IOException e) {
            Log.d("error", "IO error");
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
