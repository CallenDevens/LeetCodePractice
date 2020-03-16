package leetcode.src.main.java.practice;

class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        /*
         * the problem requires minimums space complexity, the input array nums serves
         * as both an input and a hashmap to record presence: index : element value,
         * positive or negative: present or not
         *
         * numbers of 1(placeholder for minus numbers, number larger than n+1) index 1
         * for number 1, index 2 for number 2... index 0: for number n
         */

        /*
         * IMPORTANT! please note the minimum missing positive must be a number falls
         * into the range[1, n+1], since the array consists of integers, even with
         * minimum step(1) the minimum missing number is at max n+1
         */
        int n = nums.length;
        int countOfValueOne = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                countOfValueOne++;
                break;

            }
        }
        // if 1 not is present returns 1;
        if (countOfValueOne == 0) {
            return 1;
        }

        // if 1 is present and length is 1 nums == [1] , returns 2
        if (nums.length == 1) {
            return 2;
        }

        // replace numbders less than 1 with 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);

            // in the pseudo presence hashmap key 0 points to number n
            if (abs == n) {
                nums[0] = -Math.abs(nums[0]);

            } else {
                nums[abs] = -Math.abs(nums[abs]);
            }
        }
        // Now the index of the first positive number
        // is equal to first missing positive.
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0)
                return i;
        }

        if (nums[0] > 0) {
            return nums.length;
        }
        // not in [1,n] return n+1
        return nums.length + 1;

    }

    public static void main(String[] args) {
        FirstMissingPositive test = new FirstMissingPositive();
        test.firstMissingPositive(new int[] { 2, 1 });

    }
}
