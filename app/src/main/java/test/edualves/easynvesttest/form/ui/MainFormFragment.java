package test.edualves.easynvesttest.form.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.edualves.easynvesttest.R;
import test.edualves.easynvesttest.Utils;
import test.edualves.easynvesttest.form.presenter.FormPresenter;
import test.edualves.easynvesttest.form.presenter.FormPresenterImpl;
import test.edualves.easynvesttest.model.Cell;

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

    @BindView(R.id.title_message)
    TextView titleMessage;

    private FormPresenter presenter;
    private List<Cell> cells = new ArrayList<>();

    private Map<CustomTextInputLayout, Cell> fieldsMap = new HashMap<>();
    private String titleMsg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_main_form, container, false);
        ButterKnife.bind(this, view);

        presenter = new FormPresenterImpl(this);

        cells = presenter.convertStringJsonToCellsObject(Utils.readJsonCells(getActivity()));

        setUpConfigs();

        formatTitleMessage();
        setUpFields();


        return view;
    }

    private void setUpConfigs() {

        //TODO Use different Structure for store this
        for (int i = 0; i < cells.size(); i++) {

            if (cells.get(i).getType() == 2) {
                titleMsg = cells.get(i).getMessage();
            }

            //TODO Change 1 for Enum value
            if (cells.get(i).getType() == 1) {
                if (cells.get(i).getMessage().startsWith("Nome")) {
                    fieldsMap.put(nameTextInput, cells.get(i));
                } else if (cells.get(i).getMessage().startsWith("Email")) {
                    fieldsMap.put(emailTextInput, cells.get(i));
                }

            }
        }

    }

    private void formatTitleMessage() {
        titleMessage.setText(Utils.countCharsForSpace(titleMsg, 27));
    }

    private void setUpFields() {

        nameTextInput.setHint(cells.get(1).getMessage());
        emailTextInput.setHint(cells.get(3).getMessage());

    }

    @OnClick(R.id.send_btn)
    void sendInfo() {
        isMandatoryField();
        if (isEmailValid()) {
            goToSuccessScreen();
        }
    }

    private boolean isEmailValid() {
        return presenter.validateEmailField(emailTextInput.getEditText().getText().toString());
    }

    private void isMandatoryField() {

        for (Map.Entry<CustomTextInputLayout, Cell> fields : fieldsMap.entrySet()) {

            if (fields.getValue().getRequired()) {
                presenter.validateFieldIsEmpty(fields.getKey(), fields.getKey().getEditText().getText().toString());
            }
        }

    }

    private void goToSuccessScreen() {
        ((MainFormActivity) getActivity()).showSuccessScreen();
    }

    @OnClick(R.id.name_clear)
    void clearContentNameInput() {
        nameEditText.setText("");
    }

    @Override
    public void setErrorMandatoryField(CustomTextInputLayout field) {
        field.setError(getResources().getString(R.string.mandatory_field));
    }

    @Override
    public void setInvalidEmailError() {
        emailTextInput.setError(getResources().getString(R.string.invalid_email_error));
    }


}
