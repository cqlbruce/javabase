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

    //LR型
    public Node<T> leftRightRotation(Node<T> k1){
        k1.right = rightRightRotation(k1.right);
        return leftLeftRotation(k1);
    }

    //RL型
    public Node<T> rightLeftRotation(Node<T> k1){
        k1.left = leftLeftRotation(k1.left);
        return rightRightRotation(k1.right);
    }

    public Node<T> insert(Node<T> tree , T key){

        if(tree == null){
            //新建节点
            tree = new Node<T>(  null , null , key);
            if(tree == null){
                System.out.println("ERROR: create avltree node failed !");
                return null ;
            }
        } else {

            int cmp = key.compareTo(tree.key) ;
            if(cmp < 0){ //应该将key插入到tree的左子树
                tree.left = insert(tree.left , key) ;
                if(height(tree.left) - height((tree.right)) == 2){
                    if(key.compareTo(tree.left.key) < 0)
                        tree = leftLeftRotation(tree);
                    else
                        tree = leftRightRotation(tree);
                }

            }else if(cmp > 0){
                tree.right = insert(tree.right , key) ;
                if(height(tree.left) - height(tree.right) == 2){
                    if(key.compareTo(tree.right.key) < 0)
                        tree = rightRightRotation(tree);
                    else
                        tree = rightLeftRotation(tree) ;
                }
            }else{
                System.out.println("添加失败:不允许添加相同的节点!");
            }
        }
        tree.height = max(height(tree.left) , height(tree.right)) + 1 ;
        return tree ;
    }

    /*
    * 删除结点 返回根节点
    *
    * tree AVL树的跟结点
    * z 待删除的结点
    *
    * 返回值:
    *   根节点
    * */
    public Node<T> remove(Node<T> tree , Node<T> z ){

        //根为空 或者 没有要
        if(tree==null || z==null)
            return null ;

        int cmp = z.key.compareTo(tree.key) ;
        if(cmp < 0 ){ //待删除的结点在tree的左子树中
            tree.left = remove(tree.left , z) ;
            // 删除结点后，若AVL树失去平衡，则进行相应的调节
            if(height(tree.right) - height(tree.left) == 2){
                Node<T> node = tree.right ;
                if(height(node.left) > height(node.right))
                    tree = rightLeftRotation(tree);
                else
                    tree = leftLeftRotation(tree);
            }
        }else if(cmp > 0){
            tree.right = remove(tree.right,z);
            //删除结点后，若AVL树失去平衡，则进行相应的调节。
            if(height(tree.left) - height(tree.right) == 2){
                Node<T> node = tree.left ;
                if(height(node.right) > height(node.left))
                    tree = leftRightRotation(tree);
                else
                    tree = leftLeftRotation(tree);
            }
        }else { //tree 是对应要删除的节点
            // tree 的左右孩子都是非空
            if(tree.left != null && tree.right != null){

                if(height(tree.left) > height(tree.right)){
                    //代码注释是对的，但是代码错了。
                    //应该将：AVLTreeNode<T> min = maximum(tree.right);
                    //改为AVLTreeNode<T> min = minimum(tree.right);

                    // 如果tree的左子树比右子树高；
                    // 则(01)找出tree的左子树中的最大节点
                    //   (02)将该最大节点的值赋值给tree。
                    //   (03)删除该最大节点。
                    // 这类似于用"tree的左子树中最大节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的左子树中最大节点"之后，AVL树仍然是平衡的。
                    Node<T> max = maximum(tree.left);
                    tree.key = max.key;
                    tree.left = remove(tree.left, max);

                }else {
                    // 如果tree的左子树不比右子树高(即它们相等，或右子树比左子树高1)
                    // 则(01)找出tree的右子树中的最小节点
                    //   (02)将该最小节点的值赋值给tree。
                    //   (03)删除该最小节点。
                    // 这类似于用"tree的右子树中最小节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的右子树中最小节点"之后，AVL树仍然是平衡的。
                    Node<T> min = maximum(tree.right);
                    tree.key = min.key;
                    tree.right = remove(tree.right, min);
                }

            }else{
                Node<T> tmp = tree ;
                tree = (tree.left != null ) ? tree.left : tree.right;
                tmp = null ;
            }
        }

        return tree ;
    }


    public Node<T> maximum(Node<T> tree){
        if(tree == null)
            return null ;
        while (tree.right != null)
            tree = tree.right ;
        return tree ;
    }


}
