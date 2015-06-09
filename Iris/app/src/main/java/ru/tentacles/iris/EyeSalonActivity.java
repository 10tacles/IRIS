package ru.tentacles.iris;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import ru.tentacles.iris.fragments.NullSalonActivity;
import ru.tentacles.iris.fragments.eye_fragment.eyeColorRightFragment;
import ru.tentacles.iris.fragments.eye_fragment.eyeCurlingRightFragment;
import ru.tentacles.iris.fragments.eye_fragment.eyeTattooRightFragment;
import ru.tentacles.iris.fragments.eye_fragment.eyebrowRightFragment;
import ru.tentacles.iris.fragments.eye_fragment.eyelashRightFragment;
import ru.tentacles.iris.fragments.eye_fragment.makeupPermRightFragment;
import ru.tentacles.iris.fragments.eye_fragment.makeupRightFragment;
import ru.tentacles.iris.fragments.eye_fragment.mascaraRightFragment;
import ru.tentacles.iris.fragments.nail_fragments.manicureRightFragment;

//Активность для блока "Глаза"
public class EyeSalonActivity extends FragmentActivity implements View.OnClickListener {

    //Объявляем фрагменты
    private makeupRightFragment MakeupRightFragment;
    private eyebrowRightFragment EyebrowRightFragment;
    private eyeColorRightFragment EyeColorRightFragment;
    private eyeCurlingRightFragment EyeCurlingRightFragment;
    private eyelashRightFragment EyelashRightFragment;
    private eyeTattooRightFragment EyeTattooRightFragment;
    private makeupPermRightFragment MakeupPermRightFragment;
    private mascaraRightFragment MascaraRightFragment;
    private NullSalonActivity nullSalonActivity;

    //Объявляем менеджер и транзактор фрагментов -
    //без них динамически добавлять фрагменты нельзя
    FragmentManager manager;
    FragmentTransaction transaction;

