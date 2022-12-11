// import java.io.*;
// import java.math.*;
// import java.security.*;
// import java.text.*;
// import java.util.*;
// import java.util.concurrent.*;
// import java.util.function.*;
// import java.util.regex.*;
// import java.util.stream.*;
// import static java.util.stream.Collectors.joining;
// import static java.util.stream.Collectors.toList;

// class Result {

//     /*
//      * Complete the 'caesarCipher' function below.
//      *
//      * The function is expected to return a STRING.
//      * The function accepts following parameters:
//      *  1. STRING s
//      *  2. INTEGER k
//      */

//     public static String caesarCipher(String s, int k) {
//         //Without initilzing character array it is easier to create a String builder
//         StringBuilder modified = new StringBuilder();
//         char[] chars = s.toCharArray();
//         for (int i = 0; i < chars.length; i++) {
//             char e = chars[i];   //get each element from the input string
            
//             //Use ascii code to do the encryption
//             if (e>= 'A' && e <= 'Z'){
//                 modified.append((char)((e-'A'+k)%26+'A'));     
//             }
                
//             else if (e >= 'a' && e <= 'z'){
//                 modified.append((char)((e-'a'+k)%26+'a'));
//             }
                
//             else{
//                 modified.append(e);
//             }
//         }
//         return modified.toString();
        
    

//     }

// }

// public class CaesarCipher {
//     public static void main(String[] args) throws IOException {
//         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//         int n = Integer.parseInt(bufferedReader.readLine().trim());

//         String s = bufferedReader.readLine();

//         int k = Integer.parseInt(bufferedReader.readLine().trim());

//         String result = Result.caesarCipher(s, k);

//         bufferedWriter.write(result);
//         bufferedWriter.newLine();

//         bufferedReader.close();
//         bufferedWriter.close();
//     }
// }
