package com.jenky.codebuddy;

import android.support.test.espresso.assertion.PositionAssertions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.runner.AndroidJUnit4;
import com.jenky.codebuddy.ui.activities.LogInActivity;
import com.jenky.codebuddy.util.AppController;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by JTLie on 28-5-2016.
 */
@RunWith(AndroidJUnit4.class)
public class LogInActivityTest {


    @Rule public ActivityRule<LogInActivity> logIn = new ActivityRule<>(LogInActivity.class);
    @Test
    public void  LogInTest(){
        AppController.getInstance().getPreferences().reset();
        checkLoginContent();
        checkLogInPositions();
        goToMainActivity();
    }

    public void checkLoginContent(){
        onView(withId(R.id.email))
                .check(ViewAssertions.matches(withHint(R.string.github_email)));
        onView(withId(R.id.password))
                .check(ViewAssertions.matches(withHint(R.string.password)));
        onView(withId(R.id.log_in))
                .check(ViewAssertions.matches(withText(R.string.log_in)));
        onView(withId(R.id.sign_up))
                .check(ViewAssertions.matches(withText(R.string.sign_up)));
    }

    public void  checkLogInPositions(){
        onView(withId(R.id.email))
                .check(PositionAssertions.isAbove(withId(R.id.password)));
        onView(withId(R.id.password))
                .check(PositionAssertions.isAbove(withId(R.id.log_in)));
        onView(withId(R.id.log_in))
                .check(PositionAssertions.isAbove(withId(R.id.sign_up)));
    }

    public static void goToMainActivity(){
        onView(withId(R.id.email))
                .perform(typeText("jtlie@live.nl"));
        closeSoftKeyboard();
        onView(withId(R.id.password))
                .perform(typeText("jasonlie"));
        closeSoftKeyboard();
        onView(withId(R.id.log_in))
                .perform(click());
        ActivityRule.matchToolbarTitle("Profile")
                .check(matches(isDisplayed()));
    }
}
