package com.ironhead.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringRelatedProblemsTest {

  private StringRelatedProblems problems;

  @BeforeEach
  void setUp() {
    this.problems = new StringRelatedProblems();
  }

  @Test
  void lengthOfLongestSubstring() {
//    Explanation: The answer is "abc", with the length of 3.
    String firstInput = "abcabcbb";
    int firstExpectedOutput = 3;
    int firstActualOutput = problems.lengthOfLongestSubstring(firstInput);
    assertEquals(firstExpectedOutput, firstActualOutput);

//    Explanation: The answer is "b", with the length of 1.
    String secondInput = "bbbbb";
    int secondExpectedOutput = 1;
    int secondActualOutput = problems.lengthOfLongestSubstring(secondInput);
    assertEquals(secondExpectedOutput, secondActualOutput);

//    Explanation: The answer is "wke", with the length of 3.
    String thirdInput = "pwwkew";
    int thirdExpectedOutput = 3;
    int thirdActualOutput = problems.lengthOfLongestSubstring(thirdInput);
    assertEquals(thirdExpectedOutput, thirdActualOutput);
  }

  @Test
  void longestPalindrome() {
    String firstInput = "babad";
    String firstExpectedOutput = "bab";
    String firstActualOutput = problems.longestPalindrome(firstInput);
    assertEquals(firstExpectedOutput, firstActualOutput);

    String secondInput = "cbbd";
    String secondExpectedOutput = "bb";
    String secondActualOutput = problems.longestPalindrome(secondInput);
    assertEquals(secondExpectedOutput, secondActualOutput);

    String thirdInput = "racecar";
    String thirdExpectedOutput = "racecar";
    String thirdActualOutput = problems.longestPalindrome(thirdInput);
    assertEquals(thirdExpectedOutput, thirdActualOutput);

    String fourthInput = "abb";
    String fourthExpectedOutput = "bb";
    String fourthActualOutput = problems.longestPalindrome(fourthInput);
    assertEquals(fourthExpectedOutput, fourthActualOutput);

    String fifthInput = "aaaa";
    String fifthExpectedOutput = "aaaa";
    String fifthActualOutput = problems.longestPalindrome(fifthInput);
    assertEquals(fifthExpectedOutput, fifthActualOutput);
  }

  @Test
  void zigzagConvert() {
    String firstCaseInput = "PAYPALISHIRING";
    int firstCaseNumRows = 3;
    String firstCaseExpectedOutput = "PAHNAPLSIIGYIR";
    String firstCaseActualOutput = problems.zigzagConvert(firstCaseInput, firstCaseNumRows);
    assertEquals(firstCaseExpectedOutput, firstCaseActualOutput);

    String secondCaseInput = "PAYPALISHIRING";
    int secondCaseNumRows = 4;
    String secondCaseExpectedOutput = "PINALSIGYAHRPI";
    String secondCaseActualOutput = problems.zigzagConvert(secondCaseInput, secondCaseNumRows);
    assertEquals(secondCaseExpectedOutput, secondCaseActualOutput);

    String thirdCaseInput = "A";
    int thirdCaseNumRows = 1;
    String thirdCaseExpectedOutput = "A";
    String thirdCaseActualOutput = problems.zigzagConvert(thirdCaseInput, thirdCaseNumRows);
    assertEquals(thirdCaseExpectedOutput, thirdCaseActualOutput);
  }

  // Helpers tests
  @Test
  void insertSeparators() {
    String firstString = "string";
    String firstExpectedString = "|s|t|r|i|n|g|";
    assertEquals(firstExpectedString, StringRelatedProblems.insertSeparators(firstString));

    String secondString = "a";
    String secondExpectedString = "|a|";
    assertEquals(secondExpectedString, StringRelatedProblems.insertSeparators(secondString));
  }

  @Test
  void getIndexOfLargest() {
    int[] firstArray = {1, 3, 2};
    int firstExpectedIndex = 1;
    assertEquals(firstExpectedIndex, StringRelatedProblems.getIndexOfLargest(firstArray));

    int[] secondArray = {1, 1, 4, 1, 1};
    int secondExpectedIndex = 2;
    assertEquals(secondExpectedIndex, StringRelatedProblems.getIndexOfLargest(secondArray));

    int[] thirdArray = {};
    int thirdExpectedIndex = -1;
    assertEquals(thirdExpectedIndex, StringRelatedProblems.getIndexOfLargest(thirdArray));
  }
}