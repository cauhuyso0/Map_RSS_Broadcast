package com.example.ps10826_maixuanhuy_asm1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.ps10826_maixuanhuy_asm1.R;
import com.example.ps10826_maixuanhuy_asm1.RSS.RSSActivity;
import com.example.ps10826_maixuanhuy_asm1.dao.KhoaHocDAO;
import com.example.ps10826_maixuanhuy_asm1.helper.Helper;
import com.example.ps10826_maixuanhuy_asm1.model.KhoaHoc;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<KhoaHoc> ds = new ArrayList<>();

    DrawerLayout drawer_layout;
    Toolbar toolbar;
    NavigationView nvView;
    FragmentManager fragmentManager = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Helper helper = new Helper(this);
        KhoaHocDAO khoaHocDAO = new KhoaHocDAO(helper.getWritableDatabase());
        ds = (ArrayList<KhoaHoc>) khoaHocDAO.readAll();
        map();
        actionBar();
        iteamSelected();
    }

    public void map(){
        toolbar = findViewById(R.id.toolbar);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        nvView = (NavigationView) findViewById(R.id.nvView);

    }


    public void actionBar(){
        setSupportActionBar(toolbar);
        ActionBar ab =  getSupportActionBar();

        ab.setHomeAsUpIndicator(R.drawable.ic_menu_black);
        ab.setDisplayHomeAsUpEnabled(true);

    }

    public void iteamSelected() {
        nvView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.qlKhoaHoc:
                        Intent intent = new Intent(MainActivity.this, KhoaHocActivity.class);
                        startActivity(intent);
                        Animatoo.animateInAndOut(MainActivity.this);
                        drawer_layout.closeDrawer(Gravity.LEFT);
                        break;

                    case R.id.banDo:
                        Intent intent1 = new Intent(MainActivity.this, MapsActivity.class);
                        startActivity(intent1);
                        Animatoo.animateSlideDown(MainActivity.this);
                        drawer_layout.closeDrawer(Gravity.LEFT);
                        break;

                    case R.id.xaHoi:
                        Intent intent3 = new Intent(MainActivity.this, FaceBookActivity.class);
                        startActivity(intent3);
                        Animatoo.animateSlideUp(MainActivity.this);
                        drawer_layout.closeDrawer(Gravity.LEFT);
                        break;

                    case R.id.tinTuc:
                        Intent intent2 = new Intent(MainActivity.this, RSSActivity.class);
                        startActivity(intent2);
                        Animatoo.animateZoom(MainActivity.this);
                        drawer_layout.closeDrawer(Gravity.LEFT);
                        break;
                }

                return false;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id==android.R.id.home){
            drawer_layout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}
