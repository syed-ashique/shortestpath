package com.syed.shortestpath.utility;

import org.junit.Assert;
import org.junit.Test;

public class UtilTest {

    @Test
    public void parseInput() {
        String input = "51 51 51\n0 51 51\n51 51 51\n5 5 51";
        int[][] grid= new int[][]{
                {51, 51, 51},
                {0, 51, 51},
                {51, 51, 51},
                {5, 5, 51}
        };

        Assert.assertEquals(Util.parseInput(input).getMatrix(),grid);
    }
}
