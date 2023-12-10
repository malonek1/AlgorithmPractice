package org.example.concepts.dynamic;

public class DynamicDriver {
    public static void main(String[] args) {
        DynamicAlgorithms dyn = new DynamicAlgorithms();
        //System.out.println(dyn.tripleStep(6));
        System.out.println(dyn.countStep(6));

        //System.out.println(findPossibleSteps(3));
    }

//    public static int findPossibleSteps(int n) {
//        // Base cases
//        if (n < 0) return 0;
//        else if (n == 0) return 1;
//
//        return findPossibleSteps(n - 1) +
//                findPossibleSteps(n - 2) +
//                findPossibleSteps(n - 3);
//    }

    public static int findPossibleSteps(int n) {
        int[] cache = new int[n+1];
        return findStepsCached(n, cache);
    }

    public static int findStepsCached(int n, int[] cache) {

        // Base cases
        if (n < 0) return 0;
        else if (n == 0 || n == 1) return 1;
        else if(cache[n] != 0) return cache[n];

        // Has not yet been cached
        cache[n] = findStepsCached(n - 1, cache) +
                findStepsCached(n - 2, cache) +
                findStepsCached(n - 3, cache);

        return cache[n];
    }

}
