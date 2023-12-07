package assignment1;
import java.util.List;
import java.util.ArrayList;

public class FindLargestValueInEachTreeRow {
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

    void dfs(TreeNode node, List<Integer> res, int level){
        if(node==null) return;
        if(res.size()==level){
            res.add(node.val);
        }else{
            res.set(level, Math.max(res.get(level), node.val));
        }

        dfs(node.left, res, level+1);
        dfs(node.right, res, level+1);
    }

    /*
     * Solution for Find Largest Value in Each Tree Row
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(root, res, 0);
        return res;
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

        List<Integer> res = largestValues(root1);
        System.out.println("Output is: " + res);
    }

    public static void main(String[] args){
        FindLargestValueInEachTreeRow instance = new FindLargestValueInEachTreeRow();
        instance.runTest();
    }
}
