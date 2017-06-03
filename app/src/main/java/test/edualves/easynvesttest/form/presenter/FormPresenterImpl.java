package test.edualves.easynvesttest.form.presenter;

import com.google.gson.Gson;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import test.edualves.easynvesttest.service.CellService;
import test.edualves.easynvesttest.service.CellServiceImpl;
import test.edualves.easynvesttest.utils.Utils;
import test.edualves.easynvesttest.utils.CustomTextInputLayout;
import test.edualves.easynvesttest.form.ui.MainFormFragmentView;
import test.edualves.easynvesttest.model.Cell;

/**
 * Created by edualves on 26/05/17.
 */

public class FormPresenterImpl implements FormPresenter {

    private final MainFormFragmentView view;

    private CellService service = new CellServiceImpl();

    public FormPresenterImpl(MainFormFragmentView view) {
        this.view = view;
    }

    @Override
    public List<Cell> convertStringJsonToCellsObject(String json) {

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

        if (!Utils.FieldValidationUtil.isValidEmail(email)){
            view.setInvalidEmailError();
            return false;
        }
        return true;
    }

}
