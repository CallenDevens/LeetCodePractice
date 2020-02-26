class Solution {
    List<String> result = new ArrayList<>();
     Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
      }};


    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return result;
        }
        backTrack("", digits);
        return result;
        
    }
    
    public void backTrack(String combination, String leftDigits){
        if(leftDigits.length() == 0){
            result.add(combination);
        }else{
            String digit = leftDigits.substring(0,1);
            String letters = phone.get(digit);
            
            for(int i = 0; i < letters.length(); i++){
                String letter = letters.substring(i, i+1);
                backTrack(combination+letter, leftDigits.substring(1));
            }
        }
        
    }

}