package test.edualves.easynvesttest.investment.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.edualves.easynvesttest.R;

/**
 * Created by edualves on 01/06/17.
 */

public class InvestmentActivity extends AppCompatActivity {

    private static final String LOG_TAG = InvestmentActivity.class.getSimpleName();

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    InvestmentFragment investmentFragment = new InvestmentFragment();
    ContactFragment contactFragment = new ContactFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investment);
        ButterKnife.bind(this);

        goInvestmentScreen();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_investment:
                        showInvestmentScreen();
                        break;
                    case R.id.action_contact:
                        showContactFragment();
                        break;
                }
                return true;
            }

        });
    }

    private void showContactFragment() {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_investment, contactFragment)
                .commit();
    }

    private void showInvestmentScreen() {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_investment, investmentFragment)
                .commit();
    }

    public void goInvestmentScreen() {

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_investment, investmentFragment)
                .commit();
    }
}
