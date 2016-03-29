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

package codechef.compete;

import my.code.library.graph.UndirectedEdge;

public class Road extends UndirectedEdge<City,Road> {
    public static Road instanceOf(int number, City cityOne, City cityTwo) {
        return new Road(number, cityOne, cityTwo);
    }

    private Road(int number, City cityOne, City cityTwo) {
        super(number, cityOne, cityTwo);
    }

    public int getNumber() {
        return (Integer) getId();
    }
}
