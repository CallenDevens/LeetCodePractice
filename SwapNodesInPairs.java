/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode resultPrev =  new ListNode(-1);
        resultPrev.next = head;
        
        ListNode preNode = resultPrev;
        ListNode firstNode = head;

        
        while(firstNode!=null && firstNode.next != null){
            ListNode secondNode = firstNode.next;
            preNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            
            
            preNode = firstNode;
            firstNode = firstNode.next;
            
        }
        
        return resultPrev.next;
    }
}