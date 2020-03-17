package practice;

class TrappingRainWaterDP {

    public int trap(int[] height) {

        // the minimum of maximum height of bars on both the sides minus its own height. can be stored

        if(height.length == 0 || height.length == 1){
            //cannnot trap water
            return 0;
        }

        int ans = 0;
        int n = height.length;
        int [] maxHeightFromLeft = new int[n];
        int [] maxHeightFromRight = new int[n];

        int maxLeftHeight = 0;
        for(int i = 0; i <n; i++){
            if(height[i] > maxLeftHeight){
                maxHeightFromLeft[i] = height[i];
                maxLeftHeight = height[i];
            }else{
                
                maxHeightFromLeft[i] = maxLeftHeight;
            }
        }
        int maxRightHeight = 0;
        for(int i = n-1; i >=0; i--){
            if(height[i] > maxRightHeight){
                maxHeightFromRight[i] = height[i];
                maxRightHeight = height[i];
            }else{
                maxHeightFromRight[i] = maxRightHeight;
            }
        }

        for(int i = 1; i < n; i++){
            ans += Math.min(maxHeightFromLeft[i], maxHeightFromRight[i]) - height[i];
        }

        return ans;
    }

    public static void main(String [] args){
        TrappingRainWaterDP test  = new TrappingRainWaterDP();
       test.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
    
}