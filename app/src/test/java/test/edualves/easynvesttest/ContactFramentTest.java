package test.edualves.easynvesttest;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import test.edualves.easynvesttest.investment.ui.ContactFragment;
import test.edualves.easynvesttest.investment.ui.InvestmentActivity;
import test.edualves.easynvesttest.utils.CustomTextInputLayout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by edualves on 05/06/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class ContactFramentTest {

    private ContactFragment contactFragment = new ContactFragment();

    @Before
    public void setup() throws Exception {

        SupportFragmentTestUtil.startVisibleFragment(contactFragment);
    }

    @Test
    public void contactFragmentShouldNotBeNull() {
        ContactFragment contactFragment = new ContactFragment();
        SupportFragmentTestUtil.startFragment(contactFragment, InvestmentActivity.class);
        assertNotNull(contactFragment);
    }

    @Test
    public void fieldsShouldBeValid() throws Exception {
        CustomTextInputLayout name = (CustomTextInputLayout) contactFragment.getActivity().findViewById(R.id.name_text_input);
        CustomTextInputLayout email = (CustomTextInputLayout) contactFragment.getActivity().findViewById(R.id.email_text_input);
        CustomTextInputLayout phone = (CustomTextInputLayout) contactFragment.getActivity().findViewById(R.id.phone_text_input);

        CheckBox checkBox = (CheckBox) contactFragment.getActivity().findViewById(R.id.checkbox_email);
        Button sendBtn = (Button) contactFragment.getActivity().findViewById(R.id.send_message);

        assertNotNull("Name could not be found", name);

        if (name.getVisibility() == View.VISIBLE) {
            assertEquals(false, name.getHint().toString().isEmpty());
            assertEquals("Nome completo", name.getHint().toString());
        }

        assertNotNull("Email could not be found", email);

        if (email.getVisibility() == View.VISIBLE) {
            assertEquals(false, email.getHint().toString().isEmpty());
            assertEquals("Email", email.getHint().toString());
        }

        assertNotNull("Phone could not be found", phone);

        if (phone.getVisibility() == View.VISIBLE) {
            assertEquals(false, phone.getHint().toString().isEmpty());
            assertEquals("Telefone", phone.getHint().toString());
        }

        assertNotNull("Checkbox could not be found", checkBox);

        if (checkBox.getVisibility() == View.VISIBLE) {
            assertEquals("Gostaria de cadastrar meu email", checkBox.getText().toString());
        }

        assertNotNull("Text button could not be found", sendBtn.getText().toString());
        assertEquals("Enviar", sendBtn.getText().toString());
    }

}
