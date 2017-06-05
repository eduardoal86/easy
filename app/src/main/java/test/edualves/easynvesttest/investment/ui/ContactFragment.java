package test.edualves.easynvesttest.investment.ui;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.edualves.easynvesttest.R;
import test.edualves.easynvesttest.form.presenter.FormPresenter;
import test.edualves.easynvesttest.form.presenter.FormPresenterImpl;
import test.edualves.easynvesttest.investment.presenter.ContactPresenterImpl;
import test.edualves.easynvesttest.model.Cell;
import test.edualves.easynvesttest.utils.CustomTextInputLayout;
import test.edualves.easynvesttest.utils.Utils;

/**
 * Created by edualves on 02/06/17.
 */

public class ContactFragment extends Fragment implements ContactView {

    @BindView(R.id.name_text_input)
    CustomTextInputLayout nameTextInput;

    @BindView(R.id.email_text_input)
    CustomTextInputLayout emailTextInput;

    @BindView(R.id.phone_text_input)
    CustomTextInputLayout phoneTextInput;

    @BindView(R.id.checkbox_email)
    CheckBox checkboxEmail;

    @BindView(R.id.form_contact_container)
    RelativeLayout formContactLayout;

    @BindView(R.id.contact_success_container)
    RelativeLayout contactSuccessLayout;

    FormPresenter presenter;

    private List<Cell> cells = new ArrayList<>();

    private Map<CustomTextInputLayout, Cell> fieldsMap = new HashMap<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        ButterKnife.bind(this, view);

        presenter = new ContactPresenterImpl(this);
        cells = presenter.getCells(Utils.readJsonCells(getActivity()));
        setUpConfigs();

        setUpFormContact();

        return view;
    }

    private void setUpFormContact() {

        nameTextInput.setHint(cells.get(1).getMessage());
        checkboxEmail.setText(cells.get(2).getMessage());
        emailTextInput.setHint(cells.get(3).getMessage());
        phoneTextInput.setHint(cells.get(5).getMessage());

    }

    private void setUpConfigs() {

        for (int i = 0; i < cells.size(); i++) {

            if (Cell.TypeField.TEXT.typeField == cells.get(i).getType()) {
                if (cells.get(i).getMessage().startsWith("Nome")) {
                    fieldsMap.put(nameTextInput, cells.get(i));
                } else if (cells.get(i).getMessage().startsWith("Email")) {
                    fieldsMap.put(emailTextInput, cells.get(i));
                } else if (cells.get(i).getMessage().startsWith("Telefone")) {
                    fieldsMap.put(phoneTextInput, cells.get(i));
                }

            }
        }

    }

    @OnClick(R.id.send_message)
    void clickOnSendMessage() {

        isMandatoryField();
        if (isEmailValid()) {
            formContactLayout.setVisibility(View.GONE);
            contactSuccessLayout.setVisibility(View.VISIBLE);
        }

    }

    @OnClick(R.id.send_new_message)
    void sendNewMessage() {
        nameTextInput.getEditText().setText("");
        emailTextInput.getEditText().setText("");
        phoneTextInput.getEditText().setText("");
        checkboxEmail.setChecked(false);
        contactSuccessLayout.setVisibility(View.GONE);
        formContactLayout.setVisibility(View.VISIBLE);
    }

    private void isMandatoryField() {

        for (Map.Entry<CustomTextInputLayout, Cell> fields : fieldsMap.entrySet()) {

            if (fields.getValue().getRequired()) {
                presenter.validateFieldIsEmpty(fields.getKey(), fields.getKey()
                        .getEditText()
                        .getText()
                        .toString());
            }
        }

    }

    private boolean isEmailValid() {
        return presenter.validateEmailField(emailTextInput.getEditText().getText().toString());
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
