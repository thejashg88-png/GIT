package program;

import java.util.*;
import java.util.stream.Collectors;


// 1. A simple Record to hold our data (Introduced in modern Java)
record Employee(String name, String department, double salary, List<String> skills) {}

public class StreamOperationsDemo {

    public static void main(String[] args) {
        
        // 2. Our Source Data
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "Engineering", 85000, Arrays.asList("Java", "SQL")),
            new Employee("Bob", "HR", 60000, Arrays.asList("Communication")),
            new Employee("Charlie", "Engineering", 95000, Arrays.asList("Python", "Java", "AWS")),
            new Employee("David", "Marketing", 70000, Arrays.asList("SEO", "Content")),
            new Employee("Eve", "Engineering", 85000, Arrays.asList("Java", "React")), // Same salary as Alice
            new Employee("Frank", "HR", 55000, Arrays.asList("Recruiting"))
        );

        System.out.println("--- INTERMEDIATE OPERATIONS ---");
        /*
         * INTERMEDIATE OPERATIONS (Lazy - they return a new Stream)
         * We will chain several together to show how data is transformed.
         */
        List<String> topEngineers = employees.stream()
            // filter(): Keeps only elements that match the condition
            .filter(emp -> emp.department().equals("Engineering"))
            
            // peek(): Allows you to perform an action without changing the stream (great for debugging)
            .peek(emp -> System.out.println("Filtered Engineer: " + emp.name()))
            
            // sorted(): Sorts the stream (here, by salary descending)
            .sorted(Comparator.comparingDouble(Employee::salary).reversed())
            
            // map(): Transforms the object into something else (Employee -> String name)
            .map(Employee::name)
            
            // distinct(): Removes duplicates (if there were any exact matching names)
            .distinct()
            
            // limit(): Truncates the stream to only allow the first N elements through
            .limit(2) 
            
            // Terminal Operation to collect the results so the stream actually runs
            .collect(Collectors.toList()); 

        System.out.println("Top 2 Paid Engineers: " + topEngineers);


        System.out.println("\n--- FLATMAP EXAMPLE ---");
        /*
         * flatMap(): Used to "flatten" nested structures. 
         * Here, we turn a Stream of Employees into a Stream of their individual skills.
         */
        List<String> allUniqueSkills = employees.stream()
            .flatMap(emp -> emp.skills().stream()) // Extracts lists of skills and merges them into one continuous stream
            .distinct()                            // Removes duplicate skills
            .sorted()                              // Sorts skills alphabetically
            .collect(Collectors.toList());

        System.out.println("All Company Skills: " + allUniqueSkills);


        System.out.println("\n--- TERMINAL OPERATIONS ---");
        /*
         * TERMINAL OPERATIONS (Eager - they trigger the stream and return a final non-stream result)
         * Remember: We have to call .stream() every time because streams cannot be reused.
         */

        // 1. count(): Returns the number of elements
        long hrCount = employees.stream()
            .filter(emp -> emp.department().equals("HR"))
            .count();
        System.out.println("Total HR Employees: " + hrCount);

        // 2. anyMatch(): Returns true if ANY element matches
        boolean hasHighEarner = employees.stream()
            .anyMatch(emp -> emp.salary() > 90000);
        System.out.println("Anyone making over 90k? " + hasHighEarner);

        // 3. allMatch(): Returns true ONLY if ALL elements match
        boolean allMakeMinimumWage = employees.stream()
            .allMatch(emp -> emp.salary() >= 50000);
        System.out.println("Does everyone make at least 50k? " + allMakeMinimumWage);

        // 4. noneMatch(): Returns true if NO elements match
        boolean noExecutives = employees.stream()
            .noneMatch(emp -> emp.department().equals("Executive"));
        System.out.println("Are there zero executives? " + noExecutives);

        // 5. max() / min(): Finds the highest/lowest based on a comparator (Returns an Optional)
        employees.stream()
            .max(Comparator.comparingDouble(Employee::salary))
            .ifPresent(emp -> System.out.println("Highest earner: " + emp.name()));

        // 6. reduce(): Combines elements into a single value (e.g., Summing all salaries)
        double totalPayroll = employees.stream()
            .map(Employee::salary) // Convert to stream of doubles
            .reduce(0.0, Double::sum); // Start at 0.0, add them all up
        System.out.println("Total Monthly Payroll: $" + totalPayroll);

        // 7. findFirst() / findAny(): Grabs an element (Returns an Optional)
        employees.stream()
            .filter(emp -> emp.department().equals("Marketing"))
            .findFirst()
            .ifPresent(emp -> System.out.println("First Marketing person found: " + emp.name()));

        System.out.println("\n--- ADVANCED TERMINAL COLLECTION ---");
        // 8. Collectors.groupingBy(): Groups data into a Map (like SQL GROUP BY)
        Map<String, List<Employee>> employeesByDept = employees.stream()
            .collect(Collectors.groupingBy(Employee::department));
        
        System.out.println("Engineering Dept Roster: " + employeesByDept.get("Engineering"));
    }
}