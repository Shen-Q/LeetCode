//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 67 👎 0

package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.*;

//Java：从上到下打印二叉树 III
public class IIICongShangDaoXiaDaYinErChaShuIiiLcof{
    public static void main(String[] args) {
        Solution solution = new IIICongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
        // TO TEST
        TreeNode root = new TreeNode(3);
        TreeNode right = root.right = new TreeNode(20);
        root.left=new TreeNode(9);
        right.left=new TreeNode(15);
        right.right=new TreeNode(7);
        List<List<Integer>> L = new LinkedList<>();
        L=solution.levelOrder(root);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

//Definition for a binary tree node.
public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        //这里用Queue和用Deque的区别是？
        List<List<Integer>> list = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for(int i=q.size();i>0;i--){ //这里必须用i--，因为q.size()是会更新滴！
                TreeNode node = q.poll();
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
                tmp.add(node.val);
            }
            list.add(tmp);
        }
        List<List<Integer>> res =new LinkedList<>();
        for(int i=0;i<list.size();i++){
            if(i%2==0){
                res.add(list.get(i));
            }else{
                Collections.reverse(list.get(i)); //机智地学会了collections的reverse用法！
                res.add(list.get(i));
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}