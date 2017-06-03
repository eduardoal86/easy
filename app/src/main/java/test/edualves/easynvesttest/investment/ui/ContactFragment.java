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
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.edualves.easynvesttest.R;
import test.edualves.easynvesttest.investment.presenter.ContactPresenter;
import test.edualves.easynvesttest.investment.presenter.ContactPresenterImpl;
import test.edualves.easynvesttest.model.Cell;
import test.edualves.easynvesttest.utils.Utils;

/**
 * Created by edualves on 02/06/17.
 */

//TODO implements an interface to read json as service layer. THE SAME will be implemented on MainFormFragment
public class ContactFragment extends Fragment {

    @BindView(R.id.name_text_input)
    TextInputLayout nameTextInput;

    @BindView(R.id.email_text_input)
    TextInputLayout emailTextInput;

    @BindView(R.id.phone_text_input)
    TextInputLayout phoneTextInput;

    @BindView(R.id.checkbox_email)
    CheckBox checkboxEmail;

    @BindView(R.id.form_contact_container)
    RelativeLayout formContactLayout;

    @BindView(R.id.contact_success_container)
    RelativeLayout contactSuccessLayout;

    private List<Cell> cells = new ArrayList<>();
    ContactPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        ButterKnife.bind(this, view);

        presenter = new ContactPresenterImpl();
        cells = presenter.getCells(Utils.readJsonCells(getActivity()));

        setUpFormContact();

        return view;
    }

    private void setUpFormContact() {

        nameTextInput.setHint(cells.get(1).getMessage());
        checkboxEmail.setText(cells.get(2).getMessage());
        emailTextInput.setHint(cells.get(3).getMessage());
        phoneTextInput.setHint(cells.get(5).getMessage());

    }

    @OnClick(R.id.send_message)
    void clickOnSendMessage() {
        formContactLayout.setVisibility(View.GONE);
        contactSuccessLayout.setVisibility(View.VISIBLE);

    }

    @OnClick(R.id.send_new_message)
    void sendNewMessage() {
        contactSuccessLayout.setVisibility(View.GONE);
        formContactLayout.setVisibility(View.VISIBLE);
    }

    //TODO Missing validate fields contact form
}
