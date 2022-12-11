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
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    public static int activityNotifications(List<Integer> expenditure, int d) {
    // Write your code here
        int notificationCount =0;
            for (int i = 0; i < expenditure.size()-d ; i++) {
                int[] arr =new int[d] ; 
                for (int j = 0; j < d; j++) {
                    arr[j] = expenditure.get(i+j);
                }
                Arrays.sort(arr);
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[j]);
                }
                System.out.println("");
                double mid ;
                
                if(d%2==1){
                    mid = arr[d/2];
                }else{
                    mid = (arr[d/2]+arr[d/2-1])/2.0;
                }

                
                if(expenditure.get(d)>=(2*mid)){
                    notificationCount++;
                }

            }
            
        return notificationCount;
            

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}