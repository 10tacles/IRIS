package ru.tentacles.iris.fragments.eye_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ru.tentacles.iris.R;

//Фрагмент для 2 состояния блока "Глаза". Находится справа,
//на нем располагаются услуги подблока "Глаза", такие как
//"Макиях вечерний", "Татуаж бровей" и т.д.
public class makeupRightFragment extends ListFragment{

    public static final String TAG = "makeupRightFragmentTAG";

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Мы не будем создавать массивы внутри классов.
        //Все массивы располагаются в ресурсах res/values/arrays.xml
        //В самом классе мы получаем доступ до ресурса с массивами
        // и создаем адаптер - который будет связывать сам массив, полученный ранее,
        //и View-элемент "Список"
        ArrayAdapter<CharSequence> mAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.makeupArray,
                android.R.layout.simple_list_item_1);
        setListAdapter(mAdapter);
    }

    //Обработчик кнопок. Нажатие на любую кнопку из списка
    //переводит нас в активность NailCostFragment, туда же
    //передаем позицию кнопки "position"
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent me = new Intent(getActivity(), MakeupCostFragment.class);
        me.putExtra("makeup", position);
        startActivity(me);

    }
}
