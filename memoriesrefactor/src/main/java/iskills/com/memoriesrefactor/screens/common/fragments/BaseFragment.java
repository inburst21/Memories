package iskills.com.memoriesrefactor.screens.common.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Toast;

import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

public class BaseFragment extends DaggerFragment {

  protected Unbinder unbinder;

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }

  public void showSuccess(String success) {
    Toast.makeText(getActivity(), success, Toast.LENGTH_SHORT).show();
  }

  public void showError(String error) {
    Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }

  protected int checkPermissions(String permission) {
    if (ActivityCompat.checkSelfPermission(requireActivity(), permission)
            != PackageManager.PERMISSION_GRANTED
        && ActivityCompat.checkSelfPermission(
                requireActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
      ActivityCompat.requestPermissions(requireActivity(), new String[] {permission}, 1);
    }
    return ActivityCompat.checkSelfPermission(requireActivity(), permission);
  }
}
