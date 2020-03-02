class Solution {
    public boolean isMatch(String s, String p) {
        
		//invalid patterns
        if(p.startsWith("*")) return false;
        
        int i = 0;
        int j = 0;
        
        while(i < s.length() && j < p.length() ){
            char sch = s.charAt(i);
            char pch = p.charAt(j);
            if(isEqual(sch, pch)){
                i++;
                j++;
                continue;
            }else if(pch == '*'){
                int k = 0;
                char standChar = p.charAt(j - 1);
                while (i+k < s.length() && isEqual( s.charAt(i+k), standChar)){
                    k++;
                }
                i = i+k;
                j++;
            }else{
                if(j +1< p.length()&& p.charAt(j+1) == '*'){
                    j+=2;
                    continue;
                }
                return false;
            }
        }
        
        return i == s.length() && j == p.length();
    }
    
    public boolean isEqual(char schar, char pchar){
        return schar == pchar || pchar == '.';
    }
}