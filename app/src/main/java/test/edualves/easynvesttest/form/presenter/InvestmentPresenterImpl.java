package test.edualves.easynvesttest.form.presenter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

import test.edualves.easynvesttest.form.ui.InvestmentView;

/**
 * Created by edualves on 30/05/17.
 */

public class InvestmentPresenterImpl implements InvestmentPresenter{

    InvestmentView view;

    public InvestmentPresenterImpl(InvestmentView view) {
        this.view = view;
    }


    @Override
    public List<Entry> setValuesToLineChart() {

        List<Entry> entries = new ArrayList<>();

        entries.add(new Entry(0,0));
        entries.add(new Entry(1, 2));
        entries.add(new Entry(2, 3));
        entries.add(new Entry(3, 4));
        entries.add(new Entry(4, 5));

        return entries;
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
