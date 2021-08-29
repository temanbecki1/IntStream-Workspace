import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args) {


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

        
    }
    
}
