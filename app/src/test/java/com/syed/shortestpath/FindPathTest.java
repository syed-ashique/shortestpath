package com.syed.shortestpath;

import com.syed.shortestpath.model.Matrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by SyedAliAhmed on 5/28/2018.
 */

public class FindPathTest {

    @Test
    public void findPath_NormalFlow() {
        int[][] grid = new int[][]{
                {3, 4, 1, 2, 8, 6},
                {6, 1, 8, 2, 7, 4},
                {5, 9, 3, 9, 9, 5},
                {8, 4, 1, 3, 2, 6},
                {3, 7, 2, 8, 6, 4}
        };
        Matrix matrix = new Matrix(grid);

        Findpath findpath = new Findpath(matrix);
        findpath.calculatePath();

        Assert.assertEquals(findpath.isPathPossible(), true);
        Assert.assertEquals(findpath.getTotalCost(), 16);
        Assert.assertEquals(findpath.getPath(), Arrays.asList(1, 2, 3, 4, 4, 5));
    }

    @Test
    public void findPath_NormalFlow1() {
        int[][] grid = new int[][]{
                {3, 4, 1, 2, 8, 6},
                {6, 1, 8, 2, 7, 4},
                {5, 9, 3, 9, 9, 5},
                {8, 4, 1, 3, 2, 6},
                {3, 7, 2, 1, 2, 3}
        };
        Matrix matrix = new Matrix(grid);

        Findpath findpath = new Findpath(matrix);
        findpath.calculatePath();

        Assert.assertEquals(findpath.isPathPossible(), true);
        Assert.assertEquals(findpath.getTotalCost(), 11);
        Assert.assertEquals(findpath.getPath(), Arrays.asList(1, 2, 1, 5, 4, 5));
    }

    @Test
    public void findPath_NormalFlow_1X5() {
        int[][] grid = new int[][]{
                {5, 8, 5, 3, 5}
        };
        Matrix matrix = new Matrix(grid);

        Findpath findpath = new Findpath(matrix);
        findpath.calculatePath();

        Assert.assertEquals(findpath.isPathPossible(), true);
        Assert.assertEquals(findpath.getTotalCost(), 26);
        Assert.assertEquals(findpath.getPath(), Arrays.asList(1, 1, 1, 1, 1));
    }

    @Test
    public void findPath_NormalFlow_5X1() {
        int[][] grid = new int[][]{
                {5}, {8}, {5}, {3}, {5}
        };
        Matrix matrix = new Matrix(grid);

        Findpath findpath = new Findpath(matrix);
        findpath.calculatePath();

        Assert.assertEquals(findpath.isPathPossible(), true);
        Assert.assertEquals(findpath.getTotalCost(), 3);
        Assert.assertEquals(findpath.getPath(), Arrays.asList(4));
    }

    @Test
    public void findPathInputNoPath() {
        int[][] grid = new int[][]{
                {19, 10, 19, 10, 19},
                {21, 23, 20, 19, 12},
                {20, 12, 20, 11, 10}
        };
        Matrix matrix = new Matrix(grid);

        Findpath findpath = new Findpath(matrix);
        findpath.calculatePath();

        Assert.assertEquals(findpath.isPathPossible(), false);
        Assert.assertEquals(findpath.getTotalCost(), 48);
        Assert.assertEquals(findpath.getPath(), Arrays.asList(1, 1, 1));
    }


    @Test
    public void findPath_CostAbove50() {
        int[][] grid = new int[][]{
                {69, 10, 19, 10, 19},
                {51, 23, 20, 19, 12},
                {50, 12, 20, 11, 10}
        };
        Matrix matrix = new Matrix(grid);

        Findpath findpath = new Findpath(matrix);
        findpath.calculatePath();

        Assert.assertEquals(findpath.isPathPossible(), false);
        Assert.assertEquals(findpath.getTotalCost(), 0);
        Assert.assertEquals(findpath.getPath(), Arrays.asList());
    }

    @Test
    public void findPath_OneValueAbove50() {
        int[][] grid = new int[][]{
                {60, 3, 3, 6},
                {6, 3, 7, 9},
                {5, 6, 8, 3}
        };
        Matrix matrix = new Matrix(grid);

        Findpath findpath = new Findpath(matrix);
        findpath.calculatePath();

        Assert.assertEquals(findpath.isPathPossible(), true);
        Assert.assertEquals(findpath.getTotalCost(), 14);
        Assert.assertEquals(findpath.getPath(), Arrays.asList(3, 1, 1, 3));
    }

    @Test
    public void findPath_NegativeValue() {
        int[][] grid = new int[][]{
                {6, 3, -5, 9},
                {-5, 2, 4, 10},
                {3, -2, 6, 10},
                {6, -1, -2, 10}
        };
        Matrix matrix = new Matrix(grid);

        Findpath findpath = new Findpath(matrix);
        findpath.calculatePath();

        Assert.assertEquals(findpath.isPathPossible(), true);
        Assert.assertEquals(findpath.getTotalCost(), 0);
        Assert.assertEquals(findpath.getPath(), Arrays.asList(2, 3, 4, 1));
    }

    @Test
    public void findPath_CompletePathVsLowerCost() {
        int[][] grid = new int[][]{
                {51, 51},
                {0, 51},
                {51, 51},
                {5, 5}
        };
        Matrix matrix = new Matrix(grid);

        Findpath findpath = new Findpath(matrix);
        findpath.calculatePath();

        Assert.assertEquals(findpath.isPathPossible(), true);
        Assert.assertEquals(findpath.getTotalCost(), 10);
        Assert.assertEquals(findpath.getPath(), Arrays.asList(4, 4));
    }

    @Test
    public void findPath_InCompetePathShorterLowerCost() {
        int[][] grid = new int[][]{
                {51, 51, 51},
                {0, 51, 51},
                {51, 51, 51},
                {5, 5, 51}
        };
        Matrix matrix = new Matrix(grid);

        Findpath findpath = new Findpath(matrix);
        findpath.calculatePath();

        Assert.assertEquals(findpath.isPathPossible(), false);
        Assert.assertEquals(findpath.getTotalCost(), 10);
        Assert.assertEquals(findpath.getPath(), Arrays.asList(4, 4));
    }

    @Test
    public void findPath_longColumn() {
        int[][] grid = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        Matrix matrix = new Matrix(grid);

        Findpath findpath = new Findpath(matrix);
        findpath.calculatePath();

        Assert.assertEquals(findpath.isPathPossible(), true);
        Assert.assertEquals(findpath.getTotalCost(), 20);
        Assert.assertEquals(findpath.getPath(), Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
    }

    @Test
    public void findPath_EmptyMatrix() {
        int[][] grid = new int[][]{};

        Matrix matrix = new Matrix(grid);

        Findpath findpath = new Findpath(matrix);
        findpath.calculatePath();

        Assert.assertEquals(findpath.isPathPossible(), false);
        Assert.assertEquals(findpath.getTotalCost(), 0);
        Assert.assertEquals(findpath.getPath(), Arrays.asList());
    }
}
