package ru.tentacles.iris.fragments.nail_fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import ru.tentacles.iris.R;

public class nailServRightFragment extends ListFragment {

    public static final String TAG = "nailServRightFragmentTAG";


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<CharSequence> nAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.nailServiceArray, android.R.layout.simple_list_item_1);
        setListAdapter(nAdapter);
    }


    //Обработчик кнопок. Нажатие на любую кнопку из списка
    //переводит нас в активность NailCostFragment, туда же
    //передаем позицию кнопки "position"
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent nn = new Intent(getActivity(), ShellacCostFragment.class);
        nn.putExtra("nail", position);
        startActivity(nn);

    }
}

