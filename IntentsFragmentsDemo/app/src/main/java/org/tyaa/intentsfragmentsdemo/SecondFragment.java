package org.tyaa.intentsfragmentsdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    public static final String EXTRA_ITEM_TEXT = "com.tyaa.itsteplistfragments.item_text";
    private String mItemTextString = "";
    private TextView mSecondActivityTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mItemTextString =
                (String)getActivity().getIntent().getSerializableExtra(EXTRA_ITEM_TEXT);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        mSecondActivityTextView = (TextView)view.findViewById(R.id.second_activity_TextView);
        mSecondActivityTextView.setText(mItemTextString);
        return view;
    }
}
