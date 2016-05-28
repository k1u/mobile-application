package com.jenky.codebuddy;

import android.app.Activity;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.FragmentManager;

import com.jenky.codebuddy.ui.activities.MainActivity;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by JTLie on 28-5-2016.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule public final ActivityRule<MainActivity> main = new ActivityRule<>(MainActivity.class);

    @Test
    public void  checkViewContent(){
        onView(withId(R.id.total_score_label))
                .check(ViewAssertions.matches(withText(R.string.total_score)));
        onView(withId(R.id.avg_score_label))
                .check(ViewAssertions.matches(withText(R.string.avg_score)));
        onView(withId(R.id.achievements_label))
                .check(ViewAssertions.matches(withText(R.string.achievements)));
        onView(withId(R.id.games_played_label))
                .check(ViewAssertions.matches(withText(R.string.games_played)));
    }
}
