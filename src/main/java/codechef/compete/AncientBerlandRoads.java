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
