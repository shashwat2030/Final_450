# Comparison
```java
// method 1
import java.util.Arrays;

class GfG {
    
    static void reverseArray(int[] arr) {
        int n = arr.length;
        
        // Temporary array to store elements
        // in reversed order
        int[] temp = new int[n];
  
        // Copy elements from original array
        // to temp in reverse order
        for (int i = 0; i < n; i++)
            temp[i] = arr[n - i - 1];
  
        // Copy elements back to original array
        for (int i = 0; i < n; i++)
            arr[i] = temp[i];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 3, 2, 6, 5 };

        reverseArray(arr);
  
        for (int i = 0; i < arr.length; i++) 
            System.out.print(arr[i] + " ");
    }
}
```
```java
import java.util.Arrays;
// method 2
class GfG {

    // function to reverse an array
    static void reverseArray(int[] arr) {

        // Initialize left to the beginning
        // and right to the end
        int left = 0, right = arr.length - 1;

        // Iterate till left is less than right
        while (left < right) {

            // Swap the elements at left
            // and right position
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Increment the left pointer
            left++;

            // Decrement the right pointer
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 3, 2, 6, 5 };

        reverseArray(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
```
```java
import java.util.Arrays;
// method 3
class GfG {
    
    static void reverseArray(int[] arr) {
        int n = arr.length;
        
        // Iterate over the first half 
        // and for every index i, swap
        // arr[i] with arr[n - i - 1]
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 3, 2, 6, 5 };

        reverseArray(arr);
  
        for (int i = 0; i < arr.length; i++) 
            System.out.print(arr[i] + " ");
    }
}
```
```java
// method 4
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class GfG {
    
    // function to reverse an array
    static void reverseArray(List<Integer> arr) {
        Collections.reverse(arr);
    }

    public static void main(String[] args) {
        List<Integer> arr = 
          new ArrayList<>(Arrays.asList(1, 4, 3, 2, 6, 5));

        reverseArray(arr);
  
        for (int i = 0; i < arr.size(); i++) 
            System.out.print(arr.get(i) + " ");
    }
}
```
```java
// mymethod
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

*/
interface Reverse {
    int[] input(int a[]);

    int[] reverse(int a[]);

    int[] output(int a[]);


}

public class ReverseArray implements Reverse {
    @java.lang.Override
    public int[] input(int[] a) {
        Scanner in= new Scanner(System.in);
        System.out.println("Enter elements");
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }
        return a;
    }

    @java.lang.Override
    public int[] output(int[] a) {
        System.out.println("Array:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        return a;
    }

    @java.lang.Override
    public int[] reverse(int[] a) {
        int n = a.length;
        int i = 0;
        int j = n - 1;
        while (j>i) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return a;
    }

    public static void exe() {
        ReverseArray ra = new ReverseArray();
        Scanner in=new Scanner(System.in);
        System.out.println("Enter Array Size:");
        int n = in.nextInt();
        int arr[]= new int[n];
        ra.input(arr);
        ra.reverse(arr);
        ra.output(arr);

    }

    public static void main(String[] shashwat) {
        exe();

    }
}
```