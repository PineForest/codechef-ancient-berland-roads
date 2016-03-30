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

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author PineForest (see https://github.com/PineForest) 3/29/2016
 */
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
