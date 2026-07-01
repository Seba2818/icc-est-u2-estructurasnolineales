import collections.maps.Maps;
import collections.set.Sets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import models.Contacto;
import models.Persona;
import structures.node.Node;
import structures.trees.BinaryTree;
import structures.trees.Ejercicio1;
import structures.trees.Ejercicio2;
import structures.trees.Ejercicio3;
import structures.trees.Ejercicio4;
import structures.trees.IntTree;

public class App {
    public static void main(String[] args) throws Exception {
        runIntTree();
        runBinaryTree();
        runEjercicios();

        runSets();
        
    }

    
    private static void runSets() {
        Sets sets = new Sets();

        //Implementacion -> HashSet hashcode

        System.out.println("\n-------------HashCode-----------");
        Set<String> hashSet = sets.construirHashSet();
        System.out.println(hashSet);
        System.out.println("Size = " + hashSet.size());
        System.out.println(hashSet.contains("F"));

        ArrayList<String> lis = new ArrayList<>();
        lis.add("S");
        System.out.println(lis);


         System.out.println("\n-------------LinkedHashCode-----------");
        Set<String> lSet = sets.LinkedHashSet();
        System.out.println(lSet);
        System.out.println("Size = " + lSet.size());
        System.out.println(lSet.contains("F"));

        System.out.println("\n-------------TreeSet-----------");
        Set<String> tSet = sets.TreeSet();
        System.out.println(tSet);
        System.out.println("Size = " + tSet.size());
        System.out.println(tSet.contains("F"));

        System.out.println("\n-------------HashSet Contacto-----------");
        Set<Contacto> hCSet = sets.construirHContacto();
        System.out.println(hCSet);
        System.out.println("Size = " + hCSet.size());

        System.out.println("\n-------------TreeSet Contacto-----------");
        Set<Contacto> thCSet = sets.construirTreeSetContacto();
        System.out.println(thCSet);
        System.out.println("Size = " + thCSet.size());
        
        System.out.println("\n-------------Mapa-----------");
        Maps maps = new Maps();
        maps.contruirHashMap();

    }


    private static void runEjercicios(){
        // ----------------------------
        Ejercicio1 ejercicio1 = new Ejercicio1();
        int[] numeros = new int[]{5,3,7,2,4,6,8};
        ejercicio1.insert(numeros);
        
        // ---------------------------
        Ejercicio2 ejercicio2 = new Ejercicio2();
        int[] numeros2 = new int[] {5,3,7,2,4,6,8};

        BinaryTree<Integer> arbol = new BinaryTree<>();
        for(int numero: numeros2)
            arbol.add(numero);

        Node<Integer> root = arbol.getRoot();
        ejercicio2.invertTree(root);

        // ---------------------------------
        Ejercicio3 ejercicio3 = new Ejercicio3();
        
        int[] numeros3 = new int[]{4,2,7,1,3,6,9};

        BinaryTree<Integer> arbolEjercicio3 = new BinaryTree<>();
        
        for (int numero : numeros3) {
             arbolEjercicio3.add(numero);
            }

        List<List<Node<Integer>>> niveles = ejercicio3.listLevels(arbolEjercicio3.getRoot());

        System.out.println("\n------------Ejercicio 3-----------");

            for (List<Node<Integer>> nivel : niveles) {
                for (Node<Integer> nodo : nivel) {
                System.out.print(nodo.getValue() + " ");
                }
                System.out.println();
            }

        //--------------------------------------
        Ejercicio4 ejercicio4 = new Ejercicio4();
       

        Node<Integer> root4 = new Node<>(4);
        root4.setLeft(new Node<>(2));
        root4.setRight(new Node<>(7));

        root4.getLeft().setLeft(new Node<>(1));
        root4.getLeft().setRight(new Node<>(3));

        root4.getLeft().getLeft().setLeft(new Node<>(8));

        int profundidad = ejercicio4.maxDepth(root4);

        System.out.println("\n------------Ejercicio 4-----------");


        System.out.println("Input:");
        System.out.println("    " + root4.getValue());
        System.out.println("  " + root4.getLeft().getValue() + "     " + root4.getRight().getValue());
        System.out.println(" " + root4.getLeft().getLeft().getValue() + "   " + root4.getLeft().getRight().getValue());
        System.out.println(root4.getLeft().getLeft().getLeft().getValue());

        System.out.println();
        System.out.println("Output: " + profundidad);
        
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
