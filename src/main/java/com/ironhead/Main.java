package com.ironhead;

import com.ironhead.problems.StringRelatedProblems;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {

    System.out.println("Hello world!");

    int result[] = {1, 2, 3, 4, 5};
//    result.length;
    int value = 123;
    StringBuilder s1 = new StringBuilder(String.valueOf(value));

    s1.append(4);
    s1.append(0);
    System.out.println("Not inverted: " + s1.toString());
    System.out.println("Reversed: " + s1.reverse().toString());
    int newValue = 12340;
    System.out.println("Remainder: " + newValue % 10);

    value = Integer.parseInt(s1.toString());

    int testArr1[] = {1, 2, 3};
    int testArr2[] = {4, 5, 6};

    for (int element : testArr1) {
      System.out.println("Before: " + element);
    }
    test(testArr1, testArr2);
    for (int element : testArr1) {
      System.out.println("After: " + element);
    }

    Blob blobInstance = new Blob(5);
    System.out.println("Before: " + blobInstance.toString());

    System.out.println("In Method: " + changeBlob(blobInstance));

    System.out.println("After: " + blobInstance.toString());

    List<Integer> testList = new ArrayList<>();
    testList.add(5);
    testList.add(18);
    System.out.println("Size: " + Collections.max(testList));

    String test = "abcabcbb";

    List<Character> charList = new ArrayList<>();
    int maxLength = 0;
    for (int i = 0; i < test.length(); i++) {
      var currentChar = test.charAt(i);
      int existedCharIndex = charList.indexOf(currentChar);

      if (existedCharIndex > -1) {
        charList.subList(0, existedCharIndex + 1).clear();
      }

      charList.add(currentChar);
      if (charList.size() > maxLength) {
        maxLength = charList.size();
      }
    }

    System.out.println("MaxValue: " + maxLength);

    StringRelatedProblems stringProblems = new StringRelatedProblems();
    System.out.println("Result: " + stringProblems.longestPalindrome("racecar"));
  }

  private static String test(int[] s1, int[] s2) {
    s1[1] = 8;
    s2[1] = 9;
    return s1.toString() + s2.toString();
  }

  private static String changeBlob(Blob blob) {
    blob = new Blob(0);
    return blob.toString();
  }
}

class Blob {
  int value;

  public Blob(int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}