package binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树前中后，迭代遍历的统一算法形式，转向思路https://juejin.im/post/6844903503807119374
 */
public class BinTreeTraversalUnion {

    static List<Integer> dfsPreOrder(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                results.add(cur.val); // 前序在这里就访问节点
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right; // 转向
        }
        return results;
    }

    static List<Integer> dfsInOrder(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            results.add(cur.val); // 中序在这里访问节点
            cur = cur.right; // 转向
        }
        return results;
    }

    static List<Integer> dfsPostOrder(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;
        while(cur != null || !stack.empty()){
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == last) { // 右子树为空或者右子树已经访问过
                results.add(cur.val);
                stack.pop();
                last = cur; // 记录上一个访问的节点, 用于判断“访问根节点之前，右子树是否已访问过”
                cur = null; // 表示不需要转向，继续弹栈
            } else {
                cur = cur.right; // 转向
            }
        }

        return results;
    }


    public static void main(String[] args) {
        TreeNode root = BuildBinaryTree.build(Arrays.asList(1, 2, 3, 4, 5, 7, 6, 8), Arrays.asList(3, 2, 5, 4, 6, 7, 1, 8));
        List<Integer> res = BinTreeTraversalUnion.dfsPreOrder(root);
        res = BinTreeTraversalUnion.dfsInOrder(root);
        res = BinTreeTraversalUnion.dfsPostOrder(root);
        System.out.println();
    }
}
