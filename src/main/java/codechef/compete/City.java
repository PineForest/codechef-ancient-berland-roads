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

import my.code.library.graph.BasicVertex;
import my.code.library.graph.VertexVisitor;

public class City extends BasicVertex<City,Road> {
    private int population;

    public static City instanceOf(int number) {
        return new City(number, 0);
    }

    public static City instanceOf(int number, int population) {
        return new City(number, population);
    }

    City(int number, int population) {
        super(number);
        this.population = population;
    }

    public int getNumber() {
        return (Integer) getId();
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public void accept(VertexVisitor<City, Road> visitor) {
        visitor.visit(this);
    }
}
