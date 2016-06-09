package com.jenky.codebuddy.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.jenky.codebuddy.R;
import com.jenky.codebuddy.api.Callback;
import com.jenky.codebuddy.api.Request;
import com.jenky.codebuddy.util.AppController;
import com.jenky.codebuddy.util.IntentFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEmail;
    private EditText editTextPassword;

    private Button buttonLogIn;
    private Button buttonSignUp;

    private Toolbar toolbar;

    private ProgressBar progressBar;
    private Callback tokenCallback = new Callback() {
        @Override
        public void onSuccess(JSONObject result) throws JSONException {
                AppController.getInstance().getPreferences().setToken(result.getString("responseMessage"));
                AppController.getInstance().getPreferences().setUserName(editTextEmail.getText().toString());
                logIn();
        }
        @Override
        public void onFailed(JSONObject result) throws JSONException {
            Toast.makeText(AppController.getInstance(), result.getString("responseMessage"), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(AppController.getInstance().getPreferences().hasCredentials()) {
            setContentView(R.layout.activity_log_in);
            setViews();
            setSupportActionBar(toolbar);
            setTitle(R.string.app_name);
        }
        else{
            logIn();
        }
    }

    private void setViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);
        buttonLogIn = (Button) findViewById(R.id.log_in);
        buttonSignUp = (Button) findViewById(R.id.sign_up);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        buttonSignUp.setOnClickListener(this);
        buttonLogIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.log_in:
                progressBar.setVisibility(View.VISIBLE);
                Request.getRequest(progressBar).getLogIn(tokenCallback, editTextEmail.getText().toString(), editTextPassword.getText().toString());
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
        Intent intent = IntentFactory.getMainIntent(AppController.getInstance());
        startActivity(intent);
        finish();
    }

    private void goToSignUp(){
        Intent intent = IntentFactory.getSignUpIntent(this);
        startActivity(intent);
    }

}
