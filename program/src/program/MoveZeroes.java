package program;
import java.util.ArrayList;
import java.util.Arrays;

public class MoveZeroes {
    
    public static void moveZeroes(ArrayList<Integer> list) {
        // This pointer keeps track of where the next non-zero element should go
        int nonZeroIndex = 0; 

        // Iterate through the ArrayList with our main pointer 'i'
        for (int i = 0; i < list.size(); i++) {
            
            // If we find a non-zero element, swap it to the 'nonZeroIndex' position
            if (list.get(i) != 0) {
                int temp = list.get(nonZeroIndex);
                list.set(nonZeroIndex, list.get(i));
                list.set(i, temp);
                
                // Move the nonZeroIndex forward
                nonZeroIndex++;
            }
        }
    }

    // Testing the method
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(0, 1, 0, 3, 12));
        
        System.out.println("Original List: " + nums);
        moveZeroes(nums);
        System.out.println("After moving zeroes: " + nums);
    }
}