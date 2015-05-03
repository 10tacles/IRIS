package ru.tentacles.iris.fragments.nail_fragments;


import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;
import ru.tentacles.iris.R;


public class manicureRightFragment  extends ListFragment{


    public static final String TAG = "manicureRightFragmentTAG";




    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Мы не будем создавать массивы внутри классов.
        //Все массивы располагаются в ресурсах res/values/arrays.xml
        //В самом классе мы получаем доступ до ресурса с массивами
        // и создаем адаптер - который будет связывать сам массив, полученный ранее,
        //и View-элемент "Список"
        ArrayAdapter<CharSequence> mAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.manicureServiceArray, android.R.layout.simple_list_item_1);
        setListAdapter(mAdapter);

    }
}
