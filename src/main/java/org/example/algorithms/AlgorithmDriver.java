package org.example.algorithms;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmDriver {
    public static void main(String[] args) {
        AlgorithmService service = new AlgorithmService();
        //System.out.println(service.isUnique("here"));
        //System.out.println(service.countFrequency("AaaaaaAAAAAAaa",'a'));
        //System.out.println(service.isPermutation("hello","hell"));
//        String [] word1 = {"a", "cb"};
//        String [] word2 = {"ab", "c"};
//        System.out.println(service.isEqual(word1, word2));
//        int[] list = {10,9,2,5,3,7,101,18};
//        System.out.println(service.lengthOfLIS(list));
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(1);
//        list.add(3);
//        list.add(2);
//
//        int[] arr = {1,2,2,3,1};
//        //System.out.println("Size of largest degree " + service.findShortestSubArrayList(list));
//        System.out.println("Size of shortest contiguous subarray: " + service.findShortestSubArray(arr));

        //service.findComplement(5);
        //System.out.print(5 & 6);
        //int[] arr = {2,5,6,5,2,7,6};
        //System.out.print(service.getSingleOcc(arr));
        //System.out.print(5 ^ 5 ^ 2 ^ 3 ^ 3 ^ 4);
        //service.swapNums(5,7);

//        int[][] points = {{1,1},{3,4},{-1,6}};
//        System.out.print(service.minTimeToVisitAllPoints(points));
//
//        String input = "hello";
//        System.out.print(input.contains("hell"));

        //System.out.println(service.largestGoodIntegerr("6777133339"));
        //System.out.println("777".compareTo("111"));
        int[] nums = {1,2,3,1,5,3,4,8,2,4,7};
//        System.out.print(service.lengthOfLIS(nums));

        //System.out.println(service.totalMoney(10));

        //System.out.println(service.maxSubsequence(nums, 3));

        for(int num: service.maxxSubsequence(nums, 3)) {
            System.out.println(num);
        }

//        for(int num: service.maxSubarray(nums, 3)) {
//            System.out.println(num);
//        }
    }
}
