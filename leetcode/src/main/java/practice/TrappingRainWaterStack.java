package practice;

import java.util.ArrayDeque;
import java.util.Deque;

class TrappingRainWaterStack {

    //items of efficiency DP works better 
    public int trap(int[] height) {
        int ans = 0;
        int currentIndex = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        while(currentIndex < height.length){
            while(!stack.isEmpty() && height[stack.peek()] < height[currentIndex]){
                int top = stack.pop();

                if(stack.isEmpty()){
                    break;
                }

                int distance = currentIndex - stack.peek() - 1;
                int boundaryHeight =  Math.min(height[currentIndex], height[stack.peek()]) - height[top];

                ans += boundaryHeight * distance;

            }


            stack.push(currentIndex++);
        }

        return ans;

    }

}