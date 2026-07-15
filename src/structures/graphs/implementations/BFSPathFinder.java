package structures.graphs.implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import structures.graphs.Graph;
import structures.graphs.PathFinder;
import structures.graphs.PathResult;
import structures.node.Node;

public class BFSPathFinder<T> implements PathFinder<T> {

    @Override
    public PathResult<T> find(Graph<T> graph, T start, T end) {

        Queue<T> queue = new LinkedList<>();

        // Evita agregar nodos repetidos a la cola
        Set<T> descubiertos = new HashSet<>();

        // Mantiene el orden en el que se visitaron
        Set<T> visited = new LinkedHashSet<>();

        // Guarda el padre de cada nodo para construir el camino
        Map<Node<T>, Node<T>> parent = new HashMap<>();

        queue.add(start);
        descubiertos.add(start);
        parent.put(new Node<>(start), null);

        while (!queue.isEmpty()) {

            T current = queue.poll();
            visited.add(current);

            if (current.equals(end)) {
                return new PathResult<>(
                    new ArrayList<>(visited),
                    buildPath(parent, end)
                );
            }

            for (Node<T> vecino : graph.getVecinos(current)) {

                T valorVecino = vecino.getValue();

                if (!descubiertos.contains(valorVecino)) {

                    descubiertos.add(valorVecino);

                    parent.put(
                        new Node<>(valorVecino),
                        new Node<>(current)
                    );

                    queue.add(valorVecino);
                }
            }
        }

        return new PathResult<>(
            new ArrayList<>(visited),
            new ArrayList<>()
        );
    }

    private List<T> buildPath(Map<Node<T>, Node<T>> parent, T end) {

        List<T> path = new ArrayList<>();

        Node<T> actual = new Node<>(end);

        while (actual != null) {
            path.add(actual.getValue());
            actual = parent.get(actual);
        }

        // El camino estaba de final a inicio, por eso se invierte
        Collections.reverse(path);

        return path;
    }
}