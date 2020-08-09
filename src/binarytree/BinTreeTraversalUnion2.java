package binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// 在访问根节点后添加标志位null
// https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/che-di-chi-tou-er-cha-shu-de-qian-zhong-hou-xu-di-/
public class BinTreeTraversalUnion2 {

    static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.empty()) {
            TreeNode node = st.pop();
            if (node != null) {
                if (node.right != null) st.push(node.right);    // 右
                if (node.left != null) st.push(node.left);      // 左
                st.push(node); st.push(null);              // 中
            } else { // 遇到null就代表要访问节点了
                node = st.pop();
                results.add(node.val);            // 节点处理逻辑
            }
        }
        return results;
    }

    static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.empty()) {
            TreeNode node = st.pop();
            if (node != null) {
                if (node.right != null) st.push(node.right);    // 右
                st.push(node); st.push(null);              // 中
                if (node.left != null) st.push(node.left);      // 左
            } else {
                node = st.pop();
                results.add(node.val);            // 节点处理逻辑
            }
        }
        return results;
    }

    static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.empty()) {
            TreeNode node = st.pop();
            if (node != null) {
                st.push(node); st.push(null);              // 中
                if (node.right != null) st.push(node.right);    // 右
                if (node.left != null) st.push(node.left);      // 左
            } else {
                node = st.pop();
                results.add(node.val);            // 节点处理逻辑
            }
        }
        return results;
    }

    public static void main(String[] args) {
        TreeNode root = BuildBinaryTree.build(Arrays.asList(1, 2, 3, 4, 5, 7, 6, 8), Arrays.asList(3, 2, 5, 4, 6, 7, 1, 8));
        List<Integer> res = BinTreeTraversalUnion2.preorderTraversal(root);
        res = BinTreeTraversalUnion2.inorderTraversal(root);
        res = BinTreeTraversalUnion2.postorderTraversal(root);
        System.out.println();
    }
}
