import java.io.*;



public class Q3 {

    
    static int M = 1000000007;
    static char[] a;
  
    public static int shortPalindrome(String s) {
        // Write your code here
         a = s.toCharArray();
        int count = 0;
        for (int i = 97; i <= 122; i++) {
            count = (count + makeArray((char) i)) % M;
        }
        return count;
        }


    public static int makeArray(char yo) {

        int[] curr = new int[4];
        int[] ab = new int[26];


        for (int i = 0; i<a.length; i++) {

            char x = a[a.length-i-1];
            int previousone = curr[0];

            if (yo == x) {
                curr[3] = (curr[3] + curr[2]) % M;
                curr[0] = (1 + curr[0]) % M;
            }
            curr[2] = (curr[2] + ab[(int) x - 97]) % M;
            ab[(int) x - 97] = (ab[(int) x - 97] + previousone) % M;
            curr[1] = (curr[1] + previousone) % M;
        }
        return curr[3];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        int result = shortPalindrome(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
