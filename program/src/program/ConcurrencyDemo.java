package program;

import java.util.concurrent.CompletableFuture;

public class ConcurrencyDemo {

    public static void main(String[] args) {
        System.out.println("Main Thread starts: " + Thread.currentThread().getName());
        long startTime = System.currentTimeMillis();

        // Task 1: Fetch user profile asynchronously
        CompletableFuture<String> userProfileTask = CompletableFuture.supplyAsync(() -> {
            simulateDelay(2000); // Simulating a 2-second network call
            System.out.println("Fetched Profile on: " + Thread.currentThread().getName());
            return "User: John Doe (ID: 101)";
        });

        // Task 2: Fetch order history asynchronously
        CompletableFuture<String> orderHistoryTask = CompletableFuture.supplyAsync(() -> {
            simulateDelay(3000); // Simulating a 3-second database query
            System.out.println("Fetched Orders on: " + Thread.currentThread().getName());
            return "Recent Orders: [Laptop, Coffee Mug]";
        });

        System.out.println("Main Thread is free to do other things while data fetches...");

        // Task 3: Combine the results of Task 1 and Task 2 when BOTH are finished
        CompletableFuture<String> combinedTask = userProfileTask.thenCombine(orderHistoryTask, (profile, orders) -> {
            System.out.println("Combining results on: " + Thread.currentThread().getName());
            return "DASHBOARD SUMMARY -> " + profile + " | " + orders;
        });

        // Task 4: Do something with the final combined result
        CompletableFuture<Void> finalOutputTask = combinedTask.thenAccept(finalResult -> {
            System.out.println("\n--- FINAL OUTPUT ---");
            System.out.println(finalResult);
        });

        // .join() blocks the main thread just to prevent the program from exiting before our background tasks finish.
        // In a real web server, you wouldn't block; you would just return the CompletableFuture to the web framework.
        finalOutputTask.join(); 

        long endTime = System.currentTimeMillis();
        System.out.println("\nTotal Time Taken: " + (endTime - startTime) + " ms");
        // Notice it takes ~3 seconds total, not 5 seconds!
    }

    // A simple helper method to simulate long-running tasks
    private static void simulateDelay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}