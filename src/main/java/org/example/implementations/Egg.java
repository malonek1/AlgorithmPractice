package org.example.implementations;

//1. Optimal Substructure:
//        When we drop an egg from floor x, there can be two cases (1) The egg breaks (2) The egg doesn’t break.
//
//
//        If the egg breaks after dropping from ‘xth’ floor, then we only need to check for floors lower than ‘x’ with remaining eggs as some floors should exist lower than ‘x’ in which the egg would not break, so the problem reduces to x-1 floors and n-1 eggs.
//        If the egg doesn’t break after dropping from the ‘xth’ floor, then we only need to check for floors higher than ‘x’; so the problem reduces to ‘k-x’ floors and n eggs.
//        Since we need to minimize the number of trials in the worst case, we take a maximum of two cases. We consider the max of the above two cases for every floor and choose the floor which yields the minimum number of trials.
//
//        Below is the illustration of the above approach:
//
//        K ==> Number of floors
//        N ==> Number of Eggs
//
//        eggDrop(N, K) ==> Minimum number of trials needed to find the critical
//        floor in worst case.
//        eggDrop(N, K) = 1 + min{max(eggDrop(N – 1, x – 1), eggDrop(N, K – x)), where x is in {1, 2, …, K}}
//
//        Concept of worst case:
//
//        Let there be ‘2’ eggs and ‘2’ floors then-:
//        If we try throwing from ‘1st’ floor:
//        Number of tries in worst case= 1+max(0, 1)
//
//        0=>If the egg breaks from first floor then it is threshold floor (best case possibility).
//        1=>If the egg does not break from first floor we will now have ‘2’ eggs and 1 floor to test which will give answer as
//        ‘1’.(worst case possibility)
//
//        We take the worst case possibility in account, so 1+max(0, 1)=2
//        If we try throwing from ‘2nd’ floor:
//        Number of tries in worst case= 1+max(1, 0)
//        1=>If the egg breaks from second floor then we will have 1 egg and 1 floor to find threshold floor.(Worst Case)
//        0=>If egg does not break from second floor then it is threshold floor.(Best Case)
//        We take worst case possibility for surety, so 1+max(1, 0)=2.
//        The final answer is min(1st, 2nd, 3rd….., kth floor)
//        So answer here is ‘2’.

// Java program for the above approach

public class Egg {

    /* Function to get minimum number of
    trials needed in worst case with n
    eggs and k floors */
    static int eggDrop(int n, int k)
    {
        // If there are no floors, then
        // no trials needed. OR if there
        // is one floor, one trial needed.
        if (k == 1 || k == 0)
            return k;

        // We need k trials for one egg
        // and k floors
        if (n == 1)
            return k;

        int min = Integer.MAX_VALUE;
        int x, res;

        // Consider all droppings from
        // 1st floor to kth floor and
        // return the minimum of these
        // values plus 1.
        for (x = 1; x <= k; x++) {
            res = Math.max(eggDrop(n - 1, x - 1),
                    eggDrop(n, k - x));
            if (res < min)
                min = res;
        }

        return min + 1;
    }

    // Driver code
    public static void main(String args[])
    {
        int n = 2, k = 10;
        System.out.print("Minimum number of "
                + "trials in worst case with " + n
                + " eggs and " + k + " floors is "
                + eggDrop(n, k));
    }
}