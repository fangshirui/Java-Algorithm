package com.二叉树.二叉树的最近公共祖先236;

import com.TreeNode;


/*

给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
（一个节点也可以是它自己的祖先）。”

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。

输入：
     3
   /  \
  1    4

输出： 节点1和4的公共祖先是节点3


输入：
    3
   / \
  1   4

输出： 节点3和4的公共祖先是节点3

 */
public class Solution {
    // 关于二叉树的问题都可以用递归来遍历
    // 通过构造深度优先搜索，选择一个递归模式。自行构造合适的递归方法，就可以得到答案，
    // 该递归方法，返回的不是题目要求的最后结果，而只是中间结果。！！！！

    // 新建一个变量，用于在递归方法中保存，题目结果的变量

    private TreeNode res = null;

    // 构建递归方法 : 节点root 是否 包含节点p 或者 节点q
    // 注意在递归方法中保存外部res变量
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }

        // 左子树是否包含有 p 或者 q
        boolean left = dfs(root.left, p, q);
        // 右子树是否包含有 p 或者 q
        boolean right = dfs(root.right, p, q);


        // 若 root 是 p 和 q 的公共父节点
        if( left && right  || (root.val == p.val || root.val == q.val) && (left || right) ){
            res = root;
        }

        return left || right || root.val == p.val || root.val == q.val;
    }



    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }
}

class Test{
    public static void main(String[] args) {
        Solution s = new Solution();

        /*
                  3
                 / \
                10  13
                   / \
                  5   9
         */

        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(9);
        root.left = new TreeNode(10);
        root.right = new TreeNode(13);
        root.right.left = p;
        root.right.right = q;

        System.out.println(s.lowestCommonAncestor(root, p, q).val);



    }
}
