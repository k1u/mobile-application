package com.jenky.codebuddy;

import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.assertion.PositionAssertions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.runner.AndroidJUnit4;

import com.jenky.codebuddy.adapters.HistoryAdapter;
import com.jenky.codebuddy.ui.activities.MainActivity;
import com.jenky.codebuddy.util.AppController;
import com.jenky.codebuddy.util.Utilities;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.core.deps.guava.base.Predicates.instanceOf;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.core.AllOf.allOf;


/**
 * Created by JTLie on 28-5-2016.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {


    @Rule
    public ActivityRule<MainActivity> main = new ActivityRule<>(MainActivity.class);

    @Test
    public void testNavigationMenu() {
        openProfile();
        ActivityRule.matchToolbarTitle("Profile")
                .check(matches(isDisplayed()));
        openProjects();
        ActivityRule.matchToolbarTitle("Projects")
                .check(matches(isDisplayed()));
        openAchievements();
        ActivityRule.matchToolbarTitle("Achievements")
                .check(matches(isDisplayed()));
        openShop();
        ActivityRule.matchToolbarTitle("Shop")
                .check(matches(isDisplayed()));
    }

    @Test
    public void testProfile() {
        checkProfileContent();
        checkProfileLayout();
        checkCommit();
    }

    @Test
    public void testEquipment() {
        onView(withId(R.id.avatar_layout))
                .perform(click());
        checkEquipmentContent();
        checkEquipmentLayout();
        checkEquipmentClickable();
    }

    private void openNavigationMenu() {
        onView(withId(R.id.toolbar))
                .perform(ActivityRule.clickXY(Utilities.getInDp(AppController.getInstance(), 30), Utilities.getInDp(AppController.getInstance(), 30)));
    }

    private void openProfile() {
        openNavigationMenu();
        onView(withId(R.id.toolbar))
                .perform(ActivityRule.clickXY(Utilities.getInDp(AppController.getInstance(), 30), Utilities.getInDp(AppController.getInstance(), 150)));
    }

    private void openProjects() {
        openNavigationMenu();
        onView(withId(R.id.toolbar))
                .perform(ActivityRule.clickXY(Utilities.getInDp(AppController.getInstance(), 30), Utilities.getInDp(AppController.getInstance(), 200)));
    }

    private void openAchievements() {
        openNavigationMenu();
        onView(withId(R.id.toolbar))
                .perform(ActivityRule.clickXY(Utilities.getInDp(AppController.getInstance(), 30), Utilities.getInDp(AppController.getInstance(), 250)));
    }

    private void openShop() {
        openNavigationMenu();
        onView(withId(R.id.toolbar))
                .perform(ActivityRule.clickXY(Utilities.getInDp(AppController.getInstance(), 30), Utilities.getInDp(AppController.getInstance(), 280)));
    }

    private void checkProfileContent() {
        onView(withId(R.id.total_score_label))
                .check(matches(withText(R.string.total_score)));
        onView(withId(R.id.avg_score_label))
                .check(matches(withText(R.string.avg_score)));
        onView(withId(R.id.achievements_label))
                .check(matches(withText(R.string.achievements)));
        onView(withId(R.id.games_played_label))
                .check(matches(withText(R.string.games_played)));
        onView(withId(R.id.avatar_layout))
                .check(matches(isClickable()));
    }


    private void checkProfileLayout() {
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

    private void checkEquipmentContent() {
        onView(withId(R.id.cancel))
                .check(matches(withText(R.string.cancel)));
        onView(withId(R.id.apply))
                .check(matches(withText(R.string.apply)));
        onView(withId(R.id.title))
                .check(matches(withText(R.string.equipment)));
    }


    private void checkEquipmentLayout() {
        onView(withId(R.id.title))
                .check(PositionAssertions.isAbove(withId(R.id.helmet_previous)));
        onView(withId(R.id.helmet_previous))
                .check(PositionAssertions.isAbove(withId(R.id.shirt_previous)));
        onView(withId(R.id.shirt_previous))
                .check(PositionAssertions.isAbove(withId(R.id.legs_previous)));
        onView(withId(R.id.legs_previous))
                .check(PositionAssertions.isAbove(withId(R.id.block_previous)));
        onView(withId(R.id.block_previous))
                .check(PositionAssertions.isAbove(withId(R.id.cancel)));
        onView(withId(R.id.helmet_next))
                .check(PositionAssertions.isAbove(withId(R.id.shirt_next)));
        onView(withId(R.id.shirt_next))
                .check(PositionAssertions.isAbove(withId(R.id.legs_next)));
        onView(withId(R.id.legs_next))
                .check(PositionAssertions.isAbove(withId(R.id.block_next)));
        onView(withId(R.id.block_next))
                .check(PositionAssertions.isAbove(withId(R.id.apply)));

        onView(withId(R.id.helmet_previous))
                .check(PositionAssertions.isLeftOf(withId(R.id.helmet_layout)));
        onView(withId(R.id.shirt_previous))
                .check(PositionAssertions.isLeftOf(withId(R.id.shirt_layout)));
        onView(withId(R.id.legs_previous))
                .check(PositionAssertions.isLeftOf(withId(R.id.legs_layout)));
        onView(withId(R.id.block_previous))
                .check(PositionAssertions.isLeftOf(withId(R.id.block_layout)));

        onView(withId(R.id.helmet_next))
                .check(PositionAssertions.isRightOf(withId(R.id.helmet_layout)));
        onView(withId(R.id.shirt_next))
                .check(PositionAssertions.isRightOf(withId(R.id.shirt_layout)));
        onView(withId(R.id.legs_next))
                .check(PositionAssertions.isRightOf(withId(R.id.legs_layout)));
        onView(withId(R.id.block_next))
                .check(PositionAssertions.isRightOf(withId(R.id.block_layout)));
        onView(withId(R.id.apply))
                .check(PositionAssertions.isRightOf(withId(R.id.cancel)));
    }

    private void checkEquipmentClickable() {
        onView(withId(R.id.helmet_previous))
                .check(matches(isClickable()));
        onView(withId(R.id.shirt_previous))
                .check(matches(isClickable()));
        onView(withId(R.id.legs_previous))
                .check(matches(isClickable()));
        onView(withId(R.id.block_previous))
                .check(matches(isClickable()));
        onView(withId(R.id.helmet_next))
                .check(matches(isClickable()));
        onView(withId(R.id.shirt_next))
                .check(matches(isClickable()));
        onView(withId(R.id.legs_next))
                .check(matches(isClickable()));
        onView(withId(R.id.block_next))
                .check(matches(isClickable()));
        onView(withId(R.id.apply))
                .check(matches(isClickable()));
        onView(withId(R.id.cancel))
                .check(matches(isClickable()));
    }

    private void checkCommit() {
        onData(anything())
                .inAdapterView(withId(R.id.result_list_view))
                .atPosition(0).onChildView(withId(R.id.project_label)).check(ViewAssertions.matches(withText(R.string.project_name)));
        onData(anything())
                .inAdapterView(withId(R.id.result_list_view))
                .atPosition(0).onChildView(withId(R.id.score_label)).check(ViewAssertions.matches(withText(R.string.score)));
        onData(anything())
                .inAdapterView(withId(R.id.result_list_view))
                .atPosition(0).onChildView(withId(R.id.branch_label)).check(ViewAssertions.matches(withText(R.string.branch)));
        onData(anything())
                .inAdapterView(withId(R.id.result_list_view))
                .atPosition(0).onChildView(withId(R.id.date_label)).check(ViewAssertions.matches(withText(R.string.commited_on)));
    }

}
