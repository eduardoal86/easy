package test.edualves.easynvesttest;


import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import test.edualves.easynvesttest.investment.ui.InvestmentActivity;
import test.edualves.easynvesttest.investment.ui.InvestmentFragment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by edualves on 05/06/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class InvestmentFragmentTest {

    private InvestmentFragment investmentFragment = new InvestmentFragment();

    @Before
    public void setup() throws Exception {
        SupportFragmentTestUtil.startVisibleFragment(investmentFragment);
    }

    @Test
    public void investmentFragmentShouldNotBeNull() {
        InvestmentFragment investmentFragment = new InvestmentFragment();
        SupportFragmentTestUtil.startFragment(investmentFragment, InvestmentActivity.class);
        assertNotNull(investmentFragment);
    }

    @Test
    public void shouldHaveATitle() throws Exception {
        TextView title = (TextView) investmentFragment.getActivity().findViewById(R.id.title_investments);
        TextView fundName = (TextView) investmentFragment.getActivity().findViewById(R.id.fund_name);
        TextView description = (TextView) investmentFragment.getActivity().findViewById(R.id.description_text);
        TextView riskTitle = (TextView) investmentFragment.getActivity().findViewById(R.id.risk_title);

        assertNotNull("TextView could not be found", title);
        assertEquals("Fundos de investimento", title.getText().toString());

        assertNotNull("TextView could not be found", fundName);
        assertEquals("Vinci Valorem FI Multimercado", fundName.getText().toString());

        assertNotNull("TextView could not be found", description);

        assertNotNull("TextView could not be found", riskTitle);
    }

    @Test
    public void shouldHaveAButtonInTheEndOfScreen() {
        Button btn = (Button) investmentFragment.getActivity().findViewById(R.id.next_investments);

        assertNotNull("Button could not be found", btn);
    }
}
