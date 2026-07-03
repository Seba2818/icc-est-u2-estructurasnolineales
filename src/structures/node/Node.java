package structures.node;

import java.util.Objects;

public class Node<T> {
    
    private T value;
    private Node<T> left;
    private Node<T> right;


    //CREO NODO
    //Instancio el node --> Constructor
    //tiene que crearse con el valor

    public Node(T value){
        this.value = value;
        this.left  = null;
        this.right = null; 


    }

    
    public T getValue() {
        return value;
    }


    public void setValue(T value) {
        this.value = value;
    }


    public Node<T> getLeft() {
        return left;
    }


    public void setLeft(Node<T> left) {
        this.left = left;
    }


    public Node<T> getRight() {
        return right;
    }


    public void setRight(Node<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }


    @Override
    public boolean equals(Object obj) {
    if (this == obj)
        return true;

    if (obj == null || getClass() != obj.getClass())
        return false;

    Node<?> other = (Node<?>) obj;
    return Objects.equals(value, other.value);
    }

    @Override
    public int hashCode() {
    return Objects.hash(value);
    }

    
}
