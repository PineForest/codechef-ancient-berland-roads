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
