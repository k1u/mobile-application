package com.jenky.codebuddy;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import android.content.Context;

import com.jenky.codebuddy.util.Utilities;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.Calendar;


@RunWith(MockitoJUnitRunner.class)
public class TowerHeightTest {

    private static final ArrayList<Calendar> calendars = new ArrayList<>();
    Calendar cal = Calendar.getInstance();

    @Mock
    Context mMockContext;

    @Test
    public void DateConverterStringValues() {
        for (int i = 0; i < 1000; i++) {
            cal.add(Calendar.DATE, i);
            calendars.add(cal);
        }

        for (int j = 0; j < calendars.size(); j++){
            Assert.assertTrue(Utilities.ddMMyyyyToString(calendars.get(j)).matches("[0-9]{2}/[0-9]{2}/[0-9]{4}"));
        }
    }


}