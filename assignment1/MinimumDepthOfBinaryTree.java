package assignment1;

/**
* Solution for Question: Minimum Depth of Binary Tree
* https://leetcode.com/problems/minimum-depth-of-binary-tree/
*/
class MinimumDepthOfBinaryTree {
    /*
     * Definition of TreeNode class
     */
    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
    }
    
    /*
     * Solution for Minimum depth of binary tree
     */
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null){
            return minDepth(root.right)+1;
        }
        if(root.right==null){
            return minDepth(root.left)+1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1 ;
    }

    /*
     * Code to run test case
     */
    public void runTest(){
        /*
         * Input: root = [3,9,20,null,null,15,7]
         * Expected Output: 2
         */
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println("Output is: " + minDepth(node1));
    }

    public static void main(String[] args){
        MinimumDepthOfBinaryTree instance = new MinimumDepthOfBinaryTree();
        instance.runTest();
    }
}