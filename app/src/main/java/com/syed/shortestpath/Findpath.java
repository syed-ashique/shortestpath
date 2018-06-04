package com.syed.shortestpath;

import com.syed.shortestpath.model.Matrix;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by SyedAliAhmed on 5/27/2018.
 */

public class Findpath {
    private boolean mIsPathPossible;
    private List<Integer> mPath;
    private int mTotalCost;
    private Matrix mMatrix;

    public Findpath(Matrix matrix) {
        mMatrix = matrix;
        mPath = new LinkedList<>();
    }

    /**
     *  1. pick the best index from previous column if it is not the first column
     *  2. keep track where it came from in a different matrix
     *  3. if one value in column is less than 50 still have a valid path
     *  4. continue the above process till the last column
     *
     *  Total cost finding:
     *      iterate through the last valid column to find the totalcost
     *
     *  Path finding:
     *      1. find the lowest value from the last valid column.
     *      2. check the value where it came from and add it to the queue.
     *      3. do the process until it reaches to the first column
     */

    public void calculatePath () {
        int[][] grid = mMatrix.getMatrix();
        int lastValidColumnIndex = -1;

        if (grid.length == 0) {
            return;
        }

        for (int i = 0; i < grid[0].length; i++) {
            mIsPathPossible = false;
            for (int j = 0; j < grid.length; j++) {
                if (i != 0) {
                    int minValueIndex = mMatrix.bestIndexToPickFromColumn(j, i);
                    grid[j][i] += grid[minValueIndex][i-1];
                    mMatrix.setMatrixTracker(j, i, minValueIndex);
                }

                if (grid[j][i] < 50) {
                    lastValidColumnIndex = i;
                    mIsPathPossible = true;
                }
            }
            if (!mIsPathPossible) {
                break;
            }
        }

        if (lastValidColumnIndex == -1)
            return;

        //find total cost
        mTotalCost = Integer.MAX_VALUE;
        int currentRowIndex = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][lastValidColumnIndex] < mTotalCost) {
                mTotalCost = grid[i][lastValidColumnIndex];
                currentRowIndex = i;
            }
        }

        //find the path
        generateShortestPath(lastValidColumnIndex, currentRowIndex);
    }

    public void generateShortestPath(int lastValidColumnIndex, int currentRowIndex) {
        mPath.add(currentRowIndex + 1);
        while (lastValidColumnIndex > 0) {
            ((LinkedList) mPath).addFirst(mMatrix.getMatrixTracker()[currentRowIndex][lastValidColumnIndex] + 1);
            currentRowIndex = mMatrix.getMatrixTracker()[currentRowIndex][lastValidColumnIndex--];
        }
    }

    public boolean isPathPossible() {
        return mIsPathPossible;
    }

    public List<Integer> getPath() {
        return mPath;
    }

    public int getTotalCost() {
        if (mTotalCost < 0 )
            return 0;
        return mTotalCost;
    }
}
