package test.edualves.easynvesttest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import test.edualves.easynvesttest.form.presenter.FormPresenter;
import test.edualves.easynvesttest.investment.presenter.ContactPresenter;
import test.edualves.easynvesttest.investment.presenter.ContactPresenterImpl;
import test.edualves.easynvesttest.investment.ui.ContactView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by edualves on 04/06/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class ContactPresenterImplTest {


    @Mock
    private ContactView view;

    private FormPresenter contactPresenter;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        contactPresenter = new ContactPresenterImpl(view);
    }

    @Test
    public void shouldBeAValidEmail() throws Exception {
        boolean isNotValid = contactPresenter.validateEmailField("a.com");
        assertEquals(false, isNotValid);

        boolean isValid = contactPresenter.validateEmailField("a@email.com");

        assertEquals(true, isValid);
    }


}
