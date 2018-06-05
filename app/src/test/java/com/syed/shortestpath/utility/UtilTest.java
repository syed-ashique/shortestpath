package com.syed.shortestpath.utility;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void convertListToArrayTest() {
        List<List<Integer>> listOfList = new ArrayList();
        listOfList.add(Arrays.asList(3,4));
        listOfList.add(Arrays.asList(1,2));

        int [][] grid = new int[][] {
                {3,4},
                {1,2}
        };

        Assert.assertEquals(Util.convertListToArray(listOfList), grid);
    }
}
