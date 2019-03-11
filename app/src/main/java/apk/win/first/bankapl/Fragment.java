package apk.win.first.bankapl;

import android.app.SearchManager;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.io.Serializable;

import apk.win.first.bankapl.databinding.CustomlistBinding;
import apk.win.first.bankapl.databinding.FragmentBinding;

public class Fragment extends android.support.v4.app.Fragment implements Serializable, MainContract.Presenter {

    FragmentBinding fragmentBinding;
    public Model model;
    public ModelTwo modelTwo;
    public MainContract.View mView;
    String s = "";
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.user_info, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView sv = new SearchView( ((MainActivity)getActivity()).getSupportActionBar().getThemedContext());
        //item.setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItem.SHOW_AS_ACTION_IF_ROOM); item.setActionView(searchView);
        MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        MenuItemCompat.setActionView(item, sv);
        //MenuItemCompat.setActionView(itemTwo);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                System.out.println("search query submit");
                System.out.println("Query: " + query);
                //recyclerViewAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
               // System.out.println("tap");
                recyclerViewAdapter.getFilter().filter(newText);
                System.out.println("Query: " + newText);
                return false;
            }
        });


        /*inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.user_info, menu);
        MenuItem searchitem = menu.findItem(R.id.action_search);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        if (searchitem!=null){
            searchView = (SearchView) searchitem.getActionView();
        }

        if (searchView!=null){
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                s = query;
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });*/
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                // Not implemented here
                return false;
            default:
                break;
        }
        //searchView.setOnQueryTextListener(queryTextListener);
        return super.onOptionsItemSelected(item);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment, container,false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(container.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        fragmentBinding.recyclerView.setLayoutManager(layoutManager);
        ((MainActivity)getActivity()).setSupportActionBar(fragmentBinding.ToolB);

        MainActivity activityHome = (MainActivity) container.getContext();
        final CallbackClass callbacks = new CallbackClass();
        callbacks.registerCallBack(activityHome);

        fragmentBinding.swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    model = callbacks.loadObjectsList();
                    System.out.println("Good");
                    recyclerViewAdapter = new RecyclerViewAdapter(model.getOrganizations(), model);
                    fragmentBinding.recyclerView.setAdapter(recyclerViewAdapter);
                    fragmentBinding.setModelFor(model);
                    fragmentBinding.swipeLayout.setRefreshing(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            model = callbacks.loadObjectsList();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Good");
        recyclerViewAdapter = new RecyclerViewAdapter(model.getOrganizations(), model);
        fragmentBinding.recyclerView.setAdapter(recyclerViewAdapter);
        fragmentBinding.setModelFor(model);

        /*try {
           // modelTwo = callbacks.loadModelTwoObject();
            System.out.println("ModelTwogood");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        /*fragmentBinding.recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(container.getContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                MainActivity activityHome = (MainActivity) view.getContext();
                CallbackClass callbackClass = new CallbackClass();
                callbackClass.registerCallBack(activityHome);
                callbackClass.sentObjectToSecondFr(model.getOrganizations().get(position), model);
            }
        }));*/
        return fragmentBinding.getRoot();
    }

    @Override
    public void onButtonWasClicked() {
        mView.giveModel(model.getCurrencies());
    }
}
