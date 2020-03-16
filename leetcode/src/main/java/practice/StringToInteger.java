class Solution {
    public int myAtoi(String str) {
        int start = 0;
        boolean minus = false;
        
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            
            if(Character.isSpace(ch)){
                continue;
            }
            
            if(!Character.isDigit(ch)){
                if(i == str.length() - 1){
                    return 0;
                }
                
                if(ch == '-'){
                    minus = true;
                    start =i+1;
                    break;

                }else if (ch == '+'){
                    start =i+1;
                    break;
                }else{
                    return 0;
                }
                /*
                if(ch != '-'){
                    return 0;
                }else if(ch == '+')
                    minus = true;
                    start =i+1;
                    break;
                }
                */
            }
            if(Character.isDigit(ch)){
               start = i;
                break;
            }
        }
        
        
        int result = 0;
        for(int j = start; j < str.length(); j++){
            char ch = str.charAt(j);
            if(!Character.isDigit(ch)){
                break;
            }
            int digit = Character.getNumericValue(ch);
            if(minus){
                digit = -digit;
            }
            
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && digit >7)){
                return Integer.MAX_VALUE;
            }
            if(result < Integer.MIN_VALUE/10 ||(result == Integer.MIN_VALUE/10 && digit < -8)){
                return Integer.MIN_VALUE;
            }
            
           result = result *10 + digit;

               
        }
               
               return result;
    }
}