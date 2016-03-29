package my.code.library.graph;

import java.util.*;

public class BasicVertex<V extends BasicVertex<V,E>, E extends Edge<V>> implements Vertex<V,E> {
    private Object id;
    private Set<E> edges;

    protected BasicVertex(Object id) {
        this.id = id;
        edges = new HashSet<>();
    }

    public boolean add(E edge) {
        return edges.add(edge);
    }

    public boolean remove(E edge) {
        return edges.remove(edge);
    }

    @Override
    public Object getId() {
        return id;
    }

    @Override
    public boolean contains(E edge) {
        return edges.contains(edge);
    }

    @Override
    public int countEdges() {
        return edges.size();
    }

    @Override
    public Set<E> getImmutableEdges() {
        return Collections.unmodifiableSet(edges);
    }

    @Override
    public void accept(VertexVisitor<V, E> visitor) {
        throw new UnsupportedOperationException("Not implemented for BasicVertex");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicVertex<?, ?> that = (BasicVertex<?, ?>) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
