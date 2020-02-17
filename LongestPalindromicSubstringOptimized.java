
class Solution { 
    //loop through the array to find out the center of longest pandromic string
    public String longestPalindrome(String s) {
        if(s == null || s.isEmpty()){
            return "";
        }
        String longest = "";
        int start = 0;
        int end = 0;//inclusive

      for(int i = 0; i< s.length(); i++){
          
          int len1 = expandAroundCenter(s,i,i);// assume that i is the center of pandromic string, length is an odd number
          int len2 = expandAroundCenter(s, i, i +1);//assume that [i,i+1] os the center of pandromic string, length is an even number  marginal case: when length is 2 the range shoule be [i, i+1]
        
          int length = Math.max(len1, len2);
          int maxLength = end - start + 1;
          
          if(length > maxLength){
              //when length is 2 the range shoule be [i, i+1]
              start = i - (length -1)/2;
              end = i + length/2;
          }
              
      }
        
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        int panL = left, panR = right;
        //panL, panR: inclusive
        while (panL>=0 && panR < s.length() && s.charAt(panL) == s.charAt(panR)) {
           panL--;
           panR++;
         }
        //panR is the pos after the last pandromic char, panL is the pos before...
        //len = (lastPanRPos - lastPanLeftPos +1) = ((panR  -1) - (panL+1))+1 =
        return panR - panL - 1;
    }
  
}
