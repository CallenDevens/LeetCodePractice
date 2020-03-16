package leetcode.src.main.java.practice;

import java.util.ArrayList;
import java.util.List;

//backtracking and binary
class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void helper(int[] cans, int target, List<List<Integer>> res, ArrayList<Integer> list, int index) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add((ArrayList) list.clone());
            return;
        }
        for (int i = index; i < cans.length; i++) {
            list.add(cans[i]);
            helper(cans, target - cans[i], res, list, i);
            list.remove(list.size() - 1);
            // pop the element
        }
    }

    public static void main(String[] args) {
        CombinationSum test = new CombinationSum();
        int[] candidates = new int[] { 2, 3, 6, 7 };

        System.out.println(test.combinationSum(candidates, 7));

        // candidates = new int[] { 2, 3, 5 };

        // System.out.println(test.combinationSum(candidates, 8));

        // int[] candidates = new int[] { 1, 2 };

        // System.out.println(test.combinationSum(candidates, 3));

        // int[] candidates = new int[] { 1, 2 };

        // System.out.println(test.combinationSum(candidates, 4));

        // candidates = new int[] { 2, 3, 5 };

        // System.out.println(test.combinationSum(candidates, 7));

    }
}
