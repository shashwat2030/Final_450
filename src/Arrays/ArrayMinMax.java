package Arrays;

import java.util.Scanner;
import java.util.ArrayList;

/*
Maximum and minimum of an array using minimum number of comparisons
Last Updated : 25 Oct, 2025
Given an array of integers arr[], the task is to find the maximum and minimum elements in the array using the minimum number of comparisons.

Examples:

Input: arr[] = [3, 5, 4, 1, 9]
Output: [1, 9]
Explanation: The minimum element is 1, and the maximum element is 9.

Input: arr[] = [22, 14, 8, 17, 35, 3]
Output: [3, 35]
Explanation: The minimum element is 3, and the maximum element is 35.
Time complexity -O(n)
Space Complexity-O(1)
* */
public class ArrayMinMax {

    public static void read(int[] a, Scanner in) {
        System.out.println("Enter Elements:");
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }
    }

    public static ArrayList<Integer> getMinMax(int arr[], int n) {
        ArrayList<Integer> al = new ArrayList<Integer>();

        n = arr.length;
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        al.add(min);
        al.add(max);
        System.out.println("the result is :" + al);
        return al;
    }

    public static void main(String[] developer) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Array Size:");
        int n = in.nextInt();
        int a[] = new int[n];
        read(a, in);
        getMinMax(a, n);

    }
}
