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

import com.android.volley.VolleyError;
import com.jenky.codebuddy.R;
import com.jenky.codebuddy.api.Callback;
import com.jenky.codebuddy.api.Request;
import com.jenky.codebuddy.util.AppController;
import com.jenky.codebuddy.util.IntentFactory;

import org.json.JSONException;
import org.json.JSONObject;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText
            editTextEmail,
            editTextPassword;

    private Button
            buttonLogIn,
            buttonSignUp;

    private Toolbar toolbar;

    private Callback tokenCallback = new Callback() {
        @Override
        public void onSuccess(JSONObject result) {
            try {
                AppController.getInstance().getPreferences().setToken(result.getString("token"));
                Intent intent = IntentFactory.getMainIntent(AppController.getInstance());
                intent.putExtra("username", editTextEmail.getText().toString());
                startActivity(intent);
                finish();
            } catch (JSONException e) {
                Toast.makeText(AppController.getInstance(), "Something went wrong", Toast.LENGTH_SHORT);
                e.printStackTrace();
            }

        }

        @Override
        public void onFailed(VolleyError error){
            Log.e("Request failed", Integer.toString(error.networkResponse.statusCode));

        }
    };

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
        editTextEmail = (EditText) findViewById(R.id.email);
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

            Request.getLogIn(tokenCallback, editTextEmail.getText().toString(), editTextPassword.getText().toString());
            //TODO move intent to tokenCallback success
    }

    private void goToSignUp(){
        Intent intent = IntentFactory.getSignUpIntent(this);
        startActivity(intent);
    }


}
