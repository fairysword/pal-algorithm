package binarytree;

import java.util.Arrays;
import java.util.List;

public class BuildBinaryTree {

    /**
     * @param pre 前序
     * @param mid 中序
     * @return 二叉树根节点
     */
    public static TreeNode build(List<Integer> pre, List<Integer> mid) {
        return buildTree(pre, mid);
    }

    public static TreeNode buildTree(List<Integer> pre, List<Integer> mid) {
        TreeNode root = new TreeNode(pre.get(0));
        int rIndex = mid.indexOf(root.val);
        int leftLen = rIndex;
        int rightLen = mid.size() - leftLen - 1;
        if (leftLen >= 1) {
            root.left = buildTree(pre.subList(1, leftLen + 1), mid.subList(0, leftLen));
        }
        if (rightLen >= 1) {
            root.right = buildTree(pre.subList(leftLen + 1, pre.size()), mid.subList(rIndex + 1, mid.size()));
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = build(Arrays.asList(1, 2, 3, 4, 5, 7, 6, 8), Arrays.asList(3, 2, 5, 4, 6, 7, 1, 8));
        System.out.println("");
    }

}
