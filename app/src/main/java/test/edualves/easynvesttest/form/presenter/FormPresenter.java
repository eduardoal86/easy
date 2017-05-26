package test.edualves.easynvesttest.form.presenter;

import java.util.List;

import test.edualves.easynvesttest.model.Cell;

/**
 * Created by edualves on 26/05/17.
 */

public interface FormPresenter {

    List<Cell> convertStringJsonToCellsObject(String json);
}
