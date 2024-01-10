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
  }
}