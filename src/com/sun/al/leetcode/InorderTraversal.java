package sun.al.leetcode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {


    static class TreeNode{
        int val ;
        TreeNode left;
        TreeNode right;
        TreeNode(){
        }
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val , TreeNode left , TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0 , node1,node2);

        inorderTraversal1(node0,list);

        for (Integer i : list){
            System.out.print(i+" ");
        }

    }

    public static List<Integer> inorderTraversal1(TreeNode root , List<Integer> list ){

        if(root.left!=null){
            inorderTraversal1(root.left , list);
        }

        list.add(root.val);

        if (root.right!=null){
            inorderTraversal1(root.right,list);
        }

        return list ;
    }



}
