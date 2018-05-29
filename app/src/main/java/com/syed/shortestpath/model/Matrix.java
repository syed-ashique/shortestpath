package com.syed.shortestpath.model;

import android.text.TextUtils;

/**
 * Created by SyedAliAhmed on 5/27/2018.
 */

public class Matrix {
    private int[][] matrix;
    private int[][] matrixTracker;

    public Matrix(int[][] matrix){
        this.matrix = matrix;
        if (matrix.length > 0) {
            matrixTracker = new int[matrix.length][matrix[0].length + 1];
        }
    }

    public int bestIndexToPickFromColumn(int row, int col) {
        int x = matrix[(row-1<0)?matrix.length-1:row-1][col-1];
        int y = matrix[row][col-1];
        int z = matrix[(row+1>matrix.length-1)?0:row+1][col-1];

        if (x<=y && x<=z) {
            return (row-1<0)?matrix.length-1:row-1;
        } else if (y<=x && y<=z) {
            return row;
        } else {
            return (row+1>matrix.length-1)?0:row+1;
        }
    }

    public boolean isValidMatrix(String [][] matrixString) {
        for (int i=0; i<matrixString.length; i++) {
            if (matrixString.length > 0) {
                for (int j = 0; j < matrixString[0].length; j++) {
                    if (!TextUtils.isDigitsOnly(matrixString[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrixTracker (int i, int j, int prevBestIndex) {
        matrixTracker[i][j] = prevBestIndex;
    }

    public int[][] getMatrixTracker(){
        return matrixTracker;
    }
}
