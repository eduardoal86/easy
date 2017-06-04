package test.edualves.easynvesttest.form.ui;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import test.edualves.easynvesttest.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainFormActivityTest2 {

    @Rule
    public ActivityTestRule<MainFormActivity> mActivityTestRule = new ActivityTestRule<>(MainFormActivity.class);

    @Test
    public void mainFormActivityTest2() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.input_name), isDisplayed()));
        appCompatEditText.perform(replaceText("Teste"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.input_name), withText("Teste"), isDisplayed()));
        appCompatEditText2.perform(pressImeActionButton());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.input_email), isDisplayed()));
        appCompatEditText3.perform(replaceText("eduardoal86@gmail.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.input_email), withText("eduardoal86@gmail.com"), isDisplayed()));
        appCompatEditText4.perform(pressImeActionButton());

        ViewInteraction appCompatCheckBox = onView(
                allOf(withId(R.id.checkbox_email), withText("Gostaria de cadastrar meu email"), isDisplayed()));
        appCompatCheckBox.perform(click());

        ViewInteraction relativeLayout = onView(
                allOf(withId(R.id.send_btn), isDisplayed()));
        relativeLayout.perform(click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.next_investments), withText("Vamos investir!"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.next_investments), withText("Investir")));
        appCompatButton2.perform(scrollTo(), click());

        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.action_contact), withContentDescription("Contato"), isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.input_name), isDisplayed()));
        appCompatEditText5.perform(replaceText("Eduardo"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.input_name), withText("Eduardo"), isDisplayed()));
        appCompatEditText6.perform(pressImeActionButton());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.input_email), isDisplayed()));
        appCompatEditText7.perform(replaceText("eduardoal86@gmail.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.input_email), withText("eduardoal86@gmail.com"), isDisplayed()));
        appCompatEditText8.perform(pressImeActionButton());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.input_phone), isDisplayed()));
        appCompatEditText9.perform(replaceText("1198349"), closeSoftKeyboard());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.input_phone), withText("1198349"), isDisplayed()));
        appCompatEditText10.perform(pressImeActionButton());

        ViewInteraction appCompatCheckBox2 = onView(
                allOf(withId(R.id.checkbox_email), withText("Gostaria de cadastrar meu email"),
                        withParent(withId(R.id.form_contact_container))));
        appCompatCheckBox2.perform(scrollTo(), click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.send_message), withText("Enviar"),
                        withParent(withId(R.id.form_contact_container))));
        appCompatButton3.perform(scrollTo(), click());

    }

}
