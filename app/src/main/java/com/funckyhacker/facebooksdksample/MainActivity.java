package com.funckyhacker.facebooksdksample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

  private static final String EMAIL = "email";
  private LoginButton loginButton;
  private CallbackManager callbackManager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    callbackManager = CallbackManager.Factory.create();
    loginButton = findViewById(R.id.login_button);
    loginButton.setReadPermissions(Arrays.asList(EMAIL));
    loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
      @Override public void onSuccess(LoginResult loginResult) {
        Log.d("", "a");
      }

      @Override public void onCancel() {

      }

      @Override public void onError(FacebookException error) {

      }
    });
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    callbackManager.onActivityResult(requestCode, resultCode, data);
    super.onActivityResult(requestCode, resultCode, data);
  }
}
