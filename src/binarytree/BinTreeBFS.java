package binarytree;

import java.util.*;

/**
 * 广度有限遍历，用队列
 */
public class BinTreeBFS {

    static List<Integer> bfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = BuildBinaryTree.build(Arrays.asList(1, 2, 3, 4, 5, 7, 6, 8), Arrays.asList(3, 2, 5, 4, 6, 7, 1, 8));
        List<Integer> res = bfs(root);
        System.out.println();
    }

}
