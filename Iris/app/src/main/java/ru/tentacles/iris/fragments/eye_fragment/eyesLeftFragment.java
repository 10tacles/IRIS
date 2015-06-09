package ru.tentacles.iris.fragments.eye_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.tentacles.iris.R;

//Фрагмент для 2 состояния блока "Глаза". Находится слева,
//на нем расположены кнопки "Макияж", "Наращивание ресниц" и т.д.
public class eyesLeftFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.eyes_fragment_left, container, true);
    }
}
