package apk.win.first.bankapl;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import apk.win.first.bankapl.databinding.RecyclerlistBinding;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PersonalViewHolder> implements Filterable{

    public List<Organization> contactList;
    public List<Organization> contactListFiltered;
    String nameOfCity, nameOfRegion, nameOfStreet;
    Model model_;

    String sampleString;

    Regions regions = new Regions();

    public RecyclerViewAdapter(List<Organization> contactList, Model model) {
        this.contactList = contactList;
        this.contactListFiltered = contactList;
        this.model_ = model;
        System.out.println("sisku");
    }



    @NonNull
    @Override
    public PersonalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerlistBinding recyclerlistBinding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),R.layout.recyclerlist, parent, false);
        return new PersonalViewHolder(recyclerlistBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonalViewHolder holder, int position) {
        holder.recyclerlistBinding.setModelFor(contactListFiltered.get(position));

        if (contactListFiltered.get(position).getRegionId().equals("ua,7oiylpmiow8iy1smaci"))
            nameOfRegion = "Днепропетровская область";
        else if (contactListFiltered.get(position).getRegionId().equals("ua,7oiylpmiow8iy1smac7"))
            nameOfRegion = "Житомирская область";
        else if (contactListFiltered.get(position).getRegionId().equals("ua,7oiylpmiow8iy1smabz"))
            nameOfRegion = "Закарпатская область";
        else if (contactListFiltered.get(position).getRegionId().equals("ua,7oiylpmiow8iy1smack"))
            nameOfRegion = "Запорожская область";
        else if (contactListFiltered.get(position).getRegionId().equals("ua,7oiylpmiow8iy1smac2"))
            nameOfRegion = "Ивано-Франковская область";
        else if (contactListFiltered.get(position).getRegionId().equals("ua,0,7oiylpmiow8iy1smadi"))
            nameOfRegion = "Киев";
        else if (contactListFiltered.get(position).getRegionId().equals("ua,7oiylpmiow8iy1smac9"))
            nameOfRegion = "Киевская область";
        else if (contactListFiltered.get(position).getRegionId().equals("ua,7oiylpmiow8iy1smac0"))
            nameOfRegion = "Львовская область";
        else if (contactListFiltered.get(position).getRegionId().equals("ua,7oiylpmiow8iy1smacd"))
            nameOfRegion = "Николаевская область";
        else if (contactListFiltered.get(position).getRegionId().equals("ua,7oiylpmiow8iy1smacc"))
            nameOfRegion = "Одесская область";
        else if (contactListFiltered.get(position).getRegionId().equals("ua,7oiylpmiow8iy1smacf"))
            nameOfRegion = "Полтавская область";
        else if (contactListFiltered.get(position).getRegionId().equals("ua,7oiylpmiow8iy1smac4"))
            nameOfRegion = "Ровенская область";
        else if (contactListFiltered.get(position).getRegionId().equals("ua,7oiylpmiow8iy1smacg"))
            nameOfRegion = "Сумская область";
        else if (contactListFiltered.get(position).getRegionId().equals("ua,7oiylpmiow8iy1smac3"))
            nameOfRegion = "Тернопольская область";
        else if (contactListFiltered.get(position).getRegionId().equals("ua,7oiylpmiow8iy1smacj"))
            nameOfRegion = "Харьковская область";
        else if (contactListFiltered.get(position).getRegionId().equals("ua,7oiylpmiow8iy1smach"))
            nameOfRegion = "Херсонская область";
        else if (contactListFiltered.get(position).getRegionId().equals("ua,7oiylpmiow8iy1smac6"))
            nameOfRegion = "Хмельницкая область";
        else if (contactListFiltered.get(position).getRegionId().equals("ua,7oiylpmiow8iy1smaca"))
            nameOfRegion = "Черниговская область";
        else if (contactListFiltered.get(position).getRegionId().equals("ua,7oiylpmiow8iy1smac5"))
            nameOfRegion = "Черновицкая область";

        holder.recyclerlistBinding.textViewRegion.setText(nameOfRegion);

        if (contactListFiltered.get(position).getCityId().equals("7oiylpmiow8iy1smadm"))
            nameOfCity = "Днепр";
        else if (contactListFiltered.get(position).getCityId().equals("7oiylpmiow8iy1smadn"))
            nameOfCity = "Запорожье";
        else if (contactListFiltered.get(position).getCityId().equals("7oiylpmiow8iy1smadi"))
            nameOfCity = "Киев";
        else if (contactListFiltered.get(position).getCityId().equals("7oiylpmiow8iy1smadr"))
            nameOfCity = "Львов";
        else if (contactListFiltered.get(position).getCityId().equals("7oiylpmiow8iy1smadk"))
            nameOfCity = "Одесса";
        else if (contactListFiltered.get(position).getCityId().equals("7oiylpmiow8iy1smadx"))
            nameOfCity = "Полтава";
        else if (contactListFiltered.get(position).getCityId().equals("7oiylpmiow8iy1smadp"))
            nameOfCity = "Ужгород";
        else if (contactListFiltered.get(position).getCityId().equals("7oiylpmiow8iy1smadj"))
            nameOfCity = "Харьков";
        else if (contactListFiltered.get(position).getCityId().equals("7oiylpmiow8iy1smaec"))
            nameOfCity = "Чернигов";

        holder.recyclerlistBinding.textViewTown.setText(nameOfCity);

    }

    @Override
    public int getItemCount() {
        /*if (contactList != null && !contactList.isEmpty()) {
            return contactList.size();
        }*/
        /** new to filter search */
        //if (contactListFiltered!=null && contactListFiltered.isEmpty()){
            return contactListFiltered.size();

        //}
       // return 0;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()){
                    contactListFiltered = contactList;
                    System.out.println("sisi");
                }else {
                    List<Organization> filteredList = new ArrayList<>();
                    for (Organization organization: contactList){
                        if (organization.getTitle().toLowerCase().contains(charString.toLowerCase())){
                            filteredList.add(organization);
                        }
                    }
                    contactListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = contactListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                contactListFiltered = (List<Organization>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class PersonalViewHolder extends RecyclerView.ViewHolder  {

        public RecyclerlistBinding recyclerlistBinding;

        public PersonalViewHolder(RecyclerlistBinding recyclerlistBinding) {


            super(recyclerlistBinding.getRoot());
            this.recyclerlistBinding = recyclerlistBinding;

            recyclerlistBinding.buttonDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity activityHome = (MainActivity) view.getContext();
                    CallbackClass callbackClass = new CallbackClass();
                    callbackClass.registerCallBack(activityHome);
                    callbackClass.sentObjectToSecondFr(contactListFiltered.get(getAdapterPosition()), model_);
                }
            });

            recyclerlistBinding.buttonLink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity activityHome = (MainActivity) view.getContext();
                    CallbackClass callbackClass = new CallbackClass();
                    callbackClass.registerCallBack(activityHome);
                    callbackClass.sentLinkToWebFr(contactListFiltered.get(getAdapterPosition()).getLink());
                }
            });

            recyclerlistBinding.buttonMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity activityHome = (MainActivity) view.getContext();
                    CallbackClass callbackClass = new CallbackClass();
                    callbackClass.registerCallBack(activityHome);
                    try {
                        callbackClass.sentDataFromModelTwo(contactListFiltered.get(getAdapterPosition()).getCityId(),
                                                           contactListFiltered.get(getAdapterPosition()).getAddress());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //callbackClass.sentCallingBackMapFr();
                }
            });
            recyclerlistBinding.buttonPhone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity activityHome = (MainActivity) view.getContext();
                    CallbackClass callbackClass = new CallbackClass();
                    callbackClass.registerCallBack(activityHome);
                    callbackClass.sentDataToFragmentPhone(contactListFiltered.get(getAdapterPosition()).getPhone());
                }
            });
        }
        }
    }




