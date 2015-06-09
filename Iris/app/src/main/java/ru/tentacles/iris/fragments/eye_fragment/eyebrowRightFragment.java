package ru.tentacles.iris.fragments.eye_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ru.tentacles.iris.R;
import ru.tentacles.iris.fragments.nail_fragments.ExtentionCostFragment;

//Фрагмент для 2 состояния блока "Глаза". Находится справа,
//на нем располагаются услуги подблока "Глаза", такие как
//"Макиях вечерний", "Татуаж бровей" и т.д.
public class eyebrowRightFragment extends ListFragment{

    public static final String TAG = "eyebrowRightFragmentTAG";

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Мы не будем создавать массивы внутри классов.
        //Все массивы располагаются в ресурсах res/values/arrays.xml
        //В самом классе мы получаем доступ до ресурса с массивами
        // и создаем адаптер - который будет связывать сам массив, полученный ранее,
        //и View-элемент "Список"
        ArrayAdapter<CharSequence> mAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.eyebrow_shapeArray,
                android.R.layout.simple_list_item_1);
        setListAdapter(mAdapter);
    }

    //Обработчик кнопок. Нажатие на любую кнопку из списка
    //переводит нас в активность NailCostFragment, туда же
    //передаем позицию кнопки "position"
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent ee = new Intent(getActivity(), EyebrowCostFragment.class);
        ee.putExtra("eyebrow", position);
        startActivity(ee);

    }
}
