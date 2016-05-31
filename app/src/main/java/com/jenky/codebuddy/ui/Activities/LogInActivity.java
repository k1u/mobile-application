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
import com.jenky.codebuddy.api.Callback;
import com.jenky.codebuddy.api.Request;
import com.jenky.codebuddy.util.AppController;
import com.jenky.codebuddy.util.IntentFactory;
import com.jenky.codebuddy.util.Preferences;

import org.json.JSONObject;

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
                goToSignUp();
                break;
            default:
                Log.e("onClick", getString(R.string.unknown_id));
                break;
        }
    }

    private void logIn(){
        if(editTextUsername.getText().toString().toLowerCase().equals("jtlie") && (editTextPassword.getText().toString().equals("test123"))){

            Request.getToken(tokenCallback, editTextUsername.getText().toString(), editTextPassword.getText().toString());
        }else{
            Toast.makeText(getApplication(), "Wrong Login", Toast.LENGTH_SHORT).show();
        }
        //TODO create login method
    }

    private void goToSignUp(){
        Intent intent = IntentFactory.getSignUpIntent(this);
        startActivity(intent);
    }

    private Callback tokenCallback = new Callback() {
        @Override
        public void onSuccess(JSONObject result) {
            //TODO settoken
           // AppController.getInstance().getPreferences().setToken();
            Intent intent = IntentFactory.getMainIntent(AppController.getInstance());
            startActivity(intent);
            finish();
        }
    };
}
