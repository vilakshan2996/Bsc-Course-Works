import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
    // Write your code here
        List<Integer> tuple= new ArrayList<>();  //create a arraty list to store tuples
        Collections.sort(arr);     

        int min = arr.get(1)-arr.get(0);    //initialize a min variable with first two elements
        tuple.add(arr.get(0));
        tuple.add(arr.get(1));

        for (int i = 2; i < arr.size()-1; i++) {
            int a = arr.get(i);
            int b = arr.get(i+1);

            if((b-a)<min){          //if the differemce is less than the previous minimum value stored
                min = b-a;
                tuple.clear();
                tuple.add(a);
                tuple.add(b);
                continue;
            }

            if((b-a)==min){         //if the minimum value is equal to the difference
                tuple.add(a);
                tuple.add(b);
            }
            
        }
        return tuple;

    }

}

public class ClosestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.closestNumbers(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
