package com.company.BinarySearchTree;

public interface BinarySearchTreeInterface<T> {
    void Add(T item);
    NodeInterface<T> Get(T item);
    void Remove(T i);
}
