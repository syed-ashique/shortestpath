package com.syed.shortestpath.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by SyedAliAhmed on 5/28/2018.
 */

public class OutputTest {

    @Test
    public void getPathTest() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Output output = new Output();
        output.setPath(list);

        Assert.assertEquals(output.getPath(), list);
    }

    @Test
    public void getPathTest_EmptyTest() {
        List<Integer> list = Arrays.asList();
        Output output = new Output();
        output.setPath(list);

        Assert.assertEquals(output.getPath(), list);
    }

    @Test
    public void getTotalCostTest() {
        int cost = 10;
        Output output = new Output();
        output.setTotalCost(cost);

        Assert.assertEquals(output.getTotalCost(), cost);
    }

    @Test
    public void getTotalCostTest_NegativeCost() {
        int cost = -1;
        Output output = new Output();
        output.setTotalCost(cost);

        Assert.assertEquals(output.getTotalCost(), 0);
    }

    @Test
    public void isPathPossibleTest_PossitiveCase() {
        boolean pathPossible = true;
        Output output = new Output();
        output.setPathPossible(pathPossible);

        Assert.assertEquals(output.isPathPossible(), pathPossible);
    }

    @Test
    public void isPathPossibleTest_NegetiveCase() {
        boolean pathPossible = false;
        Output output = new Output();
        output.setPathPossible(pathPossible);

        Assert.assertEquals(output.isPathPossible(), pathPossible);
    }

}
