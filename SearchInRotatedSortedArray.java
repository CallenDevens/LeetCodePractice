class Solution {
    /*
    one-pass binary search. 
    has the best efficiency. faster than 100%. 
    will see what happens after refatoring it as recusrion solution
    */
    public int search(int[] nums, int target) {
        int i = 0; int j = nums.length-1;
        
        if(nums.length == 0){
            return -1;
        }
        int firstElem = nums[0];
        int lastElem = nums[nums.length-1];

        while(i <= j){//the eual
            int mid = i + (j-i+1)/2; //index caculation
            int midValue = nums[mid];
            
            if(midValue == target){
                return mid;
            }
            if(midValue > firstElem){
                if(target < midValue && target >= firstElem){//!! the equal
                    j = mid - 1;
                }else{
                    i = mid + 1;
                }
            }else if (midValue < firstElem){
                if(target <= lastElem && target > midValue){//the equal
                    i = mid + 1;
                }else{
                    j = mid - 1;
                }

            }else{
                break;
            }
        }
        
        return -1;
        
    }
}