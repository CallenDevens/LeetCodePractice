class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
		 int minDiff = Integer.MAX_VALUE;

         Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++){
            int left = i+1, right = nums.length-1;
            
            while(left<right){
                int sum = nums[i] + nums[left]+ nums[right];
                int diff = sum-target;
                
                if(Math.abs(diff) < Math.abs(minDiff)){
                    minDiff = diff;
                   closestSum = sum;
                }
                
                if(sum > target){
                    right--;
                }else if(sum < target){
                    left++;
                }else{
                    return sum;
                }
            }
        }
        
        return closestSum;
        
    }
}