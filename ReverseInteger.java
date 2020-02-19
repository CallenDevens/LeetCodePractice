class Solution {
    public int reverse(int x) {
        //min-2,147,483,648
        int result = 0;
        while(x != 0){
            int digit = x %10;
            
            //check if next calcultion would lead to overflow
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && digit > 7)){
             //greater than maximum 2,147,483,647   
             return 0;
            }
            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                //less than minimum -2,147,483,648
                return 0;
            }
            result = result*10 + digit;
            x = x/10;
        }

        return result;
    }
}