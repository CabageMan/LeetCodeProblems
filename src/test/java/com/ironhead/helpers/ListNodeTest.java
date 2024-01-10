package com.ironhead.helpers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {

  @Test
  void shouldTransfromToArray() {
    ListNode firstNode = new ListNode(2, new ListNode(4));
    ListNode secondNode = new ListNode(5, new ListNode(6, new ListNode(4)));
    ListNode thirdNode = new ListNode(0);

    int[] firstArray = {2, 4};
    int[] secondArray = {5, 6, 4};
    int[] thirdArray = {0};

    assertArrayEquals(firstArray, firstNode.toArray());
    assertArrayEquals(secondArray, secondNode.toArray());
    assertArrayEquals(thirdArray, thirdNode.toArray());
  }
}