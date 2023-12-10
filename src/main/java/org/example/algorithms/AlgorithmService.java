package org.example.algorithms;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlgorithmService {

    // Given a list of integers, write a function that returns the maximum number in the list. If the list is empty, return None.
    public int findMax(ArrayList<Integer> nums) {
        int max = nums.get(0);
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

    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i ++) {
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }
                if (sum < target) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        return closest;


        //        int closest = 0;
//        int index = 0;
//        int[] comb = new int[3];
//        for(int i = 0; i < nums.length; i ++) {
//            for(int k = i + 1; k < nums.length; k++) {
//                for(int j = k + 1; j < nums.length; j++) {
//                    if(0 == index++) {
//                        closest = nums[i] + nums[k] + nums[j];
//                        comb[0] = nums[i];
//                        comb[1] = nums[k];
//                        comb[2] = nums[j];
//                    }
//                    if(Math.abs(target - closest) > Math.abs(target - (nums[i] + nums[k] + nums[j]))) {
//                        closest = nums[i] + nums[k] + nums[j];
//                        comb[0] = nums[i];
//                        comb[1] = nums[k];
//                        comb[2] = nums[j];
//                    }
//                }
//            }
//        }
//        return closest + " is the closest sum to target: " + target + " by combining the following 3 numbers: " + comb[0] + ", " + comb[1] + ", " + comb[2];
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

    public boolean isEqual(String[] word1, String[] word2) {
        Arrays.sort(word1);
        String word1result = "";
        String word2result = "";
        for(int i = 0; i < word1.length; i++) {
            word1result += word1[i];
        }
        for(int j = 0; j < word2.length; j++) {
            word2result += word2[j];
        }
        if(word1result.equals(word2result)) {
            return true;
        }
        return false;
    }

    public int findDegree(List<Integer> arr) {
        if(arr == null || arr.size() == 0) {
            return 0;
        }
        int degree = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: arr) {
            if(!map.containsValue(num)) {
                map.put(num, 1);
            }
            else {
                map.put(num, map.get(num) + 1);
                degree = Math.max(map.get(num), degree);
            }
        }
//        System.out.println("Length of shortest subarray: " + findSubArray(arr, map, degree));
//        System.out.println(map);
        return degree;
    }

    public int findSubArray(List<Integer> arr, HashMap<Integer, Integer> map, int degree) {
        int shortest = arr.size();
        int index = arr.size();
        ArrayList<Integer> dp = new ArrayList<>();
        while(index != 0) {
            for (int num: arr) {
                if (map.get(arr.get(num)) == degree) {
                    dp.add(map.get(arr.get(num)));
                }
                index --;
            }
            shortest = Math.min(shortest, dp.size());
            dp.clear();
        }
        return shortest;
    }

    public int findShortestSubArrayList(List<Integer> arr) {
        if(arr == null || arr.size() == 0) {
            return 0;
        }
        int degree = 0;
        int shortest = arr.size();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: arr) {
            if(!map.containsKey(num)) {
                map.put(num, 1);
            }
            else {
                map.put(num, map.get(num) + 1);
                degree = Math.max(map.get(num), degree);
            }
        }
        for (int num: arr) {
            if (map.get(arr.get(num)) == degree) {
                int number = map.get(arr.get(num));
                if(shortest > 2) {
                    shortest--;
                }
                else {
                    return 2;
                }
            }
        }
        return shortest;
    }

    public int findShortestSubArray(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        int degree = 0;
        int shortest = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: arr) {
            if(!map.containsKey(num)) {
                map.put(num, 1);
            }
            else {
                map.put(num, map.get(num) + 1);
                degree = Math.max(map.get(num), degree);
            }
        }
        for (int i = 0; i < arr.length; i ++) {
            if (map.get(arr[i]) == degree) {
                int number = map.get(arr[i]);
                if(shortest > 2) {
                    shortest--;
                }
                else {
                    return 2;
                }
            }
        }
        return shortest;
    }

    public int findComplement(int num) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int index = 0;
        while(1 < 2) {
            if(index == 0) {
                map.put(index, 1);
            }
            else {
                map.put(index, map.get(index - 1) * 2);
            }
            if(map.get(index) > num) {
                break;
            }
            index++;
        }
        String binary = getBinary(num, map);
        //System.out.println(map);
        System.out.println("The binary version of " + num + " is: " + binary);

        int compIndex = map.size() - 2;
        int compValue = 0;
        String compBinary = "";
        char[] binaryArray = binary.toCharArray();
        for(char b: binaryArray) {
            if(b == '0') {
                compValue = compValue + map.get(compIndex);
                compBinary = compBinary + '1';
                compIndex--;
            }
            else {
                compBinary = compBinary + '0';
                compIndex--;
            }
        }
        System.out.println("The binary complement of " + binary + " is: " + compBinary);
        System.out.println("The number complement of " + num + " is: " + compValue);
        return compValue;
    }

    public String getBinary(int num, HashMap<Integer, Integer> map) {
        String binary = "";
        int temp = 0;
        for(int i = map.size() - 1; i >= 0; i--) {
            if(temp + map.get(i) <= num) {
                temp = temp + map.get(i);
                binary = binary + "1";
            }
            else {
                if(i != map.size() -1) {
                    binary = binary + "0";
                }
            }
            //System.out.println(map.get(i));
        }
        return binary;
    }

    public int getSingleOcc(int[] arr) {
        //This will return the odd integer out because in a xor operand,
        //any even occurring number in the array will be cancelled out and only the odd number (single occurrance)
        //will remain in the output
        int xor = 0;
        for(int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }
        return xor;
    }

    public void swapNums(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = " + a + "\nb = " + b);
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int totalSeconds = 0;
        for(int i = 0; i < points.length - 1; i++) {
            int[] currentPoint = points[i];
            int[] nextPoint = points[i + 1];

            int xDiff = Math.abs(nextPoint[0] - currentPoint[0]);
            int yDiff = Math.abs(nextPoint[1] - currentPoint[1]);

            System.out.println("x Diff: " + xDiff);
            System.out.println("y Diff: " + yDiff);

            int maxDiff = Math.max(xDiff, yDiff);
            System.out.println("Max Diff: " + maxDiff);
            totalSeconds = totalSeconds + maxDiff;
        }
        return totalSeconds;
    }

    public String largestGoodInteger(String num) {
        if(num == "" || num == null) {
            return num;
        }
        int maxNumber = 0;
        boolean found = false;
        char[] numArray = num.toCharArray();
        int index = 1;
        for(int i = 0; i < numArray.length - 1; i++) {
            if(numArray[i] == (numArray[i + 1])) {
                index++;
                if(index == 3) {
                    found = true;
                    maxNumber = Math.max(Integer.parseInt(String.valueOf(numArray[i])), maxNumber);
                    index = 1;
                }
            }
            else {
                index = 1;
            }
        }
        if(found == false) {
            return "";
        }
        return maxNumber + "" + maxNumber + "" + maxNumber;
    }

    public String largestGoodIntegerr(String num)
    {
        String ans = "";
        for(int i = 2; i < num.length(); i++)
            if(num.charAt(i) == num.charAt(i-1) && num.charAt(i-1) == num.charAt(i-2))
                if(num.substring(i-2,i+1).compareTo(ans) > 0) // Check if the new one is larger
                    ans = num.substring(i-2,i+1);
        return ans;
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        int[] matched = new int[arr1.length];
        int[] unmatched = new int[arr1.length];
        int matchIndex = 0;
        for(int arr2Num: arr2) {
            for(int i = 0; i < arr1.length; i++) {
                if(arr2Num == arr1[i]) {
                    matched[matchIndex] = arr1[i];
                    arr1[i] = -1;
                    matchIndex++;
                }
            }
        }
        for(int num: arr1) {
            System.out.println(num);
            if(num != -1) {
                matched[matchIndex] = num;
                matchIndex++;
            }
        }
        return matched;
    }

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length < 2)
            return nums[0];

        int[] startFromFirstHouse = new int[nums.length + 1];
        int[] startFromSecondHouse = new int[nums.length + 1];

        startFromFirstHouse[0]  = 0;
        startFromFirstHouse[1]  = nums[0];
        startFromSecondHouse[0] = 0;
        startFromSecondHouse[1] = 0;

        for (int i = 2; i <= nums.length; i++) {
            startFromFirstHouse[i] = Math.max(startFromFirstHouse[i - 1], startFromFirstHouse[i - 2] + nums[i-1]);
            startFromSecondHouse[i] = Math.max(startFromSecondHouse[i - 1], startFromSecondHouse[i - 2] + nums[i-1]);
        }

        return Math.max(startFromFirstHouse[nums.length - 1], startFromSecondHouse[nums.length]);
    }

    public int robb(int[] nums) {
        // If we get invalid input, return 0
        if (nums == null || nums.length == 0) return 0;

        // Keep track of whether or not we robbed the previous house
        int robbedPrevious = 0;
        int didNotRobPrevious = 0;

        for (int i = 0; i < nums.length; i++) {

            // If we don't rob the current house, take the max of robbing and not robbing the previous house
            int currentNotRobbed = Math.max(robbedPrevious, didNotRobPrevious);

            // If we rob the current house, add the current money robbed to what we got from not robbing previous
            int currentIsRobbed = didNotRobPrevious + nums[i];

            // Update our values for the next iteration
            didNotRobPrevious = currentNotRobbed;
            robbedPrevious = currentIsRobbed;
        }

        // Return the maximum we could have robbed provided we looked at both options
        return Math.max(robbedPrevious, didNotRobPrevious);
    }

    public int totalMoney(int n) {
        int totalMoney = 0;
        int weekCount = 1;
        if(n == 0) {
            return n;
        }
        for(int i = 0; i < n; i++) {
            int dailyMoney = (i % 7) + weekCount;
            System.out.println("Daily money to add: " + dailyMoney);
            if((i % 7) == 0 && i != 0) {
                System.out.println("New week entered");
                weekCount++;
                totalMoney = totalMoney + weekCount;
            }
            else {
                totalMoney = totalMoney + dailyMoney;
            }
            System.out.println("Total Money: " + totalMoney);
        }
        return totalMoney;
    }

    public int totalMoneyy(int n) {
        int weeks = n / 7;
        int total = 0;
        for(int i = 1; i <= weeks; i++) {
            total = total + (i + 3) * 7;
        }
        for(int i = 7 * weeks; i < n; i++) {
            weeks++;
            total = total + weeks;
        }
        return total;
    }

    public int[] maxSubarray(int[] nums, int k) {
        if(nums.length == 0 || k > nums.length) return new int[0];
        int largestSum = 0;
        int[] largestSequence = new int[k];
        for(int i = 0; i < nums.length - (k-1); i++) {
            int sum = 0;
            int[] sequence = new int[k];
            int seqIndex = 0;
            for(int j = i; j < k + i; j++) {
                //System.out.print(nums[j]);
                sum = sum + nums[j];
                sequence[seqIndex] = nums[j];
                seqIndex++;
            }
            if(largestSum < sum) {
                largestSum = Math.max(largestSum, sum);
                largestSequence = sequence;
            }
        }
        return largestSequence;
    }

    public int[] maxSubsequence(int[] nums, int k) {
        int ans[] = new int[k];

        //get the k largest integers in priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);

            if(i>=k) pq.poll();
        }

        //store elements present in queue in hashmap
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<k; i++){
            int a = pq.poll();
            map.put(a, map.getOrDefault(a, 0)+1);
        }

        //to check values
        //System.out.println("New HashMap: " + map.toString());
        //add the values in result array in the right order
        int l=0;
        for(int j=0; j<nums.length; j++){
            if(l==k) break;

            if(map.containsKey(nums[j])){
                ans[l] = nums[j];
                l++;
                int f = map.get(nums[j])-1;
                if(f>=1)
                    map.replace(nums[j],f);
                else if(f == 0)
                    map.remove(nums[j]);
            }

        }

        return ans;
    }

    public int[] maxxSubsequence(int[] nums, int k) {
        //Priority queue will add numbers from nums array and the poll method will remove the smallest number from that list whenever our queue exceeds the length of k
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        //All queue items are added to a hashmap with the key as the actual number and the value as the amount of instances of that particular number
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < k; i++) {
            int temp = pq.poll();
            if(map.containsKey(temp)) {
                map.replace(temp, map.get(temp) + 1);
            }
            else {
                map.put(temp, 1);
            }
        }

        //We look through our original nums array again in order
        //If we find a number from nums array in our hashmap we add that number to our answer array
        //If there were multiple of that number in the hashmap we update our hashmap to subtract an instance of that number from the value slot
        //If there was only 1 instance of a particular number in our hashmap we simply remove that key,value pair from our hashmap
        int[] answer = new int[k];
        int index = 0;
        for(int j = 0; j < nums.length; j++) {
            if(index == k) break;
            if(map.containsKey(nums[j])) {
                answer[index] = nums[j];
                index++;
                int mapValueCount = map.get(nums[j]) - 1;
                if(mapValueCount >= 1) {
                    map.replace(nums[j], mapValueCount);
                }
                else if(mapValueCount == 0){
                    map.remove(nums[j]);
                }
            }
        }
        return answer;
    }

    public int findShortestSubArrayy(int[] arr) {
        int degree = 0;
        HashMap<Integer,Integer> degreeMap = new HashMap<>();
        HashMap<Integer,Integer> first = new HashMap<>();
        HashMap<Integer,Integer> last = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(!degreeMap.containsKey(arr[i])) {
                degreeMap.put(arr[i], 1);
                first.put(arr[i], i);
            }
            else {
                degreeMap.put(arr[i], degreeMap.get(arr[i]) + 1);
                last.put(arr[i], i);
            }
            degree = Math.max(degree, degreeMap.get(arr[i]));
        }
        if(last.size() == 0) {
            return 1;
        }
        System.out.println(degreeMap);
        System.out.println(first);
        System.out.println(last);
        int subarrayLength = arr.length;

        for(int num: degreeMap.keySet()) {
            if(degreeMap.get(num) == degree) {
                int subDiff = (last.get(num) - first.get(num)) + 1;
                subarrayLength = Math.min(subarrayLength, subDiff);
            }
        }

        return subarrayLength;
    }

    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: arr) {
            map.put(num, 0);
        }
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], i + 1);
        }
        int[] ans = new int[arr.length];
        int index = 0;
        for(int val: map.keySet()) {
            ans[index] = map.get(val);
            index++;
        }
        return ans;





        // int[] sortedArr = arr;
        // Arrays.sort(sortedArr);
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i = 0; i < sortedArr.length; i++) {
        //     map.put(sortedArr[i], i + 1);
        //     //System.out.println(sortedArr[i]);
        // }

        // for(int val: map.keySet()) {
        //     //System.out.println(val);
        // }


        // int[] ans = new int[arr.length];
        // for(int j = 0; j < arr.length; j ++) {
        //     //System.out.println(map.get(arr[j]));
        //     System.out.println(arr[j]);
        //     if(map.containsKey(arr[j])) {
        //         ans[j] = map.get(arr[j]);
        //     }
        // }
        // return ans;
    }

    public int[] arrayyRankTransform(int[] arr) {
//        input = array of integers
//        output = array of integers showing smallest to greatest integers in order that they were from the original array
//
//        1) Create a copy of the original array
//        2) Sort the copy array from ascending order
//        3) Go through the sorted array and store the element as the key with a locally declared index as the value into a map
//        4) Go back through the original array and add the associated index from each index in the map in a new array
        System.out.println("Original array output: " + Arrays.toString(arr));
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrCopy);
        System.out.println("Sorted array output: " + Arrays.toString(arrCopy));
        int index = 1;
        for(int i = 0; i < arrCopy.length; i++) {
            if(!map.containsKey(arrCopy[i])) {
                map.put(arrCopy[i], index++);
            }
        }
        System.out.println("Map output: " + map.entrySet());
        int[] result = new int[arrCopy.length];
        for(int i = 0; i < arr.length; i++) {
            result[i] = map.get(arr[i]);
        }
        return result;
    }
}