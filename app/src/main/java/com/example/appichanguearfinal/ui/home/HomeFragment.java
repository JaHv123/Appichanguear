package com.example.appichanguearfinal.ui.home;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.appichanguearfinal.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class HomeFragment extends Fragment implements OnMapReadyCallback {

    private static final int LOCATION_REQUEST_CODE = 1;
    GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        FragmentManager fm = getActivity().getSupportFragmentManager();

        SupportMapFragment mapFragment = (SupportMapFragment) fm
                .findFragmentById(R.id.mapView);
       // mapFragment.getMapAsync(this);
        mView = inflater.inflate(R.layout.fragment_home, container, false);


        return mView;
    }



    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMapView = (MapView) mView.findViewById(R.id.mapView);

        if(mMapView != null){
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap =googleMap;

        // Controles UI
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mGoogleMap.setMyLocationEnabled(true);
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Mostrar diálogo explicativo
            } else {
                // Solicitar permiso
                ActivityCompat.requestPermissions(
                        getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        LOCATION_REQUEST_CODE);
            }
        }

        mGoogleMap.getUiSettings().setZoomControlsEnabled(true);

        // Marcadores
        mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)));

        LatLng campingUrrelo = new LatLng(-7.1522501,-78.5090717);
        googleMap.addMarker(new MarkerOptions().position(campingUrrelo).title("Camping de Urrelo")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(campingUrrelo));


        LatLng allianzArena = new LatLng(-7.1530808,-78.5082074);
        googleMap.addMarker(new MarkerOptions().position(allianzArena).title("Allianz Arena")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(allianzArena));


        MapsInitializer.initialize(getContext());
        googleMap.setMapType((GoogleMap.MAP_TYPE_NORMAL));


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == LOCATION_REQUEST_CODE) {
            // ¿Permisos asignados?
            if (permissions.length > 0 &&
                    permissions[0].equals(Manifest.permission.ACCESS_FINE_LOCATION) &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mGoogleMap.setMyLocationEnabled(true);
            } else {
                Toast.makeText(getActivity(), "Error de permisos", Toast.LENGTH_LONG).show();
            }

        }
    }
}