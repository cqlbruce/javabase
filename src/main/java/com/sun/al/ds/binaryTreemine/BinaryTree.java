package com.sun.al.ds.binaryTreemine;

public class BinaryTree {

    private TreeNode root ;

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
    public boolean delete(int data){

        TreeNode parentNode = root ;
        TreeNode current = root ;
        boolean isleft = false ;
        while(current.key != data){
            parentNode = current;
            if(data > current.key){
                current = current.right;
            }
            if(data <current.key){
                current = current.left;
                isleft = true;
            }
            if (current == null){
                return false ;
            }
        }
        //该节点为叶子结点
        if (null == current.left && null == current.right){
            if(current == root){
                root = null ;
            }else if(isleft){
                parentNode.left = null ;
            }else{
                parentNode.right = null;
            }
            return true;
        }

        //有一个叶子结点
        if(null == current.left&&null != current.right){
            if (root == current){
                root = current.right ;
            }else if(isleft){
                parentNode.left = current.right;
            }else {
                parentNode.right = current.right ;
            }
        }else if(null != current.left&& null == current.right){
            if(root == current){
                root = current.left;
            }else if(isleft){
                parentNode.left = current.left;
            }else {
                parentNode.right = current.left;
            }
        }

        //有两个结点



        return false;
    }

    public TreeNode getSuccessor(TreeNode node){



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
