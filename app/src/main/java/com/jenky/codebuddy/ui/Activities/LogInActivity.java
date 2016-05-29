package com.jenky.codebuddy.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jenky.codebuddy.R;
import com.jenky.codebuddy.util.IntentFactory;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText
            editTextUsername,
            editTextPassword;

    private Button
            buttonLogIn,
            buttonSignUp;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        setViews();
        setSupportActionBar(toolbar);
        setTitle(R.string.app_name);
    }

    private void setViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        editTextUsername = (EditText) findViewById(R.id.username);
        editTextPassword = (EditText) findViewById(R.id.password);
        buttonLogIn = (Button) findViewById(R.id.log_in);
        buttonSignUp = (Button) findViewById(R.id.sign_up);
        buttonSignUp.setOnClickListener(this);
        buttonLogIn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.log_in:
                logIn();
                break;
            case R.id.sign_up:
                signUp();
                break;
            default:
                Log.e("onClick()", getString(R.string.unknown_id));
                break;
        }
    }

    private void logIn(){
        if(editTextUsername.getText().toString().toLowerCase().equals("jtlie") && (editTextPassword.getText().toString().equals("test123"))){
            Intent intent = IntentFactory.getMainIntent(this);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(getApplication(), "Wrong Login", Toast.LENGTH_SHORT).show();
        }
        //TODO create login method
    }

    private void signUp(){
        //TODO create signup method
    }
}
