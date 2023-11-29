package org.example.algorithms;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class AlgorithmService {

    // Given a list of integers, write a function that returns the maximum number in the list. If the list is empty, return None.
    public int findMax(ArrayList<Integer> nums) {
        int max = 0;
        if (nums == null) {
            System.out.println("variable nums returns the following output: " + nums.toString());
        }
        else {
            for (int num: nums) {
                if (num > max) {
                    max = num;
                }
            }
        }
        return max;
    }


    public int minDeletions(String input) {
        ArrayList<Character> inputArray = new ArrayList<>();
        for(char c: input.toCharArray()) {
            if(inputArray.size() == 0) {
                inputArray.add(c);
            }
            else {
                for(int i = 0; i < inputArray.size() - 1; i++) {
                    if (inputArray.get(i).equals(c)) {
                        System.out.println(c + " already exists");
                    } else {
                        inputArray.add(c);
                    }
                }
            }
        }
        return inputArray.size();
    }

    // Given an integer array nums, return the length of the longest strictly increasing subsequence
    // A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int longestSequence = 1;
        for(int i = 0; i <nums.length; i++){
            dp[i] = 1;
            for(int k = 0; k < i; k++) {
                if(nums[k] < nums[i]) {
                    //Checks the dp array to see if the next index sequenced up
                    //Ex) in dp array: [1,1,1,2,2,3,4,4] anytime there is a repeating number it means there was not a sequence of increasing numbers
                    //Nums array for this example would be [10,9,2,5,3,7,101,18]: Notice everytime the sequence is broken, the dp array has the same value in the same index
                    //Also note that dp array will always have increasing index values left to right
                    dp[i] = Math.max(dp[i], dp[k] + 1);
                    longestSequence=Math.max(dp[i], longestSequence);
                }
            }
        }
        return longestSequence;

//        int largestSequence = 0;
//        int sequence = 0;
//        int next = 0;
//        List<Integer> numArray = Arrays.stream(nums).boxed().toList();
//        if (numArray != null) {
//            for (int i = 0; i < numArray.size(); i++) {
//                System.out.println(sequence);
//                if (largestSequence < sequence) {
//                    largestSequence = sequence;
//                }
//                sequence = 0;
//                for (int k = i; k < numArray.size() - 1; k++) {
//                    next = k + 1;
//                    if (numArray.get(next) > numArray.get(k)) {
//                        sequence ++;
//                    }
//                    else {
//                        sequence = 0;
//                    }
//                }
//            }
//        }
//        return largestSequence;
    }

    public int[][] construct2DArray(int[] original, int m, int n) {

        if (original.length != m * n) return new int[0][0];

        int[][] box = new int[m][n];
        int boxIndex = 0;

        for(int i = 0; i < m; ++i) {
            for(int k = 0; k < n; ++k) {
                box[i][k] = original[boxIndex++];
            }
        }
        return box;
    }

    //This commented out solution results in the following error:
    //java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1

//    int[][] box = new int[m][n];
//    int boxIndex = 0;
//
//        if (original != null) {
//        if(m + n > 2) {
//            for(int i = 0; i < m; ++i) {
//                for(int k = 0; k < n; ++k) {
//                    box[i][k] = original[boxIndex++];
//                }
//            }
//        }
//        else return new int[][]{};
//    }
//        return box;

    public int[] construct1DArray(int[][] original) {

        if(original == null) return new int[0];

        int[] ans = new int[original.length * original[original.length - 1].length];
        int index = 0;

        for(int i = 0; i < original.length; i++) {
            for(int k = 0; k < original[i].length; k++){
                ans[index++] = original[i][k];
            }
        }
        return ans;
    }

    public boolean isPalindrome(int x) {
        String rev = "";
        char[] charArray = Integer.toString(x).toCharArray();
        for(int i = charArray.length - 1; i >= 0; i --) {
            rev += charArray[i];
        }
        if(rev.equals(Integer.toString(x))) return true;

        return false;
    }

    public String threeSumClosest(int[] nums, int target) {
        int closest = 0;
        int index = 0;
        int[] comb = new int[3];
        for(int i = 0; i < nums.length; i ++) {
            for(int k = i + 1; k < nums.length; k++) {
                for(int j = k + 1; j < nums.length; j++) {
                    if(0 == index++) {
                        closest = nums[i] + nums[k] + nums[j];
                        comb[0] = nums[i];
                        comb[1] = nums[k];
                        comb[2] = nums[j];
                    }
                    if(Math.abs(target - closest) > Math.abs(target - (nums[i] + nums[k] + nums[j]))) {
                        closest = nums[i] + nums[k] + nums[j];
                        comb[0] = nums[i];
                        comb[1] = nums[k];
                        comb[2] = nums[j];
                    }
                }
            }
        }
        return closest + " is the closest sum to target: " + target + " by combining the following 3 numbers: " + comb[0] + ", " + comb[1] + ", " + comb[2];
    }

    public String stringCharCount(String str, char character, int count) {
        if(count == 0) {
            return str;
        }
        String ans = "Empty String";
        int index = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == character) {
                index++;
                if(index == count && i < str.length() - 1) {
                    ans = str.substring(i + 1);
                }
            }
        }
        return ans;
    }

    public void fizzbuzz() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0,"Buzz");
        map.put(3,"Fizz");
        for(int i = 1; i < 101; i++) {
            if(map.containsKey(i % 5)) {
                System.out.println(map.get(i % 5));
            }
            else {
                System.out.println(i);
            }
        }

