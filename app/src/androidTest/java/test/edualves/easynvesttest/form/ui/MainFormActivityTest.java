package test.edualves.easynvesttest.form.ui;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainFormActivityTest {

    @Rule
    public ActivityTestRule<MainFormActivity> mActivityTestRule = new ActivityTestRule<>(MainFormActivity.class);

    @Test
    public void mainFormActivityTest() {
    }

}
