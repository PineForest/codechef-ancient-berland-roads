/*
 * Copyright © 2016  David Williams
 *
 * This file is part of the codechef-ancient-berland-roads project.
 *
 * codechef-ancient-berland-roads is free software: you can redistribute it and/or modify it under the terms of the
 * Lesser GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * codechef-ancient-berland-roads is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the Lesser GNU General Public
 * License for more details.
 *
 * You should have received a copy of the Lesser GNU General Public License along with codechef-ancient-berland-roads.
 * If not, see <a href="http://www.gnu.org/licenses/">www.gnu.org/licenses/</a>.
 */

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
