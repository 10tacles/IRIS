package ru.tentacles.iris.fragments.nail_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import ru.tentacles.iris.R;

//Фрагмент, отражающий полный список услуг блока "Маникюр":
//Классический -- Европейский -- Аппаратный и т.д.
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
        ArrayAdapter<CharSequence> mAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.manicureServiceArray,
                android.R.layout.simple_list_item_1);
        setListAdapter(mAdapter);

    }

    //Обработчик кнопок. Нажатие на любую кнопку из списка
    //переводит нас в активность NailCostFragment, туда же
    //передаем позицию кнопки "position"
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent in = new Intent(getActivity(), ManicureCostFragment.class);
        in.putExtra("manicure", position);
        startActivity(in);
    }

}
