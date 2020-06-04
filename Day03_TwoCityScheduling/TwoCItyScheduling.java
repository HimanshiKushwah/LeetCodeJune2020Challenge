package Day03_TwoCityScheduling;

import java.util.Arrays;
import java.util.Scanner;
class Solution {
    private int twoCitySchedCostRecHelper(int[][] costs, int n, int a, int b) {

        if (a == 0 && b == 0) return 0;

        if (a < 0 || b < 0) return Integer.MAX_VALUE;

        int temp1 = twoCitySchedCostRecHelper(costs, n - 1, a - 1, b);
        int temp2 = twoCitySchedCostRecHelper(costs, n - 1, a, b - 1);
        
        temp1 = temp1 == Integer.MAX_VALUE ? temp1 :  temp1 + costs[n - 1][0];
        temp2 = temp2 == Integer.MAX_VALUE? temp2 : temp2 + costs[n - 1][1];

        return Integer.min(temp1, temp2);

    }
    private int twoCitySchedCostRec(int[][] costs) {
        int n = costs.length;

        return twoCitySchedCostRecHelper(costs, n, n >> 1, n >> 1);
    }

    private int twoCitySchedCostTopDownHelper(int[][] costs, int[][] dp, int a, int b) {

        if(a == 0 && b == 0) return dp[a][b] = 0;

        if(a < 0 || b < 0) return Integer.MAX_VALUE;

        if(dp[a][b] != -1) return dp[a][b];

        int temp1 = twoCitySchedCostTopDownHelper(costs, dp, a - 1 , b);
        int temp2 = twoCitySchedCostTopDownHelper(costs, dp, a, b -1);

        temp1 = temp1 == Integer.MAX_VALUE ? temp1 :  temp1 + costs[a - 1 + b][0];
        temp2 = temp2 == Integer.MAX_VALUE? temp2 : temp2 + costs[a + b - 1][1];

        return dp[a][b] = Integer.min(temp1, temp2);


    }
    private int twoCitySchedCostTopDown(int[][] costs) {
        int n = costs.length;
        int a = n >> 1;
        int b = a;
        int[][] dp = new int[a + 1][b + 1];

        for (int[] x : dp) {
            Arrays.fill(x, -1);
    
        }

        twoCitySchedCostTopDownHelper(costs, dp, a, b);
        return dp[a][b];

    }
    public int twoCitySchedCost(int[][] costs) {
        // return twoCitySchedCostRec(costs);
        return twoCitySchedCostTopDown(costs);
    }
}


class TwoCityScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] costs = new int[n][2];

        for (int i = 0; i < n; ++i) {
            costs[i][0] = sc.nextInt();
            costs[i][1] = sc.nextInt();
        
        }

        System.out.println(new Solution().twoCitySchedCost(costs));
        sc.close();
    }
}