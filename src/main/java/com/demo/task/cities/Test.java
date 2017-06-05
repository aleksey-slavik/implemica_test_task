package com.demo.task.cities;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Object for every testcase.
 * Consist vertices matrix, list of cities and paths, for which minimal costs need to find
 * @author Slavik Aleksey V.
 * @version 1.0
 */
public class Test {

    private int[][] costs;
    private HashMap<String, Integer> cities;
    private ArrayList<String[]> paths;

    public int[][] getCosts() {
        return costs;
    }

    public void setCosts(int[][] costs) {
        this.costs = costs;
    }

    public HashMap<String, Integer> getCities() {
        return cities;
    }

    public void setCities(HashMap<String, Integer> cities) {
        this.cities = cities;
    }

    public ArrayList<String[]> getPaths() {
        return paths;
    }

    public void setPaths(ArrayList<String[]> paths) {
        this.paths = paths;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matrix of costs:\n");
        for (int i = 0; i < costs.length; i++) {
            for (int j = 0; j < costs.length; j++)
                sb.append(costs[i][j]);
            sb.append("\n");
        }
        sb.append("Paths:\n");
        for (String[] item : paths) {
            sb.append("from ");
            sb.append(item[0]);
            sb.append(" to ");
            sb.append(item[1]);
            sb.append("\n");
        }
        return sb.toString();
    }
}
