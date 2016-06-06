package com.jenky.codebuddy.ui.activities;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import android.widget.Toast;

import com.android.volley.VolleyError;
import com.jenky.codebuddy.R;

import com.jenky.codebuddy.api.Callback;
import com.jenky.codebuddy.api.Request;
import com.jenky.codebuddy.util.Converters;

import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by JTLie on 30-5-2016.
 */
public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private EditText editTextEmail,
            editTextCode,
            editTextPassword,
            editTextPassConfirm;
    private Button buttonSendCode,
            buttonSignUp;
    private LinearLayout contentLayout;
    private final int viewWidth = 200;
    private final int textSize = 20;
    private final int buttonPadding = 5;
    private final Converters converters = new Converters(this);
    public static final Pattern emailRegex =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final Pattern passwordRegex =
            Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", Pattern.CASE_INSENSITIVE);

    private Callback verifyCallback = new Callback() {
        @Override
        public void onSuccess(JSONObject result) {
            Toast.makeText(SignUpActivity.this, "Password has been set", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onFailed(VolleyError error) {

        }


    };

    private Callback codeCallback = new Callback() {
        @Override
        public void onSuccess(JSONObject result) {
            Toast.makeText(SignUpActivity.this, "Request has been send. You should receive a email shortly", Toast.LENGTH_SHORT).show();
            setVerifyLayout();
        }

        @Override
        public void onFailed(VolleyError error) {

        }


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setViews();
        setSupportActionBar(toolbar);
        setTitle(R.string.app_name);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.send_code:
                sendEmail();
                break;
            default:
                Log.e("onClick", getString(R.string.unknown_id));
                break;
        }
    }


    private void setVerifyLayout() {
        contentLayout.removeAllViews();
        editTextCode = new EditText(this);
        editTextPassword = new EditText(this);
        editTextPassConfirm = new EditText(this);
        buttonSignUp = new Button(this);
        setViewStyling();
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPassword()) {
                    Request.setVerify(verifyCallback, editTextCode.getText().toString(), editTextPassword.getText().toString());
                }
            }
        });
        contentLayout.addView(editTextCode);
        contentLayout.addView(editTextPassword);
        contentLayout.addView(editTextPassConfirm);
        contentLayout.addView(buttonSignUp);
    }

    private boolean checkPassword() {
        if((validateRegex(editTextPassword.getText().toString(), passwordRegex))){
            Toast.makeText(SignUpActivity.this, R.string.invalid_password, Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(!editTextPassword.getText().toString().equals(editTextPassConfirm.getText().toString()))
        {
            Toast.makeText(SignUpActivity.this, R.string.mismatch_password, Toast.LENGTH_SHORT).show();
            return false;
        }
            return true;
    }

    private void setViewStyling() {
        editTextCode.setLayoutParams(getViewParams());
        editTextCode.setHint(R.string.verification_code);
        editTextCode.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);

        editTextPassword.setLayoutParams(getViewParams());
        editTextPassword.setHint(R.string.password);
        editTextPassword.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        editTextPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);

        editTextPassConfirm.setLayoutParams(getViewParams());
        editTextPassConfirm.setHint(R.string.confirm_password);
        editTextPassConfirm.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        editTextPassConfirm.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);


        buttonSignUp.setLayoutParams(getViewParams());
        buttonSignUp.setPadding(
                converters.getInDp(buttonPadding),
                converters.getInDp(buttonPadding),
                converters.getInDp(buttonPadding),
                converters.getInDp(buttonPadding)
        );
        buttonSignUp.setBackground(ContextCompat.getDrawable(this, R.drawable.default_button));
        buttonSignUp.setTextColor(ContextCompat.getColor(this, R.color.white));
        buttonSignUp.setText(getResources().getString(R.string.sign_up));
    }

    private void setViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        contentLayout = (LinearLayout) findViewById(R.id.content_layout);
        editTextEmail = (EditText) findViewById(R.id.email);
        buttonSendCode = (Button) findViewById(R.id.send_code);
        buttonSendCode.setOnClickListener(this);
    }

    public LinearLayout.LayoutParams getViewParams() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                converters.getInDp(viewWidth),
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(
                converters.getInDp(0),
                converters.getInDp(5),
                converters.getInDp(0),
                converters.getInDp(0));
        return params;
    }

    public static boolean validateRegex(String emailStr, Pattern pattern) {
        Matcher matcher = pattern.matcher(emailStr);
        return matcher.find();
    }

    private void sendEmail() {
        if (validateRegex(editTextEmail.getText().toString(), emailRegex)) {
            Request.getSignUp(codeCallback, editTextEmail.getText().toString());
        } else {
            Toast.makeText(this, R.string.invalid_mail, Toast.LENGTH_SHORT).show();
        }
    }


}
