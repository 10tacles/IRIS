package ru.tentacles.iris;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import android.view.View;



//Главная активность для салонов красоты
public class MainSalonActivity extends FragmentActivity{


    //привязываем активность и слой main_salon
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_salon);
    }

    //Обработчик для кнопки "Ногти" - переходим на активность с выбором услуг "Маникюр и Педикюр"
    public void goNailsActivity (View v) {
        Intent intent = new Intent(getApplicationContext(), NailSalonActivity.class);
        startActivity(intent);
    }

    //Обработчик для кнопки "Ukfpf" - переходим на активность с выбором услуг
    //"Татуаж", "Наращивание ресниц" и т.д.
    public void goEyesActivity (View v) {
        Intent intent = new Intent(getApplicationContext(), EyeSalonActivity.class);
        startActivity(intent);
    }
}


