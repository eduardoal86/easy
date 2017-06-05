package test.edualves.easynvesttest;

import android.support.design.widget.BottomNavigationView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import test.edualves.easynvesttest.investment.ui.InvestmentActivity;

/**
 * Created by edualves on 05/06/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class InvestmentActivityTest {

    private InvestmentActivity activity;

    @Before
    public void setup() throws Exception {
        activity = Robolectric.setupActivity(InvestmentActivity.class);
    }

    @Test
    public void bottomNavigationShouldBeNotNull() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) activity.findViewById(R.id.bottom_navigation);

        assertNotNull("BottomNavigation could not be null", bottomNavigationView);
        assertEquals("Investimento", bottomNavigationView.getMenu().getItem(0).getTitle());
        assertEquals("Contato", bottomNavigationView.getMenu().getItem(1).getTitle());
    }
}
