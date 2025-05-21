package com.rlung.leetcode.array;


import java.util.*;

public class SetMatrixZeroes_0073 {

    public void setZeroes(int[][] matrix) {

        ArrayList<Integer> listOfy = new ArrayList<>();
        Set<Integer> setOfx = new HashSet<>();

        int m = matrix.length, n =matrix[0].length;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    setOfx.add(i);
                    listOfy.add(j);
                }
            }
        }

        for(int i = 0; i<n; i++){
            for(int j : setOfx){
                matrix[j][i] = 0;
            }
        }

        for(int i =0; i<m; i++){
            for(int y:listOfy){
                matrix[i][y]=0;
            }
        }

    }


    public static void main(String[] args) {
        SetMatrixZeroes_0073 solver = new SetMatrixZeroes_0073();
        /*

         Given an m x n integer matrix , if an element is 0, set its entire row and column to 0's.
         This Quiz actually request that 「You must do it in place.」

         */
        

        int[][] input = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        //預期Output: [[1,0,1],[0,0,0],[1,0,1]]
        System.out.println("Before:\n" + Arrays.deepToString(input));

        solver.setZeroes(input);
        System.out.println("After :\n" + Arrays.deepToString(input));
    }
}
