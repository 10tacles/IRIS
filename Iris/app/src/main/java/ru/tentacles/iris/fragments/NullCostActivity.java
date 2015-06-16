package ru.tentacles.iris.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import ru.tentacles.iris.BodyFaceSalonActivity;
import ru.tentacles.iris.EpilationSalonActivity;
import ru.tentacles.iris.EyeSalonActivity;
import ru.tentacles.iris.HairSalonActivity;
import ru.tentacles.iris.MainSalonActivity;
import ru.tentacles.iris.MenSalonActivity;
import ru.tentacles.iris.NailSalonActivity;
import ru.tentacles.iris.R;



//Активность, на которую переводим пользователя, если
//по какой-либо услуге салоны не найдены
public class NullCostActivity extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salon_null_cost_fragment);

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

        res.setSelection(0);

    }
}
