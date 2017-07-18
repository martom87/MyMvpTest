package com.example.sda.mymvptest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.sda.mymvptest.activities.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by sda on 17.07.17.
 */
@RunWith(AndroidJUnit4.class)


public class MainActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<MainActivity> testRule = new ActivityTestRule<>(MainActivity.class);

    private String stringToBeTyped;

    @Before
    public void setUp() throws Exception {
        stringToBeTyped = "2027";
    }


    @Test
    public void validateEditText() {
        onView(withId(R.id.editText)).perform(typeText("1")).check(matches(withText("1")));
    }

    @Test
    public void correctInput_displayText() throws Exception {
        onView(withId(R.id.editText)).perform(click(), typeText(stringToBeTyped), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText(stringToBeTyped)));

    }

    @Test
    public void buttonClicks(){
        onView(withId(R.id.button)).perform(click());
    }




}

