package com.sun.al.ds.tree.rbtree;

public class RbNode<T extends Comparable<T>>{
    T key ;
    RbNode<T> parent ;
    RbNode<T> left ;
    RbNode<T> right;
    Color color ;

    public RbNode(T data , RbNode<T> parent , RbNode<T> left , RbNode<T> right , Color color ){
        this.key = data ;
        this.parent = parent;
        this.left = left ;
        this.right = right;
        this.color = color;
    }



}
