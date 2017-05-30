package test.edualves.easynvesttest.form.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.edualves.easynvesttest.R;
import test.edualves.easynvesttest.Utils;
import test.edualves.easynvesttest.form.presenter.InvestmentPresenter;
import test.edualves.easynvesttest.form.presenter.InvestmentPresenterImpl;
import test.edualves.easynvesttest.model.Screen;

/**
 * Created by edualves on 29/05/17.
 */

public class InvestmentFragment extends Fragment implements InvestmentView {

    @BindView(R.id.chart_line)
    LineChart lineChart;

    InvestmentPresenter presenter;

    Screen screen = new Screen();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_investment_info, container, false);
        ButterKnife.bind(this, view);

        presenter = new InvestmentPresenterImpl(this);

        screen = presenter.convertJsonToScreenObject(Utils.readJsonFund(getActivity()));

        setUpChart();

        return view;
    }

    private void setUpChart() {

        List<Entry> entries = presenter.setValuesToLineChart(screen.getGraph().getCdiValues());
        List<Entry> entries2 = presenter.setValuesToLineChart(screen.getGraph().getFundValues());

        LineDataSet dataSet = new LineDataSet(entries, getResources().getString(R.string.fund_market));
        dataSet.setColor(R.color.AuroMetalSaurus);
        dataSet.setDrawValues(false);
        dataSet.setDrawCircles(false);
        dataSet.setLineWidth(2);
        dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);

        LineDataSet dataSet2 = new LineDataSet(entries2, screen.getFundName());
        dataSet2.setColor(R.color.purple);
        dataSet2.setDrawValues(false);
        dataSet2.setDrawCircles(false);
        dataSet2.setLineWidth(2);
        dataSet2.setAxisDependency(YAxis.AxisDependency.LEFT);

        List<ILineDataSet> iLineDataSets = new ArrayList<>();
        iLineDataSets.add(dataSet);
        iLineDataSets.add(dataSet2);

        final String[] periods = screen.getGraph().getxValues().toArray(new String[0]);

        IAxisValueFormatter formatter = presenter.setUpPeriods(periods);

        XAxis xAxis = lineChart.getXAxis();

        //To display frequency on chart
        xAxis.setGranularity(2f);

        xAxis.setValueFormatter(formatter);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(R.color.CCCCCC);

        LineData lineData = new LineData(iLineDataSets);

        lineChart.setData(lineData);

        //TODO Review these properties
        lineChart.setDrawGridBackground(false);
        lineChart.getDescription().setEnabled(false);

        lineChart.getAxisLeft().setEnabled(true);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.getAxisRight().setDrawAxisLine(false);
        lineChart.getAxisRight().setDrawGridLines(true);
        lineChart.getXAxis().setDrawAxisLine(false);
        lineChart.getXAxis().setDrawGridLines(false);

        // enable touch gestures
        lineChart.setTouchEnabled(false);

        // enable scaling and dragging
        lineChart.setDragEnabled(false);
        lineChart.setScaleEnabled(false);

        // if disabled, scaling can be done on x- and y-axis separately
        lineChart.setPinchZoom(false);

        lineChart.invalidate();

    }
}
