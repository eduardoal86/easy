package test.edualves.easynvesttest.form.ui;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.edualves.easynvesttest.R;
import test.edualves.easynvesttest.form.presenter.FormPresenter;
import test.edualves.easynvesttest.form.presenter.FormPresenterImpl;

/**
 * Created by edualves on 25/05/17.
 */

public class MainFormFragment extends Fragment {

    @BindView(R.id.input_name)
    TextInputEditText nameEditText;

    @BindView(R.id.input_email)
    TextInputEditText emailEditText;

    private FormPresenter presenter = new FormPresenterImpl();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_main_form, container, false);
        ButterKnife.bind(this, view);

        presenter.convertStringJsonToCellsObject(readJsonCells());

        validateFields();

        return view;
    }

    private void validateFields() {

        //nameEditText.
    }


    //TODO Check if it is possible remove this class from fragment in the future
    private String readJsonCells() {

        String json;

        try {
            InputStream inputStream = getResources().openRawResource(R.raw.cells);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return json;
    }


}
