package assignment1;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
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
     * Solution for Leaf-Similar Trees
     */
    void dfs(TreeNode node, List<Integer> list){
        if (node==null){return;}
        if(node.left==null && node.right==null){
            list.add(node.val);
        }
        dfs(node.left,list);
        dfs(node.right,list);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1,list1);
        dfs(root2,list2);
        return list1.equals(list2);
    }

    /*
     * Code to run test case
     */
    public void runTest(){
        /*
         * Input: root1 = [1,2,3], root2 = [1,3,2]
         * Output: false
         */
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);

        System.out.println("Output is: " + leafSimilar(root1, root2));
    }

    public static void main(String[] args){
        LeafSimilarTrees instance = new LeafSimilarTrees();
        instance.runTest();
    }
}
