package ru.tentacles.iris;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

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
public class EyeSalonActivity extends ActionBarActivity implements View.OnClickListener {

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

        //Инициализируем тулбар
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(getResources().getColor(R.color.buttons_second));

        //Инициализируем навигационное меню
        Drawer.Result res = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withHeader(R.layout.drawer_header)
                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withName(R.string.drawer_item_home)
                                .withIcon(FontAwesome.Icon.faw_home)
                                .withIdentifier(1),
                        new PrimaryDrawerItem()
                                .withName(R.string.drawer_item_hair)
                                .withIcon(FontAwesome.Icon.faw_female)
                                .withIdentifier(2),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_nails)
                                .withIcon(FontAwesome.Icon.faw_paw)
                                .withIdentifier(3),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_eyebrows)
                                .withIcon(FontAwesome.Icon.faw_eye)
                                .withIdentifier(4),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_bodyface)
                                .withIcon(FontAwesome.Icon.faw_play)
                                .withIdentifier(5),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_epilation)
                                .withIcon(FontAwesome.Icon.faw_venus)
                                .withIdentifier(6),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_men)
                                .withIcon(FontAwesome.Icon.faw_male)
                                .withIdentifier(7),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem()
                                .withName(R.string.drawer_item_settings)
                                .withIcon(FontAwesome.Icon.faw_cog)
                                .setEnabled(false),
                        new SecondaryDrawerItem()
                                .withName(R.string.drawer_item_contact)
                                .withIcon(FontAwesome.Icon.faw_bullhorn)
                                .setEnabled(false)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l, IDrawerItem iDrawerItem) {
                        try {


                            switch (iDrawerItem.getIdentifier()){
                                case 1:
                                    Intent intentHome = new Intent(getApplicationContext(), MainSalonActivity.class);
                                    startActivity(intentHome);

                                    break;
                                case 2:
                                    Intent intentHair = new Intent(getApplicationContext(), HairSalonActivity.class);
                                    startActivity(intentHair);
                                    break;
                                case 3:
                                    Intent intentNails = new Intent(getApplicationContext(), NailSalonActivity.class);
                                    startActivity(intentNails);
                                    break;
                                case 4:
                                    Intent intentEyebrows = new Intent(getApplicationContext(), EyeSalonActivity.class);
                                    startActivity(intentEyebrows);
                                    break;
                                case 5:
                                    Intent intentBody = new Intent(getApplicationContext(), BodyFaceSalonActivity.class);
                                    startActivity(intentBody);
                                    break;
                                case 6:
                                    Intent intentEpil = new Intent(getApplicationContext(), EpilationSalonActivity.class);
                                    startActivity(intentEpil);
                                    break;
                                case 7:
                                    Intent intentMen = new Intent(getApplicationContext(), MenSalonActivity.class);
                                    startActivity(intentMen);
                                    break;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                })
                .build();

        res.setSelection(3);

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

