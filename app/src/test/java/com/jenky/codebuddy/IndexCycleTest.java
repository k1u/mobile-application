package com.jenky.codebuddy;

import android.content.Context;
import com.jenky.codebuddy.ui.fragments.EquipmentFragment;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class IndexCycleTest {


    @Mock
    Context mMockContext;


    @Test
    public void indexValidation() {
            Assert.assertTrue(EquipmentFragment.changeIndex(30, 30, 1) == 0);
            Assert.assertTrue(EquipmentFragment.changeIndex(50, 78, 1) == 51);
            Assert.assertTrue(EquipmentFragment.changeIndex(0, 20, -1) == 19);
            Assert.assertTrue(EquipmentFragment.changeIndex(10, 57, -1) == 9);
    }
}