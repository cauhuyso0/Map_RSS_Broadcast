package com.example.ps10826_maixuanhuy_asm1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.ps10826_maixuanhuy_asm1.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginActivity extends AppCompatActivity {
    EditText edtUser, edtPass;
    Button btnDangNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        btnDangNhap =findViewById(R.id.btnDangNhap);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUser.getText().toString().equals("admin") && edtPass.getText().toString().equals("admin")){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(LoginActivity.this)
                            .setSmallIcon(R.drawable.com_facebook_button_icon)
                            .setContentTitle("My notification")
                            .setContentText("Much longer text that cannot fit one line...")
                            .setStyle(new NotificationCompat.BigTextStyle()
                                    .bigText("Bạn đã đăng nhập vào chương trình quản lý khóa học ...."))
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                    NotificationManager notificationManager = (NotificationManager) LoginActivity.this.getSystemService(Context.NOTIFICATION_SERVICE);
                    notificationManager.notify(001, mBuilder.build());
                    intent.setClassName("com.example.ps10826_maixuanhuy_asm1", "com.example.ps10826_maixuanhuy_asm1.Activity.MainActivity");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    Animatoo.animateFade(LoginActivity.this);
                }
                else {
                    Toast.makeText(LoginActivity.this, "Sai tài khoản hoặc mật khẩu !! Mời nhập lại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        printKeyHash();
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
