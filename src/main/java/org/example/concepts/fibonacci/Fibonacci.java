package org.example.concepts.fibonacci;

public class Fibonacci {
    public int recursiveFib(int num) {
        if(num < 2) {
            return 0;
        }
        else {
            return recursiveFib(num -1) + recursiveFib(num - 2);
        }
    }

    public int dynamicRecFib(int num) {
        return dynamicRecFib(num, new int[num + 1]);
    }

    public int dynamicRecFib(int num, int[] memo) {
        if(num == 0 || num == 1) {
            return num;
        }
        if(memo[num] == 0) {
            memo[num] = dynamicRecFib(num - 1, memo) + dynamicRecFib(num - 2, memo);
        }
        return memo[num];
    }
    
    public int dynamicFib(int num) {
        int a = 0;
        int b = 1;
        if(num == a) {
            return num;
        }
        if(num == b) {
            return b;
        }
        int c = 0;
        for(int i = 0; i < num; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}
