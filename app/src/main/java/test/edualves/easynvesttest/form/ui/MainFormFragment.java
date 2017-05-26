package test.edualves.easynvesttest.form.ui;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.edualves.easynvesttest.R;

/**
 * Created by edualves on 25/05/17.
 */

public class MainFormFragment extends Fragment {

    @BindView(R.id.input_name)
    TextInputEditText nameEditText;

    @BindView(R.id.input_email)
    TextInputEditText emailEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_main_form, container, false);
        ButterKnife.bind(this, view);

        validateFields();

        return view;
    }

    private void validateFields() {

        //nameEditText.
    }


}
