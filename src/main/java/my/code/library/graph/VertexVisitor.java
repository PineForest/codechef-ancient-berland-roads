package my.code.library.graph;

public interface VertexVisitor<V extends Vertex<V,E>, E extends Edge<V>> {
    void visit(V visitedVertex);
}
