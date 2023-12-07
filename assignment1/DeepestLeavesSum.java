package assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeepestLeavesSum {
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
     * Solution for Deepest Leaves Sum
     */
    int maxLevel = -1;

    void traveseTree(TreeNode node, Map<Integer,List<Integer>> map, int level){
        if(node==null) return;
        if(!map.containsKey(level)){
            map.put(level, new ArrayList<Integer>());
        }

        if(level>maxLevel) maxLevel = level;

        map.get(level).add(node.val);
        if(node.left!=null){
            traveseTree(node.left, map, level+1);
        }
        if(node.right!=null){
            traveseTree(node.right, map, level+1);
        }
    }

    public int deepestLeavesSum(TreeNode root) {
        if (root==null)
            return 0;
        Map<Integer,List<Integer>> map = new HashMap<>();
        traveseTree(root, map, 0);
        List<Integer> list = map.get(maxLevel);
        int sum = 0;
        for(int num: list){
            sum+= num;
        }
        return sum;
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

        System.out.println("Output is: " + deepestLeavesSum(root1));
    }

    public static void main(String[] args){
        DeepestLeavesSum instance = new DeepestLeavesSum();
        instance.runTest();
    }
}
