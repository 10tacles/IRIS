package ru.tentacles.iris.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.tentacles.iris.R;

/** Этот фрагмент будем использовать во всех активностях,
 * состоящих из двух полей.
 * Фрагмент будет стоять справа, если ни одна услуга не выбрана
 */

public class NullSalonActivity extends Fragment {

    public static final String TAG = "NullSalonActivity";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.salon_null_fragment, null);
    }
}
