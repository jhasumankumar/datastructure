package com.sj.binaysearchtree;

import com.sj.exception.ElementNotFoundException;

public class BSTNode<E> {

    private E value;
    private BSTNode<E> left;
    private BSTNode<E> right;
    public BSTNode(E value){
        this.value = value;
    }


    public BSTNode insert(BSTNode<E> root, E value) {

        /* If the tree is empty, return a new node */

        if (root == null) {
            return new BSTNode<>(value);
        }
        Comparable val = (Comparable)value;
        int cmp = val.compareTo(root.value);
        if (cmp < 0){
            root.left =  insert(root.left, value);
        }else if (cmp >= 0) {
            root.right =  insert(root.right, value);
        }
        return root;
    }



    public boolean search(BSTNode<E> root, E value) {
            if(root == null){
                throw new ElementNotFoundException();
            }

        Comparable val = (Comparable)value;
        int cmp = val.compareTo(root.value);
        if (cmp == 0){
            return true;
        }else if (cmp < 0){
            return search(root.left, value);
        }else if (cmp > 0) {
            return search(root.right, value);
        }
        throw new ElementNotFoundException();
    }

    public boolean delete(BSTNode<E> root, E value) {

        if(root == null){
            throw new ElementNotFoundException();
        }
        BSTNode<E> parent = root;
        BSTNode<E> current = root;

        Comparable val = (Comparable)value;
        int cmp = val.compareTo(root.value);
        boolean isLeftChild = false;
        while(cmp != 0){
            parent = current;
            if(cmp < 0){
                isLeftChild = true;
                current = parent.left;
            }else if(cmp > 0){
                isLeftChild = false;
                current = parent.right;
            }
            if(current == null){
                return false;
            }
            cmp = val.compareTo(current.value);
        }
        rebalance(current, parent, isLeftChild);
        return true;
    }

    private void rebalance(BSTNode<E> current, BSTNode<E> parent, boolean isLeftChild){
            if(current.left == null && current.right == null){
                if(isLeftChild){
                    parent.left = null;
                }else{
                    parent.right = null;
                }
            }else if(current.left == null){
                parent.left = current.right;
            }else if(current.right == null){
                parent.right = current.left;
            }else if(current.left != null && current.right != null){
                BSTNode<E> successor = getSuccessor(current);
                BSTNode<E> leftLeaf = getLeftLeaf(successor);
                successor.left = current.left;
                leftLeaf.right = current.right;
                if(isLeftChild){
                    parent.left = successor;
                }else{
                    parent.right = successor;
                }
            }

            return;
    }

    private BSTNode getSuccessor(BSTNode<E> current){
        BSTNode<E> successor = current.right;
        while(successor.left != null){
            successor = successor.left;
        }
        successor.left = null;
        current.right.left = null;
        return successor;
    }

    private BSTNode getLeftLeaf(BSTNode<E> successor){
        while(successor.right != null){
            successor = successor.right;
        }
        return successor;
    }

    public void display(BSTNode<E> root){
        if(root!=null){
            display(root.left);
            System.out.print(" " + root.value);
            display(root.right);
        }
    }
}
