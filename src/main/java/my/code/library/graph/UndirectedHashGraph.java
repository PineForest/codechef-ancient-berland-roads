package my.code.library.graph;

import my.code.library.util.StateCorruptedException;

import java.util.HashSet;
import java.util.Set;

public class UndirectedHashGraph<V extends BasicVertex<V,E>, E extends UndirectedEdge<V,E>> extends HashGraph<V,E>
        implements VertexOperations<V,E> {
    public UndirectedHashGraph(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public boolean add(E edge) {
        V vertexOne = edge.getVertexOne();
        if (!vertexOne.add(edge)) {
            return false;
        }
        V vertexTwo = edge.getVertexTwo();
        if (vertexTwo.add(edge)) {
            return true;
        }
        if(!vertexOne.remove(edge)) {
            throw new StateCorruptedException("Unable to add to vertex two and unable to remove from vertex one. Instance in a corrupted state.");
        }
        return false;
    }

    @Override
    public boolean remove(E edge) {
        V vertexOne = edge.getVertexOne();
        if (!vertexOne.remove(edge)) {
            return false;
        }
        V vertexTwo = edge.getVertexTwo();
        if (vertexTwo.remove(edge)) {
            return true;
        }
        if(!vertexOne.add(edge)) {
            throw new StateCorruptedException("Unable to remove from vertex two and unable to add to vertext one. Instance in a corrupted state.");
        }
        return false;
    }

    @Override
    public Set<V> getAdjacentVertices(V origin) {
        Set<E> edges = origin.getImmutableEdges();
        Set<V> result = new HashSet<>(edges.size());
        for (E edge : edges) {
            V vertex = edge.getVertexTwo();
            if (vertex.equals(origin)) {
                vertex = edge.getVertexOne();
            }
            result.add(vertex);
        }
        return result;
    }
}
