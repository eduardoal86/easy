package test.edualves.easynvesttest.form.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import test.edualves.easynvesttest.R;

public class MainFormActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainFormActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_form);

        goToFragment();
    }

    private void goToFragment() {

        MainFormFragment fragment = new MainFormFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit();
    }

    public void showSuccessScreen() {
        InitialSuccessFragment initialSuccessFragment = new InitialSuccessFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, initialSuccessFragment)
                .commit();
    }

    public void showInvestmentScreen() {
        InvestmentFragment investmentFragment = new InvestmentFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, investmentFragment)
                .commit();
    }
}
