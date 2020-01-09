package com.sun.al.ds.tree.btree;

public class BtNode<K extends Comparable<K> , V> {

    //构成B树的最小度
    public final static int MIN_DEGREE = 3 ;

    //除根节点外，每个节点中总键数的下限
    public final static int LOWER_BOUND_KEYNUM = MIN_DEGREE - 1 ;
    public final static int UPPER_BOUND_KEYNUM = (MIN_DEGREE * 2) - 1 ;

    protected boolean mIsLeaf ; //标记此节点是否为叶子节点
    protected int mCurrentKeyNum ; // 此节点的键数量计数器
    protected BTKeyValue<K,V>[] mKeys;//用于存键值对的数组
    protected BtNode<K,V>[] mChildren;//用于存子节点的数组

    public BtNode(){
        mIsLeaf = true ;
        mCurrentKeyNum = 0 ;
        mKeys = new BTKeyValue[UPPER_BOUND_KEYNUM];
        mChildren = new BtNode[UPPER_BOUND_KEYNUM + 1] ;
    }

    protected  static BtNode<? , ?> getChildNodeAtIndex(BtNode<? , ?> btNode , int keyIdx , int nDirection){
        if(btNode.mIsLeaf){
            return  null ;
        }
        keyIdx += nDirection ;
        if((keyIdx < 0) || (keyIdx > btNode.mCurrentKeyNum)){
            throw new IllegalArgumentException();
        }
        return btNode.mChildren[keyIdx];
    }

    /*
    * 返回btNode 节点中位于keyIdx 位上的键左边的子节点
    * */
    protected static BtNode<? , ?> getLeftChildAtIndex(BtNode<? , ?> btNode , int keyIdx){
        return getChildNodeAtIndex(btNode , keyIdx , 0);
    }

    /*
    *返回btNode 节点中位于keyIdx位上的键右边的子节点
    * */
    protected static BtNode<? , ?> getRightChildAtIndex(BtNode<?, ?> btNode , int keyIdx){
        return getChildNodeAtIndex(btNode , keyIdx , 1);
    }

    /*
    *返回父节点的keyIdx位上的子节点的左兄弟节点
    * */
    protected static BtNode<? , ?> getLeftSiblingAtIndex(BtNode<? , ?> parentNode , int keyIdx){
        return getChildNodeAtIndex(parentNode , keyIdx , -1);
    }

    /*
    * 返回父节点的keyIdx位上的子节点的做兄弟节点
    * */
    protected static BtNode<? , ?> getRightSiblingAtIndex(BtNode<? , ?> parentNode , int keyIdx){
        return getChildNodeAtIndex(parentNode , keyIdx , 1);
    }

    /*
    * 判断父节点的keyIdx位上的子节点是否存在左兄弟节点
    * */
    protected  static boolean hasLeftSiblingAtIndex(BtNode<? , ?> parentNode , int keyIdx){
        if(keyIdx - 1 < 0){
            return false;
        }else {
            return true ;
        }
    }

    /*
    * 判断父节点的keyIdx 位上的子节点是否存在右兄弟节点
    * */
    protected static boolean hasRightSiblingAtIndex(BtNode<? , ?> parentNode , int keyIdx){
        if(keyIdx + 1 > parentNode.mCurrentKeyNum){
            return false ;
        }else{
            return true;
        }
    }


    public BtNode<K , V> split(BtNode<K,V>  x){

        int mid = x.mCurrentKeyNum / 2 ;
        BtNode<K , V> left = new BtNode<>();
        for (int i=0 ; i<mid ; i++){
            left.mKeys[i] = x.mKeys[i];
            left.mChildren[i] = x.mChildren[i];
        }
        left.mChildren[mid] = x.mChildren[mid];
        left.mIsLeaf = x.mIsLeaf ;
        left.mCurrentKeyNum = mid ;
        BtNode<K , V> right = new BtNode<>();
        for(int i = mid + 1 ; i<x.mCurrentKeyNum ; i++){

        }


    }

}
