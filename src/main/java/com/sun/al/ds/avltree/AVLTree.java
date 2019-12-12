package com.sun.al.ds.avltree;

import com.sun.datastructure.tree.avl.AVLNode;
import com.sun.datastructure.tree.avl.Tree;

public class AVLTree<T extends Comparable<T>> {


    private AVLTreeNode<T> mRoot ; //根节点

    class AVLTreeNode<T extends Comparable<T>>{
        T element; //值
        int height; //高度
        AVLTreeNode<T> left ; //左孩子
        AVLTreeNode<T> right; //右孩子

        public AVLTreeNode(T key , AVLTreeNode<T> left , AVLTreeNode<T> right){
            this.element = key;
            this.left = left;
            this.right = right;
            this.height = 0 ;
        }
    }

    /*
    * 获取树的高度
    * */
    private int heigh(AVLTreeNode<T> tree){
        if(tree != null){
            return tree.height;
        }
        return 0 ;
    }

    public int heith(){
        return heigh(mRoot);
    }

    /*
    * LL 对应情况，(坐单旋转)
    * k2
    * return 旋转后的根节点
    * */
    private AVLTreeNode<T> leftLeftRotation(AVLTreeNode<T> k2){
        AVLTreeNode<T> k1 ;
        k1 = k2.left ;
        k2.left = k1.right;
        k1.right = k2 ;

        k2.height = Math.max(heigh(k2.left) , heigh(k2.right)) + 1 ;
        k1.height = Math.max(heigh(k1.left) , k2.height) + 1;
        return k1 ;
    }

    /*
    * 右右对应的情况(右单旋转).
    *
    * return 旋转后的根节点
    * */
    private AVLTreeNode<T> rigthRightRotation(AVLTreeNode<T> k1 ){
        AVLTreeNode<T> k2 ;

        k2 = k1.right ;
        k1.right = k2.left;
        k2.left = k1 ;
        k1.height = Math.max(heigh(k1.left) , heigh(k1.right)) + 1 ;
        k2.height = Math.max(heigh(k2.right) , k1.height) + 1 ;

        return k2 ;
    }

    /*
    * LR 左右对应的情况(做双旋转)
    *
    * return 旋转后的根节点
    * */
    private AVLTreeNode<T> leftRighRotation(AVLTreeNode<T> k3){
        k3.left = rigthRightRotation(k3.left);
        return leftLeftRotation(k3);
    }

    private AVLTreeNode<T> rightLeftRotation(AVLTreeNode<T> k1){
        k1.right = leftLeftRotation(k1.right);
        return rigthRightRotation(k1) ;
    }


    public void insert(T key ){
        mRoot = insert(mRoot , key);

    }


    /*
    * 将节点插入到AVL树中 ， 并返回根节点
    *
    * @param tree avl 树的根节点
    * @param key 插入的节点的键值
    * return 根节点
    * */
    private AVLTreeNode<T> insert(AVLTreeNode<T> tree , T key){

        if(tree == null){
            return tree = new AVLTreeNode<T>(key , null , null);
        }

        int cmp = key.compareTo(tree.element);
        if(cmp < 0 ){ //将key 插入到"tree 的左子树" 的情况
            tree.left = insert(tree.left , key);
        }else if(cmp > 0 ){ //将key 插入到"tree 的右子树" 的情况
            tree.right = insert(tree.right , key);
        }

        return  balance(tree) ;
    }

    private static final int ALLOWED_IMBALANCE = 1 ;

    private AVLTreeNode<T> balance(AVLTreeNode<T> tree){
        if(tree == null ){
            return tree ;
        }

        //插入节点后，若AVL树失去平衡，则进行相应的调节
        if(heigh(tree.left) - heigh(tree.right) > ALLOWED_IMBALANCE){
            if(heigh(tree.left.left) >= heigh(tree.left.right)){
                leftLeftRotation(tree);
            }else{
                leftRighRotation(tree);
            }
        }else if(heigh(tree.right) - heigh(tree.left) > ALLOWED_IMBALANCE){
            if(heigh(tree.right.right) >= heigh(tree.right.left)){
                rigthRightRotation(tree);
            }else {
                rightLeftRotation(tree);
            }
        }
        tree.height = Math.max(heigh(tree.left) , heigh(tree.right)) + 1 ;
        return tree ;
    }

    public void remove(T key){
        AVLTreeNode<T> z ;
        if((z = search(mRoot , key)) != null){
            mRoot = remove(mRoot , z);
        }
    }

    /*
    *(递归实现)查找"AVL树X"中键值为key的节点
    * */
    private AVLTreeNode<T> search(AVLTreeNode<T> x , T key){

        if(x == null)
            return x ;

        int cmp = key.compareTo(x.element);
        if(cmp < 0)
            return search(x.left , key);
        else if(cmp > 0)
            return search(x.right , key);
        else
            return x ;
    }

    public AVLTreeNode<T> search(T key){
        return search(mRoot , key);
    }

    /*
    *删除节点(z),返回根节点
    * @param tree AVL 树的根节点
    * @param z 待删除的节点
    * @return 根节点
    *
    * */
    private AVLTreeNode<T> remove(AVLTreeNode<T> tree , AVLTreeNode<T> z){
        if(tree == null)
            return tree ;

        int cmp = z.element.compareTo(tree.element);
        if(cmp > 0 ){
            tree.right = remove(tree.left , z) ;
        }else if(tree.left != null && tree.right !=null){
            tree.element = findMin(tree.right).element;
            tree.right = remove(tree.element , tree.right);
        }else{
            tree = (tree.left != null) ? tree.left : tree.right ;
        }
        return balance(tree);
    }

    private AVLTreeNode<T> findMin(AVLTreeNode<T> node){
        if(node != null){
            while (node.left != null){
                node = node.left;
            }
        }
        return node ;
    }

    public AVLTreeNode<T> remove(T t , AVLTreeNode<T> node){
        if(null == node){
            return node ;
        }

        int compareResult = t.compareTo(node.element);
        if(compareResult > 0){
            node.right = remove(t , node.right);
        }else if(node.left != null && node.right !=null){
            node.element = findMin(node.right).element;
            node.right = remove(node.element , node.right);
        }else {
            node = (node.left != null)? node.left : node.right;
        }
        return node ;
    }


    private void print(AVLTreeNode<T> tree , T key , int direction){
        if(tree != null){
            if(direction == 0) //tree是根节点
                System.out.printf("%2d is root\n" , tree.element , key);
            else    // tree是分支节点
                System.out.printf("%2d is %2d's %6s child\n", tree.element, key, direction==1?"right" : "left");
        }
        print(tree.left, tree.element, -1);
        print(tree.right,tree.element,  1);
    }


    public void print(){
        if(mRoot != null)
            print(mRoot , mRoot.element , 0);

    }


}
