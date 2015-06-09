package ru.tentacles.iris.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.tentacles.iris.R;



public class NullSalonActivity extends Fragment {

    public static final String TAG = "NullSalonActivity";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.salon_null_fragment, null);
    }
}
