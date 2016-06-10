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
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.jenky.codebuddy.R;
import com.jenky.codebuddy.api.Callback;
import com.jenky.codebuddy.api.Request;
import com.jenky.codebuddy.util.AppController;
import com.jenky.codebuddy.util.Utilities;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by JTLie on 30-5-2016.
 */
public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private EditText editTextEmail;
    private EditText editTextCode;
    private EditText editTextPassword;
    private EditText editTextPassConfirm;
    private Button buttonSendCode;
    private Button buttonSignUp;
    private Button verifyLayout;
    private LinearLayout contentLayout;
    private int viewWidth = 200;
    private int textSize = 20;
    private int buttonPadding = 5;
    private ProgressBar progressBar;

    public static final Pattern emailRegex =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final Pattern passwordRegex =
            Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", Pattern.CASE_INSENSITIVE);

    private Callback verifyCallback = new Callback() {
        @Override
        public void onSuccess(JSONObject result) {
            Toast.makeText(SignUpActivity.this, "Password has been set", Toast.LENGTH_SHORT).show();
            finish();
        }

        public void onFailed(JSONObject result) throws JSONException {
            progressBar.setVisibility(View.INVISIBLE);
            Toast.makeText(AppController.getInstance(), result.getString("responseMessage"), Toast.LENGTH_SHORT).show();
        }
    };

    private Callback codeCallback = new Callback() {
        @Override
        public void onSuccess(JSONObject result) {
            progressBar.setVisibility(View.INVISIBLE);
            Toast.makeText(SignUpActivity.this, "Request has been send. You should receive a email shortly", Toast.LENGTH_SHORT).show();
            setVerifyLayout();
        }

        public void onFailed(JSONObject result) throws JSONException {
            progressBar.setVisibility(View.INVISIBLE);
            Toast.makeText(AppController.getInstance(), result.getString("responseMessage"), Toast.LENGTH_SHORT).show();
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
            case R.id.got_code:
                setVerifyLayout();
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
                    Request.getRequest(progressBar).setVerify(verifyCallback, editTextCode.getText().toString(), editTextPassword.getText().toString());
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });
        contentLayout.addView(editTextCode);
        contentLayout.addView(editTextPassword);
        contentLayout.addView(editTextPassConfirm);
        contentLayout.addView(buttonSignUp);
    }

    private boolean checkPassword() {
        if (validateRegex(editTextPassword.getText().toString(), passwordRegex)) {
            Toast.makeText(SignUpActivity.this, R.string.invalid_password, Toast.LENGTH_SHORT).show();
            return false;
        } else if (!editTextPassword.getText().toString().equals(editTextPassConfirm.getText().toString())) {
            Toast.makeText(SignUpActivity.this, R.string.mismatch_password, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void setViewStyling() {
        editTextCode.setLayoutParams(Utilities.getLayoutParams(this, viewWidth, LinearLayout.LayoutParams.WRAP_CONTENT, 0,5,0,0));
        editTextCode.setHint(R.string.verification_code);
        editTextPassword.setMaxLines(1);
        editTextCode.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);

        editTextPassword.setLayoutParams(Utilities.getLayoutParams(this, viewWidth, LinearLayout.LayoutParams.WRAP_CONTENT, 0,5,0,0));
        editTextPassword.setHint(R.string.password);
        editTextPassword.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        editTextPassword.setMaxLines(1);
        editTextPassword.setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_PASSWORD);

        editTextPassConfirm.setLayoutParams(Utilities.getLayoutParams(this, viewWidth, LinearLayout.LayoutParams.WRAP_CONTENT, 0,5,0,0));
        editTextPassConfirm.setHint(R.string.confirm_password);
        editTextPassConfirm.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        editTextPassword.setMaxLines(1);
        editTextPassConfirm.setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_PASSWORD);

        buttonSignUp.setLayoutParams(Utilities.getLayoutParams(this, viewWidth, LinearLayout.LayoutParams.WRAP_CONTENT, 0,5,0,0));
        buttonSignUp.setPadding(
                Utilities.getInDp(this, buttonPadding),
                Utilities.getInDp(this, buttonPadding),
                Utilities.getInDp(this, buttonPadding),
                Utilities.getInDp(this, buttonPadding)
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
        verifyLayout = (Button) findViewById(R.id.got_code);
        verifyLayout.setOnClickListener(this);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
    }

    public static boolean validateRegex(String emailStr, Pattern pattern) {
        Matcher matcher = pattern.matcher(emailStr);
        return matcher.find();
    }

    private void sendEmail() {
        if (validateRegex(editTextEmail.getText().toString(), emailRegex)) {
            Request.getRequest(progressBar).getSignUp(codeCallback, editTextEmail.getText().toString());
            progressBar.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(this, R.string.invalid_mail, Toast.LENGTH_SHORT).show();
        }
    }


}
