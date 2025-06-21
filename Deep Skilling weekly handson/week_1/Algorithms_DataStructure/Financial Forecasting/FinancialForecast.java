public class FinancialForecast {

    /**
     * Recursive method to calculate future value.
     * Formula: FV = PV * (1 + rate)^years
     */
    public static double futureValue(double presentValue, double rate, int years) {
        // Base case
        if (years == 0) {
            return presentValue;
        }
        // Recursive step
        return futureValue(presentValue, rate, years - 1) * (1 + rate);
    }

    /**
     * Optimized version using memoization (Dynamic Programming)
     */
    public static double futureValueMemo(double presentValue, double rate, int years, Double[] memo) {
        if (years == 0) return presentValue;

        if (memo[years] != null) return memo[years];

        memo[years] = futureValueMemo(presentValue, rate, years - 1, memo) * (1 + rate);
        return memo[years];
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;
        double annualGrowthRate = 0.08;  // 8% growth per year
        int years = 5;

        // Recursive calculation
        double result = futureValue(presentValue, annualGrowthRate, years);
        System.out.printf("Future Value (Recursive): ₹%.2f%n", result);

        // Optimized version using memoization
        Double[] memo = new Double[years + 1];
        double resultMemo = futureValueMemo(presentValue, annualGrowthRate, years, memo);
        System.out.printf("Future Value (Memoized): ₹%.2f%n", resultMemo);
    }
}
