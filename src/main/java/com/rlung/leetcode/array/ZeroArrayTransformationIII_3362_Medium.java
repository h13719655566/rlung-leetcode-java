package com.rlung.leetcode.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
*
* 未解決 這題Fail
* 3362. Zero Array Transformation III
*Wrong Answer
698 / 824 testcases passed
* */
public class ZeroArrayTransformationIII_3362 {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int Q = queries.length;

        // 如果連全部 query 都用上都做不到 Zero Array，就直接 -1
        if (!check(0, nums, queries)) return -1;

        // 在 [0..Q] 上二分搜尋「最大可移除的 k」
        int lo = 0, hi = Q;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;          // 嘗試移除 mid 張
            if (check(mid, nums, queries)) {
                lo = mid + 1;                   // 可行 → 嘗試更多
            } else {
                hi = mid - 1;                   // 不行 → 少移
            }
        }
        return hi;
    }


    private boolean check(int k, int[] nums, int[][] queries) {
        int n = nums.length;
        int Q = queries.length;
        int keep = Q - k;                       // 要保留的 query 條數
        int[] cover = new int[n + 1];

        // 1. 在所有 query 裡，依「interval sum」動態排序，取前 keep 條
        List<Integer> best = IntStream.range(0, Q)
                .boxed()
                .sorted((i, j) -> intervalSum(nums, queries[j])
                        - intervalSum(nums, queries[i]))
                .limit(keep)
                .collect(Collectors.toList());

        // 2. 對這 keep 條 query 做差分標記
        for (int idx : best) {
            int l = queries[idx][0];
            int r = queries[idx][1];
            cover[l] += 1;
            if (r + 1 < cover.length) {
                cover[r + 1] -= 1;
            }
        }
        // 前綴和，得到每個位置 i 最終被扣的次數
        for (int i = 1; i < n; i++) {
            cover[i] += cover[i - 1];
        }
        // 3. 驗證
        for (int i = 0; i < n; i++) {
            if (cover[i] < nums[i]) return false;
        }
        return true;
    }

    private int intervalSum(int[] nums, int[] q) {
        int s = 0;
        for (int i = q[0]; i <= q[1]; i++) s += nums[i];
        return s;
    }

    public static void main(String[] args) {
        ZeroArrayTransformationIII_3362 solver = new ZeroArrayTransformationIII_3362();

        //case 1
        int[] nums = {2, 0, 2};
        int[][] queries = {
                {0, 2},
                {0, 2},
                {1, 1}
        };

        //case 2
//        int[] nums = {2, 1, 3};
//        int[][] queries = {
//                {0, 1},
//                {1, 2},
//        };

        //case 3
//        int[] nums = {1, 2, 3, 4};
//        int[][] queries = {
//                {0, 3}
//        };

        //case 55
//        int[] nums = {0, 3};
//        int[][] queries = {
//                {0, 1},
//                {0, 0},
//                {0, 1},
//                {0, 1},
//                {0, 0}
//        };
        System.out.println("Before:\n" + Arrays.toString(nums));
        System.out.println("OUTPUT=" + solver.maxRemoval(nums, queries));

        System.out.println("after:\n" + Arrays.toString(nums));


    }
}
