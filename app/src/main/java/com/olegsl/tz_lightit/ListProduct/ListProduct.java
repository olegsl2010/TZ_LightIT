package com.olegsl.tz_lightit.ListProduct;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import com.olegsl.tz_lightit.ListAdapter.InsertList;
import com.olegsl.tz_lightit.ListAdapter.PostData;
import com.olegsl.tz_lightit.ListAdapter.PostItemAdapter;
import com.olegsl.tz_lightit.R;
import com.olegsl.tz_lightit.itemProduct.ItemList;
import java.util.ArrayList;


public class ListProduct extends Fragment implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {


    View rootView;
    FragmentTransaction fragManager;
    PostItemAdapter itemAdapter;
    public SearchView searchView;
    ListView ourListView;
    private ArrayList<PostData> listData;
    private ArrayList<PostData> searchData;
    PostData data;
    InsertList listWallet;
    private String title;
    private String TAG ="List Product";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.list_fragment_adapter, container, false);




        ourListView = (ListView) rootView.findViewById(R.id.listView);
        listWallet = new InsertList();
        listData = new ArrayList<>();
        listData = listWallet.InsertList();
        toList(listData);


        searchView = (SearchView) rootView.findViewById(R.id.search_box);
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);



        ourListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                productView(position);

            }
        });


        return rootView;
    }

    private void productView(int position) {

        title = listData.get(position).getPostTitleProduct();
        ItemList itemList= new ItemList();
        itemList.setTextForView(title);
        fragManager = getFragmentManager().beginTransaction()
                .setCustomAnimations(R.animator.gla_there_come,R.animator.gla_there_gone);
        fragManager.replace(R.id.container, itemList);
        fragManager.addToBackStack("null");
        fragManager.commit();
    }

    public void toList(ArrayList<PostData> listWallet) {
        itemAdapter = new PostItemAdapter(getActivity(), R.layout.postitem, listWallet);
        ourListView.setAdapter(itemAdapter);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        displayResults(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        if (!newText.isEmpty()){
            displayResults(newText);
        } else {
            ourListView.setAdapter(itemAdapter);
        }

        return false;

    }

    private void displayResults(String query) {

        searchData= new ArrayList<>();

        for (int pos = 0; pos < listData.size(); pos++) {
            if (listData.get(pos).getPostTitleProduct().contains(query)){
                data = new PostData();
                data.setPostTitleProduct(listData.get(pos).getPostTitleProduct());
                searchData.add(data);

                Log.d(TAG, listData.get(pos).getPostTitleProduct());

            }
        }
        toList(searchData);

          // Click listener for the searched item that was selected
        ourListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String selectedName = searchData.get(position).getPostTitleProduct();

                // Find the position for the original list by the selected name from search
                for (int pos = 0; pos < listData.size(); pos++) {
                    if (listData.get(pos).getPostTitleProduct().equals(selectedName)) {
                        position = pos;

                        break;
                    }
                }
                productView(position);
                searchView.setQuery("",true);
            }
        });
    }

    @Override
    public boolean onClose() {
        return false;
    }
}

