package com.sun.al.ds.tree.rbtree;

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
    *获取
    * */
    public RbNode grandParent(RbNode<T> n){
        if(n.parent == null) return null ;
        return n.parent.parent;

    }


}
