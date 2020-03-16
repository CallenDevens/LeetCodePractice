class Solution {
    public int removeDuplicates(int[] nums) {
        int dupStart = 0;
        
        for(int dupEnd = 1 ; dupEnd< nums.length; dupEnd++){
            if(nums[dupStart] != nums[dupEnd]){
                dupStart++; //move it forward
                nums[dupStart] = nums[dupEnd];
            }
        }
        
        return dupStart+1;//length!
    }
}