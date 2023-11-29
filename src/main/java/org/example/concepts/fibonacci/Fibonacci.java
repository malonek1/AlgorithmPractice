package org.example.concepts.fibonacci;

public class Fibonacci {
    public int recursiveFib(int num) {
        if(num == 0) {
            return 0;
        }
        else if(num == 1) {
            return 1;
        }
        else {
            return recursiveFib(num -1) + recursiveFib(num - 2);
        }
    }

    public int dynamicFib(int num) {
        return dynamicFib(num, new int[num + 1]);
    }

    public int dynamicFib(int num, int[] memo) {
        if(num == 0 || num == 1) {
            return num;
        }
        if(memo[num] == 0) {
            memo[num] = dynamicFib(num - 1, memo) + dynamicFib(num - 2, memo);
        }
        return memo[num];
    }
}
