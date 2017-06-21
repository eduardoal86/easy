package test.edualves.easynvesttest.investment.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.edualves.easynvesttest.R;
import test.edualves.easynvesttest.form.presenter.FormPresenter;
import test.edualves.easynvesttest.investment.presenter.ContactPresenterImpl;
import test.edualves.easynvesttest.model.Cell;
import test.edualves.easynvesttest.utils.CustomTextInputLayout;
import test.edualves.easynvesttest.utils.Utils;

/**
 * Created by edualves on 02/06/17.
 */

public class ContactFragment extends Fragment implements ContactView {

    @BindView(R.id.contact_title)
    TextView contactTitle;

    @BindView(R.id.name_text_input)
    CustomTextInputLayout nameTextInput;

    @BindView(R.id.email_text_input)
    CustomTextInputLayout emailTextInput;

    @BindView(R.id.phone_text_input)
    CustomTextInputLayout phoneTextInput;

    @BindView(R.id.checkbox_email)
    CheckBox checkboxEmail;

    @BindView(R.id.image_placeholder)
    ImageView placeHolder;

    @BindView(R.id.send_message)
    Button btnSendMessage;

    @BindView(R.id.form_contact_container)
    RelativeLayout formContactLayout;

    @BindView(R.id.contact_success_container)
    RelativeLayout contactSuccessLayout;

    FormPresenter presenter;

    private boolean hasError;

    private List<Cell> cells = new ArrayList<>();

    private Map<CustomTextInputLayout, Cell> fieldsMap = new HashMap<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        ButterKnife.bind(this, view);

        presenter = new ContactPresenterImpl(this);
        cells = presenter.getCells(Utils.readJsonCells(getActivity()));
        setUpConfigs();

        formatTitleMessage();
        setUpFormContact();

        return view;
    }

    private void setUpFormContact() {

        if (!cells.get(1).getHidden()) {
            nameTextInput.setHint(cells.get(1).getMessage());
            setMargins(nameTextInput, 0, Utils.convertDpToPx(cells.get(1).getTopSpacing()), 0, 0);
        } else {
            nameTextInput.setVisibility(View.GONE);
        }

        if (!cells.get(2).getHidden()) {
            checkboxEmail.setText(cells.get(2).getMessage());
            setMargins(checkboxEmail, 0, Utils.convertDpToPx(cells.get(2).getTopSpacing()), 0, 0);
        } else {
            checkboxEmail.setVisibility(View.GONE);
        }

        if (!cells.get(3).getHidden()) {
            emailTextInput.setHint(cells.get(3).getMessage());
            setMargins(emailTextInput, 0, Utils.convertDpToPx(cells.get(3).getTopSpacing()), 0, 0);
        } else {
            emailTextInput.setVisibility(View.GONE);
        }

        //If will be necessary, we can set here a image using Glide lib through cells.get(4).getMessage() then return a URL path
        setMargins(placeHolder, 0, Utils.convertDpToPx(cells.get(4).getTopSpacing()), 0, 0);

        if (!cells.get(5).getHidden()) {
            phoneTextInput.setHint(cells.get(5).getMessage());
            setMargins(phoneTextInput, 0, Utils.convertDpToPx(cells.get(5).getTopSpacing()), 0, 0);
        } else {
            phoneTextInput.setVisibility(View.GONE);
        }

        btnSendMessage.setText(cells.get(6).getMessage());
        setMargins(checkboxEmail, 0, Utils.convertDpToPx(cells.get(6).getTopSpacing()), 0, 0);
    }

    private void formatTitleMessage() {

        if (!cells.get(0).getHidden()) {
            String titleMsg = cells.get(0).getMessage();
            contactTitle.setText(Utils.countCharsForSpace(titleMsg, 27));
            setMargins(contactTitle, 0, Utils.convertDpToPx(cells.get(0).getTopSpacing()), 0, 0);
        } else {
            contactTitle.setVisibility(View.GONE);
        }

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

        hasError = false;

        isMandatoryField();

        if (!hasError) {
            if (isEmailValid()) {
                formContactLayout.setVisibility(View.GONE);
                contactTitle.setVisibility(View.GONE);
                contactSuccessLayout.setVisibility(View.VISIBLE);
            }
        }

    }

    @OnClick(R.id.send_new_message)
    void sendNewMessage() {
        nameTextInput.getEditText().setText("");
        emailTextInput.getEditText().setText("");
        phoneTextInput.getEditText().setText("");
        checkboxEmail.setChecked(false);
        contactSuccessLayout.setVisibility(View.GONE);
        contactTitle.setVisibility(View.VISIBLE);
        formContactLayout.setVisibility(View.VISIBLE);
    }

    private void isMandatoryField() {

        for (Map.Entry<CustomTextInputLayout, Cell> fields : fieldsMap.entrySet()) {

            if (fields.getValue().getRequired() && !fields.getValue().getHidden()) {
                presenter.validateFieldIsEmpty(fields.getKey(), fields.getKey()
                        .getEditText()
                        .getText()
                        .toString());
            }
        }

    }

    private boolean isEmailValid() {
        if (!cells.get(3).getHidden()) {
            return presenter.validateEmailField(emailTextInput.getEditText().getText().toString());
        } else {
            return true;
        }

    }

    @Override
    public void setErrorMandatoryField(CustomTextInputLayout field) {
        field.setError(getResources().getString(R.string.mandatory_field));
        hasError = true;
    }

    @Override
    public void setInvalidEmailError() {
        emailTextInput.setError(getResources().getString(R.string.invalid_email_error));
    }

    private void setMargins(View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }
}
