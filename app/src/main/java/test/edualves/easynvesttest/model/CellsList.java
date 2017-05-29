package test.edualves.easynvesttest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edualves on 26/05/17.
 */

public class CellsList implements Serializable {

    ArrayList<Cell> cellList;

    public ArrayList<Cell> getCellList() {
        return cellList;
    }

    public void setCellList(ArrayList<Cell> cellList) {
        this.cellList = cellList;
    }
}
