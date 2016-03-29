package my.code.library.graph;

public class UndirectedEdge<V extends BasicVertex<V,E>, E extends BasicEdge<V>> extends BasicEdge<V> {
    public UndirectedEdge(Object id, V vertexOne, V vertexTwo) {
        super(id, vertexOne, vertexTwo);
    }

    @Override
    public V getAdjacent(V origin) {
        return origin.equals(getVertexOne()) ? getVertexTwo() : origin.equals(getVertexTwo()) ? getVertexOne() : null;
    }
}
