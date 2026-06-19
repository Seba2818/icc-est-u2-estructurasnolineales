package structures.trees;

import structures.node.Node;


public class IntTree {
    
    private Node <Integer> root;

    //Constructor

    public IntTree(){
        this.root = null;
    }

    public Node<Integer> getRoot() {
        return root;
    }

    public void setRoot(Node<Integer> root) {
        this.root = root;
    }

    public void setRoot (Integer value){
        Node<Integer> node = new Node<Integer>(value);
        this.root = node;
    }

    public void add (int value){
        Node<Integer> node = new Node<Integer>(value);
        root = addRecursivo (root, node);

    }

    public Node<Integer> addRecursivo(
        Node<Integer> actual, 
        Node<Integer> nodeInsertar) {

        if(actual == null) 
            return nodeInsertar;

        if(actual.getValue() > nodeInsertar.getValue()){
            actual.setLeft(addRecursivo(actual.getLeft(), nodeInsertar));
        } else {
            actual.setRight(addRecursivo(actual.getRight(), nodeInsertar));
                    
        }

            
    return actual;
        
    }

    public void preOrden(){
        preOrdenRecursivo(root);
    }

    private void preOrdenRecursivo(Node <Integer> actual){
        if (actual == null)
            return;

        System.out.println(actual);
        preOrdenRecursivo(actual.getLeft());
        preOrdenRecursivo(actual.getRight());
    }

    public void posOrden(){
        posOrdenRecursivo(root);
    }

    public void posOrdenRecursivo(Node <Integer> actual){
        if (actual == null)
            return;
        
        posOrdenRecursivo(actual.getLeft());
        posOrdenRecursivo(actual.getRight());
        System.out.println(actual);
    }

    public void inOrden(){
        inOrdenRecursivo
    }
}
