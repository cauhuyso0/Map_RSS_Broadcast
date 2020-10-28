package com.example.ps10826_maixuanhuy_asm1.RSS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ps10826_maixuanhuy_asm1.R;

public class RSSActivity extends AppCompatActivity {

    String [] ten_loai = {"thể thao","vi tính - internet","giáo dục","du lịch"};

    String [] rss_loai = {"http://cdn.24h.com.vn/upload/rss/thethao.rss",
            "http://cdn.24h.com.vn/upload/rss/congnghethongtin.rss",
            "http://cdn.24h.com.vn/upload/rss/giaoducduhoc.rss",
            "http://cdn.24h.com.vn/upload/rss/dulich.rss"};
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss);

        lv = findViewById(R.id.lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ten_loai);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), tintheoloai.class);
                intent.putExtra("diachi_rss", rss_loai[position]);
                startActivity(intent);
            }
        });
    }
}
