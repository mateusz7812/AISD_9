package com.company.BinarySearchTree;

import com.company.Comparator.ComparatorInterface;

public class BinarySearchTree<T> implements BinarySearchTreeInterface<T> {
    private ComparatorInterface<T> comparator;
    protected NodeInterface<T> nil;

    public BinarySearchTree(ComparatorInterface<T> comparator) {
        this.comparator = comparator;
    }


    @Override
    public void Add(T value) {
        var node = new Node<T>(value);

        if (nil == null) {
            nil = node;
        } else {
            _add(nil, node);
        }
    }

    public void AddRange(T[] values){
        for (T value :
                values) {
            this.Add(value);
        }
    }

    private void _add(NodeInterface<T> parent, NodeInterface<T> nodeToAdd) {
        var comparing = comparator.Compare(nodeToAdd.getValue(), parent.getValue());
        if (comparing <= 0) {
            addAsLeftChild(parent, nodeToAdd);
        } else {
            addAsRightChild(parent, nodeToAdd);
        }
    }

    private void addAsRightChild(NodeInterface<T> parent, NodeInterface<T> nodeToAdd) {
        var rightChild = parent.getRightChild();
        if (rightChild == null) {
            parent.setRightChild(nodeToAdd);
        } else {
            _add(rightChild, nodeToAdd);
        }
    }

    private void addAsLeftChild(NodeInterface<T> parent, NodeInterface<T> nodeToAdd) {
        var leftChild = parent.getLeftChild();
        if (leftChild == null) {
            parent.setLeftChild(nodeToAdd);
        } else {
            _add(leftChild, nodeToAdd);
        }
    }

    @Override
    public NodeInterface<T> Get(T value) {
        if (nil == null) {
            return null;
        } else {
            return _get(nil, value);
        }
    }

    public NodeInterface<T> _get(NodeInterface<T> node, T value) {
        if (node == null) return null;

        var comparing = comparator.Compare(value, node.getValue());

        if (comparing == 0) {
            return node;
        } else if (comparing < 0) {
            return _get(node.getLeftChild(), value);
        } else {
            return _get(node.getRightChild(), value);
        }
    }

    @Override
    public void Remove(T i) {
        var nodeToRemove = Get(i);
        _remove(nodeToRemove);
    }

    private void _remove(NodeInterface<T> nodeToRemove) {
        if(nodeToRemove == null) return;

        var rightChild = nodeToRemove.getRightChild();
        var leftChild = nodeToRemove.getLeftChild();
        NodeInterface<T> nodeToMove = null;

        if(rightChild == null && leftChild != null) {
            nodeToMove = findMaxChild(leftChild);
        } else if((rightChild != null)){
            nodeToMove = findMinChild(rightChild);
        }

        _remove(nodeToMove);
        swap(nodeToRemove, nodeToMove);
    }

    private NodeInterface<T> findMinChild(NodeInterface<T> node) {
        if(node.getLeftChild() == null) return node;
        return node.getLeftChild();
    }

    private NodeInterface<T> findMaxChild(NodeInterface<T> node) {
        if(node.getRightChild() == null) return node;
        return node.getRightChild();
    }

    private void swap(NodeInterface<T> nodeToRemove, NodeInterface<T> nodeToMove) {
        updateParentOfRemovingNode(nodeToRemove, nodeToMove);

        if (nodeToMove == null) return;

        updateNodeToMove(nodeToRemove, nodeToMove);
    }

    private void updateNodeToMove(NodeInterface<T> nodeToRemove, NodeInterface<T> nodeToMove) {
        nodeToMove.setRightChild(nodeToRemove.getRightChild());
        nodeToMove.setLeftChild(nodeToRemove.getLeftChild());
    }

    private void updateParentOfRemovingNode(NodeInterface<T> nodeToRemove, NodeInterface<T> nodeToMove) {
        if (nodeToRemove.equals(nodeToRemove.getParent().getLeftChild())) {
            nodeToRemove.getParent().setLeftChild(nodeToMove);
        } else {
            nodeToRemove.getParent().setRightChild(nodeToMove);
        }
    }

}
