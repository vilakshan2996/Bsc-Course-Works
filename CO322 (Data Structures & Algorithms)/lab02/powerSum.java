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
    static int res = 0;

    /*
     * Complete the 'powerSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER X
     *  2. INTEGER N
     */

    //helper is a recursive function
    public static int helper(int total, int pow, int currentNumber) {
        
        int value = total - (int)Math.pow(currentNumber,pow);   
        //if the value is equal to 0, that means there is a sum of combination which is equal to the total
        if(value==0){       
            return 1;
        }
        //if the value is less than 0. The combination fails
        else if(value<0){
            return 0;         
        }
        //Other wise keep moving to next number
        else{
            //first element means that keep the value of the current Number an do the next number.
            //second element means neglects the current number summation and go to the next number.
            // It's like a spanning tree
            return helper(value,pow,currentNumber+1)+ helper(total,pow,currentNumber+1);    
        }
        
    }
    
    public static int powerSum(int X, int N)
        // Write your code here
    {
        //Start with the number 1
        return helper(X,N,1);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = Integer.parseInt(bufferedReader.readLine().trim());

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        int result = 0;
        result = Result.powerSum(X,N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}