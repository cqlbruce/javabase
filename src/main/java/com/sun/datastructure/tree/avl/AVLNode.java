package com.sun.datastructure.tree.avl;

public class AVLNode<T extends  Comparable<T>> extends TreeNode<T>{

    public AVLNode<T> left ;

    public AVLNode<T> right ;

    public T data ;

    public int height ;

    public AVLNode(T data){
        this.data = data;
    }

}
