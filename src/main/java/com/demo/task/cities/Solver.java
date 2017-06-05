package com.demo.task.cities;

/**
 * Class consist method for find minimal travel costs between the cities by
 * <a href="https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm">Floyd-Warshall method</a>
 * @author Slavik Aleksey V.
 * @version 1.0
 */
public class Solver {

    private static final int INF = 200001; // infinite value, because max cost value is 200000

    /**
     * Method return minimal costs matrix by Floyd-Warshall algorithm
     * @param test
     * @return matrix of minimal costs
     */
    public static int[][] solve(Test test) {
        int[][] costs = test.getCosts();
        for (int i = 0; i < costs.length; i++)
            for (int j = 0; j < costs.length; j++)
                if (costs[i][j] == 0) // 0 - means that no route from city i to city j
                    costs[i][j] = INF; // for this vertices cost is infinium
        for (int k = 0; k < costs.length; k++)
            for (int i = 0; i < costs.length; i++)
                for (int j = 0; j < costs.length; j++)
                    costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]); // search minimal costs between every city
        for (int i = 0; i < costs.length; i++)
            for (int j = 0; j < costs.length; j++)
                if (costs[i][j] == INF)
                    costs[i][j] = 0; // change infinium value to zero(its the same)
        return costs;
    }

    /**
     * Method return list of minimal costs for every testcase
     * @param test
     * @return list of minimal costs for every testcase
     */
    public static int[] getAnswer(Test test) {
        int[] answer = new int[test.getPaths().size()]; // get array of costs
        int[][] costs = Solver.solve(test); // get matrix of minimal travel costs for every city
        for (int i = 0; i < answer.length; i++) {
            String[] path = test.getPaths().get(i); // get departure and destination cities
            int from = test.getCities().get(path[0]); // get number of departure city
            int to = test.getCities().get(path[1]); // get number of destination city
            answer[i] = costs[from - 1][to - 1]; // get minimal travel cost
        }
        return answer;
    }
}
