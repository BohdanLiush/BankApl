package apk.win.first.bankapl;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class FragmentCall extends Fragment {

    String phoneString;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View fragmentCallV = inflater.inflate(R.layout.fragmentcall, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            phoneString = (String) bundle.getSerializable("phoneString");
            System.out.println("tits");
        }

        try
        {
            Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+phoneString));
            startActivity(callIntent);
        }
        catch(Exception e) {
            Toast.makeText(getActivity(),"Your call has failed...",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        MainActivity activityHome = (MainActivity) fragmentCallV.getContext();
        CallbackClass callbacks = new CallbackClass();
        callbacks.registerCallBack(activityHome);
        callbacks.buttonBack();

        return fragmentCallV;
    }
}
