package apk.win.first.bankapl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class FragmentWeb extends Fragment {

    WebView webView;
    String string;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragmentview,container,false);
        webView = rootview.findViewById(R.id.webview);

        Bundle bundle = getArguments();
        if (bundle!=null){
            string = (String) bundle.getSerializable("link");
        }

        webView.loadUrl(string);

        return rootview.getRootView();
    }
}
