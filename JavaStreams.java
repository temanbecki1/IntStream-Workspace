import java.util.stream.IntStream;

public class JavaStreams {
    public static void main(String[] args) {


        //Integer Stream
        IntStream
            .range(1,10)                            //first number inclusive, last digit not included
            .forEach(System.out:: print);           //prints to console for each 
            System.out.println();



        
    }
    
}
