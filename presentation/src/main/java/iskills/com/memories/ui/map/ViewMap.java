package iskills.com.memories.ui.map;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import iskills.com.memories.R;
import iskills.com.memories.di.providers.utilsAndroid.UtilsAndroid;
import iskills.com.memories.mvp.ViewBase;

/**
 * lennyhicks
 * 4/8/18
 */
public class ViewMap extends ViewBase implements ContractMemoryMap.View, OnMapReadyCallback{

    @Inject
    protected ContractMemoryMap.Presenter presenter;

    @Inject
    protected UtilsAndroid utilsAndroid;

    @BindView(R.id.map_view)
    public MapView mapView;

    private GoogleMap googleMap;

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(android.view.View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

    }

    private void setupMap() {
        if (googleMap == null) {

            mapView.onCreate(getArguments());
            mapView.getMapAsync(this);
        }
    }

    private void setupMapOptions() {
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            return;
        }
        googleMap.setMyLocationEnabled(true);
        googleMap.setOnInfoWindowClickListener(marker -> presenter.onMemorySelected((long) marker.getTag()));

    }

    @Override
    public void onResume() {
        super.onResume();
        setupMap();
    }

    @Override
    public void addMemory(Long id, String title, String comment, double lat, double lng, byte[] imageBytes) {
        MarkerOptions options = new MarkerOptions();
        LatLng latLng = new LatLng(lat, lng);
        options.title(title);
        options.snippet(comment);
        options.position(latLng);
        googleMap.addMarker(options).setTag(id);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 15);
        googleMap.animateCamera(cameraUpdate);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        setupMapOptions();
        mapView.onResume();
        presenter.loadMemories();
    }
}

