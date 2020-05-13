package com.company.BinarySearchTree;

public interface NodeInterface<T> {
    T getValue();
    NodeInterface<T> getParent();
    NodeInterface<T> getLeftChild();
    NodeInterface<T> getRightChild();

    void setLeftChild(NodeInterface<T> leftChild);
    void setRightChild(NodeInterface<T> rightChild);
    void setParent(NodeInterface<T> parent);
}
