class Solution {
    public int[] twoSum(int[] nums, int target) 
        
        //refactor the input as value-index pair for faster access
        HashMap<Integer, Integer> numsIndexMap = new HashMap<>();
        
        for(int i = 0; i< nums.length; i++){
            numsIndexMap.put(nums[i], i);
        }
        
        for(int i = 0; i< nums.length; i++){
            int yang = nums[i];
            int yin = target - yang;
            
            if(numsIndexMap.containsKey(yin)){
                if(numsIndexMap.get(yin) != i){ //!!! without the condition the test case [3,2,4] 6 would fail as 3+3 =6 and there is only one 3
                    return new int[]{i, numsIndexMap.get(yin)};
                }
            }
        }
        
        return new int[2];     
    }
}
