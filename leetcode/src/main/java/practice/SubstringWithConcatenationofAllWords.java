class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // Resultant vector which stores indices. 
    List<Integer> result = new ArrayList<Integer>(); 

     if(s == null || s.isEmpty()){
         return result;
     }
    if(words.length == 0){
        return result;
    }
        
     int wordSize = words[0].length(); 
  
    // Number of words . 
    int wordCount = words.length; 
  
    // Total characters present in s. 
    int totalLen = wordSize * wordCount; 
  
  
    // If the total number of characters in list L 
    // is more than length of string S itself. 
    if (totalLen > s.length()) 
        return result;
  
    // Map stores the words present in list L 
    // against it's occurrences inside list L 
    Map<String, Integer> wordsMap = new HashMap<>(); 
  
    for (int i = 0; i < wordCount; i++)  {
        if(wordsMap.containsKey(words[i])){
            Integer count = wordsMap.get(words[i]);
            wordsMap.put(words[i],count+1); 
        }else{
             wordsMap.put(words[i],1);

        }
    }
  
    for (int i = 0; i <= s.length() - totalLen; i++) { 
        Map<String, Integer> tempWordsMap = new HashMap<>();  
        tempWordsMap.putAll(wordsMap);
        
        int j = i,count=wordCount; 
  
        // Traverse the substring 
        while (j < i + totalLen) { 
  
            // Extract the word 
            String word = s.substring(j, j+wordSize); 
  
  
            // If word not found or if frequency of current word is more than required simply break. 
            
             if (!tempWordsMap.containsKey(word)||tempWordsMap.get(word)==0) {
                 break;
             }
            // Else decrement the count of word from hash_map 
            else
            { 
            
                Integer value = tempWordsMap.get(word);
                tempWordsMap.put(word,value-1); 
                count--;
            }  
  
  
            j += wordSize; 
        } 
       
        // Store the starting index of that substring when all the words in the list are in substring 
        if (count == 0) {
            result.add(i);
        }
    } 
  
    return result; 

    }
}
}