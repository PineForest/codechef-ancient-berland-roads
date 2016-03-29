package my.code.library.graph;

import java.util.Objects;

public abstract class BasicEdge<V extends Vertex> implements Edge<V> {
    private Object id;
    private V vertexOne;
    private V vertexTwo;

    public BasicEdge(Object id, V vertexOne, V vertexTwo) {
        this.id = id;
        this.vertexOne = vertexOne;
        this.vertexTwo = vertexTwo;
    }

    @Override
    public Object getId() {
        return id;
    }

    @Override
    public V getVertexOne() {
        return vertexOne;
    }

    @Override
    public V getVertexTwo() {
        return vertexTwo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicEdge<?> basicEdge = (BasicEdge<?>) o;
        return Objects.equals(getId(), basicEdge.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
