package com.jenky.codebuddy;

import com.jenky.codebuddy.models.Tower;
import junit.framework.Assert;
import org.junit.Test;

public class TowerHeightTest {



    int[] scores     = {689 , 5754, 5656, 4595,  988357,  986849,  94585685,  8372688,  952301,  3215,  784369,  987895};
    int[] highScores = {1455, 7642, 9483, 5920, 4789984, 5475677, 767896978, 90867070, 6799679, 35636, 1546478, 7675869};
    int[] heights    = {   6,   57,   56,   45,      49,      43,        29,       22,      33,    16,     120,      30};


    @Test
    public void calculateTowerHeight() {
        for(int i = 0; i < scores.length; i++){
            Assert.assertEquals(Tower.calculateHeight(scores[i], highScores[i]), heights[i]);
        }
    }
}