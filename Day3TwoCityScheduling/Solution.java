package Day3TwoCityScheduling;

import java.util.Comparator;
import java.util.Arrays;
class SolutionSorting {

    public int twoCitySchedCost(final int[][] costs) {
        int c = 0;
 
        Arrays.sort(costs, Comparator.comparingInt(o -> o[0] - o[1]));
 
        for (int i = 0, j = costs.length - 1; i < j; ++i, --j) {
            c += costs[i][0];
            c += costs[j][1];
        }
 
        return c;
    }
 }

 class TowCityScheduling {
    public static void main(final String[] args) {
        
        final int[][] cities = {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};

        System.out.println(new SolutionSorting().twoCitySchedCost(cities));
    }
}
