package structures.graphs;

import java.util.HashMap;
import java.util.HashSet;
// import java.util.List;
import java.util.Map;
import java.util.Set;

import structures.node.Node;

public class Graph<T> {

    // Set<Node<T>> nodes;//obliga a que el nodo conozca sus conexiones u otros
    // nodos

    Map<Node<T>, Set<Node<T>>> nodes;// asegura que el grafo no tenga nodos repetidos

    public Graph() {
        this.nodes = new HashMap<>();
    }

    /*
     * public void add(Node<T> node) tendria que insertar nodo por nodo en la clase
     * app
     * }
     */

    public void add(T value) {// recibe el valor directamente, crea internamente el nodo
        Node<T> node = new Node<>(value);
        nodes.putIfAbsent(node, new HashSet<>());// usa el putIfAbsent hace que si ya existe un valor no lo vuelva
                                                 // agregar
    }

    // agragar una coneccion bidirreccional
    public void addEdge(T v1, T v2) {
        Node<T> nV1 = new Node<>(v1);// crea valor a
        Node<T> nV2 = new Node<>(v2);// crea el valor b
        add(v1);
        add(v2);
        nodes.get(nV1).add(nV2);
        nodes.get(nV2).add(nV1);
    }

    public void addEdgeUni(T v1, T v2) {
        Node<T> nV1 = new Node<>(v1);// crea valor a
        Node<T> nV2 = new Node<>(v2);// crea el valor b
        add(v1);
        add(v2);
        nodes.get(nV1).add(nV2);

    }

    public void print() {
        for (Map.Entry<Node<T>, Set<Node<T>>> entry : nodes.entrySet()) {
            System.out.print(entry.getKey() + "->");
            for (Node<T> node : entry.getValue()) {
                System.out.print(node);
            }
            System.out.println();

        }
    }

    public void removeEdge(T v1, T v2) {
        Node<T> nV1 = new Node<>(v1);
        Node<T> nV2 = new Node<>(v2);

        if (nodes.containsKey(nV1) && nodes.containsKey(nV2)) {
            nodes.get(nV1).remove(nV2);
            nodes.get(nV2).remove(nV1);
        }
    }

    public void removeEdgeUni(T v1, T v2) {
        Node<T> nV1 = new Node<>(v1);
        Node<T> nV2 = new Node<>(v2);

        if (nodes.containsKey(nV1) && nodes.containsKey(nV2)) {
            nodes.get(nV1).remove(nV2);
        }
    }

    public void removeNode(T value) {

        Node<T> target = new Node<>(value);

        // 1. Eliminar el nodo de todas las listas de adyacencia
        for (Set<Node<T>> neighbors : nodes.values()) {
            neighbors.remove(target);
        }

        // 2. Eliminar el nodo del grafo
        nodes.remove(target);
    }

    public int getNumberOfNodes() {
        return nodes.size();
    }

    public int getNumberOfEdges() {

        int count = 0;

        for (Set<Node<T>> neighbors : nodes.values()) {
            count += neighbors.size();
        }

        // porque es no dirigido (A-B y B-A cuentan doble)
        return count / 2;
    }

    public Set<Node<T>> getVecinos(T currente) {
        Node<T> node = new Node<>(currente);
        return nodes.getOrDefault(node, new HashSet<>()); // Devuelve un conjunto vacío si el nodo no existe
        // EL metodo getOrDefault devuelve el valor asociado a la clave especificada, o
        // un valor predeterminado si la clave no está presente en el mapa.
        // En este caso, si el nodo no existe en el grafo, se devuelve un conjunto vacío
        // para evitar errores de null.

    }

    public int totalDirecciones() {
        int total = 0;
        for (Set<Node<T>> conexiones : nodes.values()) {
            total += conexiones.size();
        }
        return total;
    }

    public int totalConexiones() {
        Set<String> set = new HashSet<>();

        for (Map.Entry<Node<T>, Set<Node<T>>> entry : nodes.entrySet()) {
            for (Node<T> destino : entry.getValue()) {
                String a = entry.getKey().toString();
                String b = destino.toString();

                String key = (a.compareTo(b) < 0) ? a + "-" + b : b + "-" + a;
                set.add(key);
            }
        }
        return set.size();
    }

}