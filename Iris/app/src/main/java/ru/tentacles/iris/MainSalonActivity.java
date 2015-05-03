package ru.tentacles.iris;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import ru.tentacles.iris.R;

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
}


