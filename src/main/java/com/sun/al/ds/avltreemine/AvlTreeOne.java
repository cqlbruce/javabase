package com.sun.al.ds.avltreemine;

import com.sun.datastructure.tree.avl.AVLNode;

public class AvlTreeOne<T extends Comparable<T>> {

    Node<T> root ;

    public AvlTreeOne(){
        root = null ;
    }

    //获取高度
    public int height(Node<T> tree){
        if(tree != null){
            return tree.height;
        }
        return 0 ;
    }

    public int max(int a , int b){
        return a>b ? a : b;
    }

    //查找
    public Node<T> search(T data ){
        if(root==null){
            return null ;
        }
        Node<T> current = root ;
        while (current != null){
            int a = data.compareTo(current.key);
            if(a > 0){
                current = current.right;
            }else if(a < 0){
                current = current.left;
            }else {
                return current;
            }
        }
        return null ;
    }




}
