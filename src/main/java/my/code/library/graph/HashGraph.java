package my.code.library.graph;

import java.util.HashMap;

public abstract class HashGraph<V extends BasicVertex<V,E>, E extends BasicEdge<V>> implements VertexOperations<V,E> {
    private HashMap<Object,V> vertices;

    HashGraph(int initialCapacity) {
        vertices = new HashMap<>(initialCapacity);
    }

    public boolean add(V vertex) {
        vertices.put(vertex.getId(), vertex);
        return true;
    }

    public boolean remove(V vertex) {
        return vertices.remove(vertex.getId()) != null;
    }

    public V get(Object vertexId) {
        return vertices.get(vertexId);
    }
}
