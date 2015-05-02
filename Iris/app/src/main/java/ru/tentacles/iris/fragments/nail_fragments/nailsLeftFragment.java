package ru.tentacles.iris.fragments.nail_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.tentacles.iris.R;

//класс, который будет привязан к фрагменту nails_fragm_left
//nails_fragm_left - это список основных услуг
//раздела "Ногти
public class nailsLeftFragment extends Fragment {
        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nails_fragm_left, container, true);



    }


}
