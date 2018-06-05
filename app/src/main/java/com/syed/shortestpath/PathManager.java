package com.syed.shortestpath;

import com.syed.shortestpath.model.Matrix;
import com.syed.shortestpath.model.Output;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by SyedAliAhmed on 5/27/2018.
 */

public class PathManager {
    private Output mOutput;
    private Matrix mMatrix;

    public PathManager(Matrix matrix) {
        mMatrix = matrix;
        mOutput = new Output();
    }

    /**
     *  1. pick the best index from previous column if it is not the first column
     *  2. keep track where it came from in a matrixTracker
     *  3. if one value in column is less than 50 still have a valid path
     *  4. continue the above process till the last column
     *
     *  Total cost finding:
     *      iterate through the last valid column to find the totalcost
     *
     *  Path finding:
     *      1. find last valid column and row.
     *      2. check the value where it came from and add it to the solution list.
     *      3. do the process until it reaches to the first column
     */

    public void calculatePath () {
        int[][] grid = mMatrix.getMatrix();
        boolean isPathPossible = false;
        int lastValidColumnIndex = -1;

        if (grid.length == 0) {
            return;
        }

        for (int i = 0; i < grid[0].length; i++) {
            isPathPossible = false;
            for (int j = 0; j < grid.length; j++) {
                if (i != 0) {
                    int minValueIndex = mMatrix.bestIndexToPickFromColumn(j, i);
                    grid[j][i] += grid[minValueIndex][i-1];
                    mMatrix.setMatrixTracker(j, i, minValueIndex);
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

        mMatrix.setLastValidColumnIndex(lastValidColumnIndex);
        mOutput.setPathPossible(isPathPossible);
        if (lastValidColumnIndex == -1)
            return;

        mOutput.setTotalCost(getTotalCost(grid));
        mOutput.setPath(getShortestPath(lastValidColumnIndex));
    }

    public int getTotalCost(int[][] grid) {
        int lastValidRow = 0;
        int totalCost = Integer.MAX_VALUE;
        int col = mMatrix.getLastValidColumnIndex();

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] < totalCost) {
                totalCost = grid[i][col];
                lastValidRow = i;
            }
        }

        mMatrix.setLastValidRowIndex(lastValidRow);
        return totalCost;
    }

    public List<Integer> getShortestPath(int lastValidColumnIndex) {
        int currentRowIndex =  mMatrix.getLastValidRowIndex();

        LinkedList<Integer> path = new LinkedList<>();
        path.add(currentRowIndex + 1);

        while (lastValidColumnIndex > 0) {
            path.addFirst(mMatrix.getMatrixTracker()[currentRowIndex][lastValidColumnIndex] + 1);
            currentRowIndex = mMatrix.getMatrixTracker()[currentRowIndex][lastValidColumnIndex--];
        }

        return path;
    }

    public Output getOutput() {
        return mOutput;
    }
}
