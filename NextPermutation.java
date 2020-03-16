class Solution {
	public void nextPermutation(int[] nums) {

		// larget permutation should be in descending oreder like(5,4,3,2,1)
		int i = nums.length - 2;

		// find the first number that is not in order, start from right(if it is
		// equal fetch the leftest number)
		while (i >= 0 && nums[i] >= nums[i + 1]) {// !!!
			i--;
		}
		if (i >= 0) {
			// swap it with a larger number

			int j = nums.length - 1;
			while (j >= 0 && nums[j] <= nums[i]) {// !!!!
				j--;
			}
			swap(nums, i, j);
			// the largest per with all nums fixed before it. reverse it to get
			// a relatively small permutation as " the next permutation"

		}
		reverse(nums, i + 1);

	}

	private void reverse(int[] nums, int start) {
		int i = start, j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}