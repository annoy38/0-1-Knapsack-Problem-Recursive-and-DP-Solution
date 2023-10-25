public class Main {

    //recursive Approach Solution
    public static int knapsack(int[] weight, int[] price, int bagWeight, int n){
        if(n==0 || bagWeight==0){
            return 0;
        }

        if(weight[n-1]<=bagWeight){
            return Math.max(price[n-1]+ knapsack(weight, price, bagWeight-weight[n-1], n-1),
                    knapsack(weight, price, bagWeight, n-1));
        }
        return knapsack(weight, price, bagWeight, n-1);
    }

    //DP Approach Solution
    public static int knapsackDP(int[] weight, int[] price, int bagWeight, int n){
        int[][] dp = new int[n+1][bagWeight+1];
        for(int i = 0; i<n+1;i++){
            for(int j = 0;j<bagWeight+1;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        int i, j = 0;
        for( i = 1;i<n+1;i++){
            for( j = 1;j<bagWeight+1;j++){
                if(weight[i-1]<=j){
                    dp[i][j] = Math.max(price[i-1]+dp[i-1][j-weight[i-1]], dp[i-1][j]);
                } else if (weight[i-1]>j) {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[i-1][j-1];
    }

    public static void main(String[] args) {
        int[] weights = {1,3,4,5};
        int[] prices = {1,4,5,7};
        System.out.println("Recursive Approach Solution Answer: "+knapsack(weights, prices, 7, weights.length));
        System.out.println("DP Approach Solution Answer: "+knapsackDP(weights, prices, 7, weights.length));
    }
}