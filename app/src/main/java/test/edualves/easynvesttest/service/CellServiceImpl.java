package test.edualves.easynvesttest.service;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import test.edualves.easynvesttest.model.Cell;

/**
 * Created by edualves on 03/06/17.
 */

public class CellServiceImpl implements CellService {

    @Override
    public List<Cell> getCells(String json) {

        List<Cell> cells = new ArrayList<>();
        Gson gson = new Gson();

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("cells");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject exploreObject = jsonArray.getJSONObject(i);
                cells.add(i, gson.fromJson(exploreObject.toString(), Cell.class));
            }

            return cells;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
