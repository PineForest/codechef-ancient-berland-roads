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

import my.code.library.graph.UndirectedHashGraph;

import java.util.*;

public class AncientBerlandRoads extends UndirectedHashGraph<City,Road> {
    private Map<Integer,City> cities;
    private Map<Integer,Road> roads;

    public static AncientBerlandRoads instanceOf(int totalCities) {
        return new AncientBerlandRoads(totalCities);
    }

    private AncientBerlandRoads(int totalCities) {
        super(totalCities);
        cities = new HashMap<>(totalCities);
        // Estimating the count of edges
        roads = new HashMap<>(totalCities);
    }

    public boolean addCity(int number, int population) {
        City city = City.instanceOf(number, population);
        if (!add(city)) {
            return false;
        }
        cities.put(number, city);
        return true;
    }

    public boolean setCityPopulation(int number, int population) {
        City city = get(number);
        if (city == null) {
            return false;
        }
        city.setPopulation(population);
        return true;
    }

    public Road addRoad(int number, int cityOneNumber, int cityTwoNumber) {
        City cityOne = cities.get(cityOneNumber);
        if (null == cityOne) {
            return null;
        }
        City cityTwo = cities.get(cityTwoNumber);
        if (null == cityTwo) {
            return null;
        }
        Road road = Road.instanceOf(number, cityOne, cityTwo);
        if (!add(road)) {
            return null;
        }
        roads.put(number, road);
        return road;
    }

    public Road removeRoad(int number) {
        Road road = roads.remove(number);
        if (road == null) {
            return null;
        }
        return remove(road) ? road : null;
    }

    public Collection<City> getImmutableCities() {
        return Collections.unmodifiableCollection(cities.values());
    }
}
