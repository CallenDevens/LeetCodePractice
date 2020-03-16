class Solution {
    public boolean isPalindrome(int x) {
        
        if((x%10 == 0 && x!=0) || x < 0){
            return false;
        }
        //reverse first half of the number compare it with the second half
        // if reversed == left (even number length such as 1001)
        // or reversed/10 == left(odd number length such as 12321) the this is a palindrome number

        int reverse = 0;
        while(x > reverse){//reverse could > or == xwhile the loop ends{
            
            reverse = reverse*10 + x%10;
            x = x/10;
        }
    
        return reverse == x || reverse /10 ==x;
    }
}