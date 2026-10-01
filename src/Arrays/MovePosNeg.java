package Arrays;

import java.util.Scanner;

public class MovePosNeg {
    public static int[] move(int arr[], int left, int right) {
        int n = arr.length;
        left = 0;
        right = n - 1;
        while (left < right) {
            if (arr[left] < 0 && arr[right] > 0) {
                left++;
                right--;
            } else if (arr[left] > 0 && arr[right] < 0) {
                swap(arr, left, right);
                left++;
                right--;
            } else if (arr[left] < 0 && arr[right] < 0) {
                left++;
            } else if (arr[left] > 0 && arr[right] > 0) {
                right--;

            }

        }
        return arr;
    }

    public static void swap(int a[], int i, int j) {
        int tem = a[i];
        a[i] = a[j];
        a[j] = tem;
    }

    public static void read(int[] a, Scanner in) {

        System.out.println("Enter Array Elements:");
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();

        }

    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Array Size");
        int n = in.nextInt();
        int a[] = new int[n];
        read(a, in);
        move(a, 0, n - 1);
        print(a);


    }
}

