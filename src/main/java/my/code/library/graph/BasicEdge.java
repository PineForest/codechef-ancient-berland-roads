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

import java.util.Objects;

/**
 * @author PineForest (see https://github.com/PineForest) 3/29/2016
 */
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
