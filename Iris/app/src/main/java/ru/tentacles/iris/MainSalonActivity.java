package ru.tentacles.iris;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import com.mikepenz.materialdrawer.model.interfaces.Badgeable;
import android.view.View;
import android.widget.AdapterView;
import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;



//Главная активность для салонов красоты
public class MainSalonActivity extends ActionBarActivity{
    Badgeable header;

    //привязываем активность и слой main_salon
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_salon);
        Badgeable header = (Badgeable)findViewById(R.id.header);
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

                            switch (iDrawerItem.getIdentifier()) {

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

                    res.setSelection(9);
    }

    //Обработчик для кнопки "Ногти" - переходим на активность с выбором услуг "Маникюр и Педикюр"
    public void goNailsActivity (View v) {
        Intent intent = new Intent(getApplicationContext(), NailSalonActivity.class);
        startActivity(intent);
    }

    //Обработчик для кнопки "Глаза" - переходим на активность с выбором услуг
    //"Татуаж", "Наращивание ресниц" и т.д.
    public void goEyesActivity (View v) {
        Intent intent = new Intent(getApplicationContext(), EyeSalonActivity.class);
        startActivity(intent);
    }
}


