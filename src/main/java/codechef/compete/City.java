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
