package test.edualves.easynvesttest.form.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

    @BindView(R.id.title_investments)
    TextView titleInvestment;

    @BindView(R.id.fund_name)
    TextView fundName;

    @BindView(R.id.description_title)
    TextView whatIsTitle;

    @BindView(R.id.description_text)
    TextView descriptionText;

    @BindView(R.id.risk_title)
    TextView riskTitle;

    @BindView(R.id.more_info_title)
    TextView infoTitle;

    @BindView(R.id.fund_month_value)
    TextView fundMonthValue;

    @BindView(R.id.cdi_month_value)
    TextView cdiMonthValue;

    @BindView(R.id.fund_year_value)
    TextView fundYearValue;

    @BindView(R.id.cdi_year_value)
    TextView cdiYearValue;

    @BindView(R.id.fund_twelve_value)
    TextView fundTwelveValue;

    @BindView(R.id.cdi_twelve_value)
    TextView cdiTwelveValue;

    @BindView(R.id.admin_tax_label)
    TextView adminTaxLabel;

    @BindView(R.id.admin_tax_value)
    TextView adminTaxValue;

    @BindView(R.id.start_apply_label)
    TextView startApplyLabel;

    @BindView(R.id.start_apply_value)
    TextView startApplyValue;

    @BindView(R.id.minimum_move_label)
    TextView minimumMoveLabel;

    @BindView(R.id.minimum_move_value)
    TextView minimumMoveValue;

    @BindView(R.id.minimum_balance_label)
    TextView minimumBalanceLabel;

    @BindView(R.id.minimum_balance_value)
    TextView minimumBalanceValue;

    @BindView(R.id.withdraw_label)
    TextView withdrawLabel;

    @BindView(R.id.withdraw_value)
    TextView withdrawValue;

    @BindView(R.id.fee_label)
    TextView feeLabel;

    @BindView(R.id.fee_value)
    TextView feeValue;

    @BindView(R.id.payment_label)
    TextView paymentLabel;

    @BindView(R.id.payment_value)
    TextView paymentValue;

    InvestmentPresenter presenter;

    Screen screen = new Screen();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_investment_info, container, false);
        ButterKnife.bind(this, view);

        presenter = new InvestmentPresenterImpl(this);

        screen = presenter.convertJsonToScreenObject(Utils.readJsonFund(getActivity()));

        setUpTitleDesc();
        setUpLineChart();
        setUpBarChart();
        setUpMoreInfoAboutInvestment();
        setInfoAboutInvestment();

        return view;
    }

    private void setUpTitleDesc() {
        titleInvestment.setText(screen.getTitle());
        fundName.setText(Utils.countCharsForSpace(screen.getFundName(), 17));
        whatIsTitle.setText(screen.getWhatIs());
        descriptionText.setText(Utils.countCharsForSpace(screen.getDefinition(), 42));
    }

    private void setUpLineChart() {

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

    private void setUpBarChart() {

        riskTitle.setText(screen.getRiskTitle());
        //TODO insert barChar HERE
    }

    private void setUpMoreInfoAboutInvestment() {
        infoTitle.setText(screen.getInfoTitle());
        fundMonthValue.setText(screen.getMoreInfo().getMonth().getFund().toString());
        cdiMonthValue.setText(screen.getMoreInfo().getMonth().getCdi().toString());
        fundYearValue.setText(screen.getMoreInfo().getYear().getFund().toString());
        cdiYearValue.setText(screen.getMoreInfo().getYear().getCdi().toString());
        fundTwelveValue.setText(screen.getMoreInfo().getTwelveMonths().getFund().toString());
        cdiTwelveValue.setText(screen.getMoreInfo().getTwelveMonths().getCdi().toString());
    }

    private void setInfoAboutInvestment() {
        //This getInfos array has 7 positions(Starting at 0)
        adminTaxLabel.setText(screen.getInfos().get(0).getName());
        adminTaxValue.setText(screen.getInfos().get(0).getData());
        startApplyLabel.setText(screen.getInfos().get(1).getName());
        startApplyValue.setText(screen.getInfos().get(1).getData());
        minimumMoveLabel.setText(screen.getInfos().get(2).getName());
        minimumMoveValue.setText(screen.getInfos().get(2).getData());
        minimumBalanceLabel.setText(screen.getInfos().get(3).getName());
        minimumBalanceValue.setText(screen.getInfos().get(3).getData());
        withdrawLabel.setText(screen.getInfos().get(4).getName());
        withdrawValue.setText(screen.getInfos().get(4).getData());
        feeLabel.setText(screen.getInfos().get(5).getName());
        feeValue.setText(screen.getInfos().get(5).getData());
        paymentLabel.setText(screen.getInfos().get(6).getName());
        paymentValue.setText(screen.getInfos().get(6).getData());
    }
}
