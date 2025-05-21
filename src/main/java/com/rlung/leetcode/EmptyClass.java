package com.rlung.leetcode;

import java.util.Arrays;

public class EmptyClass {

    /**
     * 演算法實做寫在這裡
     * 例如這裡先用反轉陣列做示範
     */
    public int[] solution(int[] matrix) {
        int n = matrix.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = matrix[n - 1 - i];
        }
        return ans;
    }

    /**
     * 直接執行這個 main，就會跑上面的演算法
     */
    public static void main(String[] args) {
        EmptyClass solver = new EmptyClass();

        // 範例輸入
        int[] input = {1, 2, 3, 4, 5};
        System.out.println("Before: " + Arrays.toString(input));

        // 呼叫你的演算法
        int[] output = solver.solution(input);
        System.out.println("After : " + Arrays.toString(output));
    }
}
