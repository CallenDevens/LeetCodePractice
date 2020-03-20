package practice;

class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int ratio = 1;
        int result = 0;
        
        if(num1.isEmpty() || num2.isEmpty()){
            return "";
        }
        
        for(int i = num1.length() - 1; i >=0; i--){
            int innerRatio = 1;
            int innerProduct = 0;
            for(int j = num2.length() - 1; j >=0; j--)
            {
                innerProduct += Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j)) *innerRatio;
                innerRatio *= 10;
            }

            result += innerProduct * ratio;
            ratio *= 10;

        }
        return result+"";
        
    }

    public static void main(String [] args){
        MultiplyStrings test = new MultiplyStrings();
        test.multiply("123", "456");

    }

}