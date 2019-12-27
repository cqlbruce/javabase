package com.sun.al.ds.binaryTreemine;

public class BinaryTreeTwo {

    public Node root ;

    //查找
    public Node find(int data){
        if (root == null){
            return null ;
        }
        Node current = root ;
        while (current != null){
            if (current.key>data){
                current = current.right ;
            }else if(current.key<data){
                current = current.left;
            }else {
                return current;
            }
        }
        return null ;
    }

    //新增
    public boolean insert(int data){
        Node node = new Node(data);
        if (root == null){
            root = node ;
        }
        Node current = root ;
        Node parent = root ;
        while (current != null ){
            parent = current ;
            if(data>current.key){
                current = current.right;
                if(current == null){
                    parent.right = node ;
                    return true ;
                }
            }else if(data>current.key){
                current = current.left ;
                if(current == null){
                    parent.left = node ;
                    return true ;
                }
            }else {
                return false ;
            }
        }
        return false ;
    }

    //删除
    public boolean delete(int data){

        if (root==null){
            return false;
        }

        Node parent = root ;
        Node current = root ;
        Boolean isLeft = false ;

        while (current.key != data){
            parent = current ;
            if(data > current.key ){
                current = current.right;
            }else  if (data < current.key){
                current = current.left ;
                isLeft = true ;
            }
        }

        if(current.left == null & current.right == null){
            if(current==root){
                root = null ;
            }else if(isLeft){
                parent.left = null ;
            }else {
                parent.right = null ;
            }
        }else if(current.left == null && current.right !=null ){
            if(current == root){
                root = current.right ;
            }else if(isLeft){
                parent.left = current.right ;
            }else {
                parent.right = current.right;
            }
        }else if(current.left != null && current.right == null){
            if (current == root){
                root = current.left;
            }else if(isLeft){
                current.left = current.left;
            }else {
                current.right = current.left;
            }
        }else if(current.right != null && current.right != null){
            Node successor = getSuccessor(current);
            if(current == root){
                root = successor ;
            }else if(isLeft){
                parent.left = successor ;
            }else{
                parent.right = successor ;
            }
            successor.left = current.left ;
        }

        return false;
    }


    public Node getSuccessor(Node nodeDel){
        Node successorParent = nodeDel ;
        Node successor = nodeDel ;
        Node current = nodeDel.right;
        while (current != null){
            successorParent = successor ;
            successor = current ;
            current = current.left ;
        }
        if(nodeDel.right != successor){
            successorParent.left = successor.right;
            successor.right = nodeDel.right;
        }
        return successor ;
    }

}
