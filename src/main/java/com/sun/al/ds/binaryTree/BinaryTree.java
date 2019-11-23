package com.sun.al.ds.binaryTree;

public class BinaryTree extends AbstractTree{

    private Node root ;

    public Node find(int key ){
        Node current = root ;
        while(current != null){
            if(current.data > key){
                current = current.leftNode ;
            }else if(current.data < key){
                current = current.rightNode;
            }else {
                return current;
            }
        }
        return null ;
    }

    @Override
    public boolean insert(int data) {
        count++;
        Node newNode = new Node(data);
        if(root == null ){
            root = newNode;
            return true ;
        }
        Node current = root ;
        Node parentNode = null ;
        while(current != null){
            parentNode = current ;
            //当前值比新插入值大
            if(current.data > data){
                current = current.leftNode;
                //若左节点为空，则直接插入即可
                if(current == null){
                    parentNode.leftNode = newNode;
                    return  true ;
                }
            }else{
                //当前值小于新插入值
                current = current.rightNode;
                if(current == null){
                    parentNode.rightNode = newNode;
                    return true ;
                }
            }
            return  false ;
        }
        return false;
    }

    /*
    * 删除共有三种情况
    * 1、该节点是叶子节点
    * 2、该节点只有一个叶子节点
    * 3、该节点有两个叶子节点
    * */
    @Override
    public boolean delete(int data) {

        Node current = root ;
        Node parentNode = root ;

        //当前节点是否为左节点
        boolean isLeftNode = false ;

        //定位data的位置
        while (current.data != data){
            parentNode = current;
            if(current.data > data){

            }


        }




        return false;
    }

    /*
    * 获取要删除节点的后继节点
    * */
    public Node getSuccessor(Node delNode){
        Node successorParent = delNode ;
        Node successor = delNode ;
        Node current = delNode.rightNode;
        while (current != null){
            successorParent = successor ;
            successor = current ;
            current = current.leftNode ;
        }
        if(successor != delNode.rightNode){
            successorParent.leftNode = successor.rightNode;
            successor.rightNode = delNode.rightNode;
        }
        return successor;
    }





}
