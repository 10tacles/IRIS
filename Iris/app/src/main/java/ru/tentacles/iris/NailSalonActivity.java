package ru.tentacles.iris;



import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ru.tentacles.iris.fragments.NullSalonActivity;
import ru.tentacles.iris.fragments.nail_fragments.extentionRightFragment;
import ru.tentacles.iris.fragments.nail_fragments.manicureRightFragment;
import ru.tentacles.iris.fragments.nail_fragments.nailServRightFragment;
import ru.tentacles.iris.fragments.nail_fragments.pedicureRightFragment;


public class NailSalonActivity extends FragmentActivity implements View.OnClickListener{
    //Объявляем фрагменты
    private manicureRightFragment ManicureRightFragment;
    private NullSalonActivity nullSalonActivity;
    private pedicureRightFragment PedicureRightFragment;
    private nailServRightFragment NailServRightFragment;
    private extentionRightFragment ExtentionRightFragment;

    //Объявляем менеджер и транзактор фрагментов -
    //без них динамически добавлять фрагменты нельзя
    FragmentManager manager;
    FragmentTransaction transaction;

    //Объявляем переменные
    Button manicure;
    Button pedicure;
    Button nail;
    //Button spa_care;
    Button nail_extention;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salon_nails);

        manager = getSupportFragmentManager();

        ManicureRightFragment = new manicureRightFragment();
        nullSalonActivity = new NullSalonActivity();
        PedicureRightFragment = new pedicureRightFragment();
        NailServRightFragment = new nailServRightFragment();
        ExtentionRightFragment = new extentionRightFragment();

        //Инициализируем переменные,"связываем" их с id кнопок
        //в разметке nails_fragm_left.xml
        manicure = (Button) findViewById(R.id.manicure);
        pedicure = (Button) findViewById(R.id.pedicure);
        nail = (Button) findViewById(R.id.nail);
        //spa_care = (Button) findViewById(R.id.spa_care);
        nail_extention = (Button) findViewById(R.id.nail_extention);
        //Привязываем обработчик кнопок
        manicure.setOnClickListener(this);
        pedicure.setOnClickListener(this);
        nail.setOnClickListener(this);
        //spa_care.setOnClickListener(this);
        nail_extention.setOnClickListener(this);

        //Фрагмент с надписью "Выберите услугу" добавляется
        //в правое поле по умолчанию
        transaction = manager.beginTransaction();
        transaction.add(R.id.container, nullSalonActivity, NullSalonActivity.TAG);
        transaction.commit();




    }

    //Описываем действия, которые будут происходить
    //при нажатии на кнопки
    @Override
    public void onClick(View v) {

        transaction = manager.beginTransaction();

        //Для каждой кнопки создана своя реализация
        switch (v.getId()) {

            case R.id.manicure:
                //manicure.setBackgroundColor(getResources().getColor(R.color.right_fragment));
                if (manager.findFragmentByTag(manicureRightFragment.TAG) == null) {
                   // manicure.setBackgroundColor(getResources().getColor(R.color.right_fragment));
                    transaction.replace(R.id.container, ManicureRightFragment, manicureRightFragment.TAG);
                    transaction.setTransition(transaction.TRANSIT_FRAGMENT_OPEN);
                } /*else {
                    manicure.setBackgroundColor(getResources().getColor(R.color.body_color));
                    transaction.replace(R.id.container, ManicureRightFragment, manicureRightFragment.TAG);
                    transaction.setTransition(transaction.TRANSIT_FRAGMENT_FADE);
                } */
                break;

            case R.id.pedicure:
               //pedicure.setBackgroundColor(getResources().getColor(R.color.right_fragment));
                if (manager.findFragmentByTag(pedicureRightFragment.TAG) == null) {
                    transaction.replace(R.id.container, PedicureRightFragment, pedicureRightFragment.TAG);
                    transaction.setTransition(transaction.TRANSIT_FRAGMENT_CLOSE);
                }
                break;

            case R.id.nail:
                if (manager.findFragmentByTag(nailServRightFragment.TAG) == null) {
                    transaction.replace(R.id.container, NailServRightFragment, nailServRightFragment.TAG);
                    transaction.setTransition(transaction.TRANSIT_FRAGMENT_OPEN);
                }
                break;

            /*case R.id.spa_care:
                Toast.makeText(getApplicationContext(), "SPA", Toast.LENGTH_SHORT).show();
                break;*/

            case R.id.nail_extention:
                if (manager.findFragmentByTag(extentionRightFragment.TAG) == null) {
                    transaction.replace(R.id.container, ExtentionRightFragment, extentionRightFragment.TAG);
                    transaction.setTransition(transaction.TRANSIT_FRAGMENT_CLOSE);
                }
                break;
            default:
                break;
        }

        transaction.commit();

    }
}
