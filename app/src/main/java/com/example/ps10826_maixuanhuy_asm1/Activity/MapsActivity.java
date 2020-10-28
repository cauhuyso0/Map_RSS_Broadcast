package com.example.ps10826_maixuanhuy_asm1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ps10826_maixuanhuy_asm1.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
    EditText et_location;
    Button bt_find;
    ArrayList<Marker> markers=new ArrayList<Marker>();
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        et_location = findViewById(R.id.et_location);
        bt_find = findViewById(R.id.btn_find);

        bt_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Geocoder geocoder=new Geocoder(MapsActivity.this);
                List<Address> ds_diachi=null;

                try {
                    ds_diachi=geocoder.getFromLocationName(et_location.getText().toString(), 30);
                    Toast.makeText(getApplicationContext(), "co:"+ds_diachi.size(), Toast.LENGTH_LONG).show();
                    for(int i=0;i<ds_diachi.size();i++)
                    {
                        Address dc=(Address)ds_diachi.get(i);
                        LatLng vt = new LatLng(dc.getLatitude(),dc.getLongitude());
                        Marker mar = mMap.addMarker(
                                new MarkerOptions()
                                        .position(vt)
                                        .title(dc.getLocality())
                                        .snippet(dc.getFeatureName())
                                        .icon(BitmapDescriptorFactory.defaultMarker(
                                                BitmapDescriptorFactory.HUE_ROSE)));
                        markers.add(mar);//them vao list de de xoa

                        ///di chuyen camera chua toan bo marker
                        LatLngBounds.Builder builder = new LatLngBounds.Builder();
                        for(Marker m : markers) {
                            builder.include(m.getPosition());
                        }
                        LatLngBounds bounds = builder.build();
                        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, 5);
                        //map.moveCamera(cu);
                        mMap.animateCamera(cu);
                    }
                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "loi roi", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        UiSettings uisetting=mMap.getUiSettings();
        uisetting.setCompassEnabled(true);

        uisetting.setZoomControlsEnabled(true);
        uisetting.setScrollGesturesEnabled(true);
        uisetting.setTiltGesturesEnabled(true);
        uisetting.setMyLocationButtonEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {//bang M
            if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED)
            {
                xulyQuyen();
                Toast.makeText(this, "e", Toast.LENGTH_SHORT).show();
            } else
            {
                ActivityCompat.requestPermissions(MapsActivity.this,new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,android.Manifest.permission.ACCESS_COARSE_LOCATION},1);
                Toast.makeText(this, "d", Toast.LENGTH_SHORT).show();
            }
        }else
        {
            xulyQuyen();
            Toast.makeText(this, "f", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Toast.makeText(this, "xx", Toast.LENGTH_SHORT).show();
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(this, "xin duoc quyen roi", Toast.LENGTH_SHORT).show();
            xulyQuyen();
        }
    }

    public void xulyQuyen(){
        mMap.setMyLocationEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_map, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.normal:
                mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
                break;
            case R.id.hybrid:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            case R.id.satellite:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.terrain:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
