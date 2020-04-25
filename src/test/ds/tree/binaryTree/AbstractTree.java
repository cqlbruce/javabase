package com.sun.al.ds.binaryTree;

public abstract class  AbstractTree {

    public int count = 0 ;

    //查
    public abstract Node find(int count);

    //增
    public abstract boolean insert(int count);

    //删
    public abstract boolean delete(int count);

    /*
    * 节点个数
    * */
    public int count(){
        return this.count;
    }

}
