package apk.win.first.bankapl;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import apk.win.first.bankapl.databinding.SecondfragmentBinding;

public class SecondFragment extends Fragment implements Serializable{

    SecondfragmentBinding secondfragmentBinding;
    ArrayList<Currencies> currenciesList;
    Organization organization;
    ArrayList<ModelCurrenciesBasic> modelCurrenciesBasicArrayList;
    ArrayList<ModelCurrenciesBasic> modelCurrenciesBasicArrayListClean;
    ArrayList<ModelCurrenciesBasic> modelCurrenciesBasicArrayListCleanOneCurr;

    ArrayListModels arrayListModels;
    String nameOfCity;
    Model model;
    ModelCurrenciesBasic modelCurrenciesBasic;
    boolean isFABOpen = false;

    public void onBackPressed() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0)
            fm.popBackStack();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setHasOptionsMenu(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //if ( getActivity().getSupportFragmentManager().getBackStackEntryCount() > 0) {
            switch (item.getItemId())
            {   case android.R.id.home:
               getActivity().onBackPressed();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        secondfragmentBinding = DataBindingUtil.inflate(inflater,
                                R.layout.secondfragment,container,false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            organization = (Organization) bundle.getSerializable("organizationObject");
            model = (Model) bundle.getSerializable("currencies");
            System.out.println("tits");
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(container.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        secondfragmentBinding.recyclerViewTwo.setLayoutManager(layoutManager);

        ((MainActivity)getActivity()).setSupportActionBar(secondfragmentBinding.ToolSecBar);

        secondfragmentBinding.buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /*MainActivity activityHome = (MainActivity) view.getContext();
               CallbackClass callbackClass = new CallbackClass();
               callbackClass.registerCallBack(activityHome);
               callbackClass.sendDataToShareFrFromSecondFra(organization);*/
               FragmentManager fm = getFragmentManager();
               ShareFragment shareFragment = ShareFragment.methodOnBundel(organization, model);
               shareFragment.show(fm,"");
            }
        });

        secondfragmentBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFABOpen)
                showFABMenu();
                else {
                    closeFABMenu();
                }
            }
        });

        secondfragmentBinding.fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activityHome = (MainActivity) view.getContext();
                CallbackClass callbackClass = new CallbackClass();
                callbackClass.registerCallBack(activityHome);
                callbackClass.sentDataToFragmentPhone(organization.getPhone().toString());
            }
        });

        secondfragmentBinding.fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activityHome = (MainActivity) view.getContext();
                CallbackClass callbackClass = new CallbackClass();
                callbackClass.registerCallBack(activityHome);
                callbackClass.sentLinkToWebFr(organization.getLink());
            }
        });

        secondfragmentBinding.fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activityHome = (MainActivity) view.getContext();
                CallbackClass callbackClass = new CallbackClass();
                callbackClass.registerCallBack(activityHome);
                try {
                    callbackClass.sentDataFromModelTwo(organization.getCityId(),
                            organization.getAddress());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        /*secondfragmentBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                if (fm.getBackStackEntryCount() > 0)
                    fm.popBackStack();
            }
        });*/


            if (organization.getCityId().equals("7oiylpmiow8iy1smadm"))
                nameOfCity = "Днепр";
            else if (organization.getCityId().equals("7oiylpmiow8iy1smadn"))
                nameOfCity = "Запорожье";
            else if (organization.getCityId().equals("7oiylpmiow8iy1smadi"))
                nameOfCity = "Киев";
            else if (organization.getCityId().equals("7oiylpmiow8iy1smadr"))
                nameOfCity = "Львов";
            else if (organization.getCityId().equals("7oiylpmiow8iy1smadk"))
                nameOfCity = "Одесса";
            else if (organization.getCityId().equals("7oiylpmiow8iy1smadx"))
                nameOfCity = "Полтава";
            else if (organization.getCityId().equals("7oiylpmiow8iy1smadp"))
                nameOfCity = "Ужгород";
            else if (organization.getCityId().equals("7oiylpmiow8iy1smadj"))
                nameOfCity = "Харьков";
            else if (organization.getCityId().equals("7oiylpmiow8iy1smaec"))
                nameOfCity = "Чернигов";

        secondfragmentBinding.textCity.setText(nameOfCity);
        modelCurrenciesBasicArrayList  = new ArrayList<>();
        /* if (organization.getCurrencies().getAED()!=null){
            modelCurrenciesBasicArrayList.add(organization.getCurrencies().getAED());
        }
        else if (organization.getCurrencies().getEUR()!=null){
            modelCurrenciesBasicArrayList.add(organization.getCurrencies().getEUR());
        }
        else if (organization.getCurrencies().getUSD()!=null){
            modelCurrenciesBasicArrayList.add(organization.getCurrencies().getUSD());
        }
         else if (organization.getCurrencies().getAMD()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getAMD());
         }
         else if (organization.getCurrencies().getAUD()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getAUD());
         }
         else if (organization.getCurrencies().getAZN()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getAZN());
         }
         else if (organization.getCurrencies().getBGN()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getBGN());
         }
         else if (organization.getCurrencies().getBRL()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getBRL());
         }
         else if (organization.getCurrencies().getBYN()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getBYN());
         }
         else if (organization.getCurrencies().getCAD()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getCAD());
         }
         else if (organization.getCurrencies().getCHF()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getCHF());
         }
         else if (organization.getCurrencies().getCLP()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getCLP());
         }
         else if (organization.getCurrencies().getCNY()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getCNY());
         }
         else if (organization.getCurrencies().getCZK()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getCZK());
         }
         else if (organization.getCurrencies().getDKK()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getDKK());
         }
         else if (organization.getCurrencies().getEGP()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getEGP());
         }
         else if (organization.getCurrencies().getGBP()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getGBP());
         }
         else if (organization.getCurrencies().getGEL()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getGEL());
         }
         else if (organization.getCurrencies().getHKD()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getHKD());
         }
         else if (organization.getCurrencies().getHRK()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getHRK());
         }
         else if (organization.getCurrencies().getHUF()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getHUF());
         }
         else if (organization.getCurrencies().getILS()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getILS());
         }
         else if (organization.getCurrencies().getINR()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getINR());
         }
         else if (organization.getCurrencies().getIQD()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getIQD());
         }
         else if (organization.getCurrencies().getJPY()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getJPY());
         }
         else if (organization.getCurrencies().getKRW()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getKRW());
         }
         else if (organization.getCurrencies().getKWD()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getKWD());
         }
         else if (organization.getCurrencies().getKZT()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getKZT());
         }
         else if (organization.getCurrencies().getLBP()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getLBP());
         }
         else if (organization.getCurrencies().getMDL()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getMDL());
         }
         else if (organization.getCurrencies().getMXN()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getMXN());
         }
         else if (organization.getCurrencies().getNOK()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getNOK());
         }
         else if (organization.getCurrencies().getNZD()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getNZD());
         }
         else if (organization.getCurrencies().getPLN()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getPLN());
         }
         else if (organization.getCurrencies().getRON()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getRON());
         }
         else if (organization.getCurrencies().getRUB()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getRUB());
         }
         else if (organization.getCurrencies().getSAR()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getSAR());
         }
         else if (organization.getCurrencies().getSEK()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getSEK());
         }
         else if (organization.getCurrencies().getSGD()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getSGD());
         }
         else if (organization.getCurrencies().getTHB()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getTHB());
         }
         else if (organization.getCurrencies().getTMT()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getTMT());
         }
         else if (organization.getCurrencies().getTRY()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getTRY());
         }
         else if (organization.getCurrencies().getTWD()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getTWD());
         }
         else if (organization.getCurrencies().getVND()!=null){
             modelCurrenciesBasicArrayList.add(organization.getCurrencies().getVND());
         }*/

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
        modelCurrenciesBasicArrayListCleanOneCurr = new ArrayList<>();

        /** work good*/
        for (ModelCurrenciesBasic modelCurrenciesBasic:modelCurrenciesBasicArrayList){
            if (modelCurrenciesBasic!=null){
                modelCurrenciesBasicArrayListClean.add(modelCurrenciesBasic);
            }
        }
        /** --------- */
        arrayListModels = new ArrayListModels(modelCurrenciesBasicArrayListClean);
        System.out.println("Hello");
        secondfragmentBinding.setModelOrg(organization);
        secondfragmentBinding.setModelArr(arrayListModels);
        secondfragmentBinding.setModelCur(model);
        secondfragmentBinding.textViewOrgType.setText("витрати на послуги телекомунікаційного зв'язку, електронні цифрові підписи для ведення бухгалтерського та податкового обліку та для подання податкової звітності, звітності до органів статистики, Пенсійного Фонду України, інших фондів загальнообов'язкового державного страхування.витрати на послуги телекомунікаційного зв'язку, електронні цифрові підписи для ведення бухгалтерського та податкового обліку та для подання податкової звітності, звітності до органів статистики, Пенсійного Фонду України, інших фондів загальнообов'язкового державного страхування.");

        return secondfragmentBinding.getRoot();
    }

    public void showFABMenu(){
        isFABOpen = true;
        secondfragmentBinding.fab1.animate().translationY(-getResources().getDimension(R.dimen.standart_55));
        secondfragmentBinding.fab2.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
        secondfragmentBinding.fab3.animate().translationY(-getResources().getDimension(R.dimen.standard_155));
    }

    public void closeFABMenu(){
        isFABOpen = false;
        secondfragmentBinding.fab1.animate().translationY(0);
        secondfragmentBinding.fab2.animate().translationY(0);
        secondfragmentBinding.fab3.animate().translationY(0);
    }
/*
    public void onBackPressed() {
        if(!isFABOpen){
            this.onBackPressed();
        }else{
            closeFABMenu();
        }
    }*/
}
