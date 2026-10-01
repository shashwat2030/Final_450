```java
import java.util.ArrayList;
import java.util.Collections;
// method 1
class GfG {
    public static ArrayList<Integer> findMinMax(int[] arr) {
        
        ArrayList<Integer> sortedArr = new ArrayList<>();
        for (int num : arr) {
            sortedArr.add(num);
        }
        
        // Sort ArrayList
        Collections.sort(sortedArr);
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(sortedArr.get(0));               
        result.add(sortedArr.get(sortedArr.size() - 1)); 
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 9};
        ArrayList<Integer> result = findMinMax(arr);
        System.out.println(result.get(0) + " " + result.get(1));
    }
}
```
```java
import java.util.ArrayList;
//method 2
class GfG {
    public static ArrayList<Integer> findMinMax(int[] arr) {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        
        // Find minimum and maximum
        for (int num : arr) {
            if (num < mini) mini = num;
            if (num > maxi) maxi = num;
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(mini);
        result.add(maxi);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 9};
        ArrayList<Integer> result = findMinMax(arr);
        System.out.println(result.get(0) + " " + result.get(1));
    }
}
```
```java
import java.util.ArrayList;
import java.util.Arrays;
// method 3
public class MinMaxDivideConquer {
    
    public static ArrayList<Integer> getMinMax(ArrayList<Integer> arr, int low, int high) {
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(0, 0));

        // Base case: one element
        if (low == high) {
            result.set(0, arr.get(low));  
            result.set(1, arr.get(low)); 
            return result;
        }

        // Base case: two elements
        if (high == low + 1) {
            if (arr.get(low) < arr.get(high)) {
                result.set(0, arr.get(low));   
                result.set(1, arr.get(high));  
            } else {
                result.set(0, arr.get(high));
                result.set(1, arr.get(low));
            }
            return result;
        }

        // Recursive case: divide array into two halves
        int mid = (low + high) / 2;
        ArrayList<Integer> left = getMinMax(arr, low, mid);
        ArrayList<Integer> right = getMinMax(arr, mid + 1, high);

        // Combine results
        int min = Math.min(left.get(0), right.get(0));
        int max = Math.max(left.get(1), right.get(1));
        result.set(0, min);
        result.set(1, max);

        return result;
    }

    public static ArrayList<Integer> findMinMax(ArrayList<Integer> arr) {
        return getMinMax(arr, 0, arr.size() - 1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3, 5, 4, 1, 9));
        ArrayList<Integer> result = findMinMax(arr);
        System.out.println(result.get(0) + " " + result.get(1));
    }
}
```
```java
import java.util.ArrayList;
import java.util.Arrays;
// method 4
public class MinMaxFinder {
    public static void findMinMax(ArrayList<Integer> arr, ArrayList<Integer> result) {
        int n = arr.size();
        int mini, maxi, i;

        // Initialize min and max
        if (n % 2 == 1) {
            mini = maxi = arr.get(0);
            i = 1;
        } else {
            if (arr.get(0) < arr.get(1)) {
                mini = arr.get(0);
                maxi = arr.get(1);
            } else {
                mini = arr.get(1);
                maxi = arr.get(0);
            }
            i = 2;
        }

        // Process elements in pairs
        while (i < n - 1) {
            if (arr.get(i) < arr.get(i + 1)) {
                mini = Math.min(mini, arr.get(i));
                maxi = Math.max(maxi, arr.get(i + 1));
            } else {
                mini = Math.min(mini, arr.get(i + 1));
                maxi = Math.max(maxi, arr.get(i));
            }
            i += 2;
        }

        result.add(mini);
        result.add(maxi);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3, 5, 4, 1, 9));
        ArrayList<Integer> result = new ArrayList<>();
        findMinMax(arr, result);
        System.out.println(result.get(0) + " " + result.get(1));
    }
}
```
```java
package Arrays;

import java.util.Scanner;
import java.util.ArrayList;
// my solution
public class ArrayMinMax {

    public static void read(int[] a, Scanner in) {
        System.out.println("Enter Elements:");
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }
    }


    public static ArrayList<Integer> getMinMax(int[] a) {
        ArrayList<Integer> al = new ArrayList<>();
        int min = a[0];
        int max = a[0];
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }
        al.add(min);
        al.add(max);
        System.out.println("The Result is " + al);
        return al;
    }

    public static void main(String[] shashwat) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Array Size:");
        int n = in.nextInt();
        int a[] = new int[n];
        read(a, in);
        getMinMax(a);


    }
}

```