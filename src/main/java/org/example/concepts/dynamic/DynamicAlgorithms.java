package org.example.concepts.dynamic;

public class DynamicAlgorithms {
    public int tripleStep(int n) {
        if(n < 0) {
            return 0;
        }
        else if(n == 0) {
            return 1;
        }
        return tripleStep(n - 1) + tripleStep(n - 2) + tripleStep(n - 3);
    }

    public int countStep(int n) {
        int[] cache = new int[n + 1];
        return countStep(n, cache);
    }

    public int countStep(int n, int[] cache) {
        if(n < 0) {
            return 0;
        }
        else if(n == 0) {
            return 1;
        }
        else if(cache[n] != 0) {
            return cache[n];
        }
        cache[n] = countStep(n - 1, cache) + countStep(n - 2, cache) + countStep(n - 3, cache);
        return cache[n];
    }
}
