package LeetCode.StackAndQueue;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal_94 {
    List resList=new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root!=null){
            inorderTraversal(root.left);
            resList.add(root.val);
            inorderTraversal(root.right);
        }

        return resList;
    }
}
