package com.codembeded.fleetfoot.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.codembeded.fleetfoot.R;
import com.codembeded.fleetfoot.helperClass.AppConfig;
import com.codembeded.fleetfoot.helperClass.AppController;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    Button login_btn;
    TextView sign_up;
    TextInputEditText user_email_login_et, user_password_login_et;
    private static final String TAG = Login.class.getSimpleName();
    SharedPreferences sharedPreferences;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deliveryBoyLogin(user_email_login_et.getText().toString(),user_password_login_et.getText().toString());
            }
        });
    }

    private void init() {

        login_btn = findViewById(R.id.logIn_btn);
        user_email_login_et = findViewById(R.id.user_email_login_et);
        user_password_login_et = findViewById(R.id.user_password_login_et);
        progressBar = findViewById(R.id.login_progress_bar);
//        sign_up = findViewById(R.id.signUp_login_tv);
    }

    private void deliveryBoyLogin(final String email_str, final String password_str) {
        String tag_str_req = "req_get_login";
        progressBar.setVisibility(View.VISIBLE);

        StringRequest strReq = new StringRequest(Request.Method.POST, AppConfig.DELIVERY_BOY_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                Log.e("1st response",response);

                try {
                    JSONObject jObj = new JSONObject(response);
                    Log.e("2nd response",response);
                    boolean error = jObj.getBoolean("error");
                    //check for error node in json
                    if (!error) {
                        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//                        SharedPreferences.Editor editor = sharedPreferences.edit();
//                        editor.putString("id", jObj.getString("id"));
//                        editor.apply();
                        user_email_login_et.setText("");
                        user_password_login_et.setText("");
                        Intent intent = new Intent(Login.this, Home.class);
                        startActivity(intent);

                    } else {
                        String error_msg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(), "Error is " + error_msg, Toast.LENGTH_SHORT).show();
                        user_email_login_et.setError("Enter Valid Email Number or Password");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Volley Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("email", email_str);
                params.put("password", password_str);
                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(strReq, tag_str_req);
    }

}