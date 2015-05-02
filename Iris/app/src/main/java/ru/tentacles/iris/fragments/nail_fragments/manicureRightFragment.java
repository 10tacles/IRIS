package ru.tentacles.iris.fragments.nail_fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import ru.tentacles.iris.NailsSalonActivity;
import ru.tentacles.iris.R;


public class manicureRightFragment  extends ListFragment{

    public static final String TAG = "manicureRightFragment";
    //ћы не будем создавать массивы внутри классов
    //¬се массивы располагаютс€ в ресурсах res/values/arrays.xml
    //¬ самом классе мы получаем доступ до ресурса с массивами (1*)
    //Resources res = getResources();
    //String[] manicureService = res.getStringArray(R.array.manicureServiceArray);

    //@Override
    //public void onActivityCreated(Bundle savedInstanceState) {
        //super.onActivityCreated(savedInstanceState);
        // (1*) и создаем адаптер - который будет св€зывать сам массив, полученный ранее,
        //и View-элемент "—писок"
        //ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, manicureService);
        //setListAdapter(mAdapter);

    //}
}
