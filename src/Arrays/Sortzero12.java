package Arrays;

import java.util.Scanner;

/*Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.
Note: You need to solve this problem without utilizing the built-in sort function.
Examples:
Input: arr[] = [0, 1, 2, 0, 1, 2]
Output: [0, 0, 1, 1, 2, 2]
Explanation: 0s, 1s and 2s are segregated into ascending order.
Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
Explanation: 0s, 1s and 2s are segregated into ascending order.
Test Cases Passed:
1110 /1111
Time limit exceeded
Your program took more time than expected.
Hint : Please optimize your code and submit again.
Geek Tip:
*/

public class Sortzero12 {

    public static void sort012(int[] arr) {
        // code here

        int n = arr.length;
        int count0 = 0,
            count1 = 0,
            count2 = 0;

        /*
        for (int i = 0; i < n - 1; i++) {

            int min = i;

            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[min]) {

                    min = j;

                    }

            }

            if (i != min)
             {

                int t = arr[i];

                arr[i] = arr[min];

                arr[min] = t;

            }

            }
            */
        // time complexity: theta n2

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                count0++;
            } else if (arr[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }
        int idx = 0;
        for (int i = 0; i < count0; i++) {
            arr[idx++] = count0;
        }
        for (int i = 0; i < count1; i++) {
            arr[idx++] = count1;
        }
        for (int i = 0; i < count2; i++) {
            arr[idx++] = count2;
        }
    }

    public static void read(int[] arr, Scanner in) {
        System.out.println("Enter elements");
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
    }

    public static void sortOpt(int[] arr) {
        int n = arr.length;
        int low = 0,
            mid = 0,
            high = n - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int t = arr[low];
                arr[low] = arr[mid];
                arr[mid] = t;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int t = arr[high];
                arr[high] = arr[mid];
                arr[mid] = t;
                high--;
            }
        }
    }

    public static void print(int[] arr, int n) {
        n = arr.length;
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print("\b\b]");
    }

    // little optimized code
    public static void sort012mS(int[] arr) {
        int start = 0;
        int n = arr.length;
        int end = n - 1;
        mS(arr, start, end);
    }

    // merge sort
    public static void mS(int[] nos, int start, int end) {
        //stopping condition
        if (start >= end) {
            return;
        }
        //splitting condition
        int split = start + (end - start) / 2;
        // recursive form
        mS(nos, start, split);
        mS(nos, split + 1, end);
        merge(nos, start, split, end);
    }

    public static void merge(int[] nos, int start, int split, int end) {
        int sort[] = new int[end - start + 1];
        int left = start;
        int right = split + 1;
        int write = 0;

        while (left <= split && right <= end) {
            if (nos[left] <= nos[right]) {
                sort[write] = nos[left];
                left++;
            } else {
                sort[write] = nos[right];
                right++;
            }
            write++;
        }

        while (left <= split) {
            sort[write] = nos[left];
            left++;
            write++;
        }

        while (right <= end) {
            sort[write] = nos[right];
            right++;
            write++;
        }

        for (int i = 0; i < sort.length; i++) {
            nos[start + i] = sort[i];
        }
    }

    public static void main(String[] shashwat) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = in.nextInt();
        int arr[] = new int[n];
        read(arr, in);
        //sort012(arr);
        //sort012mS(arr);
        sortOpt(arr);
        print(arr, n);
    }
}
