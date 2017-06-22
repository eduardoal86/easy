package test.edualves.easynvesttest.investment.presenter;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import test.edualves.easynvesttest.investment.ui.ContactView;
import test.edualves.easynvesttest.model.Cell;
import test.edualves.easynvesttest.service.CellService;
import test.edualves.easynvesttest.service.CellServiceImpl;
import test.edualves.easynvesttest.utils.CustomTextInputLayout;
import test.edualves.easynvesttest.utils.Utils;

/**
 * Created by edualves on 02/06/17.
 */

public class ContactPresenterImpl implements ContactPresenter {

    private ContactView view;

    CellService service = new CellServiceImpl();

    public  ContactPresenterImpl(ContactView view) {
        this.view = view;
    }

    @Override
    public List<Cell> getCells(String json) {
        return service.getCells(json);
    }

    @Override
    public void validateFieldIsEmpty(CustomTextInputLayout field, String str) {

        if (StringUtils.isEmpty(str)) {
            view.setErrorMandatoryField(field);
        }
    }

    @Override
    public boolean validateEmailField(String email) {

        if (!Utils.FieldValidationUtil.isValidEmail(email)) {
            view.setInvalidEmailError();
            return false;
        }
        return true;
    }
}
