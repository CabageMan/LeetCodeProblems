package com.ironhead.problems;

import java.util.ArrayList;
import java.util.List;

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
    return "";
  }
}
