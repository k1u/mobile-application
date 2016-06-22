package com.jenky.codebuddy;

import com.jenky.codebuddy.ui.fragments.EquipmentFragment;
import junit.framework.Assert;
import org.junit.Test;



public class IndexCycleTest {






    @Test
    public void indexValidation() {
            Assert.assertTrue(EquipmentFragment.changeIndex(30, 30, 1) == 0);
            Assert.assertTrue(EquipmentFragment.changeIndex(50, 78, 1) == 51);
            Assert.assertTrue(EquipmentFragment.changeIndex(0, 20, -1) == 19);
            Assert.assertTrue(EquipmentFragment.changeIndex(10, 57, -1) == 9);
    }
}