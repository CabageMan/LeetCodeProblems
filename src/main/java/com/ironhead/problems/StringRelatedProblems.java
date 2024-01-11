package com.ironhead.problems;

import java.util.*;

public class StringRelatedProblems {
  /*
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
  -------------------------------------------------------------------------------
  Given a string s, return the longest palindromic (A string is palindromic if it
  reads the same forward and backward.) substring in s.
  */
  public String longestPalindrome(String s) {
    int stringLength = s.length();
    int[] radii = new int[stringLength];
    int leftBound = 0;
    int rightBound = -1;

    if (s.length() % 2 != 0) {
      for (int i = 0; i < stringLength; i++) {
        int radius = i > rightBound ? 1 : Math.min(radii[leftBound + rightBound - i], rightBound - i + 1);
        while ((i + radius) < stringLength && (i - radius) >= 0 && s.charAt(i + radius) == s.charAt(i - radius)) {
          radius++;
        }
        radii[i] = radius;
        if (i + radius - 1 > rightBound) {
          leftBound = i - radius + 1;
          rightBound = i + radius - 1;
        }
      }
    } else {
      for (int i = 0; i < stringLength; i++) {
        int radius = i > rightBound ? 0 : Math.min(radii[leftBound + rightBound + 1], rightBound - i + 1);
        while ((i + radius) < stringLength && (i - radius - 1) >= 0 && s.charAt(i + radius) == s.charAt(i - radius - 1)) {
          radius++;
        }
        radii[i] = radius;
        if (i + radius - 1 > radius) {
          leftBound = i - radius;
          rightBound = i + radius - 1;
        }
      }
    }

    int maxRadiusCenter = StringRelatedProblems.getIndexOfLargest(radii);
    int maxRadius = maxRadiusCenter != -1 ? radii[maxRadiusCenter] : 0;
    int startIndex = maxRadiusCenter - maxRadius + 1;
    int endIndex = maxRadiusCenter + maxRadius;

    return s.substring(startIndex, endIndex);
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
