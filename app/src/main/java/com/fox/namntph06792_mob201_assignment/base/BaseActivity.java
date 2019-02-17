package com.fox.namntph06792_mob201_assignment.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void navigateActivity(Class targer){
        Intent intent = new Intent(this,targer);
        startActivity(intent);
    }

    public void showMessage(String mess){
        Toast.makeText(this, mess, Toast.LENGTH_SHORT).show();
    }

}
