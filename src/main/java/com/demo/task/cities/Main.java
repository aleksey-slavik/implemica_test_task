package com.demo.task.cities;

import java.util.ArrayList;

/**
 * Task 2. Find the paths of minimum cost between pairs of cities.
 * Assume that the cost of each path is at most 200000.
 * The name of a city is a string containing characters a,...,z and is at most 10 characters long.
 * Each direct connection between two cities has its transportation cost (an integer bigger than 0)
 * @author Slavik Aleksey V.
 * @version 1.0
 */
public class Main {

    /**
     * Entry point in app
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Test> tests = Parser.parse("input.txt"); // parsing data from input.txt
        int cnt = 1; // counter for testcases
        for (Test test : tests) {
            int[] costs = Solver.getAnswer(test); // get minimal travel costs
            StringBuilder sb = new StringBuilder();
            sb.append("testcase ");
            sb.append(cnt);
            sb.append(":\n");
            for (int  i : costs) {
                sb.append(i);
                sb.append("\n");
            }
            System.out.print(sb); // output results
            cnt++;
        }
    }
}
