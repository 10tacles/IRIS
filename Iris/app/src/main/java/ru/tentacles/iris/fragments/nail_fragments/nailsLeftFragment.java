package ru.tentacles.iris.fragments.nail_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ru.tentacles.iris.R;

//Фрагмент для 2 состояния блока "Ногти". Находится слева,
//на нем расположены кнопки "Маникюр", "Наращивание ногтей" и т.д.
public class nailsLeftFragment extends Fragment {
        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nails_fragm_left, container, true);
    }

}
