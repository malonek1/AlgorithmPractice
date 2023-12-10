package org.example.problems.subsequence;

public class LIS {
    // Given an integer array nums, return the length of the longest strictly increasing subsequence
    // A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
    public int longestSubsequence(int[] nums) {
        int longest = 0;
        if(nums != null || nums.length != 0) {
            int[] memo = new int[nums.length];
            for(int i = 0; i < nums.length; i++) {
                memo[i] = 1;
                for(int j = 0; j < i; j++) {
                    if(nums[j] < nums[i]) {
                        memo[i] = Math.max(memo[i], memo[j] + 1);
                        longest = Math.max(memo[i], longest);
                    }
                }
            }
        }
        return longest;
    }
}


