package ru.tentacles.iris;


import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ru.tentacles.iris.parser.JSONParser;


public class NailCostActivity extends ListActivity{

    //Блок объявления значений и переменных

    //визуальное отображение задачи async task
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
    private static final String TAG_cost = "salon_cost";

    //массив для хранения списка салонов
    JSONArray mClassic = null;

    //URL скрипта
    String url_manicure_classic = "http://10tacles.ru/get_manicure_classic.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salon_nail_cost);

        //Блок инициализации переменных
        mClassicList = new ArrayList<HashMap<String, String>>();
        //Загружаем салоны в фоновом потоке
        new LoadManicureCost().execute();
    }

    class LoadManicureCost extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(NailCostActivity.this);
            pDialog.setMessage("Загрузка данных. Подождите...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String[] params) {

            List<NameValuePair> param = new ArrayList<NameValuePair>();

            JSONObject json = jsonParser.makeHttpRequest(url_manicure_classic, "GET", param);

            try {
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

                        //Создаем новый HashMap - хранение данных
                        //типа "Ключ", "Значение"
                        HashMap<String, String> map = new HashMap<String, String>();

                        //Добавляем каждый элемент в HashMap ключ => значение
                        map.put(TAG_id, id);
                        map.put(TAG_name, name);
                        map.put(TAG_address, address);
                        map.put(TAG_cost, cost);

                        //Добавляем HashList в ArrayList
                        mClassicList.add(map);
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            //Закрываем ДиалогПрогресс
            pDialog.dismiss();

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //Обновляем данные с JSON в ListView
                    ListAdapter adapter = new SimpleAdapter(NailCostActivity.this, mClassicList,
                            R.layout.list_item,
                            new String[]{TAG_id,
                            TAG_name, TAG_address, TAG_cost},
                            new int[]{R.id.id_salon, R.id.salon_name,
                                    R.id.salon_address, R.id.salon_cost});
                    //Обновляем ListView
                    setListAdapter(adapter);
                }
            });

        }
    }

}
