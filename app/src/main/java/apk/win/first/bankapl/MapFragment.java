package apk.win.first.bankapl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    static final LatLng HAMBURG = new LatLng(53.558, 9.927);
    static final LatLng KIEL = new LatLng(53.551, 9.993);
    GoogleMap googleMap_;
    ModelTwo modelTwo;
    Double double1, double2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.mapsfragment,container,false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            modelTwo = (ModelTwo) bundle.getSerializable("modelTwo");
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return rootview.getRootView();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        for (Candidate candidate:modelTwo.getCandidates()){
                double1 = candidate.getGeometry().getLocation().getLat();
                double2 = candidate.getGeometry().getLocation().getLng();
        }

        googleMap_ = googleMap;
        //LatLng sydney = new LatLng(-34, 151);
        //LatLng uzhorod = new LatLng( 48.61058509999999, 22.2906413);
        LatLng uzhorod = new LatLng( double1, double2);
        googleMap_.addMarker(new MarkerOptions().position(uzhorod).title("Uzhorod"));
        googleMap_.moveCamera(CameraUpdateFactory.newLatLng(uzhorod));
        googleMap_.setMinZoomPreference(17.0f);
        googleMap_.setMaxZoomPreference(27.0f);
    }
}
