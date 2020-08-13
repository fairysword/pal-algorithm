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

    static int treeDepth(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> curLevel = new ArrayDeque<>();
        Queue<TreeNode> nextLevel = new ArrayDeque<>();

        curLevel.add(root);
        while (!curLevel.isEmpty()) {
            TreeNode node = curLevel.poll(); // 当前层
            if (node != null) {
                if (node.left != null) {
                    nextLevel.add(node.left); // 下一层
                }
                if (node.right != null) {
                    nextLevel.add(node.right); // 下一层
                }
            }
            if (curLevel.isEmpty()) {
                depth++;
                Queue<TreeNode> tmp = curLevel; // 交换队列
                curLevel = nextLevel;
                nextLevel = tmp;
            }
        }
        return depth;
    }

    static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int res = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            res++;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode t = q.poll();
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = BuildBinaryTree.build(Arrays.asList(1, 2, 3, 4, 5, 7, 6, 8), Arrays.asList(3, 2, 5, 4, 6, 7, 1, 8));
        List<Integer> res = bfs(root);
        System.out.println(treeDepth(root));
        System.out.println(maxDepth(root));
    }

}