    //Объявляем переменные
    Button makeup;
    Button eye_color;
    Button eyebrow_shape;
    Button eyelash;
    Button eye_curling;
    Button eye_tattoo;
    Button makeup_perm;
    Button mascara;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salon_eyes);

        //Блок инициализации переменных и значений

        manager = getSupportFragmentManager();
        MakeupRightFragment = new makeupRightFragment();
        EyebrowRightFragment = new eyebrowRightFragment();
        EyeColorRightFragment = new eyeColorRightFragment();
        EyeCurlingRightFragment = new eyeCurlingRightFragment();
        EyelashRightFragment = new eyelashRightFragment();
        EyeTattooRightFragment = new eyeTattooRightFragment();
        MakeupPermRightFragment = new makeupPermRightFragment();
        MascaraRightFragment = new mascaraRightFragment();
        nullSalonActivity = new NullSalonActivity();

        //Инициализируем кнопки,"связываем" их с id кнопок
        //в разметке eyes_fragm_left.xml
        makeup = (Button) findViewById(R.id.makeup);
        eye_color = (Button) findViewById(R.id.eye_color);
        eyebrow_shape = (Button) findViewById(R.id.eyebrow_shape);
        eyelash = (Button) findViewById(R.id.eyelash);
        eye_curling = (Button) findViewById(R.id.eye_curling);
        eye_tattoo = (Button) findViewById(R.id.eye_tattoo);
        makeup_perm = (Button) findViewById(R.id.makeup_perm);
        mascara = (Button) findViewById(R.id.mascara);
        //К кнопкам "прикрепляем" обработчик кнопок
        makeup.setOnClickListener(this);
        eye_color.setOnClickListener(this);
        eyebrow_shape.setOnClickListener(this);
        eyelash.setOnClickListener(this);
        eye_curling.setOnClickListener(this);
        eye_tattoo.setOnClickListener(this);
        makeup_perm.setOnClickListener(this);
        mascara.setOnClickListener(this);

        //Фрагмент с надписью "Выберите услугу" добавляется
        //в правое поле по умолчанию
        transaction = manager.beginTransaction();
        transaction.add(R.id.container, nullSalonActivity, NullSalonActivity.TAG);
        transaction.commit();

    }

    //Описываем действия, которые будут происходить
    //при нажатии на кнопки в подблоке "Глаза"
    @Override
    public void onClick(View v) {


        transaction = manager.beginTransaction();

        //При клике на какую-либо кнопку (Маникюр, Наращивание ресниц и т.д.)
        //в правое поле динамически добавляется нужный фрагмент с более
        //подробными услугами (Маникюр: классический, европейский и т.д.)
        switch (v.getId()) {

            case R.id.makeup:

                if (manager.findFragmentByTag(makeupRightFragment.TAG) == null) {

                    transaction.replace(R.id.container, MakeupRightFragment, makeupRightFragment.TAG);
                    transaction.setTransition(transaction.TRANSIT_FRAGMENT_OPEN);

                }
                break;

            case R.id.eye_color:

                if (manager.findFragmentByTag(eyeColorRightFragment.TAG) == null) {

                    transaction.replace(R.id.container, EyeColorRightFragment, eyeColorRightFragment.TAG);
                    transaction.setTransition(transaction.TRANSIT_FRAGMENT_FADE);

                }
                break;

            case R.id.eyebrow_shape:

                if (manager.findFragmentByTag(eyebrowRightFragment.TAG) == null) {

                    transaction.replace(R.id.container, EyebrowRightFragment, eyebrowRightFragment.TAG);
                    transaction.setTransition(transaction.TRANSIT_FRAGMENT_OPEN);

                }
                break;

            case R.id.eyelash:

                if (manager.findFragmentByTag(eyelashRightFragment.TAG) == null) {

                    transaction.replace(R.id.container, EyelashRightFragment, eyelashRightFragment.TAG);
                    transaction.setTransition(transaction.TRANSIT_FRAGMENT_FADE);

                }
                break;

            case R.id.eye_curling:

                if (manager.findFragmentByTag(eyeCurlingRightFragment.TAG) == null) {

                    transaction.replace(R.id.container, EyeCurlingRightFragment, eyeCurlingRightFragment.TAG);
                    transaction.setTransition(transaction.TRANSIT_FRAGMENT_OPEN);

                }
                break;

            case R.id.eye_tattoo:

                if (manager.findFragmentByTag(eyeTattooRightFragment.TAG) == null) {

                    transaction.replace(R.id.container, EyeTattooRightFragment, eyeTattooRightFragment.TAG);
                    transaction.setTransition(transaction.TRANSIT_FRAGMENT_FADE);

                }
                break;

            case R.id.makeup_perm:

                if (manager.findFragmentByTag(makeupPermRightFragment.TAG) == null) {

                    transaction.replace(R.id.container, MakeupPermRightFragment, makeupPermRightFragment.TAG);
                    transaction.setTransition(transaction.TRANSIT_FRAGMENT_OPEN);

                }
                break;

            case R.id.mascara:

                if (manager.findFragmentByTag(mascaraRightFragment.TAG) == null) {

                    transaction.replace(R.id.container, MascaraRightFragment, mascaraRightFragment.TAG);
                    transaction.setTransition(transaction.TRANSIT_FRAGMENT_FADE);

                }
                break;
            default:
                break;
        }
        transaction.commit();

    }

    //Обработчик для кнопки в виде домика в шапке приложения. Возвращает пользователя
    //в главную активность
    public void goHome(View v) {
        Intent intent = new Intent(getApplicationContext(), MainSalonActivity.class);
        startActivity(intent);
    }

    //Обработчик для кнопки в виде стрелки в шапке приложения. Возвращает пользователя
    //в предыдущую активность
    public void goBack(View v) {
        Intent intent = new Intent(getApplicationContext(), MainSalonActivity.class);
        finish();
    }
}

