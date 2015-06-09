package ru.tentacles.iris;




import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import ru.tentacles.iris.fragments.NullSalonActivity;
import ru.tentacles.iris.fragments.nail_fragments.extentionRightFragment;
import ru.tentacles.iris.fragments.nail_fragments.manicureRightFragment;
import ru.tentacles.iris.fragments.nail_fragments.nailServRightFragment;
import ru.tentacles.iris.fragments.nail_fragments.pedicureRightFragment;



public class NailSalonActivity extends FragmentActivity implements View.OnClickListener{

    //Объявляем фрагменты
    private manicureRightFragment ManicureRightFragment;
    private NullSalonActivity nullSalonActivity;
    private pedicureRightFragment PedicureRightFragment;
    private nailServRightFragment NailServRightFragment;
    private extentionRightFragment ExtentionRightFragment;


    //Объявляем менеджер и транзактор фрагментов -
    //без них динамически добавлять фрагменты нельзя
    FragmentManager manager;
    FragmentTransaction transaction;

    //Объявляем переменные

    Button manicure;
    Button pedicure;
    Button nail;
    Button nail_extention;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salon_nails);


        //Блок инициализации переменных и значений

        manager = getSupportFragmentManager();

        ManicureRightFragment = new manicureRightFragment();
        nullSalonActivity = new NullSalonActivity();
        PedicureRightFragment = new pedicureRightFragment();
        NailServRightFragment = new nailServRightFragment();
        ExtentionRightFragment = new extentionRightFragment();

        //Инициализируем переменные,"связываем" их с id кнопок
        //в разметке nails_fragm_left.xml
        manicure = (Button) findViewById(R.id.manicure);
        pedicure = (Button) findViewById(R.id.pedicure);
        nail = (Button) findViewById(R.id.nail);
        nail_extention = (Button) findViewById(R.id.nail_extention);
        //Привязываем обработчик кнопок
        manicure.setOnClickListener(this);
        pedicure.setOnClickListener(this);
        nail.setOnClickListener(this);
        nail_extention.setOnClickListener(this);

        //Фрагмент с надписью "Выберите услугу" добавляется
        //в правое поле по умолчанию
        transaction = manager.beginTransaction();
        transaction.add(R.id.container, nullSalonActivity, NullSalonActivity.TAG);
        transaction.commit();

    }

    //Описываем действия, которые будут происходить
    //при нажатии на кнопки
    @Override
    public void onClick(View v) {

        transaction = manager.beginTransaction();

        //При клике на какую-либо кнопку (Маникюр, Наращивание ресниц и т.д.)
        //в правое поле динамически добавляется нужный фрагмент с более
        //подробными услугами (Маникюр: классический, европейский и т.д.)
        switch (v.getId()) {

            case R.id.manicure:

                if (manager.findFragmentByTag(manicureRightFragment.TAG) == null) {

                    transaction.replace(R.id.container, ManicureRightFragment, manicureRightFragment.TAG);
                    transaction.setTransition(transaction.TRANSIT_FRAGMENT_OPEN);

                }
                break;

            case R.id.pedicure:
               //pedicure.setBackgroundColor(getResources().getColor(R.color.right_fragment));
                if (manager.findFragmentByTag(pedicureRightFragment.TAG) == null) {
                    transaction.replace(R.id.container, PedicureRightFragment, pedicureRightFragment.TAG);
                    transaction.setTransition(transaction.TRANSIT_FRAGMENT_CLOSE);
                }
                break;

            case R.id.nail:
                if (manager.findFragmentByTag(nailServRightFragment.TAG) == null) {
                    transaction.replace(R.id.container, NailServRightFragment, nailServRightFragment.TAG);
                    transaction.setTransition(transaction.TRANSIT_FRAGMENT_OPEN);
                }
                break;

            /*case R.id.spa_care:
                Toast.makeText(getApplicationContext(), "SPA", Toast.LENGTH_SHORT).show();
                break;*/

            case R.id.nail_extention:
                if (manager.findFragmentByTag(extentionRightFragment.TAG) == null) {
                    transaction.replace(R.id.container, ExtentionRightFragment, extentionRightFragment.TAG);
                    transaction.setTransition(transaction.TRANSIT_FRAGMENT_CLOSE);
                }
                break;
            default:
                break;
        }

        transaction.commit();

    }

    //Обработчик для кнопки в виде домика в шапке приложения. Возвращает пользователя
    //в главную активность
    public void goHome(View v) {
        Intent intent = new Intent(getApplicationContext(), MainSalonActivity.class);
        startActivity(intent);
    }

    //Обработчик для кнопки в виде стрелки в шапке приложения. Возвращает пользователя
    //в предыдущую активность
    public void goBack(View v) {
        Intent intent = new Intent(getApplicationContext(), MainSalonActivity.class);
        finish();
    }

}
