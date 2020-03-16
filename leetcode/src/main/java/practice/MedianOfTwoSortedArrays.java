class Solution {
	public double findMedianSortedArrays(int[] a, int[] b) {
		
		/*
		To get the median
		fetch the last element of Left part of the(virtually merged) list (size of the merged list is an odd number) 
		or the result of(lastElement of left part + first element of right part)/2.0 
		(must be 2.0 to convert the result to a double number
		*/
		
		if (a.length > b.length) {
			int[] temp = a;
			a = b;
			b = temp;
		}// search the shorter element 1. faster  2, ensure bCount(leftPartLen - aCount >0) 
		int m = a.length;
		int n = b.length;

		int leftPartCount = (m + n + 1) / 2;

		int minCount = 0;// [minCount,maxCount
							// ] range of number of elements nums1
							// contributes to the left part of
							// virtually merged array
		int maxCount = m;
		int rightPartStart = 0;
		int leftPartEnd = 0;

		boolean isOdd = (m + n) % 2 != 0;

		while (true) {

			// middle of possible count use binary search
			int aCount = minCount + (maxCount - minCount + 1) / 2;
			int bCount = leftPartCount - aCount;

			if (aCount > 0 && bCount > 0 && aCount < m && bCount < n) {

				if (a[aCount - 1] <= b[bCount] && b[bCount - 1] <= a[aCount]) {
					// return this.getMedian(isOdd, a, b, aCount, bCount);
					if (isOdd) {
						return a[aCount - 1] > b[bCount - 1] ? a[aCount - 1] : b[bCount - 1];
					} else {
						leftPartEnd = a[aCount - 1] > b[bCount - 1] ? a[aCount - 1] : b[bCount - 1];
						rightPartStart = a[aCount] > b[bCount] ? b[bCount] : a[aCount];
						return (leftPartEnd + rightPartStart) / 2.0;
					}
				} else if (a[aCount - 1] > b[bCount]) {
					maxCount--;
				} else if (a[aCount] < b[bCount - 1]) {
					minCount++;
				}
			} else if (aCount == 0)// bCount = leftPartCount
			{
				if(a.length != 0 && a[aCount] < b[bCount -1]){
					minCount++;
					continue;
				}
				if (isOdd) {
					return b[bCount - 1];
				} else {
					leftPartEnd = b[bCount - 1];
					rightPartStart = bCount<n? 
							(a.length == 0?b[bCount]:
							(b[bCount] >a[0]? 
									a[0]: b[bCount])): a[0];
							
					return (leftPartEnd + rightPartStart) / 2.0;
				}
			} else if (bCount == 0) {
				if(b.length != 0 && b[bCount] < a[aCount -1]){
					maxCount--;
					continue;
				}

				if (isOdd) {
					return a[aCount - 1];
				} else {
					leftPartEnd = a[aCount - 1];
					rightPartStart = aCount < m? (b.length == 0?a[aCount]:(a[aCount]>b[0]?b[0]:a[aCount])): b[0];
					return (leftPartEnd + rightPartStart) / 2.0;
				}
			} else if (aCount == m) {// shorter length please note that m+n+1/2 is larger than m, still need 
				if (a[aCount - 1] > b[bCount]) {
					maxCount--;
					continue;
				} else {
					if (isOdd) {
						return a[aCount - 1] > b[bCount - 1] ? a[aCount - 1] : b[bCount - 1];
					} else {
						leftPartEnd = a[aCount - 1] > b[bCount - 1] ? a[aCount - 1] : b[bCount - 1];
						rightPartStart = b[bCount];
						return (leftPartEnd + rightPartStart) / 2.0;
					}
				}
			} else if (bCount == n) {
				if(b[bCount-1] > a[aCount]){
					minCount++;
					continue;
				}
				if (isOdd) {
					return a[aCount - 1] > b[bCount - 1] ? a[aCount - 1] : b[bCount - 1];
				} else {
					leftPartEnd = a[aCount - 1] > b[bCount - 1] ? a[aCount - 1] : b[bCount - 1];
					rightPartStart = a[aCount];
					return (leftPartEnd + rightPartStart) / 2.0;
				}
			}
		}
	}

}