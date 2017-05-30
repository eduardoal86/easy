package test.edualves.easynvesttest.form.presenter;

import android.util.Log;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
        return null;
    }

    //TODO receive (float)
    @Override
    public List<Entry> setValuesToLineChart() {

        List<Entry> entries = new ArrayList<>();

        //TODO second parameter of Entry is that float parameter
        entries.add(new Entry(0, 1500));
        entries.add(new Entry(1, 2000));
        entries.add(new Entry(2, 3000));
        entries.add(new Entry(3, 4000));
        entries.add(new Entry(4, 5000));
        entries.add(new Entry(5, 6000));
        entries.add(new Entry(6, 7000));
        entries.add(new Entry(7, 8000));
        entries.add(new Entry(8, 9000));
        entries.add(new Entry(9, 10000));

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
