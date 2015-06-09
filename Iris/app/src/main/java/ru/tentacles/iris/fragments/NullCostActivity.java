package ru.tentacles.iris.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import ru.tentacles.iris.MainSalonActivity;
import ru.tentacles.iris.R;



//Активность, на которую переводим пользователя, если
//по какой-либо услуге салоны не найдены
public class NullCostActivity extends FragmentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salon_null_cost_fragment);

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
        finish();

       //Intent intent = new Intent(getApplicationContext(), ());
        //startActivity(intent);
    }
}
