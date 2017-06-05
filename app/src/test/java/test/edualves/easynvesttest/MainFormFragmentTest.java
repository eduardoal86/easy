package test.edualves.easynvesttest;

import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import test.edualves.easynvesttest.form.ui.MainFormFragment;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by edualves on 04/06/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainFormFragmentTest {

    private MainFormFragment mainFormFragment = new MainFormFragment();

    @Before
    public void setup() throws Exception {
        SupportFragmentTestUtil.startVisibleFragment(mainFormFragment);
    }

    @Test
    public void shouldHaveATitle() throws Exception {
        TextView title = (TextView) mainFormFragment.getActivity().findViewById(R.id.title_message);

        assertThat(title.getText().toString(), equalTo("Olá, primeiro se apresente com\no seu nome:"));
    }
}
