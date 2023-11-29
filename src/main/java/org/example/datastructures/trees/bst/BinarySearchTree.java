package org.example.datastructures.trees.bst;

import java.util.ArrayList;

public class BinarySearchTree {

    private TreeNode root;

    private ArrayList<Integer> sortedValues = new ArrayList<>();

    public void insert(TreeNode node) {
        if(node != null) {
            if(root == null) {
                root = node;
            }
            else {
                TreeNode temp = root;
                while(temp != null) {
                    if(node.getValue() < temp.getValue()) {
                        if(temp.getLeft() == null) {
                            temp.setLeft(node);
                            break;
                        }
                        else {
                            temp = temp.getLeft();
                        }
                    }
                    else if(node.getValue() > temp.getValue()) {
                        if(temp.getRight() == null) {
                            temp.setRight(node);
                            break;
                        }
                        else {
                            temp = temp.getRight();
                        }
                    }
                }
            }
        }
    }

    public void inOrderTraversal(TreeNode node) {
        if(node != null) {
            inOrderTraversal(node.getLeft());
            visit(node);
            inOrderTraversal(node.getRight());
        }
    }

    public void preOrderTraversal(TreeNode node) {
        if(node != null) {
            visit(node);
            preOrderTraversal(node.getRight());
            preOrderTraversal(node.getLeft());
        }
    }

    public void postOrderTraversal(TreeNode node) {
        if(node != null) {
            postOrderTraversal(node.getLeft());
            postOrderTraversal(node.getRight());
            visit(node);
        }
    }

    public void visit(TreeNode node) {
        if(!node.isVisited()) {
            node.setVisited(true);
            sortedValues.add(node.getValue());
            System.out.println(node.getValue());
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public ArrayList<Integer> binarySort(int[] values) {
        TreeNode[] nodes = new TreeNode[values.length];
        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = new TreeNode(values[i]);
            insert(nodes[i]);
        }
        if(root != null) {
            TreeNode temp = root;
            inOrderTraversal(temp);
            return sortedValues;
        }
        return null;
    }
}
