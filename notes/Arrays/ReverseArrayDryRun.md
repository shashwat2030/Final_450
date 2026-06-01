Basic Intuition

## Thought process

### Dry run for `[1, 4, 3, 2, 6, 5]`

We want to reverse the array by swapping pairs from the ends toward the center:

```
Swap 0 ↔ 5:  1 ↔ 5   → [5, 4, 3, 2, 6, 1]
Swap 1 ↔ 4:  4 ↔ 6   → [5, 6, 3, 2, 4, 1]
Swap 2 ↔ 3:  3 ↔ 2   → [5, 6, 2, 3, 4, 1]   ← desired reversed array
```

### First attempt at code (with nested loops)

```java
public void reverseArray(int arr[]) {
    int n = arr.length;
    int low = (int)Math.floor((n-1)/2);
    int high = (int)Math.floor(n/2);
    for(int i = 0; i <= low; i++){
        for(int j = n-1; j >= high; j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
```

Felt that nested structure is wrong because `n*n =9 ` which is wrong
---

## Refined Hints

Node code just observation deriving magical relationship between the `i` and `j
### 1. Look at the relationship between `i` and `j` in your dry run

| Swap # | `i` (left index) | `j` (right index) | Notice… |
|--------|------------------|-------------------|---------|
| 1      | 0                | 5                 | 0 + 5 = 5 = n-1 |
| 2      | 1                | 4                 | 1 + 4 = 5 = n-1 |
| 3      | 2                | 3                 | 2 + 3 = 5 = n-1 |

So **`j` is always `n - 1 - i`**. hence this also proves that looping structure is wrong
### 2. What does the nested loop actually do?

Imagine the array `[1, 4, 3, 2, 6, 5]` with your nested code:

- Outer loop `i = 0`, inner loop runs `j = 5, 4, 3`:
    - `i=0, j=5` → swap 1 and 5 → `[5, 4, 3, 2, 6, 1]`
    - `i=0, j=4` → swap arr[0] (now 5) with arr[4] (6) → `[6, 4, 3, 2, 5, 1]`
    - `i=0, j=3` → swap arr[0] (6) with arr[3] (2) → `[2, 4, 3, 6, 5, 1]`

Already the array is scrambled.
That’s not what your dry run did.
The nested loops are performing extra swaps that destroy the reversal.  
**Question to yourself**: 
How many total swaps should the whole reversal require for an array of length `n`? 
Do you need a loop *inside* another loop to achieve that?

### 3. The magical part starts here finding the exact solution

** We need to analyse the relationship between `i` and `j ' i.e.
```java
int i=n-1-j;
//or 
int j=n-1-i;

```
### Analyze different parts 
* *Constant Part**

*constant*
```
i+j == n-1

```
but the ***varying*** part 
* `i` `=` `0` and `j` `=` `5`
* `i` `=` `1` and `j` `=` `4`
* `i` `=` `2` and `j` `=` `3`
+ **i.e.** `i` `=` `i+1`
+ **and** `j` `=`  `j-1`
* So this creates that ***2 pointers*** concept.
* Now this creates condition when 
`i` `=` `3` and `j` `=` `2`
+ ***similarly***
`i` `=` `4` and `j` `=` `1`
`i` `=` `5` and `j` `=` 0 
* Now we can move to ***while*** loop 
```java
public void reverseArray(int arr[]) {
   // we have found that i should start at zero
    // and j should start with n-1
    // initializing length of the array
     int n= arr.length;
     int i=0;
     int j=n-1;
     // from previous analysis or varying part when loop starts and ends
    // i=0 , j=5 so here we analyze 
    // j> i
    // 0>5 not possible loop never run
    while (j>=i)
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
        i++;
        j--;
    }
}
    
```
** Now testing **