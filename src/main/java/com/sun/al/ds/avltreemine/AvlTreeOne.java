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

    public Node<T> leftLeftRotation(Node<T> k2){
        Node<T> k1 ;
        k1 = k2.left ;
        k2.left = k1.right;
        k1.right = k2 ;
        k1.height = max(height(k1.left) , k2.height) + 1 ;
        k2.height = max(height(k2.left),height(k1.right)) + 1 ;
        return k1 ;
    }

    public Node<T> rightRightRotation(Node<T> k1){

        Node<T> k2 ;

        k2 = k1.right ;
        k1.right = k2.left ;
        k2.left = k1 ;

        k2.height = max(k1.height , height(k2.right)) + 1 ;
        k1.height = max(height(k1.left) , height(k1.right)) + 1 ;

        return k2 ;

    }


}
