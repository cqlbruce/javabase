package com.sun.al.ds.avltreemine;

public class Node<T extends Comparable<T>>{

    T key ; //值
    int height;//高度
    Node<T> left ; //左孩子
    Node<T> right ; //右孩子

    public Node(Node<T> left , Node<T> right , T data , int height){
        this.left = left ;
        this.right = right ;
        this.key = data ;
        this.height = 0;
    }

}
