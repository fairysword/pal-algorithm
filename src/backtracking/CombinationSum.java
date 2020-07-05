package backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/combination-sum/

public class CombinationSum {

    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return lists;
        }

        List<Integer> list = new ArrayList<>();
        process(0, candidates, target, list);
        return lists;
    }

    private void process(int start, int[] candidates, int target, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                //因为每个数字都可以使用无数次，所以递归还可以从当前元素开始
                process(i, candidates, target - candidates[i], list);
                list.remove(list.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> res = new CombinationSum().combinationSum(new int[] {2, 3, 6, 7}, 7);
        System.out.println(res);
    }
}
