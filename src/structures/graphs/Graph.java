package structures.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<T> {

    private Map<T, Set<T>> nodes;

    public Graph() {
        nodes = new HashMap<>();
    }

    // Agrega un vértice
    public void add(T value) {
        nodes.putIfAbsent(value, new HashSet<>());
    }

    // Grafo dirigido: v1 -> v2
    public void addEdge(T v1, T v2) {
        add(v1);
        add(v2);

        nodes.get(v1).add(v2);
    }

    // Grafo no dirigido
    public void addEdgeBi(T v1, T v2) {
        add(v1);
        add(v2);

        nodes.get(v1).add(v2);
        nodes.get(v2).add(v1);
    }

    public boolean contains(T value) {
        return nodes.containsKey(value);
    }



    public void print() {
        System.out.println("\n--------- GRAFO ---------");

        for (Map.Entry<T, Set<T>> entry : nodes.entrySet()) {

            System.out.print(entry.getKey() + " -> ");

            for (T vecino : entry.getValue()) {
                System.out.print(vecino + " ");
            }

            System.out.println();
        }
    }

    public void remove(T value) {

    // Si el nodo no existe, no hacemos nada
        if (!nodes.containsKey(value)) {
            System.out.println("El nodo " + value + " no existe.");
            return;
        }

    // Eliminar el nodo del grafo
        nodes.remove(value);

    // Eliminar todas las referencias hacia ese nodo
        for (Set<T> vecinos : nodes.values()) {
            vecinos.remove(value);
        }

        System.out.println("Nodo " + value + " eliminado.");
    }

    public int getCantidadNodos() {
        return nodes.size();
    }

    public int getCantidadConexiones() {

        int total = 0;

        for (Set<T> vecinos : nodes.values()) {
            total += vecinos.size();
        }

        return total;
    }
}