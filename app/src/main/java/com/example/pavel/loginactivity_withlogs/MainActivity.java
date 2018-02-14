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

    final String TAG = "MainActivityLifeCycle";

    private Button login;
    private EditText name, password;
    private ImageView image;
    private TextView enterText;
    private boolean buttonClick;
    private int buffImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Activity: onCreate()");

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
                    buttonClick = true;
                    Toast.makeText(MainActivity.this, R.string.welkome, Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this, R.string.all_fields, Toast.LENGTH_LONG).show();
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
        Log.d(TAG, "Activity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Activity: onResume()");
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (buttonClick == true){
            outState.putInt("imgId", R.drawable.open);
        }else {
            outState.putInt("imgId", R.drawable.lock);
        }
        Log.d(TAG, "onSaveInstanceState: ImgRes Saved");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Activity: onPause()");
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "" + savedInstanceState.getInt("imgId"));
        image.setImageResource(savedInstanceState.getInt("imgId"));
        Log.d(TAG, "onRestoreInstanceState: Img Viewed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Activity: onStop()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Activity: onDestroy()");
    }

}