//        for(int i = 0; i < 101; i++) {
//            if(i == 0) {
//                System.out.println(i);
//            }
//            else if(i % 3 == 0 && i % 5 == 0) {
//                System.out.println("FizzBuzz");
//            }
//            else if(i % 3 == 0) {
//                System.out.println("Fizz");
//            }
//            else if(i % 5 == 0) {
//                System.out.println("Buzz");
//            }
//            else {
//                System.out.println(i);
//            }
//        }
    }

    public String armstrong(int input) {
        String eval = Integer.toString(input);
        double total = 0;
        for(int i = 0; i < eval.length(); i++) {
            total += Math.pow(Integer.parseInt(Character.toString(eval.charAt(i))), eval.length());
        }
        if(input == total) {
            return "Yes, " + input + " is an armstrong number";
        }
        return "No, " + input + " is not an armstrong number";
    }

    public int repeatingInt(int[] numbers) {
        //dynamic memoization approach:
        ArrayList<Integer> numList = new ArrayList<>();
        for(int num: numbers) {
            if(numList.contains(num)) {
                return num;
            }
            else {
                numList.add(num);
            }
        }
        return 0;

        //brute force approach:
//        for(int i = 0; i < numbers.length; i++) {
//            if(i != numbers.length - 1) {
//                for (int j = i + 1; j < numbers.length; j++) {
//                    if (numbers[i] == numbers[j]) {
//                        return numbers[i];
//                    }
//                }
//            }
//        }
//        return 0;
    }

    public boolean isUnique(String str) {
        //brute force solution (without data structures):
//        char[] charArray = str.toCharArray();
//        for(int i = 0; i < charArray.length; i ++) {
//            for(int j = i + 1; j < charArray.length; j ++) {
//                if(charArray[i] == charArray[j]) {
//                    return false;
//                }
//            }
//        }
//        return true;

        //optimal solution (with data structures):
        char[] charArray = str.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch: charArray) {
            if(map.containsKey(ch)) {
                return false;
            }
            else {
                map.put(ch, 1);
            }
        }
        return true;
    }

    public int countFrequency(String str, Character freq) {
        char[] charArray = str.toLowerCase().toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch: charArray) {
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }
            else {
                map.put(ch, 1);
            }
        }
        return map.get(freq);
    }

    public boolean isAnagram(String input1, String input2) {
        HashMap<Character,Integer> map = new HashMap<>();
        calcFreq(input1, map);
        calcFreq(input2, map);
        for(char ch: map.keySet()) {
            if(map.get(ch) % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPermutation(String input1, String input2) {
        HashMap<Character,Integer> map = new HashMap<>();
        calcFreq(input1, map);
        return calcFreq(input2, map);
    }

    public boolean calcFreq(String input, HashMap<Character,Integer> map) {
        boolean permutation = true;
        int counter = 0;
        char[] inputArray = input.toCharArray();
        if(map != null) {
            counter++;
        }
        for(char ch: inputArray) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
                if(counter > 0) {
                    permutation = false;
                }
            }
        }
        return permutation;
    }
}
