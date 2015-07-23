package ru.tentacles.iris.fragments.eye_fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ru.tentacles.iris.BodyFaceSalonActivity;
import ru.tentacles.iris.EpilationSalonActivity;
import ru.tentacles.iris.EyeSalonActivity;
import ru.tentacles.iris.HairSalonActivity;
import ru.tentacles.iris.MainSalonActivity;
import ru.tentacles.iris.MenSalonActivity;
import ru.tentacles.iris.NailSalonActivity;
import ru.tentacles.iris.R;
import ru.tentacles.iris.fragments.CostSalonsFragment;
import ru.tentacles.iris.fragments.NullCostActivity;
import ru.tentacles.iris.parser.JSONParser;

// 3-е состояние приложения.
// Выводит салоны и цены на услуги подблока "Перманентный макияж"
// блока "Глаза"
public class MakeupPermCostFragment extends ActionBarActivity{

    //Блок объявления значений и переменных.
    TextView block_name;
    //Визуальное отображение задачи async task
    //для пользователя
    private ProgressDialog pDialog;

    //Создаем JSONParser, который будет отсылать запросы к серверу и
    //обрабатывать полученные данные
    JSONParser jsonParser = new JSONParser();


    //список для вывода информации по ценам
    ArrayList<HashMap<String, String>> mClassicList;

    //Объявляем тэги, которые будут соответствовать данным,
    //приходящим от сервера
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_SALONS = "salons";
    private static final String TAG_id = "id_salon";
    private static final String TAG_name = "salon_name";
    private static final String TAG_address = "salon_address";
    private static final String TAG_cost = "salon_eyes_cost";
    private static final String TAG_rate = "salon_rate";
    private static final String TAG_comm = "salon_comm";
    private static final String TAG_phone = "salon_phone";

    //массив для хранения списка салонов
    JSONArray mClassic = null;

    //URL скрипта
    String update_salon = "http://10tacles.ru/salons/getcost/get_eye_cost.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salon_nail_cost);

        //Инициализируем тулбар
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(getResources().getColor(R.color.buttons_second));

        //Инициализируем навигационное меню
        Drawer res = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(true)
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
                    public boolean onItemClick(AdapterView<?> adapterView, View view, int position, long l, IDrawerItem iDrawerItem) {
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
                        return false;
                    }
                })
                .build();

        res.setSelection(3);

        //Блок инициализации переменных
        block_name = (TextView) findViewById(R.id.block_name);

        mClassicList = new ArrayList<HashMap<String, String>>();

        //В фоновом потоке передаем на сервер id
        //требуемой услуги
        new UpdateCost().execute();
        //Загружаем салоны в фоновом потоке
        new LoadCost().execute();
    }

    class UpdateCost extends AsyncTask<String, String, Void> {


        @Override
        protected Void doInBackground(String... args) {
            //Принимаем переход с предыдущей активности, а также
            //получаем позицию нажатой кнопки "position".
            Intent ta = getIntent();
            int n = ta.getIntExtra("perm", 20);
            String id_eye = null;
            //В зависимости от позиции (нажатой кнопки) мы отправляем
            //в SQL запрос id требуемой нами услуги
            if (n == 0) {
                id_eye = "25";
                block_name.setText("Перманентный макияж бровей:");
            } else if (n == 1) {
                id_eye = "26";
                block_name.setText("Коррекция бровей:");
            } else if (n == 2) {
                id_eye = "27";
                block_name.setText("Перманентный макияж век:");
            } else if (n == 3) {
                id_eye = "28";
                block_name.setText("Коррекция век:");
            }else if (n == 4) {
                id_eye = "29";
                block_name.setText("Ресничный контур:");
            }else if (n == 5) {
                id_eye = "30";
                block_name.setText("Коррекция ресничного контура:");
            }

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("id_eye", id_eye));
            // отправляем измененные данные через http запрос
            jsonParser.makeHttpRequest(update_salon, "POST", params);


            return null;
        }

    }


    //Фоновая задача для получения нужного списка салонов из
    //базы данных MySQL
    class LoadCost extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
            //Пока загружается список саолонов
            //для пользователя выводим надпись
            super.onPreExecute();
            pDialog = new ProgressDialog(MakeupPermCostFragment.this);
            pDialog.setMessage("Загрузка данных. Подождите...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String[] params) {
            //Здесь будем хранить параметры
            List<NameValuePair> param = new ArrayList<NameValuePair>();

            //Получаем JSON строк с URL
            JSONObject json = jsonParser.makeHttpRequest(update_salon, "GET", param);

            try {
                //Получаем SUCCESS тег для проверки статуса ответа от сервера
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    //Салоны найдены
                    //Получаем массив из салонов
                    mClassic = json.getJSONArray(TAG_SALONS);

                    //Перебор всех салонов
                    for (int i = 0; i < mClassic.length(); i++) {
                        JSONObject c = mClassic.getJSONObject(i);

                        //Сохраняем каждый json элемент в переменную
                        String id = c.getString(TAG_id);
                        String name = c.getString(TAG_name);
                        String address = c.getString(TAG_address);
                        String cost = c.getString(TAG_cost);
                        String rate = c.getString(TAG_rate);
                        String comm = c.getString(TAG_comm);
                        String phone = c.getString(TAG_phone);

                        //Создаем новый HashMap - хранение данных
                        //типа "Ключ", "Значение"
                        HashMap<String, String> map = new HashMap<String, String>();

                        //Добавляем каждый элемент в HashMap ключ => значение
                        map.put(TAG_id, id);
                        map.put(TAG_name, name);
                        map.put(TAG_address, address);
                        map.put(TAG_cost, cost);
                        map.put(TAG_rate, rate);
                        map.put(TAG_comm, comm);
                        map.put(TAG_phone, phone);

                        //Добавляем HashList в ArrayList
                        mClassicList.add(map);

                    }
                } else {
                    //Если салоны по какой-либо услуге
                    //не найдены, то пользователю выводим
                    //соответствующее сообщение
                    Intent on = new Intent(getApplicationContext(), NullCostActivity.class);
                    startActivity(on);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        //После завершения фоновой задачи закрываем
        //Прогресс диалог
        @Override
        protected void onPostExecute(String s) {
            //Закрываем ДиалогПрогресс
            pDialog.dismiss();

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //Объявляем и инициализируем фрагмент и менеджер
                    FragmentManager manager = getSupportFragmentManager();
                    CostSalonsFragment costSalonsFragment = (CostSalonsFragment) manager.findFragmentById(R.id.CostSalonsFragment);
                    //Обновляем данные с JSON в ListView
                    ListAdapter adapter = new SimpleAdapter(MakeupPermCostFragment.this, mClassicList,
                            R.layout.list_item,
                            new String[]{TAG_id,
                                    TAG_name, TAG_address, TAG_cost, TAG_rate, TAG_comm, TAG_phone},
                            new int[]{R.id.id_salon, R.id.salon_name,
                                    R.id.salon_address, R.id.salon_cost, R.id.salon_rate, R.id.salon_comm, R.id.salon_phone});
                    //Обновляем ListView
                    costSalonsFragment.setListAdapter(adapter);
                }
            });

        }
    }


    public void takeCall(View v){
        String num;

        //TextView txt = (TextView)findViewById(R.id.salon_phone);
        TextView txt = ((TextView)v);

        num = txt.getText().toString();
        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:" + num));
        startActivity(call);
    }
}
