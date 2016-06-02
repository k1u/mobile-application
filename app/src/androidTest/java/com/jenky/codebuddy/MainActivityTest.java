package com.jenky.codebuddy;

import android.app.Activity;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.PositionAssertions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.FragmentManager;

import com.jenky.codebuddy.ui.activities.LogInActivity;
import com.jenky.codebuddy.ui.activities.MainActivity;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
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
        //goToMainActivty();
        onView(withId(R.id.total_score_label))
                .check(ViewAssertions.matches(withText(R.string.total_score)));
        onView(withId(R.id.avg_score_label))
                .check(ViewAssertions.matches(withText(R.string.avg_score)));
        onView(withId(R.id.achievements_label))
                .check(ViewAssertions.matches(withText(R.string.achievements)));
        onView(withId(R.id.games_played_label))
                .check(ViewAssertions.matches(withText(R.string.games_played)));
    }

    @Test
    public void  checkViewPosition(){
        onView(withId(R.id.total_score_label))
                .check(PositionAssertions.isAbove(withId(R.id.avg_score_label)));
        onView(withId(R.id.avg_score_label))
                .check(PositionAssertions.isAbove(withId(R.id.achievements_label)));
        onView(withId(R.id.achievements_label))
                .check(PositionAssertions.isAbove(withId(R.id.games_played_label)));
        onView(withId(R.id.total_score_label))
                .check(PositionAssertions.isLeftOf(withId(R.id.total_score_value)));
        onView(withId(R.id.avg_score_label))
                .check(PositionAssertions.isLeftOf(withId(R.id.avg_score_value)));
        onView(withId(R.id.achievements_label))
                .check(PositionAssertions.isLeftOf(withId(R.id.achievements_value)));
        onView(withId(R.id.games_played_label))
                .check(PositionAssertions.isLeftOf(withId(R.id.games_played_value)));
    }

    public void goToMainActivty(){
        onView(withId(R.id.email))
                .perform(typeText("hoi"));
        onView(withId(R.id.password))
                .perform(typeText("doei"));
        onView(withId(R.id.log_in))
                .perform(click());
    }

}
