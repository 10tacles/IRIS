package ru.tentacles.iris;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import ru.tentacles.iris.R;

//Главная активность для салонов красоты
public class MainSalonActivity extends FragmentActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_salon);
    }
}
