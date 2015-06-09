package ru.tentacles.iris.fragments.nail_fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ru.tentacles.iris.MainSalonActivity;
import ru.tentacles.iris.NailSalonActivity;
import ru.tentacles.iris.R;
import ru.tentacles.iris.fragments.CostSalonsFragment;
import ru.tentacles.iris.fragments.NullCostActivity;
import ru.tentacles.iris.parser.JSONParser;


public class ShellacCostFragment extends FragmentActivity {


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
    private static final String TAG_cost = "salon_cost";
    private static final String TAG_rate = "salon_rate";
    private static final String TAG_comm = "salon_comm";
    private static final String TAG_phone = "salon_phone";

    //массив для хранения списка салонов
    JSONArray mClassic = null;

    //URL скрипта
    String update_salon = "http://10tacles.ru/salons/getcost/get_nail_cost.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salon_nail_cost);

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
            Intent nn = getIntent();
            int f = nn.getIntExtra("nail", 1);
            String id_nail = null;
            //В зависимости от позиции (нажатой кнопки) мы отправляем
            //в SQL запрос id требуемой нами услуги
            if (f == 0) {
                id_nail = "14";
                block_name.setText("Покрытие ногтей Shellac (руки):");
            } else if (f == 1) {
                id_nail = "15";
                block_name.setText("Покрытие ногтей Shellac French (руки):");
            } else if (f == 2) {
                id_nail = "16";
                block_name.setText("Маникюр+покрытие Shellac:");
            } else if (f == 3) {
                id_nail = "17";
                block_name.setText("Маникюр+покрытие Shellac French:");
            } else if (f == 4) {
                id_nail = "18";
                block_name.setText("Покрытие ногтей Shellac (ноги):");
            }else if (f == 5) {
                id_nail = "19";
                block_name.setText("Покрытие ногтей Shellac French (ноги):");
            }else if (f == 6) {
                id_nail = "20";
                block_name.setText("Педикюр+покрытие Shellac:");
            }else if (f == 7) {
                id_nail = "21";
                block_name.setText("Педикюр+покрытие Shellac French:");
            }else if (f == 8) {
                id_nail = "22";
                block_name.setText("Снятие гель-лака:");
            }

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("id_nail", id_nail));
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
            pDialog = new ProgressDialog(ShellacCostFragment.this);
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
                    ListAdapter adapter = new SimpleAdapter(ShellacCostFragment.this, mClassicList,
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

    //Обработчик для кнопки в виде домика в шапке приложения. Возвращает пользователя
    //в главную активность
    public void goHome(View v) {
        Intent intent = new Intent(this, MainSalonActivity.class);
        startActivity(intent);
    }

    //Обработчик для кнопки в виде стрелки в шапке приложения. Возвращает пользователя
    //в предыдущую активность
    public void goBack(View v) {
        Intent intent = new Intent(getApplicationContext(), NailSalonActivity.class);
        finish();
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
