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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * An implementation of the Ancient Berland Roads graph exercise taken from <a href="https://www.codechef.com/LTIME31/problems/ABROADS">www.codechef.com</a>.
 * <p/>
 * In Ancient Berland, there were N towns, along with M bidirectional roads connecting them. With time, some roads became unusable, and nobody repaired them.<br/>
 * As a person who is fond of Ancient Berland history, you now want to undertake a small research study. For this purpose, you want to write a program capable of processing the following kinds of queries:
 * <ul>
 *     <li><tt>D</tt><b> K</b> : meaning that the road numbered <b>K</b> in the input became unusable. The road numbers are 1-indexed.</li>
 *     <li><tt>P</tt><b> A x</b> : meaning that the population of the <b>A</b><sup>th</sup> town became <b>x</b>.</li>
 * </ul>
 * Let's call a subset of towns a <b>region</b> if it is possible to get from each town in the subset to every other town in the subset by the usable (those, which haven't already been destroyed) roads, possibly, via some intermediary cities of this subset. The <b>population</b> of the region is, then, the sum of populations of all the towns in the region.<br/>
 * You are given the initial road system, the initial population in each town and <b>Q</b> queries, each being one of two types above. Your task is to maintain the size of the most populated region after each query.
 * <h3>Input</h3>
 * The first line of each test case contains three space-separated integers — <b>N</b>, <b>M</b>, and <b>Q</b> — denoting the number of cities, the number of roads, and the number of queries, respectively.<br/>
 * The following line contains <b>N</b> space-separated integers, the <b>i</b><sup>th</sup> of which denotes the initial population of the <b>i</b><sup>th</sup> city.<br/>
 * The <b>j</b><sup>th</sup> of the following <b>M</b> lines contains a pair of space-separated integers — <b>X<sub>j</sub>, Y<sub>j</sub></b> — denoting that there is a bidirectional road connecting the cities numbered <b>X<sub>j</sub></b> and <b>Y<sub>j</sub></b>.<br/>
 * Each of the following <b>Q</b> lines describes a query in one of the forms described earlier.
 * <h3>Output</h3>
 * Output <b>Q</b> lines. On the <b>i</b><sup>th</sup> line, output the size of the most populated region after performing <b>i</b> queries.
 * <h3>Constraints</h3>
 * <ul>
 *     <li><b>1</b> ≤ <b>X<sub>j</sub></b>, <b>Y<sub>j</sub></b> ≤ <b>N</b></li>
 *     <li>Roads' numbers are 1-indexed.</li>
 *     <li>There is no road that gets removed twice or more.</li>
 *     <li><b>1</b> ≤ <b>P<sub>i</sub></b> ≤ <b>10<sup>5</sup></b></li>
 *     <li>Subtask 1 (30 points) : <b>1</b> ≤ <b>N</b>, <b>M</b>, <b>Q</b> ≤ <b>10<sup>3</sup></b></li>
 *     <li>Subtask 2 (70 points) : <b>1</b> ≤ <b>N</b>, <b>M</b>, <b>Q</b> ≤ <b>5 × 10<sup>5</sup></b></li>
 * </ul>
 * <h3>Example</h3>
 * <pre>
 * <b>Input:</b>
 * <tt>3 3 6
 * 1 2 3
 * 1 2
 * 2 3
 * 3 1
 * P 1 3
 * D 1
 * P 2 3
 * D 2
 * P 3 10
 * D 3</tt><br/>
 * <b>Output:</b>
 * <tt>8
 * 8
 * 9
 * 6
 * 13
 * 10</tt></pre>
 * <h3>Explanation</h3>
 * <ul>
 *     <li>After the first query, the populations are <b>(3, 2, 3)</b> and the most populated region is <b>{1, 2, 3}</b>.</li>
 *     <li>After the second query the populations and the regions remain the same.</li>
 *     <li>After the third query the populations are <b>(3, 3, 3)</b> and the most populated region is again <b>{1, 2, 3}</b>.</li>
 *     <li>After the fourth query the populations remain the same, but we have two regions: <b>{1, 3}</b> and <b>{2}</b>. The most populated region is <b>{1, 3}</b>.</li>
 *     <li>After the fifth query the populations become equal to <b>(3, 3, 10)</b> respectively, and the most populated region is again <b>{1, 3}</b>.</li>
 *     <li>After the last query we have populations the same, but now every city forms it own separate region, and the most populated region is region <b>{3}</b>.</li>
 * </ul>
 *
 * @author PineForest (see https://github.com/PineForest) 3/29/2016
 */
public class AncientBerlandRoadsExercise {
    private AncientBerlandRoads ancientBerlandRoads;
    int countCities;
    int countRoads;
    int countQueries;

    public static void main(String[] args) throws IOException {
        AncientBerlandRoadsExercise exercise = new AncientBerlandRoadsExercise();
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        // Read bounds
        String line = buffer.readLine().trim();
        exercise.init(line);
        // Create cities
        line = buffer.readLine().trim();
        exercise.createCities(line);
        // Add roads between cities
        for (int i = 0; i < exercise.getCountRoads(); ++i) {
            line = buffer.readLine().trim();
            exercise.createRoad(i + 1, line);
        }
        // Execute queries (D or P) and display the population of the largest region
        for (int i = 0; i < exercise.getCountQueries(); ++i) {
            line = buffer.readLine().trim();
            exercise.executeQuery(line);
            exercise.printLargestPopulation();
        }
    }

    public AncientBerlandRoadsExercise() {
        ancientBerlandRoads = null;
        countCities = 0;
        countRoads = 0;
        countQueries = 0;
    }

    public int getCountCities() {
        return countCities;
    }

    public int getCountRoads() {
        return countRoads;
    }

    public int getCountQueries() {
        return countQueries;
    }

    private void init(String inputLine) {
        String[] boundsDetailsArray = inputLine.split("\\s+");
        int[] boundsDetails = convert(boundsDetailsArray);
        countCities = boundsDetails[0];
        countRoads = boundsDetails[1];
        countQueries = boundsDetails[2];
        ancientBerlandRoads = AncientBerlandRoads.instanceOf(countCities);
    }

    private void createCities(String inputLine) {
        String[] citiesDetailsArray = inputLine.split("\\s+");
        int[] cityDetails = convert(citiesDetailsArray);
        for (int i = 0; i < cityDetails.length; ++i) {
            if (!ancientBerlandRoads.addCity(i + 1, cityDetails[i])) {
                System.err.println(String.format("Unable to add city %d with population %d", i + 1, cityDetails[i]));
                System.exit(-1);
            }
        }
    }

    private void createRoad(int number, String inputLine) {
        String[] connectedCitiesDetails = inputLine.split("\\s+");
        int[] connectedCities = convert(connectedCitiesDetails);
        if (ancientBerlandRoads.addRoad(number, connectedCities[0], connectedCities[1]) == null) {
            System.err.println(String.format("Unable to add a road between cities %d and %d", connectedCities[0], connectedCities[1]));
            System.exit(-1);
        }
    }

    private void executeQuery(String inputLine) {
        String[] queryDetails = inputLine.split("\\s+");
        if (queryDetails[0].equals("D")) {
            int roadNumber = Integer.parseInt(queryDetails[1]);
            ancientBerlandRoads.removeRoad(roadNumber);
        } else if (queryDetails[0].equals("P")) {
            int cityNumber = Integer.parseInt(queryDetails[1]);
            int population = Integer.parseInt(queryDetails[2]);
            ancientBerlandRoads.setCityPopulation(cityNumber, population);
        } else {
            throw new RuntimeException("Problem with query line: " + inputLine);
        }
    }

    // 1 2 3 4 5
    // 1 <- 2 <- 3, 4 <- 5, 2 -> 5
    private void printLargestPopulation() {
        RegionalPopulationCountingVisitor populationVisitor = new RegionalPopulationCountingVisitor();
        int largestRegion = 0;
        for (City city : ancientBerlandRoads.getImmutableCities()) {
            populationVisitor.visit(city);
            if (populationVisitor.getPopulationCount() > largestRegion) {
                largestRegion = populationVisitor.getPopulationCount();
            }
            populationVisitor.setPopulationCount(0);
        }
        System.out.println(largestRegion);
    }

    private static int[] convert(String[] stringArray) {
        int[] result = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; ++i) {
            result[i] = Integer.parseInt(stringArray[i]);
        }
        return result;
    }
}
