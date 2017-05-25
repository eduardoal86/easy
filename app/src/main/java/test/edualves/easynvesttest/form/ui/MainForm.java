package test.edualves.easynvesttest.form.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import test.edualves.easynvesttest.R;

public class MainForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_form);

        goToFragment();
    }

    private void goToFragment() {

        MainFormFragment fragment = new MainFormFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
    }
}
