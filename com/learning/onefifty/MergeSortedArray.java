/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

 

Constraints:

    nums1.length == m + n
    nums2.length == n
    0 <= m, n <= 200
    1 <= m + n <= 200
    -109 <= nums1[i], nums2[j] <= 109

 

Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */
package com.learning.onefifty;

import java.util.Arrays;
public class MergeSortedArray{
    /**
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * 
     * Intution: Given two arrays with their lengths, requirement is to merge the second array to the first one in a sorted manner.
     * - First merge the array by traversing nums2 from 0 -> n and copy them to m -> nums1.length-1
     * - After merging, sort the array to get the sorted array.
     * - Time Complexity: traversal from 0 -> n, hence O(N) and Sorting of nums1.length takes O(k log K) where K is the length of nums1.
     * - Space Compexity: O(1) as first array can accommodate the second array
     */
    public void mergeBruteForce(int[] nums1, int m, int[] nums2, int n){
        if(nums1 == null || nums2 == null)
            throw new IllegalArgumentException("Invalid input.");

        for(int i=0; i<n; i++){
            nums1[m++] = nums2[i];
        }

        Arrays.sort(nums1);

        for(int val : nums1)
            System.out.println(val);
    }

    /**
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * 
     * Intution: Traverse both the arrays from the rear end until either of them are empty and copy the element that is greater.
     *  - if the second array is not null, copy the elements into numns1.
     * Time Complexity: O(M*N)
     * Space Complexity: O(1)
     */
    public void mergeOpt(int[] nums1, int m, int[] nums2, int n){
        if(nums1 == null || nums2 == null)
            throw new IllegalArgumentException("Invalid input.");

        int len = nums1.length;
        m = m-1;
        n = n-1;
        while(m>=0 && n>=0){
            if(nums1[m] >= nums2[n]){
                nums1[--len] = nums1[m--];
            } else {
                nums1[--len] = nums2[n--];
            }
        }

        while(n >= 0){
            nums1[--len] = nums2[n--];
        }

        for(int val : nums1)
            System.out.println(val);
    }

    public static void main(String[] args){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = nums2.length;

        MergeSortedArray obj = new MergeSortedArray();
        obj.mergeOpt(nums1, m, nums2, n);
    }
}
