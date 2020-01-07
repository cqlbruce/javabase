package com.sun.al.ds.tree.rbtree;

import org.omg.CORBA.REBIND;

/*
https://my.oschina.net/u/3737136/blog/1649433
* 红黑树性质:
* 1、节点要么红，要么黑；
* 2、根是黑色；
* 3、所有叶子都是黑色;(叶子为Null节点)
* 4、每个红色节点的两个子节点都是黑色(从每个叶子到根的所有路劲上不能有两个连续的红色节点)
* 5、从任一节点到其每个叶子的所有简单路劲都包含相同数目的黑色节点。
*
* */
public class RbTree<T extends Comparable<T>>  {

    private RbNode<T> root ; //树的根节点
    private int size ; //树元素个数
    //标志叶子结点表示空节点
    private RbNode<T> NIL = new RbNode<T>(null , null , null ,null, Color.BLACK);



    /*
    *获取 叔叔节点
    *return 其叔节点
    * */
    public RbNode<T> uncle(RbNode<T> n){
        RbNode<T> gp = grandParent(n) ;
        if(gp == null){
            return null ;
        }

        if(n.parent == gp.left){ //若其父节点在其祖父节点左边
            return gp.right;
        }else {
            return gp.left ;
        }

    }

    /*
    *获取 祖父节点
    * */
    public RbNode grandParent(RbNode<T> n){
        if(n.parent == null) return null ;
        return n.parent.parent;
    }


    public RbNode<T> min(RbNode<T> node){
        RbNode<T> min = node ;
        while (min != NIL)
            min = min.left;
        return min == NIL ? null : min ;
    }

    public T minN(RbNode<T> node){
        RbNode<T> min = min(node);
        return min == NIL ? null : min.key;
    }

    public T max(RbNode<T> node){
        RbNode<T> max = maxN(node);
        return max == NIL ? null : max.key;
    }

    public RbNode<T> maxN(RbNode<T> node){
        RbNode<T> max = node ;
        while (max.right != null)
            max = node.right;
        return max == NIL ? null : max;
    }


    /*
    *
    * 左旋以n节点为根的子树:
    * 1、将rightChild的左子树作为n的右子树
    * 2、将rightChild作为根
    * 3、将n结点作为rightChild的左孩子
    *
    * */
    public void leftRotate(RbNode<T> node){
        // 1、将rightChild的左子树作为n的右子树
        RbNode<T> rightChild = node.right;
        node.right = rightChild.left;
        if(rightChild.left != NIL) rightChild.left.parent = node ;
        //2、将rightChild作为根
        rightChild.parent = node.parent;
        if (null == node.parent){
            root = rightChild;
        }else if(node.parent.left == node){
            node.parent.left = rightChild;
        }else{
            node.parent.right = rightChild;
        }
        //3、将n结点作为rightChild的左孩子
        rightChild.left = node;
        node.parent = rightChild.left ;
    }


    /*
    *
    * 右旋以n节点为根节点的子树
    *
    *1、将leftChild右子树作为n的左子树
    *2、将leftChild作为根节点
    *3、将n结点作为leftChild的右子树
    * */
    public void rightRotate(RbNode<T> node){

        RbNode<T> leftChild = node.left ;
        //1、将leftChild右子树作为n的左子树
        node.left = leftChild.right;
        if(leftChild.right != null) leftChild.right.parent = node ;


        //2、将leftChild作为根节点
        leftChild.parent = node.parent ;
        if(node.parent == null){
            root = leftChild;
        }else if(node.parent.left == node){
            node.parent.left = leftChild;
        }else {
            node.parent.right = leftChild ;
        }

        //3、将n结点作为leftChild的右子树
        leftChild.right = node;
        node.parent = leftChild ;
    }




}