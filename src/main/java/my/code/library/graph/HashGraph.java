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
