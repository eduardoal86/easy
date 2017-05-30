package test.edualves.easynvesttest.form.presenter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import test.edualves.easynvesttest.form.ui.InvestmentView;
import test.edualves.easynvesttest.model.Screen;

/**
 * Created by edualves on 30/05/17.
 */

public class InvestmentPresenterImpl implements InvestmentPresenter {

    InvestmentView view;

    public InvestmentPresenterImpl(InvestmentView view) {
        this.view = view;
    }


    @Override
    public Screen convertJsonToScreenObject(String json) {
        Screen screen = new Screen();
        Gson gson = new Gson();

        try {
            JSONObject jsonObject = new JSONObject(json);

            JSONObject jsonScreen = jsonObject.getJSONObject("screen");

            screen = gson.fromJson(jsonScreen.toString(), Screen.class);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return screen;

    }

    @Override
    public List<Entry> setValuesToLineChart(List<Float> values) {

        List<Entry> entries = new ArrayList<>();

        for (int i = 0; i < values.size(); i++) {
            entries.add(new Entry(i, values.get(i)));
        }

        return entries;
    }

    public static int convertDateStringToDateAsInt(String dateString) {
        int dateInt = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");

        try {

            Date parseDate = sdf.parse(dateString);
            dateInt = (int) (parseDate.getTime() / 1000);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateInt;
    }

    @Override
    public IAxisValueFormatter setUpPeriods(final String[] periods) {

        IAxisValueFormatter formatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return periods[(int) value];
            }

        };

        return formatter;
    }

}
