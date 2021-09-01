import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args) throws IOException {


        //Integer Stream
        IntStream
            .range(1,10)                            //first number inclusive, last digit not included
            .forEach(System.out:: print);           //prints to console for each 
            System.out.println();


        IntStream
            .range(1,10)                            //range of 1-9
            .skip(5)                                //skips first 5 elements of stream
            .forEach(x -> System.out.println(x));   //lambda expression to print the elements pass in (x) basically parameter passed in
            System.out.println();

        System.out.println(                         //places inside println statement
            IntStream                               
            .range(1,5)                             //sum range 1-5, excluding 5 
            .sum()                                  //adds elements in the range together
        );

        System.out.println();


        //Stream.of, sorted and findFirst
        Stream.of("Teman", "Nyheim", "Sceaira")
            .sorted()                               //can sort, reverse sort, pass in own argument to search for
            .findFirst()                            // find first item in list
            .ifPresent(System.out::println);        //prints out the element found

        System.out.println();

        //Stream of Array, sort, filter and print
        String[] names = {"Nylah", "Nyasia", "Teman", "Nya", "Sceaira", "Nyheim"};              //Array of names
        Arrays.stream(names)                        //same as Stream.of(names)
            .filter(x -> x.startsWith("N"))         //filters for names starting with N
            .sorted()                               //sorts the filtered names
            .forEach(System.out::println);          //prints to screen


        //Average of squares of an int array
        Arrays.stream(new int[] {2, 4, 5, 8, 10})                                               //Array of ints
            .map(x -> x * x)                            //this maps each (x) int to its square
            .average()                                  //averages all elements including last because no range used
            .ifPresent(System.out::println);            //if present, prints to screen (in double form)


        //Stream from List, filter and print
        List<String> people = Arrays.asList("Nylah", "Nyasia", "Teman", "Nya", "Sceaira", "Nyheim");
        people
            .stream()                                   //streams the list of people
            .map(String::toLowerCase)                   //maps them to all lowercase
            .filter(x -> x.startsWith("n"))             //filters for people names starting with n
            .forEach(System.out::println);              //prints to screen
            System.out.println();


        //Stream rows from text file, sort, filter, and print
        Stream<String> sports = Files.lines(Paths.get("sports.txt"));
        sports
            .sorted()                                   //sorts
            .filter(x -> x.length() > 7)                //filters items , will show items with more than 7 characters
            .forEach(System.out::println);              //prints to screen
            sports.close();                             //closes file resource to prevent memory leaks
            System.out.println();


        List<String> sports2 = Files.lines(Paths.get("sports.txt"))
            .filter(x -> x.contains("ing"))             //filters and retrieves elements containing ing
            .sorted()                                   //sorts filtered items
            .collect(Collectors.toList());              //adds filtered items to collector as list

        sports2.forEach(x -> System.out.println(x));    //prints to screen results


        // //Stream rows from CSV file and count
        // Stream<String> rows = Files.lines(Paths.get("data.txt"));
        // int rowCount = (int)rows                        //creates variable rowCount to track amount of rows 
        //     .map(x -> x.split(","))                     //splits the row into an array separated by commas
        //     .filter(x -> x.length == 3)                 //filters elements to ensure at least 3 elements in row
        //     .count();                                   //counts rows
        // System.out.println(rowCount + " rows.");        //prints amount of rows with 3 elements to screen
        // rows.close();                                   //closes data.txt file to prevent memory leaks



        // //Stream rows from CSV file, parse data from rows
        // Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
        // rows1
        //     .map(x -> x.split(","))                     //split the row into an array seperated by commas
        //     .filter(x -> x.length == 3)                //filters elementsto ensure at least 3 elements in a row
        //     //.filter(x -> Integer.parseInt(x[1]) > 12)   //convert the second index to an integer , then only shows if it is greater than 15
        //     .forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));          //prints to screen
        //     rows1.close();                              //closes data.txt file to prevent memory leaks




        // //Strea rows from CSV file, store fields in HashMap
        // Stream<String> rows2 = Files.lines(Paths.get("data.txt"));
        // Map<String, Integer> map = new HashMap<>();
        // map = rows2
        //     .map(x -> x.split(","))
        //    // .filter(x -> x.length ==3)
        //   //  .filter(x -> Integer.parseInt(x[1]) > 15)
        //     .collect(Collectors.toMap(
        //         x -> x[0],
        //         x -> Integer.parseInt(x[1])
        //     ));
        // rows2.close();

        // for (String key: map.keySet()){
        //     System.out.println(key + " " + map.get(key));
        // }

        //Reduction - sum
        double total = Stream.of(7.2, 1.6, 4.8)                 //
            .reduce(0.0,(Double a, Double b) -> a + b );        //0.0 is starting value, then we pass in two doubles, where a is running total and b is new item
            System.out.println("Total = " + total);             //prints to screen

        

        //reduction - summary statistics only works for integers
        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)     //takes summary stats of stream of ints
            .summaryStatistics();                                                
            System.out.println(summary);                        //prints to screen count, sum, min, max and average of values



        

        
        
            
            
    }
    
}
