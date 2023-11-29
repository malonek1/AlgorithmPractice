package org.example.datastructures.trees.bst;

import java.util.ArrayList;
import java.util.Random;

public class TreeDriver {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {8,2,16,4,12,6,10,3,7,1};
        ArrayList<Integer> list = bst.binarySort(values);

//        System.out.println("\nBinary search tree data from left to right: ");
//        TreeNode inOrderNode = bst.getRoot();
//        bst.inOrderTraversal(inOrderNode);
//
//        TreeNode preOrderNode = bst.getRoot();
//        System.out.println("\nBinary search tree data from right to left: ");
//        bst.preOrderTraversal(preOrderNode);
//
//        TreeNode postOrderNode = bst.getRoot();
//        System.out.println("\nBinary search tree data from top down: ");
//        bst.postOrderTraversal(postOrderNode);
    }
}
