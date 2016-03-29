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
