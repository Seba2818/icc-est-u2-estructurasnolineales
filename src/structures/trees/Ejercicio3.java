package structures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import structures.node.Node;

public class Ejercicio3 {

    public List<List<Node<Integer>>> listLevels(Node<Integer> root) {

        List<List<Node<Integer>>> niveles = new ArrayList<>();

        if (root == null) {
            return niveles;
        }

        Queue<Node<Integer>> cola = new LinkedList<>();
        cola.add(root);

        while (!cola.isEmpty()) {

            int cantidadNivel = cola.size();
            List<Node<Integer>> nivelActual = new LinkedList<>();

            for (int i = 0; i < cantidadNivel; i++) {
                Node<Integer> actual = cola.poll();

                nivelActual.add(actual);

                if (actual.getLeft() != null) {
                    cola.add(actual.getLeft());
                }

                if (actual.getRight() != null) {
                    cola.add(actual.getRight());
                }
            }

            niveles.add(nivelActual);
        }

        return niveles;
    }
}