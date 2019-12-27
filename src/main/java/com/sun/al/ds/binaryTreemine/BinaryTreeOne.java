package com.sun.al.ds.binaryTreemine;

public class BinaryTreeOne {

    private Node root ;

    public Node find(int data){
        Node current = root ;
        while (null != current){
            if(data > current.key){
                current = current.right;
            }else if (data < current.key){
                current = current.left;
            }else {
                return current;
            }
        }
        return null ;
    }

    public boolean insert(int data){
        Node node = new Node(data);
        if(root == null){
            root = node ;
            return true;
        }
        Node current = root ;
        Node parent = root ;
        while (current!=null){
            parent = current;
            if(data>current.key){
                current=current.right;
                if(null == current){
                    parent.right = node ;
                    return true ;
                }
            } else if(data<current.key){
                current = current.left;
                if (null==current){
                    current.left = node;
                    return true;
                }
            }else {
                return false;
            }
        }
        return false;
    }

    // 定位 连接
    public boolean delete(int data ){

        Node parentNode = root ;
        Node currentNode = root ;
        boolean isLeft = false;

        while (currentNode.key != data){
            parentNode = currentNode;
            if(currentNode.key > data){
                currentNode = currentNode.right ;
            }else if(currentNode.key < data){
                currentNode = currentNode.left;
                isLeft=true;
            }
            if(null == currentNode){
                return false;
            }
        }

        if(currentNode.left == null && currentNode.right == null){//该结点无叶子结点

            if(currentNode==root){
                root = null ;
            }else if(isLeft){
                parentNode.left=null ;
            }else{
                parentNode.right=null ;
            }
            return true;
        }else if (currentNode.left != null && currentNode.right == null){ //3、该结点只有一个子节点
            if(currentNode==root){
                root = currentNode.left ;
            }else if(isLeft){
                parentNode.left = currentNode.left;
            }else {
                parentNode.right = currentNode.left;
            }
        }else if (currentNode!=null && currentNode.right !=null){ //4、该结点只有一个
            if(currentNode==root){
                root = currentNode.right;
            } else  if(isLeft){
                parentNode.left = currentNode.right;
            }else {
                parentNode.right=currentNode.right;
            }
            return true;
        }else {//有两个叶子结点
            Node successor = getSucceesor(currentNode);
            if(currentNode==root){
                root = successor;
            }else if(isLeft){
                parentNode.left = successor;
            }else {
                parentNode.right = successor;
            }
            successor.left = currentNode.left ;
            return true;
        }
        return false;
    }


    //找最近的大  首先确认有两个叶子结点 需要改变后继结点父节点形态， 同时需要改变后继结点形态，所谓形态指的是他们的左右子树
    public Node getSucceesor(Node node ){
        Node successorParent = node ;
        Node sucessor = node;
        Node current = node.right ;
        while (current != null){
            //三层关系
            successorParent = sucessor ;
            sucessor = current;
            current = sucessor.left;
        }
        //如果后继结点不为删除结点的右节点，则做连接
        if(sucessor != node.right){
            successorParent.left = sucessor.right; //因为它自己肯定是最左结点，所以没有左结点，只需要连接右节点。
            sucessor.right = node.right;
        }
        return sucessor;
    }



}
