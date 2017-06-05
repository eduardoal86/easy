package test.edualves.easynvesttest;

import android.widget.CheckBox;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import test.edualves.easynvesttest.form.ui.MainFormActivity;
import test.edualves.easynvesttest.form.ui.MainFormFragment;
import test.edualves.easynvesttest.utils.CustomTextInputLayout;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
    public void MainFormFragmentShouldNotBeNull() {
        MainFormFragment mainFormFragment = new MainFormFragment();
        SupportFragmentTestUtil.startFragment(mainFormFragment, MainFormActivity.class);
        assertNotNull(mainFormFragment);
    }

    @Test
    public void shouldHaveATitle() throws Exception {
        TextView title = (TextView) mainFormFragment.getActivity().findViewById(R.id.title_message);

        assertThat(title.getText().toString(), equalTo("Olá, primeiro se apresente com\no seu nome:"));
    }

    @Test
    public void shouldHaveAText() throws Exception {
        CustomTextInputLayout name = (CustomTextInputLayout) mainFormFragment.getActivity().findViewById(R.id.name_text_input);
        CustomTextInputLayout email = (CustomTextInputLayout) mainFormFragment.getActivity().findViewById(R.id.email_text_input);
        CheckBox checkBox = (CheckBox) mainFormFragment.getActivity().findViewById(R.id.checkbox_email);
        TextView sendBtnText = (TextView) mainFormFragment.getActivity().findViewById(R.id.send_btn_text);

        assertNotNull("Name could not be found", name);
        assertEquals(false, name.getHint().toString().isEmpty());
        assertEquals("Nome completo", name.getHint().toString());

        assertNotNull("Email could not be found", email);
        assertEquals(false, email.getHint().toString().isEmpty());
        assertEquals("Email", email.getHint().toString());

        assertNotNull("Checkbox could not be found", checkBox);
        assertEquals("Gostaria de cadastrar meu email", checkBox.getText().toString());

        assertNotNull("Text button could not be found", sendBtnText.getText().toString());
        assertEquals("Enviar", sendBtnText.getText().toString());

    }
}
