package assignment1;

import java.util.List;
import java.util.ArrayList;

public class FindLeaves {
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

    List<List<Integer>> solution;

    int getHeight(TreeNode node){
        if(node==null) return -1;

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        int currHeight = Math.max(leftHeight, rightHeight) + 1;
        if(solution.size()==currHeight){
            solution.add(new ArrayList<>());
        }

        solution.get(currHeight).add(node.val);

        return currHeight;
    }

    /*
     * Solution for Find Leaves of Binary Tree
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        solution = new ArrayList<>();
        getHeight(root);
        return solution;
    }

    /*
     * Code to run test case
     */
    public void runTest(){
        /*
         * Input: root1 = [1,2,3]
         * Output: 5
         */
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        List<List<Integer>> ans = findLeaves(root1);
        System.out.println("Output is: "+ ans );
    }

    public static void main(String[] args){
        FindLeaves instance = new FindLeaves();
        instance.runTest();
    }
}
