package com.jenky.codebuddy;

import org.junit.Test;
import com.jenky.codebuddy.util.Utilities;
import junit.framework.Assert;
import java.util.ArrayList;
import java.util.Calendar;


public class DateConverterUnitTest {

    private static final ArrayList<Calendar> calendars = new ArrayList<>();
    Calendar cal = Calendar.getInstance();


    @Test
    public void dateConverterStringValues() {
        for (int i = 0; i < 1000; i++) {
            cal.add(Calendar.DATE, i);
            calendars.add(cal);
        }

        for (int j = 0; j < calendars.size(); j++){
            Assert.assertTrue(Utilities.ddMMyyyyToString(calendars.get(j)).matches("[0-9]{2}/[0-9]{2}/[0-9]{4}"));
        }
    }


}