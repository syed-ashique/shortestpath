package com.syed.shortestpath.model;

/**
 * Created by SyedAliAhmed on 5/27/2018.
 */

public class Matrix {
    private int[][] mMatrix;
    private int[][] mMatrixTracker;
    private boolean mIsValidMatrix;
    private int mLastValidColumnIndex;
    private int mLastValidRowIndex;

    public int getLastValidColumnIndex() {
        return mLastValidColumnIndex;
    }

    public void setLastValidColumnIndex(int lastValidColumnIndex) {
        this.mLastValidColumnIndex = lastValidColumnIndex;
    }

    public int getLastValidRowIndex() {
        return mLastValidRowIndex;
    }

    public void setLastValidRowIndex(int lastValidRowIndex) {
        this.mLastValidRowIndex = lastValidRowIndex;
    }

    public Matrix(boolean isValidMatrix) {
        this.mIsValidMatrix = isValidMatrix;
    }

    public Matrix(int[][] matrix){
        this.mMatrix = matrix;
        if (matrix.length > 0) {
            mIsValidMatrix = true;
            mMatrixTracker = new int[matrix.length][matrix[0].length + 1];
        }
    }

    public int bestIndexToPickFromColumn(int row, int col) {
        int x = mMatrix[(row-1<0)? mMatrix.length-1:row-1][col-1];
        int y = mMatrix[row][col-1];
        int z = mMatrix[(row+1> mMatrix.length-1)?0:row+1][col-1];

        if (x<=y && x<=z) {
            return (row-1<0)? mMatrix.length-1:row-1;
        } else if (y<=x && y<=z) {
            return row;
        } else {
            return (row+1> mMatrix.length-1)?0:row+1;
        }
    }

    public boolean isValidMatrix() {
        return mIsValidMatrix;
    }

    public int[][] getMatrix() {
        return mMatrix;
    }

    public void setMatrixTracker (int i, int j, int prevBestIndex) {
        mMatrixTracker[i][j] = prevBestIndex;
    }

    public int[][] getMatrixTracker(){
        return mMatrixTracker;
    }
}
