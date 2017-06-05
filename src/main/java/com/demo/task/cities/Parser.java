package com.demo.task.cities;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class contain method for getting data from a file
 * @author Slavik Aleksey V.
 * @version 1.0
 */
public class Parser {

    /**
     * Method parsing data from a file and save data as a list of Test objects
     * @param file
     * @return list of testcases
     */
    public static ArrayList<Test> parse(String file) {
        ArrayList<Test> tests = new ArrayList<Test>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file)); // read file
            int testCount = Integer.valueOf(reader.readLine()); // get count of testcases
            for (int i = 0; i < testCount; i++) {
                Test test = new Test();
                int cityCount = Integer.valueOf(reader.readLine()); // get count of cities
                int[][] costs = new int[cityCount][cityCount]; // create matrix for current testcase
                HashMap<String, Integer> cities = new HashMap<String, Integer>();
                ArrayList<String[]> paths = new ArrayList<String[]>();
                for (int j = 0; j < cityCount; j++) {
                    String city = reader.readLine(); // get city name
                    cities.put(city, j + 1); // save city name into map
                    int neighbourCount = Integer.valueOf(reader.readLine()); // get count of neighbour cities
                    for (int k = 0; k < neighbourCount; k++) {
                        String[] str = reader.readLine().split(" "); // get array, which consist of two values - number of city and travel cost
                        int cityNum = Integer.valueOf(str[0]); // get number of neighbour city
                        int cityCost = Integer.valueOf(str[1]); // get travel cost to neighbour city
                        costs[j][cityNum - 1] = cityCost; // save data in matrix
                    }
                }
                int pathCount = Integer.valueOf(reader.readLine()); // get count of paths, which need to find
                for (int j = 0; j < pathCount; j++) {
                    paths.add(reader.readLine().split(" ")); // get array, which consist of two values - departure and destination cities
                }

                test.setCosts(costs);
                test.setCities(cities);
                test.setPaths(paths);
                tests.add(test); // save testcase in list
                if (testCount - i > 1)
                    reader.readLine(); // pass one line that separate testcases
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Not correct form of input data!");
        }
        return tests;
    }
}
