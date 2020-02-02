package org.tyaa.intentsfragmentsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;

public class ItemsListFragment extends ListFragment {

    private ArrayList<String> mItems;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mItems = new ArrayList<String>();
        ItemsAdapter itemsAdapter = new ItemsAdapter(mItems);
        setListAdapter(itemsAdapter);
        mItems.add("One");
        mItems.add("Two");
        mItems.add("Three");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_items_list, container, false);
        return view;
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        /* Toast toast = Toast.makeText(
                getActivity(), mItems.get(position), Toast.LENGTH_SHORT
        );
        toast.show(); */
        Intent startSecondActivityIntent =
                new Intent(getActivity(), SecondActivity.class);
        startSecondActivityIntent.putExtra(SecondFragment.EXTRA_ITEM_TEXT, mItems.get(position));
        startActivity(startSecondActivityIntent);
    }

    private class ItemsAdapter extends ArrayAdapter<String> {
        public ItemsAdapter(ArrayList<String> items) {
            super(getActivity(), android.R.layout.simple_list_item_1, items);
        }
    }
}
