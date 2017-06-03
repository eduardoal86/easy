package test.edualves.easynvesttest.form.presenter;

import java.util.List;

import test.edualves.easynvesttest.utils.CustomTextInputLayout;
import test.edualves.easynvesttest.model.Cell;

/**
 * Created by edualves on 26/05/17.
 */

public interface FormPresenter {

    //TODO Extract to another interface just to read this jSON
    List<Cell> convertStringJsonToCellsObject(String json);

    void validateFieldIsEmpty(CustomTextInputLayout field, String str);

    boolean validateEmailField(String email);

}
