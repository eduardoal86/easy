package test.edualves.easynvesttest.form.presenter;

import android.util.Log;

import com.google.gson.Gson;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import test.edualves.easynvesttest.R;
import test.edualves.easynvesttest.Utils;
import test.edualves.easynvesttest.form.ui.CustomTextInputLayout;
import test.edualves.easynvesttest.form.ui.MainFormFragmentView;
import test.edualves.easynvesttest.model.Cell;

/**
 * Created by edualves on 26/05/17.
 */

public class FormPresenterImpl implements FormPresenter {

    private final MainFormFragmentView view;

    public FormPresenterImpl(MainFormFragmentView view) {
        this.view = view;
    }

    @Override
    public List<Cell> convertStringJsonToCellsObject(String json) {

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

    @Override
    public String formatTitleMessage(String msg) {

        StringBuilder stringBuilder = new StringBuilder(msg);

        int i = 0;
        while ((i = stringBuilder.indexOf(" ", i + 27)) != -1) {

            stringBuilder.replace(i, i + 1, "\n");
        }

        return stringBuilder.toString();
    }
}
