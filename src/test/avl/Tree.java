package com.sun.datastructure.tree.avl;

public interface Tree<T extends Comparable<T>> {



    boolean isEmpty();

    int size();

    int height();

    String preOrder();

    String postOrder();

    String levelOrder();

    void insert(T data);

    void remove(T data);

    T findMax();

    TreeNode findNode(T data);

    boolean contains(T data) throws Exception;

    void clear();

}
