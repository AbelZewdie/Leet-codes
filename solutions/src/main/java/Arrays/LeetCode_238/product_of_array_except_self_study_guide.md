# LeetCode 238: Product of Array Except Self

## 1. Problem Overview

Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`.

* **Time Complexity Constraint:** $O(n)$
* **Constraint:** You must solve it **without** using the division operation.
* **Follow-up:** Can you solve the problem in $O(1)$ extra space complexity? (The output array does not count as extra space).

---

## 2. Core Intuition: Prefix & Suffix Products

For any index $i$ in an array, the product of all elements except `nums[i]` can be broken down into two independent parts:

$$\text{answer}[i] = (\text{product of all numbers BEFORE index } i) \times (\text{product of all numbers AFTER index } i)$$

$$\text{answer}[i] = \text{prefix}[i] \times \text{suffix}[i]$$

By decoupling the left side ("before") and the right side ("after"), we avoid nested loops ($O(n^2)$) and division.

---

## 3. Approach 1: Three-Array Solution (Explicit & Intuitive)

This approach uses three separate arrays:
1. `left_products[i]`: Stores the product of all elements to the left of index $i$.
2. `right_products[i]`: Stores the product of all elements to the right of index $i$.
3. `output_arr[i]`: Stores `left_products[i] * right_products[i]`.

### Base Case Setup
* `left_products[0] = 1` (nothing exists to the left of index $0$).
* `right_products[n - 1] = 1` (nothing exists to the right of index $n - 1$).

### Java Code

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        int[] left_products = new int[n];
        int[] right_products = new int[n];
        int[] output_arr = new int[n];
        
        // Base cases: 1 is the identity value for multiplication
        left_products[0] = 1;
        right_products[n - 1] = 1;
        
        // Pass 1: Build left_products array (left to right)
        for (int i = 1; i < n; i++) {
            left_products[i] = left_products[i - 1] * nums[i - 1];
        }
        
        // Pass 2: Build right_products array (right to left)
        for (int i = n - 2; i >= 0; i--) {
            right_products[i] = right_products[i + 1] * nums[i + 1];
        }
        
        // Pass 3: Multiply left and right products for each index
        for (int i = 0; i < n; i++) {
            output_arr[i] = left_products[i] * right_products[i];
        }
        
        return output_arr;
    }
}
```

### Complexity Analysis
* **Time Complexity:** $O(n)$ — Three linear passes over the array of size $n$.
* **Space Complexity:** $O(n)$ — Two additional arrays of size $n$ (`left_products` and `right_products`).

---

## 4. Approach 2: Space-Optimized Solution ($O(1)$ Extra Space)

Instead of using explicit arrays for left and right products, we can reuse the output array to store the prefix products, and use a single running integer variable (`after`) during a backward pass to compute suffix products on the fly.

### Algorithm Steps
1. Create `result` array. Set `result[0] = 1`.
2. **First Pass (Left to Right):** Fill `result[i]` with the product of all elements to the left of $i$.
3. **Second Pass (Right to Left):** Maintain a running variable `after = 1`. Multiply `result[i]` by `after`, then update `after *= nums[i]`.

### Java Code

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Pass 1: Build prefix products directly into result
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // Pass 2: Multiply by running suffix product from the right
        int after = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * after;
            after = after * nums[i];
        }
        
        return result;
    }
}
```

---

## 5. Visual Step-by-Step Execution

Given `nums = [1, 2, 3, 4]`:

### Pass 1: Prefix Products (`result`)

| Index ($i$) | Formula | `result[i]` value |
| :--- | :--- | :--- |
| `0` | Seed value | `1` |
| `1` | `result[0] * nums[0]` $\rightarrow 1 \times 1$ | `1` |
| `2` | `result[1] * nums[1]` $\rightarrow 1 \times 2$ | `2` |
| `3` | `result[2] * nums[2]` $\rightarrow 2 \times 3$ | `6` |

* `result` after Pass 1: `[1, 1, 2, 6]`

### Pass 2: Suffix Products (`after`) & Final Result

| Index ($i$) | `result[i]` before | `after` | New `result[i]` (`result[i] * after`) | Next `after` (`after * nums[i]`) |
| :--- | :--- | :--- | :--- | :--- |
| `3` | `6` | `1` | $6 \times 1 = \mathbf{6}$ | $1 \times 4 = \mathbf{4}$ |
| `2` | `2` | `4` | $2 \times 4 = \mathbf{8}$ | $4 \times 3 = \mathbf{12}$ |
| `1` | `1` | `12` | $1 \times 12 = \mathbf{12}$ | $12 \times 2 = \mathbf{24}$ |
| `0` | `1` | `24` | $1 \times 24 = \mathbf{24}$ | $24 \times 1 = \mathbf{24}$ |

* Final `result`: `[24, 12, 8, 6]`

---

## 6. Summary Comparison

| Metric | 3-Array Approach | Optimized 2-Pass Approach |
| :--- | :--- | :--- |
| **Time Complexity** | $O(n)$ | $O(n)$ |
| **Space Complexity** | $O(n)$ extra space | $O(1)$ extra space (excluding output array) |
| **Code Readability** | Very high (easiest to write first) | High (standard LeetCode optimal solution) |