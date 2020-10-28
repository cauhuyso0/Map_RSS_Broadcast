package com.example.ps10826_maixuanhuy_asm1.RSS;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import com.example.ps10826_maixuanhuy_asm1.R;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MyAsyncTask extends AsyncTask<Void,Void,Void> {

    Context c;
    String diachi_rss;
    ArrayList<Item> items = new ArrayList<Item>();
    ListView lv;
    private String chuoi;

    public MyAsyncTask(Context c, String link, ListView lv){
        this.c = c;
        this.diachi_rss = link;
        this.lv = lv;
    }

    public MyAsyncTask(){}

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url=new URL(diachi_rss);
            URLConnection connection=url.openConnection();
            InputStream is=connection.getInputStream();
            items=(ArrayList<Item>) MySaxParser.xmlParser(is);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return null;
    }
    ProgressDialog dialog;
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        try{
            tintheoloai.MyAdapter adapter=new tintheoloai.MyAdapter(c, R.layout.row_listview,items);
            lv.setAdapter(adapter);
        }catch(Exception e)
        {
            Log.d("title","adapter khong duoc");
        }
    }
}
