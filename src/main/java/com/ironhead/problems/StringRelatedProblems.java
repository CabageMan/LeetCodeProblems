package com.ironhead.problems;

import java.util.*;

public class StringRelatedProblems {
  /*
  Longest Substring Without Repeating Characters
  -------------------------------------------------------------------------------
  Given a string s, find the length of the longest substring
  without repeating characters.
   */
  public int lengthOfLongestSubstring(String s) {
    List<Character> charList = new ArrayList<>();
    int maxLength = 0;
    for (int i = 0; i < s.length(); i++) {
      var currentChar = s.charAt(i);
      int existedCharIndex = charList.indexOf(currentChar);
      if (existedCharIndex > -1) {
        charList.subList(0, existedCharIndex + 1).clear();
      }
      charList.add(currentChar);
      if (charList.size() > maxLength) {
        maxLength = charList.size();
      }
    }
    return maxLength;
  }

  /*
  Longest Palindromic Substring
  -------------------------------------------------------------------------------
  Given a string s, return the longest palindromic (A string is palindromic if it
  reads the same forward and backward.) substring in s.
  */
  // Manacher's algorithm
  public String longestPalindrome(String s) {
    int stringLength = s.length();

    int[] oddRadii = new int[stringLength];
    int[] evenRadii = new int[stringLength];

    int leftBound = 0;
    int rightBound = -1;
    for (int i = 0; i < stringLength; i++) {
      int radius = i > rightBound ? 1 : Math.min(oddRadii[leftBound + rightBound - i], rightBound - i + 1);
      while ((i + radius) < stringLength && (i - radius) >= 0 && s.charAt(i + radius) == s.charAt(i - radius)) {
        radius++;
      }
      oddRadii[i] = radius;
      if (i + radius - 1 > rightBound) {
        leftBound = i - radius + 1;
        rightBound = i + radius - 1;
      }
    }

    leftBound = 0;
    rightBound = -1;
    for (int i = 0; i < stringLength; i++) {
      int radius = i > rightBound ? 0 : Math.min(evenRadii[leftBound + rightBound - i + 1], rightBound - i + 1);
      while ((i + radius) < stringLength && (i - radius - 1) >= 0 && s.charAt(i + radius) == s.charAt(i - radius - 1)) {
        radius++;
      }
      evenRadii[i] = radius;
      if (i + radius - 1 > radius) {
        leftBound = i - radius;
        rightBound = i + radius - 1;
      }
    }

    int maxOddRadiusCenter = StringRelatedProblems.getIndexOfLargest(oddRadii);
    int maxOddRadius = maxOddRadiusCenter != -1 ? oddRadii[maxOddRadiusCenter] : 0;

    int maxEvenRadiusCenter = StringRelatedProblems.getIndexOfLargest(evenRadii);
    int maxEvenRadius = maxEvenRadiusCenter != -1 ? evenRadii[maxEvenRadiusCenter] : 0;

    if (maxOddRadius > maxEvenRadius) {
      int startIndex = maxOddRadiusCenter - maxOddRadius + 1;
      int endIndex = maxOddRadiusCenter + maxOddRadius;
      return s.substring(startIndex, endIndex);
    } else {
      int startIndex = maxEvenRadiusCenter - maxEvenRadius;
      int endIndex = maxEvenRadiusCenter + maxEvenRadius;
      return s.substring(startIndex, endIndex);
    }
  }

  /*
  Zigzag Conversion
  -------------------------------------------------------------------------------
  The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows (3) like this:
  (you may want to display this pattern in a fixed font for better legibility)
  P   A   H   N
  A P L S I I G
  Y   I   R
  And then read line by line: "PAHNAPLSIIGYIR"
    4 rows:
  P     I    N
  A   L S  I G
  Y A   H R
  P     I
  And then read line by line: "PINALSIGYAHRPI"
  Write the code that will take a string and make this conversion given a number of rows:
  string convert(string s, int numRows);
   */
  public String zigzagConvert(String s, int numRows) {
    return "";
  }


  // Helpers
  public static String insertSeparators(String s) {
    StringBuilder stringBuilder = new StringBuilder(s.length() * 2 + 1);
    int index = 0;
    String separator = "|";

    stringBuilder.append(separator);
    while (index < s.length()) {
      stringBuilder.append(s.charAt(index));
      stringBuilder.append(separator);
      index++;
    }

    return stringBuilder.toString();
  }

  public static int getIndexOfLargest(int[] array) {
    if (array == null || array.length == 0) return -1;
    int largestIndex = 0;
    for (int i = 1; i < array.length; i++) {
      if (array[i] > array[largestIndex]) largestIndex = i;
    }
    return largestIndex;
  }
}
