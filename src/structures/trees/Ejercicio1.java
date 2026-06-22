package structures.trees;

import structures.node.Node;

public class Ejercicio1 {
    public void insert ( int [] numeros){

        //CREAR ARBOL DE ENTEROS
        //INSERTAR CADA NUMERO 
        BinaryTree <Integer> arbol = new BinaryTree<>();

        for (int numero : numeros){
            arbol.add(numero);

        }
        //IMPRIMIR EL ARBOL

        System.out.println("\n------------Ejercicio 1-----------");

        System.out.println("\nInorden: ");
        arbol.inOrden();
        
        printTree(arbol.getRoot()   );

    }

    public void printTree(Node <Integer> root){
        System.out.println("Imprimiendo el arbol");
        printTreeRecursivo(root, 0);
    }

    private void printTreeRecursivo (Node <Integer> actual, int nivel){

        if(actual == null)
            return;

        printTreeRecursivo(actual.getRight(), nivel+1);

        for (int i = 0; i < nivel; i++) {
            System.out.print("     ");
            
        }

        System.out.println(actual.getValue());
        printTreeRecursivo(actual.getLeft(), nivel+1);
        
    }
}
