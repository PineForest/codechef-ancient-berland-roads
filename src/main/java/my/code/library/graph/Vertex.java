package my.code.library.graph;

import java.util.Set;

public interface Vertex<V extends Vertex<V,E>, E extends Edge<V>> {
    Object getId();

    boolean contains(E edge);

    int countEdges();

    Set<E> getImmutableEdges();

    void accept(VertexVisitor<V,E> visitor);
}
