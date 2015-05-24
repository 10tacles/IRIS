package ru.tentacles.iris.fragments.nail_fragments;



import android.support.v4.app.ListFragment;




public class manicureCost extends ListFragment{


    //Блок объявления значений и переменных
    /*public static final String TAG = "manicureCostTAG";

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
    private static final TAG_SUCCESS = "success";
    private static final TAG_SALONS = "salons";
    private static final TAG_id = "id_salon";
    private static final TAG_name = "salon_name";
    private static final TAG_address = "salon_address";
    private static final TAG_cost = "salon_cost";

    //массив для хранения списка салонов
    JSONArray mClassic = null;

    //URL скрипта
    String url_manicure_classic = "http://10tacles.ru/get_manicure_classic.php";


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Блок инициализации переменных
        mClassicList = new ArrayList<HashMap<String, String>>();

        //Загружаем салоны в фоновом потоке
        new LoadManicureCost().execute();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), mClassicList, layout.list_item);
        setListAdapter(adapter);
    }

    class LoadManicureCost extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Загрузка данных. Подождите...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String[] params) {

            List<NameValuePair>  = new ArrayList<NameValuePair>();
            /*params.add(new BasicNameValuePair(TAG_id, id_salon));
            params.add(new BasicNameValuePair(TAG_name, salon_name));
            params.add(new BasicNameValuePair(TAG_address, salon_address));
            params.add(new BasicNameValuePair(TAG_cost, salon_cost));

            JSONObject json = jsonParser.makeHttpRequest(url_manicure_classic, "GET", params);

            try {
                int success = json.getInt(TAG_SUCCESS);

                if (success = 1) {
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
            //Обновляем UI форму в фоновом потоке
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //Обновляем данные с JSON в ListView
                    ListAdapter adapter = new SimpleAdapter(getActivity(), mClassicList,
                            layout.list_item, new String[]{TAG_id,
                            TAG_name, TAG_address, TAG_cost},
                            new int[]{id.id_salon, id.salon_name,
                                    id.salon_address, id.salon_cost});
                    //Обновляем ListView
                    setListAdapter(adapter);
                }
            });
        }
    } */

}
