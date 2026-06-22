import models.Persona;
import structures.node.Node;
import structures.trees.BinaryTree;
import structures.trees.Ejercicio1;
import structures.trees.Ejercicio2;
import structures.trees.IntTree;

public class App {
    public static void main(String[] args) throws Exception {
        runIntTree();
        runBinaryTree();
        runEjercicios();
        
    }

   
    private static void runEjercicios(){
        Ejercicio1 ejercicio1 = new Ejercicio1();
        int[] numeros = new int[]{5,3,7,2,4,6,8};
        ejercicio1.insert(numeros);

        Ejercicio2 ejercicio2 = new Ejercicio2();
        int[] numeros2 = new int[] {5,3,7,2,4,6,8};

        BinaryTree<Integer> arbol = new BinaryTree<>();
        for(int numero: numeros2)
            arbol.add(numero);

        Node<Integer> root = arbol.getRoot();
        ejercicio2.invertTree(root);

        
    }

     

    private static void runBinaryTree() {
        BinaryTree<String> arbolStrings = new BinaryTree<>();
        BinaryTree <Persona> arbolPersonas = new BinaryTree<>();

        arbolPersonas.add(new Persona("pablo", 30));
        arbolPersonas.add(new Persona("ana", 25));
        arbolPersonas.add(new Persona("luis", 35));
        arbolPersonas.add(new Persona("maria", 28));
    }
    
    public static void runIntTree(){

        
        IntTree arbolNumero = new IntTree();
        // Node <Integer> nodo1 = new Node<>(50);
        // Node <Integer> nodo2 = new Node<>(10);
        // Node <Integer> nodo3 = new Node<>(30);

        // arbolNumero.setRoot(nodo1);
        // nodo1.setRight(nodo2);
        // nodo2.setLeft(nodo3);

        // System.out.println(arbolNumero.getRoot());
        // System.out.println(arbolNumero.getRoot().getRight().getLeft()); 

        //nodo3.setLeft(nodo1);

        arbolNumero.add(50);
        arbolNumero.add(10);
        arbolNumero.add(30);
        arbolNumero.add(60);
        arbolNumero.add(75);
        arbolNumero.add(55


        );
        

        System.out.println("\nPreorden: ");
        arbolNumero.preOrden();

        System.out.println("\nInorden: ");
        arbolNumero.inOrden();

        System.out.println("\nPostorden: ");
        arbolNumero.posOrden();

        System.out.println("\nArbol Altura: " + arbolNumero.getHeight());

        System.out.println("Peso: " + arbolNumero.getPeso());
        
        
        
    }
}
