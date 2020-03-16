class Solution {
    public int strStr(String haystack, String needle) {
        if(needle ==null ||needle.isEmpty() || haystack.equals(needle)){
            return 0;
        }
        for(int i = 0; i <haystack.length() - needle.length()+1;i++){
            char ch = haystack.charAt(i);
           

            if(ch == needle.charAt(0)){
                boolean find = true;

                for(int j =1; j<needle.length();j++){
                    if(!(needle.charAt(j) == haystack.charAt(i+j))){
                        find = false;
                        break;
                    }
                }
                
                if(find) return i;
            }
            
        }
        
        return -1;
    }
}