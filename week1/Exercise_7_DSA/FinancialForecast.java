package com.Bharani.FinancialForecasting;

import java.util.HashMap;
import java.util.Map;

//Concept of Recursion:
//Recursion is a technique in programming where a function calls itself to solve smaller instances of the same problem. It is often used to simplify problems that can be broken down into similar sub-problems.
//
//Recursion typically involves:
//
//Base Case: The condition under which the recursion ends.
//Recursive Case: The part of the function that reduces the problem and calls itself.


public class FinancialForecast {

    // Map to store computed future values
    private static Map<Integer, Double> memo = new HashMap<>();

    // Recursive method to calculate future value with memoization
    public static double calculateFutureValue(double presentValue, double annualGrowthRate, int years) {
        // Base case: if years is 0, return present value
        if (years == 0) {
            return presentValue;
        }

        // Check if result is already computed
        if (memo.containsKey(years)) {
            return memo.get(years);
        }

        // Recursive case: calculate future value for (years - 1) and apply growth rate
        double futureValue = calculateFutureValue(presentValue, annualGrowthRate, years - 1) * (1 + annualGrowthRate);
        memo.put(years, futureValue); // Store the result

        return futureValue;
    }

    public static void main(String[] args) {
        // Example usage
        double presentValue = 1000.0; // Present value in dollars
        double annualGrowthRate = 0.05; // Annual growth rate (5%)
        int years = 10; // Number of years in the future

        double futureValue = calculateFutureValue(presentValue, annualGrowthRate, years);
        System.out.println("The future value is: " + futureValue);
    }
}
// Analysis:
//Time Complexity:
//The time complexity of the recursive algorithm is O(n), where n is the number of years. This is because each recursive call reduces the problem size by one year until it reaches the base case.
//
//Optimizing the Recursive Solution
//To avoid excessive computation and potential stack overflow issues, we can use memoization. Memoization involves storing the results of expensive function calls and reusing them when the same inputs occur again.

