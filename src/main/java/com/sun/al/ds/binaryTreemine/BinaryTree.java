package com.sun.al.ds.binaryTreemine;

public class BinaryTree {

    //树结点
    class TreeNode{
        int key ;
        TreeNode left ;
        TreeNode right;
        TreeNode(int key){

        }
    }

    //增加
    public TreeNode insert(int value , TreeNode root){

        TreeNode node = new TreeNode(value);
        if(null == root){
            return new TreeNode(value) ;
        }
        TreeNode current = root ;
        while (true){
            if (value > current.key){
                if(null == current.right){
                    current.right = node ;
                    break;
                }
                current = current.right;
            }
            if(value < current.key){
                if(null == current.left){
                    current.left = node ;
                    break;
                }
                current = current.left ;
            }
        }
        return node ;
    }

    //删除
    public void delete(TreeNode node , TreeNode root ){

        TreeNode parentNode = node ;
        TreeNode current = node ;

        boolean isleft = false ;

//        while(){
//
//
//        }
        if (null == node.left && null == node.right){


        }



    }

    //查询
    public TreeNode find(int value , TreeNode root){
        if(null == root){
            return null;
        }
        TreeNode current = root ;
        while (true){
            if(value>current.key){
                current = current.right ;
                if(null == current){
                    return null ;
                }
            }
            if(value<current.key){
                current = current.left;
                if(null == current){
                    return null ;
                }
            }
            return current ;
        }
    }

}
