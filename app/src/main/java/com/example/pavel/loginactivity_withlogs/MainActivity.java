package com.example.pavel.loginactivity_withlogs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    final String TAG = "ActivityLifeCycle";

    private Button login;
    private EditText name, password;
    private ImageView image;
    private TextView enterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "MainActivity: onCreate()");

        login = (Button)findViewById(R.id.loginButton);
        name = (EditText) findViewById(R.id.nameField);
        password = (EditText) findViewById(R.id.passwordField);
        image = (ImageView)findViewById(R.id.imageLock);
        enterText = (TextView)findViewById(R.id.enterText);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkFields()){
                    changeImage();
                    Toast.makeText(MainActivity.this, "Добро Пожаловать", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this, "Заполните все поля", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private boolean checkFields(){
        if (name.length()>0 && password.length()>0){
            return true;
        }else{
            return false;
        }
    }

    private void changeImage(){

        image.setImageResource(R.drawable.open);
    }

    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity: onDestroy()");
    }

}
