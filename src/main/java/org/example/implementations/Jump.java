package org.example.implementations;

// Java program to implement
// the above approach
import java.util.*;
import java.lang.*;
import java.io.*;

//One Simple Solution is to traverse all numbers from 0 to x.
//        For every traversed number, check if it is a Jumping number.
//        If yes, then print it. Otherwise ignore it.

class Jump
{
    public static void print_sieve(int x)
    {
        int i, temp, digit;
        int check;

        for(i = 0; i <= x; i++)
        {
            if(i < 10)
            {
                System.out.print(i + " ");
                continue;
            }
            check = 1;
            temp = i;
            digit = temp % 10;
            temp /= 10;
            while(temp != 0)
            {
                if(Math.abs(digit - temp % 10) != 1)
                {
                    check = 0;
                    break;
                }
                digit = temp % 10;
                temp /= 10;
            }
            if(check != 0)
                System.out.print(i + " ");
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        int x = 105;
        print_sieve(x);
    }
}