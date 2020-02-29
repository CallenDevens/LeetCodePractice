class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode prev = new ListNode(-1);

		ListNode resultPrev = prev;
		ListNode l1p = l1;
		ListNode l2p = l2;
		while (l1 != null || l2 != null) {
			int val = 0;
			if (l1 == null) {
				val = l2.val;
				l2 = l2.next;

			} else if (l2 == null) {
				val = l1.val;
				l1 = l1.next;

			} else {
				if (l1.val < l2.val) {
					val = l1.val;
					l1 = l1.next;
				} else {
					val = l2.val;
					l2 = l2.next;

				}

			}

			ListNode node = new ListNode(val);
			prev.next = node;
			prev = prev.next;

		}

		return resultPrev.next;

	}
}