package com.example.splashactivity_java;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.example.splashactivity_java.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import java.util.concurrent.locks.ReentrantLock;

public class MAP extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private static final int LOCATION_PERMISSION_CODE = 101;
    ReentrantLock lock = new ReentrantLock();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isLocationPermissionGranted()){
            try {
                requestLocationPermission();
            }finally {
                lock.unlock();
            }
            lock.lock();
            binding = ActivityMapsBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            if (mapFragment != null) {
                mapFragment.getMapAsync(this);
            }
        }else if (isLocationPermissionGranted()){
            binding = ActivityMapsBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            if (mapFragment != null) {
                mapFragment.getMapAsync(this);
            }
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        }
    }
    private boolean isLocationPermissionGranted () {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED;
    }
    private void requestLocationPermission(){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                LOCATION_PERMISSION_CODE );
    }
    public void Caminho(View view) {
        Button button = (Button) view;
        String z = (String) button.getText();
        if (z.equals("Iniciar")) {
            button.setText("Parar");
        }else if(z.equals("Parar")){
            button.setText("Iniciar");
        }
    }
}