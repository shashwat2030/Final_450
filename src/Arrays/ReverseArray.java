package Arrays;

import java.util.Scanner;

//Reverse an array arr[]. Reversing an array means rearranging the elements such that the first element
// becomes the last, the second element becomes second last and so on.
/*
Input: arr[] = [1, 4, 3, 2, 6, 5]
Output:  [5, 6, 2, 3, 4, 1]
Explanation: The first element 1 moves to last position, the second element 4 moves to second-last and so on.

Input: arr[] = [4, 5, 1, 2]
Output: [2, 1, 5, 4]
Explanation: The first element 4 moves to last position, the second element 5 moves to second last and so on.
// Time Complexity : O(n)
// Space Complexity: O(1)
*/


public class ReverseArray {

    public static void read(int[] a, Scanner in) {
        System.out.println("Enter elements");
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }
    }

    public static void reverse(int[] a) {
        int n = a.length;
        int i = 0;
        int j = n - 1;
        while (j > i) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }

    }

    public static void reversep(int[] a) {
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = a[i];
            a[i] = a[n - 1 - i];
            a[n - 1 - i] = temp;
        }

    }

    public static void print(int[] a) {
        System.out.println("Array:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

    }

    public static void main(String[] shashwat) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter Array Size:");
        int n=in.nextInt();
        int []a=new int[n];
        read(a,in);
        //  reverse(a);
        reversep(a);
        print(a);



    }
}