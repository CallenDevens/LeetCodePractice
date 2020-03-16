/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || k <=0){
            return head;
        }
        
        
        ListNode resultDummyPrev = new ListNode(-1);
        ListNode resultEnd = resultDummyPrev;
        ListNode end = head;
        int lenAcc = 0;
        
        while(end != null){
           if(end.next == null){
                resultEnd.next = head;
                break;
            }

            end = end.next;
            lenAcc++;
            
            if(lenAcc == k-1){
                lenAcc = 0;
                ListNode temphead = end.next;
                end.next = null;
                resultEnd.next = reverseList(head);
                
                while(resultEnd.next != null){
                    resultEnd = resultEnd.next;
                }
                
                
                head = temphead;
                end = head;
            }
        }
        
        return resultDummyPrev.next;
        
    }
    
    public ListNode reverseList(ListNode head){
        if(head.next == null){
            return head;
        }
        
        ListNode prev = head;
        ListNode node = head.next;
        head.next = null;
        
        while(node != null){
            ListNode anchor = node.next;
            
            node.next = prev;
            prev = node;
            node = anchor;
        }
        
        return prev;
        
    }
}