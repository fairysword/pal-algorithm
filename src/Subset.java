import java.util.ArrayList;
import java.util.List;

public class Subset {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        searchElement(0, result, new ArrayList<>(), nums);
        return result;
    }

    // 回溯法
    void searchElement(int index, List<List<Integer>> result, List<Integer> list, int[] nums) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        searchElement(index + 1, result, list, nums);
        list.remove(list.size() -1 );
        searchElement(index + 1, result, list, nums);
    }

    // 位运算法
    List<List<Integer>> bitmap(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int N = 1 << nums.length;
        for (int i = 0; i < N; i ++) {
            List<Integer> list = new ArrayList<>();
            for  (int j = 0 ; j < nums.length; j ++) {
                int t =  (i >> j) & 1;
                if (t == 1) {
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Subset().bitmap(new int[] {1, 2, 3});
        System.out.println(res);
        System.out.println(res.size());
    }
}
