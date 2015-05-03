package ru.tentacles.iris.fragments.nail_fragments;


import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import ru.tentacles.iris.R;

public class nailServRightFragment extends ListFragment {

    public static final String TAG = "nailServRightFragmentTAG";


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<CharSequence> nAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.nailServiceArray, android.R.layout.simple_list_item_1);
        setListAdapter(nAdapter);
    }
}
