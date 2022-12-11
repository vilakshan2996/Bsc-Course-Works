import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'lilysHomework' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */



     //method to find the total number of swaps to sort the array
    public static int totalSwaps(List<Integer> arr , List<Integer> sort_arr){       
        int swap =0;
        for (int i = 0; i < sort_arr.size(); i++) {
            int index = arr.indexOf(sort_arr.get(i));
            if(index!=i ){     // if the index of value in a sorted array and it's index on input array is not equal
                Collections.swap(arr, i, index);
                swap++;
            }

        }
        return swap;

    }

    public static int lilysHomework(List<Integer> arr) {
    // Write your code here
        List<Integer> arr_rev = new ArrayList<>(arr);
        Collections.reverse(arr_rev);   //reverse the array

        List<Integer> sort_arr = new ArrayList<>(arr);      
    
        Collections.sort(sort_arr);       //sort an array

        int swap_reverse = totalSwaps(arr_rev, sort_arr);
        int swap = totalSwaps(arr, sort_arr);

        if(swap<swap_reverse){       
            return swap;
        }else{
            return swap_reverse;
        }



       
        
        

    }

}

public class LilysHomework {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
