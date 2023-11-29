package org.example.datastructures.trees.bst;

public class TreeNode {

    private int value;
    private boolean visited;

    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        left = right = null;
        visited = false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
