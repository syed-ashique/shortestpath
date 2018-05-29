package com.syed.shortestpath.utility;

import com.syed.shortestpath.model.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SyedAliAhmed on 5/27/2018.
 */

public class Util {

    public static Matrix parseInput(String input) {

        List<String> rows = Arrays.asList(input.split("\n"));
        List<List<Integer>> grid = new ArrayList<>();

        int rowSize = 0;
        for (String row : rows) {
            List<String> stringRowsList = Arrays.asList(row.split(" "));
            if (rowSize == 0)
                rowSize = stringRowsList.size();
            if (stringRowsList.size() != rowSize) {
                throw new RuntimeException("All rows require same number of Integers.");
            }

            List<Integer> integerRowsList = new ArrayList<>();
            for (String value : stringRowsList) {
                try {
                    integerRowsList.add(Integer.parseInt(value));
                } catch (Exception e) {
                    throw new RuntimeException("Invalid matrix");
                }
            }
            grid.add(integerRowsList);
        }

        int[][] gridInt;
        if (grid.size() > 0) {
            gridInt = new int[grid.size()][grid.get(0).size()];
            for (int i=0; i<grid.size(); i++) {
                for (int j = 0; j< grid.get(0).size(); j++) {
                    gridInt[i][j] = grid.get(i).get(j);
                }
            }

            return new Matrix(gridInt);
        } else {
            return null;
        }
    }
}
