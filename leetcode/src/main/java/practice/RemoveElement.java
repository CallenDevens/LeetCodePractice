class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) {
            return 0;
        }
    
        int len = nums.length;
        int left = 0, right = nums.length-1;
        
        if(left == right && nums[0] == val){ return 0;}
        while(left < right){
            while( left <=nums.length-1 && nums[left]!=val ){
                left++;

            }
            
            if(left == nums.length){return len;}

            while( right >=0 &&nums[right]==val ){
                right--;
                len--;//!!!
            }
            
            if(right < 0){return 0;}
            if(left<right){

            nums[left] = nums[right];
            nums[right] = val;
               left++;//!!!
            right--;//!!!
                len--;


            }
        }
        if(left == right && nums[left] == val){len--;}
        
        return len;
        
    }
}43at4