package org.example.implementations;

//Method 2 (Using Bitwise Operators)
//
//        Level 1: E
//        Level 2: ED
//        Level 3: EDDE
//        Level 4: EDDEDEED
//        Level 5: EDDEDEEDDEEDEDDE
//        Level input isn’t necessary (if we ignore max position limit) because first elements are same.
//        The result is based on count of 1’s in binary representation of position minus one. If count of 1’s is even then result is Engineer, else then Doctor.
//        And of course position limit is 2^(Level-1)


// Java program to find profession of a person at
// given level and position.
class BitwiseProfession {
    /* Function to get no of set bits in binary
    representation of passed binary no. */
    static int countSetBits(int n)
    {
        int count = 0;
        while (n!=0)
        {
            n &= (n-1) ;
            count++;
        }
        return count;
    }

    // Returns 'e' if profession of node at given level
// and position is engineer. Else doctor. The function
// assumes that given position and level have valid values.
    static char findProffesion(int level, int pos)
    {
        // Count set bits in 'pos-1'
        int c = countSetBits(pos-1);

        // If set bit count is odd, then doctor, else engineer
        return (c%2 !=0)? 'd' : 'e';
    }

    // Driver code
    public static void main(String [] args)
    {
        int level = 3, pos = 4;
        String prof = (findProffesion(level, pos) == 'e')? "Engineer"
                : "Doctor"  ;
        System.out.print(prof);
    }
}