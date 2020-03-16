class Solution {
	//recursive solution
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        
		//first chracter cannot be *
        boolean isFirstCharMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        
        if(p.length() >= 2 && p.charAt(1) == '*'){
            //move p by 2, as * needs previous charatcter
            return isMatch(s, p.substring(2)) ||// zero repeating, can be true even first c not match
                (isFirstCharMatch && isMatch(s.substring(1), p)); //repeating
            
        }else{
            return isFirstCharMatch && isMatch(s.substring(1), p.substring(1));
        }
        
    }
}