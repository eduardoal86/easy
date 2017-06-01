package test.edualves.easynvesttest.investment.presenter;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.List;

import test.edualves.easynvesttest.model.Screen;

/**
 * Created by edualves on 30/05/17.
 */

public interface InvestmentPresenter {

    Screen convertJsonToScreenObject(String json);

    List<Entry> setValuesToLineChart(List<Float> values);

    IAxisValueFormatter setUpPeriods(final String[] periods);
}
