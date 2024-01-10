package com.ironhead.helpers;

public class ListNode {

  public int val;
  public ListNode next;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public int[] toArray() {
    return listNodeToArray(this, new int[0]);
  }

  private static int[] listNodeToArray(ListNode listNode, int[] resultArray) {
    int[] currentArray = new int[resultArray.length + 1];
    int i = 0;
    for (int number : resultArray) {
      currentArray[i] = number;
      i++;
    }
    currentArray[i] = listNode.val;

    if (listNode.next == null) {
      return currentArray;
    }
    return listNodeToArray(listNode.next, currentArray);
  }
}
