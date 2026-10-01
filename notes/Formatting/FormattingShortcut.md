Absolutely. IntelliJ IDEA has some very useful shortcuts that you'll end up using constantly during DSA practice.

## 1. Auto Format Code (Most Important)

### Windows/Linux

```text
Ctrl + Alt + L
```

### macOS

```text
Cmd + Option + L
```

This automatically:

* Fixes indentation
* Aligns braces
* Removes unnecessary spacing
* Makes code look professional

Example:

Before:

```java
for(int i=0;i<n;i++){
System.out.println(arr[i]);
}
```

After pressing `Ctrl + Alt + L`:

```java
for (int i = 0; i < n; i++) {
    System.out.println(arr[i]);
}
```

---

## 2. Optimize Imports

### Windows/Linux

```text
Ctrl + Alt + O
```

Removes unused imports.

Example:

```java
import java.util.Scanner;
import java.util.ArrayList;
```

If `ArrayList` is not used, IntelliJ removes it.

---

## 3. Auto Indent Selected Code

Select code and press:

```text
Ctrl + Alt + I
```

Useful when you've pasted messy code.

---

## 4. Generate Code Automatically

Type:

```java
psvm
```

Press:

```text
Tab
```

Becomes:

```java
public static void main(String[] args) {

}
```

---

Type:

```java
sout
```

Press:

```text
Tab
```

Becomes:

```java
System.out.println();
```

---

## 5. Rename Anything Safely

Put cursor on variable/class/method.

Press:

```text
Shift + F6
```

IntelliJ updates all references automatically.

---

## 6. Quick Fix (Magic Key)

Put cursor on an error.

Press:

```text
Alt + Enter
```

This is one of IntelliJ's most powerful features.

Examples:

* Create missing method
* Import missing class
* Fix syntax suggestions
* Convert loops

---

## 7. Duplicate Line

```text
Ctrl + D
```

Example:

```java
int left = 0;
```

Press `Ctrl + D`:

```java
int left = 0;
int left = 0;
```

Then edit the second line.

---

## 8. Delete Line Quickly

```text
Ctrl + Y
```

No need to select the whole line.

---

## 9. Comment/Uncomment

Select code:

```text
Ctrl + /
```

Example:

```java
// System.out.println(arr[i]);
```

Very useful during debugging.

---

## 10. My Daily DSA Shortcut Set

If I were solving 450 DSA questions in IntelliJ, I'd mainly use:

```text
Ctrl + Alt + L    -> Format Code
Alt + Enter       -> Quick Fix
Ctrl + D          -> Duplicate Line
Ctrl + Y          -> Delete Line
Ctrl + /          -> Comment
Shift + F6        -> Rename
```

Learn these six shortcuts first. You'll probably use them on almost every DSA problem you solve. They save a surprising amount of time and keep your code clean without extra effort.
