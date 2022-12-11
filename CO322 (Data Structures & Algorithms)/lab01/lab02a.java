import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();;
        ArrayList<Integer> grades = new ArrayList<>();
        ArrayList<Integer> newgrades = new ArrayList<>();
        for (int i = 0; i < n; i++) {
             grades.add(scan.nextInt());
        }
        for (int i = 0; i < n; i++) {
             int grade = grades.get(i);
             int round = grade+(5-(grade%5));
             if((grade%5)>=3 && round>=40)
                grade = round;
             newgrades.add(grade);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(newgrades.get(i));
        }
    }
}