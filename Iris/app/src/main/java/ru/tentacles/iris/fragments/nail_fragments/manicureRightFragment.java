package ru.tentacles.iris.fragments.nail_fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import ru.tentacles.iris.NailsSalonActivity;
import ru.tentacles.iris.R;


public class manicureRightFragment  extends ListFragment{

    public static final String TAG = "manicureRightFragment";
    //�� �� ����� ��������� ������� ������ �������
    //��� ������� ������������� � �������� res/values/arrays.xml
    //� ����� ������ �� �������� ������ �� ������� � ��������� (1*)
    //Resources res = getResources();
    //String[] manicureService = res.getStringArray(R.array.manicureServiceArray);

    //@Override
    //public void onActivityCreated(Bundle savedInstanceState) {
        //super.onActivityCreated(savedInstanceState);
        // (1*) � ������� ������� - ������� ����� ��������� ��� ������, ���������� �����,
        //� View-������� "������"
        //ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, manicureService);
        //setListAdapter(mAdapter);

    //}
}
