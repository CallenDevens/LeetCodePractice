package leetcode.src.main.java.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, ans, target, 0, new ArrayList<>());
        return ans;

    }

    private void helper(int[] candidates, List<List<Integer>> ans, int target, int index, ArrayList<Integer> result) {

        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add((ArrayList) result.clone());
        }

        for (int i = index; i < candidates.length; i++) {

            result.add(candidates[i]);
            helper(candidates, ans, target - candidates[i], i + 1, result);
            result.remove(result.size() - 1);

            // to skip duplicated solutions..
            while (i + 1 < candidates.length && candidates[i + 1] == candidates[i])
                ++i;

        }

    }

}
