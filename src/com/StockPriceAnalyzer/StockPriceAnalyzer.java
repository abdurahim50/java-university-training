package com.StockPriceAnalyzer;
import java.util.ArrayList;

public class StockPriceAnalyzer {

    // Method to calculate the average stock price from an array
    public static float calculateAveragePrice(float[] prices) {
        float sum = 0;
        for (float price : prices) {
            sum += price;
        }
        return sum / prices.length;
    }

    // Method to calculate the average stock price from an ArrayList
    public static float calculateAveragePrice(ArrayList<Float> prices) {
        float sum = 0;
        for (float price : prices) {
            sum += price;
        }
        return sum / prices.size();
    }

    // Method to find the maximum stock price from an array
    public static float findMaximumPrice(float[] prices) {
        float maxPrice = prices[0];
        for (float price : prices) {
            if (price > maxPrice) {
                maxPrice = price;
            }
        }
        return maxPrice;
    }

    // Method to find the maximum stock price from an ArrayList
    public static float findMaximumPrice(ArrayList<Float> prices) {
        float maxPrice = prices.get(0);
        for (float price : prices) {
            if (price > maxPrice) {
                maxPrice = price;
            }
        }
        return maxPrice;
    }

    // Method to count occurrences of a specific price in an array
    public static int countOccurrences(float[] prices, float targetPrice) {
        int count = 0;
        for (float price : prices) {
            if (price == targetPrice) {
                count++;
            }
        }
        return count;
    }

    // Method to count occurrences of a specific price in an ArrayList
    public static int countOccurrences(ArrayList<Float> prices, float targetPrice) {
        int count = 0;
        for (float price : prices) {
            if (price == targetPrice) {
                count++;
            }
        }
        return count;
    }

    // Method to compute the cumulative sum of stock prices in an ArrayList
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
        ArrayList<Float> cumulativeSum = new ArrayList<>();
        float sum = 0;
        for (float price : prices) {
            sum += price;
            cumulativeSum.add(sum);
        }
        return cumulativeSum;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Example array of stock prices
        float[] stockPricesArray = { 100.5f, 102.0f, 101.5f, 102.0f, 103.0f, 102.0f, 101.0f, 100.5f, 100.0f, 101.5f };

        // Example ArrayList of stock prices
        ArrayList<Float> stockPricesList = new ArrayList<>();
        for (float price : stockPricesArray) {
            stockPricesList.add(price);
        }

        // Calculate average price
        float averagePriceArray = calculateAveragePrice(stockPricesArray);
        float averagePriceList = calculateAveragePrice(stockPricesList);
        System.out.println("Average Stock Price (Array): " + averagePriceArray);
        System.out.println("Average Stock Price (ArrayList): " + averagePriceList);

        // Find maximum price
        float maxPriceArray = findMaximumPrice(stockPricesArray);
        float maxPriceList = findMaximumPrice(stockPricesList);
        System.out.println("Maximum Stock Price (Array): " + maxPriceArray);
        System.out.println("Maximum Stock Price (ArrayList): " + maxPriceList);

        // Count occurrences of a specific price
        float targetPrice = 102.0f;
        int occurrencesArray = countOccurrences(stockPricesArray, targetPrice);
        int occurrencesList = countOccurrences(stockPricesList, targetPrice);
        System.out.println("Occurrences of " + targetPrice + " (Array): " + occurrencesArray);
        System.out.println("Occurrences of " + targetPrice + " (ArrayList): " + occurrencesList);

        // Compute cumulative sum
        ArrayList<Float> cumulativeSum = computeCumulativeSum(stockPricesList);
        System.out.println("Cumulative Sum of Stock Prices: " + cumulativeSum);
    }
}