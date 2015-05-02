package ru.tentacles.iris;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;

import ru.tentacles.iris.fragments.NullSalonActivity;
import ru.tentacles.iris.fragments.nail_fragments.manicureRightFragment;


    //Активность, в которой будут описываться все услуги
    //из раздела "Ногти"
    //Экран разделен на 2 части, слева общие услуги,
    //а справа более подробная информация по выбранной услуге.
    //правое окошко реализовано через динамическое
    //добавление фрагментов
public class NailsSalonActivity extends FragmentActivity implements View.OnClickListener{

    //Объявляем переменные
    Button manicure;
    Button pedicure;
    Button nail;
    Button spa_care;
    Button nail_extention;

     //Мы не будем создавать массивы внутри классов
     //Все массивы располагаются в ресурсах res/values/arrays.xml
     //В самом классе мы получаем доступ до ресурса с массивами (1*)
        Resources res = getResources();
        String[] manicureService = res.getStringArray(R.array.manicureServiceArray);



    //Объявляем фрагменты
    private manicureRightFragment ManicureRightFragment;



        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salon_nails);

        // (1*) и создаем адаптер - который будет связывать сам массив, полученный ранее,
        //и View-элемент "Список"
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, manicureService);
        ManicureRightFragment.setListAdapter(mAdapter);

        //Через Менеджер будем проводить транзакции
            FragmentManager manager = getSupportFragmentManager();

        //Инициализируем фрагменты
        ManicureRightFragment = new manicureRightFragment();



        //Инициализируем переменные и "связываем" их с элементами-кнопками
        //в разметке nails_fragment_left.xml
        manicure = (Button) findViewById(R.id.manicure);
        pedicure = (Button) findViewById(R.id.pedicure);
        nail = (Button) findViewById(R.id.nail);
        spa_care = (Button) findViewById(R.id.spa_care);
        nail_extention = (Button) findViewById(R.id.nail_extention);

        //Прописываем обработчик кнопок
        manicure.setOnClickListener(this);
        pedicure.setOnClickListener(this);
        nail.setOnClickListener(this);
        spa_care.setOnClickListener(this);
        nail_extention.setOnClickListener(this);

        /*//Запуск транзакций
        transaction = manager.beginTransaction();
        if(manager.findFragmentByTag(NullSalonActivity.TAG) == null) {
            transaction.add(R.id.container, nullSalonActivity, NullSalonActivity.TAG );
        }*/



    }

    //Обработчик кликов по кнопкам
    @Override
    public void onClick(View v) {
      /*  //Запуск транзакций
        FragmentTransaction transaction = manager.beginTransaction();
    //В зависимости от нажатой кнопки будем динамически
    // добавлять нужный фрагмент
        switch (v.getId()) {
            case R.id.manicure:
                if (manager.findFragmentByTag(manicureRightFragment.TAG) == null){
                    transaction.add(R.id.container, ManicureRightFragment, manicureRightFragment.TAG);
                    //transaction.setTransition(transaction.TRANSIT_FRAGMENT_OPEN);
                } else {
                    transaction.replace(R.id.container, ManicureRightFragment, manicureRightFragment.TAG);
                    //transaction.setTransition(transaction.TRANSIT_FRAGMENT_FADE);
                }
                break;
            case R.id.pedicure:
                break;

            case R.id.nail:
                break;

            case R.id.spa_care:
                break;

            case R.id.nail_extention:
                break;

        }
        transaction.commit();*/
    }
}
