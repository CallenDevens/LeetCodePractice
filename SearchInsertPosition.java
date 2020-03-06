class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int left = 0, right = nums.length - 1;
        int maxIndex = nums.length - 1;
        
        while(left <= right){
            int mid = left + (right-left +1)/2;
            
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                if(mid < maxIndex && nums[mid + 1] > target){
                    return mid + 1;
                }
                left = mid + 1;
                
            }else {
                if(mid > 0 && nums[mid -1] < target){
                    return mid;

                }
                right = mid - 1;
            }
        }
        
        return left;
        
    }
}Search Insert PositionSearch Insert PositionSearch Insert PositionSearch Insert PositionSearch Insert PositionSearch Insert Position