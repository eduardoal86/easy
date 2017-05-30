package test.edualves.easynvesttest.form.presenter;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.List;

/**
 * Created by edualves on 30/05/17.
 */

public interface InvestmentPresenter {

    List<Entry> setValuesToLineChart();

    IAxisValueFormatter setUpPeriods(final String[] periods);
}
