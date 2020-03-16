/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode node = dummy;
        int length = 0;
        while(node!=null){
            node = node.next;
            length++;
        }
        
        //length - n +2
        length = length - n -1;
        node = dummy;
        while(length>0){
            length--;
            node = node.next;
        }
        
        //dangling node 
        ListNode removeNode = node.next;
        node.next = node.next.next;
        
        //memory cleanup
        removeNode.next= null;
        removeNode= null;
        return dummy.next;
        
    }
}