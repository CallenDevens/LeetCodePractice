class Solution {

    public int longestValidParentheses(String s) {

        int maxAns = 0;
        int dp[] = new int[s.length()];// ith element of \text{dp}dp represents the length of the longest valid
                                       // substring ending at iith index.
        // by default all 0
        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;

                } else if (i - dp[i - 1] > 0 // ensure that i - dp[i - 1] - 1> 0 to avoid
                        && s.charAt(i - dp[i - 1] - 1) == '(') {// '(((())))' spread accross to find the first half for
                                                                // s[i]
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;// case 0
                }
                maxAns = Math.max(maxAns, dp[i]);

            }
        }

        return maxAns;

    }
}
