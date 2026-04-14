package program;
import java.util.ArrayList;
import java.util.Arrays;

public class BuyAndSellStock {
    
    public static int maxProfit(ArrayList<Integer> prices) {
        // Variable 1: Track the lowest price we have found in the past
        // We start it at the absolute maximum integer so the first day will always overwrite it.
        int minPrice = Integer.MAX_VALUE; 
        
        // Variable 2: Track the absolute best profit we have calculated
        int maxProfit = 0; 

        // Let time move forward day by day
        for (int i = 0; i < prices.size(); i++) {
            int currentPrice = prices.get(i);

            // Step A: Is today's price a new historical low?
            if (currentPrice < minPrice) {
                minPrice = currentPrice; // Update our buying price to this new low
            } 
            // Step B: If it's not a new low, would selling today beat our record profit?
            else if (currentPrice - minPrice > maxProfit) {
                maxProfit = currentPrice - minPrice; // Update our high score!
            }
        }

        return maxProfit;
    }

    // Testing the method
    public static void main(String[] args) {
        // Our standard test case
        ArrayList<Integer> normalCase = new ArrayList<>(Arrays.asList(7, 1, 5, 6, 4, 3));
        System.out.println("Normal Case Max Profit: " + maxProfit(normalCase)); // Expected: 5
        
        // The "Trap" test case (prices only go down)
        ArrayList<Integer> trapCase = new ArrayList<>(Arrays.asList(7, 6, 4, 3, 1));
        System.out.println("Trap Case Max Profit: " + maxProfit(trapCase));     // Expected: 0
    }
}