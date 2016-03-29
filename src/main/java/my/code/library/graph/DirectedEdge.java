package my.code.library.graph;

public class DirectedEdge<V extends Vertex> extends BasicEdge<V> {
    public DirectedEdge(Object id, V vertexOne, V vertexTwo) {
        super(id, vertexOne, vertexTwo);
    }

    @Override
    public V getAdjacent(V origin) {
        return origin.equals(getVertexOne()) ? getVertexTwo() : null;
    }
}
