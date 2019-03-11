package apk.win.first.bankapl;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import apk.win.first.bankapl.apk.win.first.valuesmoney.AED;
import apk.win.first.bankapl.databinding.CustomlistBinding;

public class RecyclerAdapterTwo extends RecyclerView.Adapter<RecyclerAdapterTwo.PersonalViewHolder> {

    public ArrayList<ModelCurrenciesBasic> model;

    public Currencies_ currencies_;
    //AED aed = new AED();
    ModelCurrenciesBasic modelCurrenciesBasic;

    /*public HashMap <ArrayList<Currencies>, List<Currencies_>> map = new HashMap<>();
    public HashMap<Object,String> hashMapCurr = new HashMap<>();*/

    public RecyclerAdapterTwo(ArrayList<ModelCurrenciesBasic> model, Currencies_ currencies_) {
        this.model = model;
        this.currencies_ = currencies_;
    }

    @NonNull
    @Override
    public PersonalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomlistBinding customlistBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.customlist,parent,false);
        return new PersonalViewHolder(customlistBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonalViewHolder holder, int position) {

        holder.customlistBinding.setModelCur(model.get(position));
        /** назва валюти */
        if (model.get(position)==null){}
        else if (model.get(position).getClass().getSimpleName()==null){}
        else if (model.get(position).getClass().getSimpleName().equals("AED")) {
            model.get(position).setName(currencies_.getAED());
        }
        else if (model.get(position).getClass().getSimpleName().equals("USD")){
            model.get(position).setName(currencies_.getUSD());
        }
        else if (model.get(position).getClass().getSimpleName().equals("EUR")){
            model.get(position).setName(currencies_.getEUR());
        }
        else if (model.get(position).getClass().getSimpleName().equals("AUD")){
            model.get(position).setName(currencies_.getAUD());
        }
        else if (model.get(position).getClass().getSimpleName().equals("AZN")){
            model.get(position).setName(currencies_.getAZN());
        }
        else if (model.get(position).getClass().getSimpleName().equals("BGN")){
            model.get(position).setName(currencies_.getBGN());
        }
        else if (model.get(position).getClass().getSimpleName().equals("BRL")){
            model.get(position).setName(currencies_.getBRL());
        }
        else if (model.get(position).getClass().getSimpleName().equals("BYN")){
            model.get(position).setName(currencies_.getBYN());
        }
        else if (model.get(position).getClass().getSimpleName().equals("CAD")){
            model.get(position).setName(currencies_.getCAD());
        }
        else if (model.get(position).getClass().getSimpleName().equals("CHF")){
            model.get(position).setName(currencies_.getCHF());
        }
        else if (model.get(position).getClass().getSimpleName().equals("CLP")){
            model.get(position).setName(currencies_.getCLP());
        }
        else if (model.get(position).getClass().getSimpleName().equals("CNY")){
            model.get(position).setName(currencies_.getCNY());
        }
        else if (model.get(position).getClass().getSimpleName().equals("CZK")){
            model.get(position).setName(currencies_.getCZK());
        }
        else if (model.get(position).getClass().getSimpleName().equals("DKK")){
            model.get(position).setName(currencies_.getDKK());
        }
        else if (model.get(position).getClass().getSimpleName().equals("DZD")){
            model.get(position).setName(currencies_.getDZD());
        }
        else if (model.get(position).getClass().getSimpleName().equals("EGP")){
            model.get(position).setName(currencies_.getEGP());
        }
        else if (model.get(position).getClass().getSimpleName().equals("GBP")){
            model.get(position).setName(currencies_.getGBP());
        }
        else if (model.get(position).getClass().getSimpleName().equals("GEL")){
            model.get(position).setName(currencies_.getGEL());
        }
        else if (model.get(position).getClass().getSimpleName().equals("HKD")){
            model.get(position).setName(currencies_.getHKD());
        }
        else if (model.get(position).getClass().getSimpleName().equals("HRK")){
            model.get(position).setName(currencies_.getHRK());
        }
        else if (model.get(position).getClass().getSimpleName().equals("HUF")){
            model.get(position).setName(currencies_.getHUF());
        }
        else if (model.get(position).getClass().getSimpleName().equals("ILS")){
            model.get(position).setName(currencies_.getILS());
        }
        else if (model.get(position).getClass().getSimpleName().equals("INR")){
            model.get(position).setName(currencies_.getINR());
        }
        else if (model.get(position).getClass().getSimpleName().equals("IQD")){
            model.get(position).setName(currencies_.getIQD());
        }
        else if (model.get(position).getClass().getSimpleName().equals("JPY")){
            model.get(position).setName(currencies_.getJPY());
        }
        else if (model.get(position).getClass().getSimpleName().equals("KGS")){// nema
            model.get(position).setName(currencies_.getKGS());
        }
        else if (model.get(position).getClass().getSimpleName().equals("KRW")){
            model.get(position).setName(currencies_.getKRW());
        }
        else if (model.get(position).getClass().getSimpleName().equals("KWD")){
            model.get(position).setName(currencies_.getKWD());
        }
        else if (model.get(position).getClass().getSimpleName().equals("KZT")){
            model.get(position).setName(currencies_.getKZT());
        }
        else if (model.get(position).getClass().getSimpleName().equals("LBP")){
            model.get(position).setName(currencies_.getLBP());
        }
        else if (model.get(position).getClass().getSimpleName().equals("MDL")){
            model.get(position).setName(currencies_.getMDL());
        }
        else if (model.get(position).getClass().getSimpleName().equals("MXN")){
            model.get(position).setName(currencies_.getMXN());
        }
        else if (model.get(position).getClass().getSimpleName().equals("NOK")){
            model.get(position).setName(currencies_.getNOK());
        }
        else if (model.get(position).getClass().getSimpleName().equals("NZD")){
            model.get(position).setName(currencies_.getNZD());
        }
        else if (model.get(position).getClass().getSimpleName().equals("PKR")){//
            model.get(position).setName(currencies_.getPKR());
        }
        else if (model.get(position).getClass().getSimpleName().equals("PLN")){
            model.get(position).setName(currencies_.getPLN());
        }
        else if (model.get(position).getClass().getSimpleName().equals("RON")){
            model.get(position).setName(currencies_.getRON());
        }
        else if (model.get(position).getClass().getSimpleName().equals("RUB")){
            model.get(position).setName(currencies_.getRUB());
        }
        else if (model.get(position).getClass().getSimpleName().equals("SAR")){
            model.get(position).setName(currencies_.getSAR());
        }
        else if (model.get(position).getClass().getSimpleName().equals("SEK")){
            model.get(position).setName(currencies_.getSEK());
        }
        else if (model.get(position).getClass().getSimpleName().equals("SGD")){
            model.get(position).setName(currencies_.getSGD());
        }
        else if (model.get(position).getClass().getSimpleName().equals("THB")){
            model.get(position).setName(currencies_.getTHB());
        }
        else if (model.get(position).getClass().getSimpleName().equals("TJS")){//
            model.get(position).setName(currencies_.getTJS());
        }
        else if (model.get(position).getClass().getSimpleName().equals("TMT")){
            model.get(position).setName(currencies_.getTMT());
        }
        else if (model.get(position).getClass().getSimpleName().equals("TRY")){
            model.get(position).setName(currencies_.getTRY());
        }
        else if (model.get(position).getClass().getSimpleName().equals("TWD")){
            model.get(position).setName(currencies_.getTWD());
        }
        else if (model.get(position).getClass().getSimpleName().equals("VND")){
            model.get(position).setName(currencies_.getVND());
        }


        /** -------------- */
}

    @Override
    public int getItemCount() {
        if (model != null && !model.isEmpty()) {
            return model.size();
        }
        return 0;
    }

    public class PersonalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        CustomlistBinding customlistBinding;

        public PersonalViewHolder(CustomlistBinding customlistBinding) {
            super(customlistBinding.getRoot());
            this.customlistBinding = customlistBinding;
        }

        @Override
        public void onClick(View view) {

        }
    }
}
