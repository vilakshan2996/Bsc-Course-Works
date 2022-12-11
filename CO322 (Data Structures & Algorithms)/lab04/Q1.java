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


public class Q1 {
    public static int beautifulPairs(List<Integer> A, List<Integer> B) {
        // Write your code here
            int maxPairwiseDisjoint = 0;
            List<Integer> temp = new ArrayList<Integer>(A);
    
            for (Integer item : temp) {
                if (A.contains(item) && B.contains(item)) {
                    A.remove(item);
                    B.remove(item);
                    maxPairwiseDisjoint++;
                }
            }
    
            if (A.size() >= 1 && B.size() >= 1) {
                maxPairwiseDisjoint++;
            } else if (maxPairwiseDisjoint == temp.size()) {
                maxPairwiseDisjoint--;
            }
    
            return maxPairwiseDisjoint;
    
        }

        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
    
            List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
    
            int result = beautifulPairs(A, B);
    
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
    
            bufferedReader.close();
            bufferedWriter.close();
        }
    
}
