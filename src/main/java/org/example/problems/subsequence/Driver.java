package org.example.problems.subsequence;

import org.example.algorithms.AlgorithmService;

public class Driver {
    public static void main(String[] args) {
        LIS lis = new LIS();
        int[] input = {10,9,2,5,3,7,101,18};;
        System.out.println(lis.longestSubsequence(input));
    }
}