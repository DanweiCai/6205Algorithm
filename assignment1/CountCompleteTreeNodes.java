package assignment1;

/*
 * Solution for Question: Count Complete Tree Nodes
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */

public class CountCompleteTreeNodes {
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
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        return countNodes(root.left)+countNodes(root.right)+1;
    }
    
    /*
     * Code to run test case
     */
    public void runTest(){
        /*
         * Input: root = [1,2,3,4,5,6]
         * Expected output: 6
         */
        TreeNode node1= new TreeNode(1);
        TreeNode node2= new TreeNode(2);
        TreeNode node3= new TreeNode(3);
        TreeNode node4= new TreeNode(4);
        TreeNode node5= new TreeNode(5);
        TreeNode node6= new TreeNode(6);
        node1.left =node2;
        node1.right =node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        System.out.println("Output is: " + countNodes(node1));
    }


     public static void main(String[] args){
        CountCompleteTreeNodes instance = new CountCompleteTreeNodes();
        instance.runTest();
     }
}

