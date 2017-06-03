package test.edualves.easynvesttest.investment.presenter;

import java.util.List;

import test.edualves.easynvesttest.model.Cell;
import test.edualves.easynvesttest.service.CellService;
import test.edualves.easynvesttest.service.CellServiceImpl;

/**
 * Created by edualves on 02/06/17.
 */

public class ContactPresenterImpl implements ContactPresenter {

    CellService service = new CellServiceImpl();

    @Override
    public List<Cell> getCells(String json) {
        return service.getCells(json);
    }
}
