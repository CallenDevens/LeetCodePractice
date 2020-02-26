class Solution {
    //it's an interesting problem, reminding me of the sc fiction The Gods Themselves
    //I have a brute force solution TC O(n^2)
    //I wanna implement it by sorting and binary search TC (n + n*logn)
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays. sort(nums);

       List<List<Integer>> solution=new ArrayList<>();

        for(int i = 0; i< nums.length; i++){
            int elem1 = nums[i];
            if(i!=0&&nums[i]==nums[i-1]){
                continue;
            }

            int requireSum = 0-elem1;
            
            int j=i+1, k=nums.length-1;
            //could this be optimized binary search?? which requies 4 index to rack the range of 2 numbers.....a bit annoying to human brain
            while(j<k){
                
                if(nums[j] + nums[k] > requireSum){
                    k--;// reduce max element
                }else if(nums[j] + nums[k] < requireSum){
                    j++;
                }else{
                    if(j!=i+1 && nums[j] == nums[j-1] ){
                        //duplicated couple
                        k--;
                        j++;
                        continue;
                    }
                    
                    solution.add(Arrays.asList(nums[i],nums[j], nums[k]));
                    k--;
                    j++;

                }
            }
        }
        return solution;
        
    }
}