package com.bryonnicoson.keyboardsamples;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class SpinnerSelectionTest {
    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void iterateSpinnerItems() {
        String[] mArray =
                mActivityRule.getActivity().getResources().getStringArray(R.array.labels_array);
        int size = mArray.length;
        for (int i=0; i<size; i++){
            // find the spinner and click it to open it
            onView(withId(R.id.spinner_main)).perform(click());
            // find mArray[i] and click on it
            onData(is(mArray[i])).perform(click());
            // find the submit button and click it
            onView(withId(R.id.button_main)).perform(click());
            // find the textView and check that it contains mArray[i]
            onView(withId(R.id.textView_phone)).check(matches(withText(containsString(mArray[i]))));
        }
    }

}
