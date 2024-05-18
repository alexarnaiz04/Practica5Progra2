package util;

import java.util.*;

/**
 * Esta clase representa un grafo dirigido utilizando una lista de adyacencia.
 * 
 * @param <V> el tipo de los vértices en el grafo.
 * 
 * @author Alejandro Arnaiz
 */
public class Graph<V> {
    // Lista de adyacencia que almacena los vértices y sus conexiones.
    private Map<V, Set<V>> adjacencyList = new HashMap<>();

    /******************************************************************
     * Añade el vértice `v` al grafo.
     * 
     * @param v vértice a añadir.
     * @return `true` si no estaba anteriormente y `false` en caso contrario.
     ******************************************************************/
    public boolean addVertex(V v) {
        if (!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new HashSet<>());
            return true;
        }
        return false;
    }

    /******************************************************************
     * Añade un arco entre los vértices `v1` y `v2` al grafo.
     * En caso de que no exista alguno de los vértices, lo añade también.
     *
     * @param v1 el origen del arco.
     * @param v2 el destino del arco.
     * @return `true` si no existía el arco y `false` en caso contrario.
     ******************************************************************/
    public boolean addEdge(V v1, V v2) {
        if (!containsVertex(v1))
            addVertex(v1);
        if (!containsVertex(v2))
            addVertex(v2);
        if (adjacencyList.get(v1).contains(v2))
            return false;
        else {
            adjacencyList.get(v1).add(v2);
            return true;
        }
    }

    /******************************************************************
     * Obtiene el conjunto de vértices adyacentes a `v`.
     *
     * @param v vértice del que se obtienen los adyacentes.
     * @return conjunto de vértices adyacentes.
     * @throws Exception si el vértice no está en el grafo.
     ******************************************************************/
    public Set<V> obtainAdjacents(V v) throws Exception {
        if (!adjacencyList.containsKey(v)) {
            throw new Exception("El vértice no está en el grafo.");
        }
        return adjacencyList.get(v);
    }

    /******************************************************************
     * Comprueba si el grafo contiene el vértice dado.
     *
     * @param v vértice para el que se realiza la comprobación.
     * @return `true` si `v` es un vértice del grafo.
     ******************************************************************/
    public boolean containsVertex(V v) {
        return adjacencyList.containsKey(v);
    }

    /******************************************************************
     * Método `toString()` reescrito para la clase `Graph`.
     * 
     * @return una cadena de caracteres con la lista de adyacencia.
     ******************************************************************/
    @Override
    public String toString() {
        return adjacencyList.toString();
    }

    /******************************************************************
     * Obtiene, en caso de que exista, el camino más corto entre `v1` y `v2`. 
     * En caso contrario, devuelve `null`.
     *
     * @param v1 el vértice origen.
     * @param v2 el vértice destino.
     * @return lista con la secuencia de vértices del camino más corto entre `v1` y `v2`.
     ******************************************************************/
    public List<V> shortestPath(V v1, V v2) {
        if (!containsVertex(v1) || !containsVertex(v2)) {
            return null;
        }

        LinkedList<V> queue = new LinkedList<>();
        Map<V, V> predecessors = new HashMap<>();
        Set<V> visited = new HashSet<>();

        queue.add(v1);
        visited.add(v1);
        predecessors.put(v1, null);

        while (!queue.isEmpty()) {
            V current = queue.removeFirst();

            if (current.equals(v2)) {
                List<V> path = new LinkedList<>();
                V currentVertex = v2;
                while (currentVertex != null) {
                    path.add(currentVertex);
                    currentVertex = predecessors.get(currentVertex);
                }

                Collections.reverse(path);
                return path;
            }

            for (V neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    predecessors.put(neighbor, current);
                }
            }
        }

        return null;
    }
}