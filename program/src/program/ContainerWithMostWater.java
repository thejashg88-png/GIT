package program;
import java.util.ArrayList;
import java.util.Arrays;

public class ContainerWithMostWater {
    
    public static int maxArea(ArrayList<Integer> height) {
        int maxArea = 0;      // This will store our all-time highest record
        int left = 0;         // Pointer starting at the far left
        int right = height.size() - 1; // Pointer starting at the far right

        // Keep going as long as the pointers haven't crossed
        while (left < right) {
            
            // 1. Calculate Width and Height
            int currentWidth = right - left;
            int currentHeight = Math.min(height.get(left), height.get(right));
            
            // 2. Calculate Area and update our record if it's bigger
            int currentArea = currentWidth * currentHeight;
            maxArea = Math.max(maxArea, currentArea);

            // 3. The Golden Rule: Move the shorter wall inward
            if (height.get(left) < height.get(right)) {
                left++;  // Left wall was shorter, abandon it and move right
            } else {
                right--; // Right wall was shorter (or equal), abandon it and move left
            }
        }

        return maxArea;
    }

    // Testing the method
    public static void main(String[] args) {
        // Our standard test case
        ArrayList<Integer> normalCase = new ArrayList<>(Arrays.asList(1, 8, 6, 2, 5, 4, 8, 3, 7));
        System.out.println("Normal Case Max Area: " + maxArea(normalCase)); // Expected: 49
        
        // The "Trap" test case
        ArrayList<Integer> trapCase = new ArrayList<>(Arrays.asList(20, 2, 2, 100, 100, 2, 2, 20));
        System.out.println("Trap Case Max Area: " + maxArea(trapCase));     // Expected: 140
    }
}