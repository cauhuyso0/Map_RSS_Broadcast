package com.example.ps10826_maixuanhuy_asm1.RSS;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ps10826_maixuanhuy_asm1.R;

import java.util.ArrayList;
import java.util.List;

public class tintheoloai extends AppCompatActivity {
    static ListView lv;
    String diachi_rss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tintheoloai);

        diachi_rss = getIntent().getExtras().getString("diachi_rss");
        lv = findViewById(R.id.lv);

        Toast.makeText(getApplicationContext(), diachi_rss, Toast.LENGTH_SHORT).show();

        MyAsyncTask gandulieu = new MyAsyncTask(this, diachi_rss, lv);
        gandulieu.execute();
    }

    public static class MyAdapter extends ArrayAdapter<Item>{
            Context context;
            ArrayList<Item> items;
        public MyAdapter(@NonNull Context context, int textViewResourceId, @NonNull List<Item> objects) {
            super(context, textViewResourceId, objects);
            this.context = context;
            this.items = (ArrayList<Item>) objects;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inf=(LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowview=inf.inflate(R.layout.row_listview,parent, false);
            TextView tv_title=(TextView)rowview.findViewById(R.id.title);
            TextView tv_description=(TextView)rowview.findViewById(R.id.description);
            TextView tv_pubdate=(TextView)rowview.findViewById(R.id.pubdate);

            tv_title.setText(items.get(position).getTitle().toString());
            tv_description.setText(items.get(position).getDescription().toString());
            tv_pubdate.setText(items.get(position).getPuddate().toString());

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String link = items.get(position).getDiachi_rss();

                    Intent intent = new Intent(context, XemTin.class);
                    intent.putExtra("link", link);
                    getContext().startActivity(intent);
                }
            });

            return rowview;
        }
    }
}
