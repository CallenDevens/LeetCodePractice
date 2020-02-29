/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if(len<=0) return null;
        while(len > 1){
            ListNode[] newLists = new ListNode[(lists.length+1) /2];
            int index = 0;
            for(int i = 0; i < lists.length; i+=2){
                if(i + 1 >=  lists.length){
                    newLists[index] = lists[i];
                }else{
                    newLists[index] = this.mergeTwoLists(lists[i], lists[i+1]);
                }
                index++;
                
            }
            lists = newLists;
            len = lists.length;
        }
        return lists[0];
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(-1);
        ListNode resultPrev = dummyHead;
        
        while(l1!=null && l2!=null){
            int val = 0;
            if(l1.val>l2.val){
                val = l2.val;
                l2 = l2.next;
            }else{
                val = l1.val;
                l1 = l1.next;
            }
            
            ListNode node = new ListNode(val);
            dummyHead.next = node;
            dummyHead = dummyHead.next;
        }
        dummyHead.next = l1== null? l2: l1;        
        return resultPrev.next;
        
    }
}