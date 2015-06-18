package ru.tentacles.iris.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ru.tentacles.iris.R;

//класс, который будет привязан к фрагментуbody_main_salon
//body_main_salon - это тело приложения, тут будут располагаться
//основные блоки услуг салонов
public class bodyMainSalonFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.body_main_salon, container, true);
    }

}

