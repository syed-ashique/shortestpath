package com.syed.shortestpath;

import com.syed.shortestpath.model.Matrix;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by SyedAliAhmed on 5/27/2018.
 */

public class Findpath {
    private boolean isPathPossible;
    private List<Integer> path;
    private int totalCost;
    private Matrix matrix;

    public Findpath(Matrix matrix) {
        this.matrix = matrix;
    }

    public void calculatePath () {
        path = new LinkedList<>();
        int[][] grid = matrix.getMatrix();
        int[][] gridTracker = matrix.getMatrixTracker();
        int lastValidColumnIndex = -1;

        for (int i = 0; i < grid[0].length; i++) {
            isPathPossible = false;
            for (int j = 0; j < grid.length; j++) {
                if (i != 0) {
                    int minValueIndex = matrix.bestIndexToPickFromColumn(j, i);
                    grid[j][i] += grid[minValueIndex][i-1];
                    matrix.setMatrixTracker(j, i, minValueIndex);
                }

                if (grid[j][i] < 50) {
                    lastValidColumnIndex = i;
                    isPathPossible = true;
                }
            }
            if (!isPathPossible) {
                break;
            }
        }

        if (lastValidColumnIndex == -1)
            return;

        totalCost = Integer.MAX_VALUE;
        int currentRowIndex = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][lastValidColumnIndex] < totalCost) {
                totalCost = grid[i][lastValidColumnIndex];
                currentRowIndex = i;
            }
        }


        generateShortestPath(lastValidColumnIndex, currentRowIndex);
    }

    public void generateShortestPath(int lastValidColumnIndex, int currentRowIndex) {

        path.add(currentRowIndex + 1);
        while (lastValidColumnIndex > 0) {
            ((LinkedList)path).addFirst(matrix.getMatrixTracker()[currentRowIndex][lastValidColumnIndex] + 1);
            currentRowIndex = matrix.getMatrixTracker()[currentRowIndex][lastValidColumnIndex--];
        }
    }

    public boolean isPathPossible () {
        return isPathPossible;
    }

    public List<Integer> getPath() {
        return path;
    }

    public int getTotalCost() {
        if (totalCost < 0 )
            return 0;
        return totalCost;
    }
}
