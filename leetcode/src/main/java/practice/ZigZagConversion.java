class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1) return s; //marginal cases

        List<StringBuilder> rows = new ArrayList<>();

        for(int i = 0; i< Math.min(numRows, s.length()); i++){ // s could be not long enough to fill the row number; ex. s: aaa numRwos:9
            rows.add(new StringBuilder());
        }
        int cursorRow = 0; //depth;
        boolean movingDown = false; // initialize as false, it would be updated in the first loop soon...
        for(int j = 0; j < s.length(); j++){
            char ch = s.charAt(j);
            rows.get(cursorRow).append(ch);
            if(cursorRow == 0 || cursorRow == numRows -1){
                movingDown = !movingDown;
            }
            if(movingDown){
            	cursorRow++;
            }else{
            	cursorRow--;
            }
            
        }
        
        
        //concatenate string
        StringBuilder resultBuilder = new StringBuilder();
        
        for(StringBuilder sb: rows){
            resultBuilder.append(sb.toString());
        }
        
        return resultBuilder.toString();
        
    }
}