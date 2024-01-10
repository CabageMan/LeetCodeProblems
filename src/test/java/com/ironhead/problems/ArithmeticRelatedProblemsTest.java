package com.ironhead.problems;

import com.ironhead.helpers.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticRelatedProblemsTest {
  private ArithmeticRelatedProblems problems;

  @BeforeEach
  void init() {
    this.problems = new ArithmeticRelatedProblems();
  }

  @org.junit.jupiter.api.Test
  void shouldTwoSum() {
    int[] firstCaseNums = {2, 7, 11, 15};
    int firstCaseTarget = 9;
    int[] firstCaseExpectedOutput = {0, 1};
    int[] firstCaseActualOutput = problems.twoSum(firstCaseNums, firstCaseTarget);
    assertArrayEquals(firstCaseExpectedOutput, firstCaseActualOutput);

    int[] secondCaseNums = {3, 2, 4};
    int secondCaseTarget = 6;
    int[] secondCaseExpectedOutput = {1, 2};
    int[] secondCaseActualOutput = problems.twoSum(secondCaseNums, secondCaseTarget);
    assertArrayEquals(secondCaseExpectedOutput, secondCaseActualOutput);

    int[] thirdCaseNums = {3, 3};
    int thirdCaseTarget = 6;
    int[] thirdCaseExpectedOutput = {0, 1};
    int[] thirdCaseActualOutput = problems.twoSum(thirdCaseNums, thirdCaseTarget);
    assertArrayEquals(thirdCaseExpectedOutput, thirdCaseActualOutput);
  }

  @Test
  void shouldAddTwoNumbers() {
    /*
    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
     */
    ListNode firstCaseL1 = new ListNode(2, new ListNode(4, new ListNode(3)));
    ListNode firstCaseL2 = new ListNode(5, new ListNode(6, new ListNode(4)));
    ListNode firstCaseExpectedOutput = new ListNode(7, new ListNode(0, new ListNode(8)));
    ListNode firstCaseActualOutput = problems.addTwoNumbers(firstCaseL1, firstCaseL2);
    int[] firstExpectedArray = firstCaseExpectedOutput.toArray();
    int[] firstActualArray = firstCaseActualOutput.toArray();
    assertArrayEquals(firstExpectedArray, firstActualArray);

    /*
    Input: l1 = [0], l2 = [0]
    Output: [0]
     */
    ListNode secondCaseL1 = new ListNode(0);
    ListNode secondCaseL2 = new ListNode(0);
    ListNode secondCaseExpectedOutput = new ListNode(0);
    ListNode secondCaseActualOutput = problems.addTwoNumbers(secondCaseL1, secondCaseL2);
    int[] secondExpectedArray = secondCaseExpectedOutput.toArray();
    int[] secondActualArray = secondCaseActualOutput.toArray();
    assertArrayEquals(secondExpectedArray, secondActualArray);

    /*
    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]
     */
  }

  @Test
  void shouldFindMedianSortedArrays() {
//    Explanation: merged array = [1,2,3] and median is 2.
    int[] firstCaseNums1 = {1, 3};
    int[] firstCaseNums2 = {2};
    double firstCaseExpectedOutput = 2.0;
    double firstCaseActualOutput = problems.findMedianSortedArrays(firstCaseNums1, firstCaseNums2);
    assertEquals(firstCaseExpectedOutput, firstCaseActualOutput);

//    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
    int[] secondCaseNums1 = {1, 2};
    int[] secondCaseNums2 = {3, 4};
    double secondCaseExpectedOutput = 2.5;
    double secondCaseActualOutput = problems.findMedianSortedArrays(secondCaseNums1, secondCaseNums2);
    assertEquals(secondCaseExpectedOutput, secondCaseActualOutput);

//    Explanation: merged array = [1,5,7,8,9] and median is 7.
    int[] thirdCaseNums1 = {1, 7, 9};
    int[] thirdCaseNums2 = {5, 8};
    double thirdCaseExpectedOutput = 7.0;
    double thirdCaseActualOutput = problems.findMedianSortedArrays(thirdCaseNums1, thirdCaseNums2);
    assertEquals(thirdCaseExpectedOutput, thirdCaseActualOutput);

//    Explanation: merged array = [1,3,5,7,8,9] and median is (5 + 7) / 2 = 6.
    int[] fourthCaseNums1 = {1, 7, 9};
    int[] fourthCaseNums2 = {3, 5, 8};
    double fourthCaseExpectedOutput = 6.0;
    double fourthCaseActualOutput = problems.findMedianSortedArrays(fourthCaseNums1, fourthCaseNums2);
    assertEquals(fourthCaseExpectedOutput, fourthCaseActualOutput);
  }
}