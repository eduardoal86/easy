package test.edualves.easynvesttest.investment.presenter;

import java.util.List;

import test.edualves.easynvesttest.model.Cell;
import test.edualves.easynvesttest.utils.CustomTextInputLayout;

/**
 * Created by edualves on 04/06/17.
 */

public interface ContactPresenter {

    List<Cell> getCells(String json);

    void validateFieldIsEmpty(CustomTextInputLayout field, String str);

    boolean validateEmailField(String email);
}
