package apk.win.first.bankapl;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BindingAdapters {

    @BindingAdapter("bind:items")
    public static void listBindGridview (RecyclerView view, List<Organization> results){
        //RecyclerViewAdapter adapterNew = new RecyclerViewAdapter(results);

        //view.setAdapter(adapterNew);
    }

    @BindingAdapter({"bind:itemsTwo","bind:curr"} )
    public static void listBindGridviewTwo (RecyclerView view, ArrayList<ModelCurrenciesBasic> currencies, Currencies_ currencies_){
        RecyclerAdapterTwo adapterTwo = new RecyclerAdapterTwo(currencies, currencies_);

        view.setAdapter(adapterTwo);
    }

    /*@BindingAdapter("bind:itemsTwo")
    public static void listBindGridviewTwo (RecyclerView view, ArrayList<ModelCurrenciesBasic> currencies){
        RecyclerAdapterTwo adapterTwo = new RecyclerAdapterTwo(currencies);
        view.setAdapter(adapterTwo);
        view.getRecycledViewPool().clear();
        adapterTwo.notifyDataSetChanged();
    }
*/
}
