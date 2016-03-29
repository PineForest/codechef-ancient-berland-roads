package my.code.library.graph;

public interface Edge<V extends Vertex> {
    Object getId();

    V getVertexOne();

    V getVertexTwo();

    V getAdjacent(V origin);
}
