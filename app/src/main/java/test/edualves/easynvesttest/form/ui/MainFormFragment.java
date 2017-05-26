package test.edualves.easynvesttest.form.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.edualves.easynvesttest.R;
import test.edualves.easynvesttest.form.presenter.FormPresenter;
import test.edualves.easynvesttest.form.presenter.FormPresenterImpl;

/**
 * Created by edualves on 25/05/17.
 */

public class MainFormFragment extends Fragment implements MainFormFragmentView {

    @BindView(R.id.name_text_input)
    CustomTextInputLayout nameTextInput;

    @BindView(R.id.email_text_input)
    CustomTextInputLayout emailTextInput;

    @BindView(R.id.input_name)
    EditText nameEditText;

    @BindView(R.id.input_email)
    EditText emailEditText;

    private FormPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_main_form, container, false);
        ButterKnife.bind(this, view);

        presenter = new FormPresenterImpl(this);

        presenter.convertStringJsonToCellsObject(readJsonCells());

        return view;
    }

    private void validateNameField() {

        presenter.validateName(nameTextInput.getEditText().getText().toString());
    }

    @OnClick(R.id.send_btn)
    void sendInfo() {
        validateNameField();
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


    @Override
    public void setErrorNameField() {
        nameTextInput.setError(getResources().getString(R.string.mandatory_field));
    }
}
