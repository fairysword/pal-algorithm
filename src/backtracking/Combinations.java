package backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/combinations/

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        searchElement(0, result, new ArrayList<>(), n, k);
        return result;
    }

    void searchElement(int index, List<List<Integer>> result, List<Integer> list, int n, int k) {
        if (index >= n || list.size() == k) {
            if (list.size() == k) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(index + 1);
        searchElement(index + 1, result, list, n, k);
        list.remove(list.size() - 1);
        searchElement(index + 1, result, list, n, k);
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Combinations().combine(4, 2);
        System.out.println(result);
        System.out.println(result.size());
    }
}
