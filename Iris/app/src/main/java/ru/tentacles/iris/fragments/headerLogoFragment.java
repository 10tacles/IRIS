package ru.tentacles.iris.fragments;

<<<<<<< HEAD
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.tentacles.iris.R;
=======
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import ru.tentacles.iris.R;
>>>>>>> 27/04/15      Создал фрагмент с логотипом, зарегал отдельный класс и связал с главной активностью/ Создал макет логотипа /временно изменил иконку приложения


//класс, который будет привязан к фрагменту header_logo
//header_logo - это шапка приложения, тут располагаются:
//лого, кнопки "акции", "поиск", "личный кабинет"
public class headerLogoFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.header_logo, container, true);
    }
<<<<<<< HEAD
=======

>>>>>>> 27/04/15      Создал фрагмент с логотипом, зарегал отдельный класс и связал с главной активностью/ Создал макет логотипа /временно изменил иконку приложения
}
