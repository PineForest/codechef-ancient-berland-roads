package my.code.library.graph;

import java.util.Set;

public interface VertexOperations<V extends Vertex<V,E>, E extends Edge<V>> {
    boolean add(E edge);

    boolean remove(E edge);

    Set<V> getAdjacentVertices(V origin);
}
