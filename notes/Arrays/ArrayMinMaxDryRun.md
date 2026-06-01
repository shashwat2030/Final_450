# Thought Process
### Dry run [3,5,4,1,9]
```
n= a.length;
min =max =a[0]
iterate to find min a[i] < min and for max a[i]>max

i=0 --> a[0]<min   ==> a[0]<a[0] ==> 3<3 (skip)
        a[0]>max   ==> a[0]>a[0] ==> 3>3 (skip)
       
i=1 --> a[1]<min   ==> a[1]<a[0] ==> 5<3 (skip)
        a[1]>max   ==> a[1]>a[0] ==> 5>3(execute)
         max= a[1]= 5; 
         
i=2 --> a[2]<min   ==> a[2]<a[0] ==> 4<3 (skip)
        a[2]>max   ==> a[2]>a[1] ==> 4>5  (skip)
        
i=3 --> a[3]<min   ==> a[3]<a[0] ==> 1<3 (execute)
        min=a[3]=1;
        a[3]>max   ==> a[3]>a[1] ==> 1>9 (skip)
        
i=4 --> a[4]<min ==> a[4]<a[3] ==> 9<1 (skip)
        a[4]>max ==>a[4]>a[1]  ==> 9>5 (execute)
        max=a[4]=9;
        since  i lies b/w 0 to 4
        add to the arraylist
        al.add(min);
        al.add(max);
        the result is [1,9]

```

### first attempt
```java
class Solution { 
    public ArrayList<Integer> getMinMax(int[] arr) { 
        // code Here 
        // variables 
        int n = arr.length; 
        int x=arr[0];
        int y=arr[n-1]; 
        int min=0;
        int max=0;
        int temp=0;
        // main loop 
        for(int i=0;i<n;i++) { 
            if(x>arr[i]) { 
                temp=x;
                arr[i]=x;
                x=temp;
                min=i;
                /*temp=x;  x = 3--> temp=3
                arr[i]=x;arr[i] = 1--> arr[0]=3
                 x=temp; x=3 
                 result  a[i] and x becomes 3 loosing 1 so hence swap logic is wrong 
                 * */
            } 
            if(y<arr[i]){ 
                temp=y; 
                arr[i]=y;
                y=temp;
                max =i;
               /* result  a[i] and x becomes 3 loosing 1 so hence swap logic is wrong*/
            }
        }
        ArrayList<Integer> a = new ArrayList<>();
        a.add(arr[min]); 
        a.add(arr[max]);
        return a;
    } 
}
```
## Now found 4 mistakes
1. first identified that there is no use of extra variable x and y 
2. second min and max are not index they are values
3. min and max should be equal
4. first thing swapping logic is wrong and its not need
```java
class Solution { 
    public ArrayList<Integer> getMinMax(int[] arr) { 
        // code Here 
        // variables 
        int n = arr.length;
        int min=a[0];
        int max=a[0];
        // main loop 
        for(int i=0;i<n;i++) { 
            if(a[i]<min) { 
                min=a[i];
            } 
            if(a[i]>max){
                max =a[i];
            }
        }
        ArrayList<Integer> a = new ArrayList<>();
        a.add(arr[min]); 
        a.add(arr[max]);
        return a;
    } 
}
```
## now finding the last piece of the cake i.e. min and max are values not index
### check how to add to arraylist i.e. collection framework that needs to be addressed 
```java
class Solution { 
    public ArrayList<Integer> getMinMax(int[] arr) { 
        // code Here 
        // variables 
        int n = arr.length;
        int min=a[0];
        int max=a[0];
        // main loop 
        for(int i=0;i<n;i++) { 
            if(a[i]<min) { 
                min=a[i];
            } 
            if(a[i]>max){
                max =a[i];
            }
        }
        ArrayList<Integer> a = new ArrayList<>();
        a.add(min);
        a.add(max);
        return a;
    } 
}
```
### here we go this makes the whole code ready for the compilation 
## two question that shapes the code here  and form the solution process
1. first till elements are not know fully then min and max should be equal and its not index but the value.
2. So first question clears that min and max should  be equal right then after iterating 
3. how to find the min and max so from the current value so exactly what needs to be analyzed 
4. the exact condition that needed to be fulfilled to have current element become either minimum or maximum.
5. These two core question formed the baseline that when min and max are value then how it should be 
6. passed to the array list and this just completes the solution after returning as result for the ques.

## The whole code can be re formated forming the final solution
# final Solution
```java
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
        //System.out.println("The Result is " + al);
    // this line should be included offline but online its creating the error.
        return al;
    }
```