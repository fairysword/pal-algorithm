package binarytree;

import java.util.*;

public class BinTreeTraversal {

    // 前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(root);
        while (!treeNodeStack.isEmpty()) {
            TreeNode node = treeNodeStack.pop();
            if (node == null) {
                continue;
            }
            res.add(node.val);
            treeNodeStack.push(node.right);
            treeNodeStack.push(node.left);
        }
        return res;
    }

    // 后序遍历，算法与前序基本一致，部分操作有差别
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(root);
        while (!treeNodeStack.isEmpty()) {
            TreeNode node = treeNodeStack.pop();
            if (node == null) {
                continue;
            }
            res.add(node.val);
            treeNodeStack.push(node.left); // 这里先压栈左子树，是为了形成中右左的结果，最后只需将结果反转即可
            treeNodeStack.push(node.right);
        }
        Collections.reverse(res); // 中右左反转即左右中，即后序遍历
        return res;
    }

    // 中序遍历的算法不仅右栈，还需要指针来切换节点，因为中序遍历的初始节点并不是要访问的节点
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }

    // 可以看到上述前后遍历和中序遍历的算法不同，目前右两种统一的方式，
    // 第一种即将前后遍历的算法转换为中序的方式
    // 第二种即将中序的算法统一为前者

    public static void main(String[] args) {
        TreeNode root = BuildBinaryTree.build(Arrays.asList(1, 2, 3, 4, 5, 7, 6, 8), Arrays.asList(3, 2, 5, 4, 6, 7, 1, 8));
        List<Integer> res = new BinTreeTraversal().inorderTraversal(root);
        res = new BinTreeTraversal().preorderTraversal(root);
        res = new BinTreeTraversal().postorderTraversal(root);
        System.out.println("");
    }

}
