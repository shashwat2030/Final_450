package Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
Given an integer array arr[] and an integer k, find and return the kth smallest element in the given array.
Note: The kth smallest element is determined based on the sorted order of the array.

Examples :

Input: arr[] = [10, 5, 4, 3, 48, 6, 2, 33, 53, 10], k = 4
Output: 5
Explanation: 4th smallest element in the given array is 5.
Input: arr[] = [7, 10, 4, 3, 20, 15], k = 3
Output: 7
Explanation: 3rd smallest element in the given array is 7.
*/
public class kthSmallest {

    public static void read(int[] arr, Scanner in) {
        System.out.println("Enter elements");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
    }

    // brute forceApproach

    public static int Kthsmallest(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int t = arr[i];
                arr[i] = arr[min];
                arr[min] = t;
            }
        }
        System.out.println("The kth element:" + arr[k - 1]);
        return arr[k - 1];
    }

    // this approach is not good because there is an extra effort of sorting unnecessary elements which
    // // is creating the main issue.
    public static void print(int[] arr, int n) {
        n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println("\b\b");
    }

    public static int kthSmallestOpt(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            Comparator.reverseOrder()
        );
        int n = arr.length;
        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }

        for (int i = k; i < n; i++) {
            if (arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }
        System.out.println("the Result is:" + maxHeap.peek());
        return maxHeap.peek();
    }

    public static void main(String[] shashwat) {
        System.out.println("Enter array Size:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        read(arr, in);
        System.out.println("Enter k value:");
        int k = in.nextInt();

        //      Kthsmallest(arr, k);
        // print(arr,n);
        kthSmallestOpt(arr, k);
    }
}
