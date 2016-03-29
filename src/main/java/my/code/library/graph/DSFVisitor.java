package my.code.library.graph;

import java.util.HashSet;
import java.util.Set;

public abstract class DSFVisitor<V extends BasicVertex<V,E>, E extends Edge<V>> implements VertexVisitor<V,E> {
    private Set<V> visited;

    public DSFVisitor() {
        this.visited = new HashSet<>();
    }

    @Override
    public void visit(V visitedVertex) {
        // If we have already visited this vertex, do nothing further
        if (visited.contains(visitedVertex)) {
            return;
        }
        visited.add(visitedVertex);
        operation(visitedVertex);
        visitAdjoining(visitedVertex);
    }

    protected abstract void operation(V visitedVertex);

    private void visitAdjoining(V visitedVertex) {
        for (E edge : visitedVertex.getImmutableEdges()) {
            V adjacent = edge.getAdjacent(visitedVertex);
            adjacent.accept(this);
        }
    }
}
