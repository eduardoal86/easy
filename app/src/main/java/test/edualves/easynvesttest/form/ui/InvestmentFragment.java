package test.edualves.easynvesttest.form.ui;

import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.edualves.easynvesttest.R;

/**
 * Created by edualves on 29/05/17.
 */

public class InvestmentFragment extends Fragment {

    @BindView(R.id.chart_line)
    LineChart lineChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_investment_info, container, false);
        ButterKnife.bind(this, view);

        setUpChart();

        return view;
    }

    private void setUpChart() {
        List<Entry> entries = new ArrayList<>();
        List<Entry> entries2 = new ArrayList<>();

        entries.add(new Entry(0,0));
        entries.add(new Entry(1, 2));
        entries.add(new Entry(2, 3));
        entries.add(new Entry(3, 4));
        entries.add(new Entry(4, 5));

        entries2.add(new Entry(0,0));
        entries2.add(new Entry(1,4));
        entries2.add(new Entry(2,5));
        entries2.add(new Entry(3,7));
        entries2.add(new Entry(4,8));

        LineDataSet dataSet = new LineDataSet(entries, "CDI"); // add entries to dataset
        dataSet.setColor(R.color.AuroMetalSaurus);
        dataSet.setDrawValues(false);
        dataSet.setDrawCircles(false);
        dataSet.setLineWidth(2);
        dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);

        LineDataSet dataSet2 = new LineDataSet(entries2, "CDB"); // add entries to dataset
        dataSet2.setColor(R.color.purple);
        dataSet2.setDrawValues(false);
        dataSet2.setDrawCircles(false);
        dataSet2.setLineWidth(2);
        dataSet2.setAxisDependency(YAxis.AxisDependency.LEFT);

        List<ILineDataSet> iLineDataSets = new ArrayList<>();
        iLineDataSets.add(dataSet);
        iLineDataSets.add(dataSet2);


        final String[] periods = new String[] { "14/07" ,"14/08", "14/09", "14/10", "14/11", "14/12" };

        IAxisValueFormatter formatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return periods[(int) value];
            }

        };


        XAxis xAxis = lineChart.getXAxis();
        xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter(formatter);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(R.color.CCCCCC);

        LineData lineData = new LineData(iLineDataSets);


        lineChart.setData(lineData);
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
