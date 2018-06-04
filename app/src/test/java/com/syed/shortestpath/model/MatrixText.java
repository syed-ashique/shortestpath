package com.syed.shortestpath.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by SyedAliAhmed on 5/28/2018.
 */

public class MatrixText {

    int[][] grid = new int[][] {
            {3, 4, 1, 2, 8, 6},
            {6, 1, 8, 2, 7, 4},
            {5, 9, 3, 9, 9, 5},
            {8, 4, 1, 3, 2, 6},
            {3, 7, 2, 8, 6, 4}
    };
    Matrix matrix;

    @Before
    public void preSetup() {
        matrix = new Matrix(grid);
    }


    @Test
    public void bestIndexToPick_TakingTopDiagnalValue() {
        Assert.assertEquals(matrix.bestIndexToPickFromColumn(1, 1), 0);
    }

    @Test
    public void bestIndexToPick_TretingBottomOneAsTopDiagnalValue() {
        Assert.assertEquals(matrix.bestIndexToPickFromColumn(0, 1), 4);
    }

    @Test
    public void bestIndexToPick_TakingBottomDiagonalValue() {
        Assert.assertEquals(matrix.bestIndexToPickFromColumn(2, 3), 3);
    }

    @Test
    public void bestIndexToPick_TreatingTopOneAsBottomDiagonalValue() {
        Assert.assertEquals(matrix.bestIndexToPickFromColumn(4, 4), 0);
    }

    @Test
    public void bestIndexToPick_TakingLeftValue() {
        Assert.assertEquals(matrix.bestIndexToPickFromColumn(2, 1), 2);
    }

    @Test
    public void isValidMatrix() {
        Matrix matrix = new Matrix(false);
        Assert.assertEquals(matrix.isValidMatrix(), false);
    }
}
