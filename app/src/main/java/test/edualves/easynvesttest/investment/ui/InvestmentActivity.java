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
                        //bottomNavigationView.setItemIconTintList();
                        break;
                    case R.id.action_contact:
                        break;
                }
                return true;
            }

        });
    }

    public void goInvestmentScreen() {
        InvestmentFragment investmentFragment = new InvestmentFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_investment, investmentFragment)
                .commit();
    }
}
