package codechef.compete;

import my.code.library.graph.DSFVisitor;

public class RegionalPopulationCountingVisitor extends DSFVisitor<City,Road> {
    private int populationCount;

    public RegionalPopulationCountingVisitor() {
        this.populationCount = 0;
    }

    public int getPopulationCount() {
        return populationCount;
    }

    public void setPopulationCount(int populationCount) {
        this.populationCount = populationCount;
    }

    @Override
    protected void operation(City visitedVertex) {
        populationCount += visitedVertex.getPopulation();
    }
}
