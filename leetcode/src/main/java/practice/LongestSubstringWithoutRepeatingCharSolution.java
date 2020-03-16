class Solution {
    //window sliding scan
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxlength = 0;
        
        HashMap<Character, Integer> charsetIndexMap = new HashMap<>();
        int i = 0;
        for(int j=0; j <n; j++){
            Character scanChar = s.charAt(j);
            
            if(charsetIndexMap.containsKey(scanChar)){
			/** get max i, i could be the first character within [i,j) or a chacter between i and j
			eg1: abcdefa, when the loop reaches the second a ,i is the index of the first abcdefa
			eg2 abcdefd when the loop reaches the second d ,i is the index of the first d
			**/
			
                  i = Math.max(i, charsetIndexMap.get(scanChar)) ; 
            }

                
                maxlength = Math.max(maxlength, j-i+1);

                //save j+1 into the map, not j to make the process work with exception)the whole string doesnt't contain any repeating character
               charsetIndexMap.put(scanChar, j+1);

        }
        return maxlength;
    }
}
	
