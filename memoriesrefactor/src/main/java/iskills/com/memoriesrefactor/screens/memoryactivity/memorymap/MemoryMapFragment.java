package iskills.com.memoriesrefactor.screens.memoryactivity.memorymap;

import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import iskills.com.memoriesrefactor.R;
import iskills.com.memoriesrefactor.screens.common.fragments.BaseFragment;

/** lennyhicks 4/8/18 */
public class MemoryMapFragment extends BaseFragment implements MemoryMapView, OnMapReadyCallback {

  @Inject protected MemoryMapPresenter presenter;

  @BindView(R.id.map_view)
  public MapView mapView;

  private GoogleMap googleMap;

  @Nullable
  @Override
  public android.view.View onCreateView(
      LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_map, container, false);
  }

  @Override
  public void onViewCreated(android.view.View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    unbinder = ButterKnife.bind(this, view);
  }

  private void setupMap() {
    mapView.onCreate(getArguments());
    mapView.getMapAsync(this);
  }

  @SuppressLint("MissingPermission")
  private void setupMapOptions() {
    googleMap.getUiSettings().setMyLocationButtonEnabled(true);
    googleMap.getUiSettings().setZoomControlsEnabled(true);
    checkPermissions(Manifest.permission.ACCESS_FINE_LOCATION);
    checkPermissions(Manifest.permission.ACCESS_COARSE_LOCATION);
    
    googleMap.setMyLocationEnabled(true);
    googleMap.setOnInfoWindowClickListener(
        marker -> presenter.onMemorySelected((long) marker.getTag()));
  }

  @Override
  public void onResume() {
    super.onResume();
    setupMap();
  }

  @Override
  public void addMemory(Long id, String title, String comment, double lat, double lng) {
    MarkerOptions options = new MarkerOptions();
    LatLng latLng = new LatLng(lat, lng);
    options.title(title);
    options.snippet(comment);
    options.position(latLng);
    CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 15);

    mapView.post(() -> googleMap.addMarker(options).setTag(id));
    mapView.post(() -> googleMap.animateCamera(cameraUpdate));
  }

  @Override
  public void onMapReady(GoogleMap googleMap) {
    this.googleMap = googleMap;
    setupMapOptions();
    presenter.loadMemories();
    mapView.onResume();
  }
}
