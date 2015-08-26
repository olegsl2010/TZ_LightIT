package com.olegsl.tz_lightit.ListProduct;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.olegsl.tz_lightit.ListAdapter.InsertList;
import com.olegsl.tz_lightit.ListAdapter.PostData;
import com.olegsl.tz_lightit.ListAdapter.PostItemAdapter;
import com.olegsl.tz_lightit.R;
import com.olegsl.tz_lightit.itemProduct.ItemList;

import java.util.ArrayList;

/**
 * Created by olegs_000 on 22.07.2015.
 */
public class ListProduct extends Fragment implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {


    View rootView;
    FragmentTransaction fragManager;
PostItemAdapter itemAdapter;
    public SearchView searchView;
    public SearchHelper mDbHelper;
    ListView ourListView;
    private ArrayList<PostData> listData;
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

        mDbHelper = new SearchHelper(rootView.getContext());
        mDbHelper.open();

        //Clear all names
        mDbHelper.deleteAllNames();

        // Create the list of names which will be displayed on search
        for (PostData postTitleProduct : listData) {
            mDbHelper.createList(String.valueOf(postTitleProduct));
        }


        ourListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, String.valueOf(position));
                title = listData.get(position).getPostTitleProduct();

                ItemList itemList= new ItemList();

                itemList.setTextForView(title);

                fragManager = getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.animator.gla_there_come,R.animator.gla_there_gone);
                fragManager.replace(R.id.container, itemList);
                fragManager.addToBackStack("null");
                fragManager.commit();
            }
        });


        return rootView;
    }

    public void toList(ArrayList<PostData> listWallet) {
        itemAdapter = new PostItemAdapter(getActivity(), R.layout.postitem, listWallet);
        Log.d("To list wallet", String.valueOf(listWallet.size()));
        ourListView.setAdapter(itemAdapter);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        displayResults(query + "*");
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        if (!newText.isEmpty()){
            displayResults(newText + "*");
        } else {
            ourListView.setAdapter(itemAdapter);
        }

        return false;

    }

    private void displayResults(String query) {

        Cursor cursor = mDbHelper.searchByInputText((query != null ? query : "@@@@"));

        if (cursor != null) {

            String[] from = new String[] {SearchHelper.COLUMN_NAME};

            // Specify the view where we want the results to go
            int[] to = new int[] {R.id.postTitleProduct};

            // Create a simple cursor adapter to keep the search data
            SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(rootView.getContext(), R.layout.postitem, cursor, from, to);
            ourListView.setAdapter(cursorAdapter);

            // Click listener for the searched item that was selected
            ourListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    // Get the cursor, positioned to the corresponding row in the result set
                    Cursor cursor = (Cursor) ourListView.getItemAtPosition(position);

                    // Get the state's capital from this row in the database.
                    String selectedName = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                    Toast.makeText(rootView.getContext(), selectedName, Toast.LENGTH_SHORT).show();

                    // Set the default adapter
                    ourListView.setAdapter(itemAdapter);

                    // Find the position for the original list by the selected name from search
                    for (int pos = 0; pos < listData.size(); pos++) {
                        if (listData.get(pos).equals(selectedName)){
                            position = pos;
                            break;
                        }
                    }

                    // Create a handler. This is necessary because the adapter has just been set on the list again and
                    // the list might not be finished setting the adapter by the time we perform setSelection.
                    Handler handler = new Handler();
                    final int finalPosition = position;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            ourListView.setSelection(finalPosition);
                        }
                    });

                    searchView.setQuery("",true);
                }
            });

        }
    }

    @Override
    public boolean onClose() {
        return false;
    }
}

