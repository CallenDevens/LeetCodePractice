class Solution {
    String [] parentheses = new String []{"(", ")"};
    List<String> result = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        this.backTracking("",0,0, n);
        return result;
    }
    
    private void backTracking(String combination, int open, int close, int n){
        if(combination.length() == n * 2) {
            result.add(combination);
            
        }else{//!!!
            if(open < n){
                backTracking(combination+"(", open+1, close, n);
            }
            if(close<open){
                 backTracking(combination+")", open, close +1, n);
            }
        }
        
    }
}