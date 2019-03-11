package apk.win.first.bankapl;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ShareFragment extends DialogFragment {

    public ShareFragment() {
    }

    Organization organization;
    Model model;
    View viewShar;
    TextView title, oblastj, region;
    RecyclerAdapterTwo recyclerAdapterTwo;
    ArrayList<ModelCurrenciesBasic> modelCurrenciesBasicArrayList;
    ArrayList<ModelCurrenciesBasic> modelCurrenciesBasicArrayListClean;
    RecyclerView recyclerView;
    Button shareButton;

    public static ShareFragment methodOnBundel(Organization organization, Model model){
        ShareFragment shareFragment = new ShareFragment();
        Bundle args = new Bundle();
        args.putSerializable("organizationObject", organization);
        args.putSerializable("models", model);
        shareFragment.setArguments(args);
        return shareFragment;
    }

    @Override
    public void onResume() {
        int width = getResources().getDimensionPixelSize(R.dimen.popup_width);
        int height = getResources().getDimensionPixelSize(R.dimen.popup_height);
        getDialog().getWindow().setLayout(width, height);
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewShar = inflater.inflate(R.layout.sharefragment, container,false);
        Bundle bundle = getArguments();

        if (bundle != null) {
            organization = (Organization) bundle.getSerializable("organizationObject");
            model = (Model) bundle.getSerializable("models");
            System.out.println("tits");
        }

        title = viewShar.findViewById(R.id.textViewTitle);
        oblastj = viewShar.findViewById(R.id.textViewTitleOblast);
        region = viewShar.findViewById(R.id.textViewTitleTown);
        shareButton = viewShar.findViewById(R.id.button2);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        title.setText(organization.getTitle());
        oblastj.setText(organization.getRegionId());
        region.setText(organization.getCityId());
        recyclerView = viewShar.findViewById(R.id.recycler_view_shar);

        LinearLayoutManager layoutManager = new LinearLayoutManager(viewShar.getContext());
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        modelCurrenciesBasicArrayList  = new ArrayList<>();

        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getAED());//
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getUSD());//
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getEUR());//
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getAMD());//
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getAUD());//
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getAZN());//
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getBGN());//
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getBRL());//
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getBYN());//
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getCAD());//
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getCHF());//
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getCLP());//
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getCNY());//
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getCZK());//
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getDKK());//    *********
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getEGP());//
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getGBP());   //
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getGEL());//
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getHKD());//
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getHRK());//
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getHUF());//
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getILS());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getINR());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getIQD());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getJPY());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getKRW());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getKWD());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getKZT());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getLBP());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getMDL());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getMXN());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getNOK());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getNZD());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getPLN());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getRON());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getRUB());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getSAR());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getSEK());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getSGD());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getTHB());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getTMT());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getTRY());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getTWD());
        modelCurrenciesBasicArrayList.add(organization.getCurrencies().getVND());

        modelCurrenciesBasicArrayListClean = new ArrayList<>();
        for (ModelCurrenciesBasic modelCurrenciesBasic:modelCurrenciesBasicArrayList){
            if (modelCurrenciesBasic!=null){
                modelCurrenciesBasicArrayListClean.add(modelCurrenciesBasic);
            }
        }

        recyclerAdapterTwo = new RecyclerAdapterTwo(modelCurrenciesBasicArrayListClean,model.getCurrencies());
        recyclerView.setAdapter(recyclerAdapterTwo);


        return viewShar.getRootView();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }



}
