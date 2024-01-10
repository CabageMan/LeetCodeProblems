package com.ironhead.problems;

import com.ironhead.helpers.ListNode;

public class ArithmeticRelatedProblems {
  /*
  Given an array of integers nums and an integer target,
  return indices of the two numbers such that they add up to target.
  You may assume that each input would have exactly one solution,
  and you may not use the same element twice.
  You can return the answer in any order.
   */
  public int[] twoSum(int[] nums, int target) {
    final int intBound = 1_000_000_000;
    boolean isNumsLengthValid = nums.length >= 2 && nums.length <= 10_000;
    boolean isTargetValid = target >= -intBound && target <= intBound;

    if (!isNumsLengthValid || !isTargetValid) {
      return null;
    }

    for (int i = 0; i < nums.length; i++) {
      var prevValue = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        var nextValue = nums[j];
        boolean prevIsValid = prevValue >= -intBound && prevValue <= intBound;
        boolean nextIsValid = nextValue >= -intBound && nextValue <= intBound;
        boolean sumIsValid = (prevValue + nextValue) == target;
        if (prevIsValid && nextIsValid && sumIsValid) {
          int result[] = {i, j};
          return result;
        }
      }
    }

    return null;
  }

  /*
  -------------------------------------------------------------------------------
  You are given two non-empty linked lists representing two non-negative integers.
  The digits are stored in reverse order, and each of their nodes contains a single digit.
  Add the two numbers and return the sum as a linked list.
  You may assume the two numbers do not contain any leading zero, except the number 0 itself.
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode resultNode = new ListNode();
    ListNode currentNode = new ListNode();
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
      int digitFirst = l1 != null ? l1.val : 0;
      int digitSecond = l2 != null ? l2.val : 0;
      int sum = digitFirst + digitSecond + carry;
      carry = sum / 10;

      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }

      currentNode.val = sum % 10;
      currentNode.next = (l1 == null && l2 == null && carry == 0) ? null : new ListNode();

      if (resultNode.next == null) {
        resultNode = currentNode;
      }

      currentNode = currentNode.next;
    }

    return resultNode;
  }


  /*
  -------------------------------------------------------------------------------
  Given two sorted arrays nums1 and nums2 of size m and n respectively,
  return the median of the two sorted arrays.
  The overall run time complexity should be O(log (m+n)).
   */
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int i = 0;
    int j = 0;
    int k = 0;
    int totalLength = nums1.length + nums2.length;
    int[] sumArray = new int[totalLength];

    while (i < nums1.length && j < nums2.length) {
      sumArray[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
    }

    while (i < nums1.length) {
      sumArray[k++] = nums1[i++];
    }

    while (j < nums2.length) {
      sumArray[k++] = nums2[j++];
    }

    if (totalLength % 2 != 0) {
      return sumArray[Math.round((float) (totalLength - 1) / 2)];
    } else {
      int centralIndex = totalLength / 2;
      return (double) (sumArray[centralIndex - 1] + sumArray[centralIndex]) / 2;
    }
  }
}
