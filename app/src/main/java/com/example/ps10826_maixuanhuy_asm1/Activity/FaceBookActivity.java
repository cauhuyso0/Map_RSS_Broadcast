package com.example.ps10826_maixuanhuy_asm1.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ps10826_maixuanhuy_asm1.R;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;

public class FaceBookActivity extends AppCompatActivity {

    LoginButton btnLogin;
    CircleImageView pic;
    TextView tvName, tvMail;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_book);
        printKeyHash();
        btnLogin = findViewById(R.id.btnLogin);
        pic = findViewById(R.id.pic);
        tvName = findViewById(R.id.tvName);
        tvMail = findViewById(R.id.tvMail);
        callbackManager = CallbackManager.Factory.create();
        btnLogin.setPermissions(Arrays.asList("email", "public_profile"));

        btnLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    AccessTokenTracker tokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
            if (currentAccessToken==null){
                tvName.setText("");
                tvMail.setText("");
                pic.setImageResource(0);
                Toast.makeText(FaceBookActivity.this, "User Logged out", Toast.LENGTH_SHORT).show();
            }
            else {
                 load(currentAccessToken);
            }
        }
    };

    public void load(AccessToken newAccesToken){
        GraphRequest request = GraphRequest.newMeRequest(newAccesToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                    String first_name = object.getString("first_name");
                    String last_name = object.getString("last_name");
                    String email = object.getString("email");
                    String id =object.getString("id");
                    String image_url = "http://graph.facebook.com/"+id+ "/picture?type=normal";

                    tvMail.setText(email);
                    tvName.setText(first_name+ " " +last_name);
                    RequestOptions requestOptions = new RequestOptions();
                    requestOptions.dontAnimate();

                    Glide.with(FaceBookActivity.this).load(image_url).into(pic);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        Bundle bundle = new Bundle();
        bundle.putString("fields","first_name,last_name,email,id");
        request.setParameters(bundle);
        request.executeAsync();

    }

    private void printKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.i("KeyHash:",
                        Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("jk", "Exception(NameNotFoundException) : " + e);
        } catch (NoSuchAlgorithmException e) {
            Log.e("mkm", "Exception(NoSuchAlgorithmException) : " + e);
        }
    }
}
