package ru.tentacles.iris;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import ru.tentacles.iris.fragments.NullSalonActivity;
import ru.tentacles.iris.fragments.nail_fragments.extentionRightFragment;
import ru.tentacles.iris.fragments.nail_fragments.manicureRightFragment;
import ru.tentacles.iris.fragments.nail_fragments.nailServRightFragment;
import ru.tentacles.iris.fragments.nail_fragments.pedicureRightFragment;




public class NailSalonActivity extends AppCompatActivity implements View.OnClickListener {

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
    Button nail_extention;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salon_nails);

        //Инициализируем тулбар
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(getResources().getColor(R.color.buttons_second));

        //Инициализируем навигационное меню
        Drawer res = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(true)
                .withActionBarDrawerToggleAnimated(true)
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
                // TODO починить обработчик кнопок для nav drawer
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                            @Override
                            public boolean onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
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
                                        //интент на ту же страницу крашит приложуху!
//                                        case 3:
//                                            Intent intentNails = new Intent(getApplicationContext(), NailSalonActivity.class);
//                                            startActivity(intentNails);
//                                            break;
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
                                        default:
                                        break;

                                            }
                                } catch (Exception e) {
                            e.printStackTrace();
                       }

                                return false;
                            }
                        })
                    .build();

        res.setSelection(2);

        //Блок инициализации переменных и значений
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
        nail_extention = (Button) findViewById(R.id.nail_extention);
        //Привязываем обработчик кнопок
        manicure.setOnClickListener(this);
        pedicure.setOnClickListener(this);
        nail.setOnClickListener(this);
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

        //При клике на какую-либо кнопку (Маникюр, Наращивание ресниц и т.д.)
        //в правое поле динамически добавляется нужный фрагмент с более
        //подробными услугами (Маникюр: классический, европейский и т.д.)
        switch (v.getId()) {

            case R.id.manicure:

                if (manager.findFragmentByTag(manicureRightFragment.TAG) == null) {
                    transaction.replace(R.id.container, ManicureRightFragment, manicureRightFragment.TAG);
                    transaction.setTransition(transaction.TRANSIT_FRAGMENT_OPEN);

                }
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
