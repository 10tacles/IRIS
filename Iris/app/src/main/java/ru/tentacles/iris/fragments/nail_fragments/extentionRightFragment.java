package ru.tentacles.iris.fragments.nail_fragments;


import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import ru.tentacles.iris.R;

public class extentionRightFragment extends ListFragment{

    public static final String TAG = "extentionRightFragmentTAG";

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<CharSequence> eAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.extentionServiceArray, android.R.layout.simple_list_item_1);
        setListAdapter(eAdapter);
    }
}
