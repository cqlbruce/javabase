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
    public void delete(int data ){

        if(root.key == data){
            root = null ;
        }
        Node parent = root ;
        Node current = root ;
        boolean ifLeft = true;
        //1、先定位结点 定位其parent current结点
        while (current != null){
            parent = current ;
            if (data >current.key){
                current = current.right;
            }else if(data < current.key){
                current = current.left;
            }else {
                break;
            }
        }

        //2、该结点无叶子结点


        //3、该结点只有一个子节点


        //4、该结点有两个子节点



    }

    public Node succeesor(Node node ){

        Node current = node.right;
        if(current.left == null){
            return current ;
        }
        while (current != null){
            current = current.left;
        }
        return current ;
    }



}
