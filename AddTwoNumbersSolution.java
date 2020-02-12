class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode result = null;

		ListNode cursor = null;

		int carryOver = 0;
		
		while (true) {

			// generate digit node
			ListNode node = null;

			int nodeValue = 0;
			if (l1 != null && l2 != null) {

				// the digit equals = sum of two digits plus carryOver %10
				//my fault was sum of two digits %10 plus carryOver
				nodeValue = (l1.val + l2.val + carryOver) % 10;
				carryOver = (l1.val + l2.val + +carryOver) / 10;

			} else if (l1 != null) {
				nodeValue = (l1.val + carryOver) % 10;

				carryOver = (l1.val + carryOver) / 10;

			} else if (l2 != null) {
				nodeValue = (l2.val + carryOver) % 10;
				carryOver = (l2.val + carryOver) / 10;

			} else {
				//marginal case
				// Don't forget deal with possibly existing carryover
				if (carryOver != 0) {

					node = new ListNode(carryOver);

					if (result == null) {
						result = node;
						cursor = result;
					} else {
						cursor.next = node;
						cursor = cursor.next;
					}
				}

				break;
			}

			node = new ListNode(nodeValue);

			// append it to linked list, move end to next
			if (result == null) {
				result = node;
				cursor = result;
			} else {
				cursor.next = node;
				cursor = cursor.next;
			}
			// null check
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}

		return result;
	}
}