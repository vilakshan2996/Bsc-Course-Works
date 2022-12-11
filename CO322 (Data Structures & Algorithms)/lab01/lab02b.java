import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner reader = new Scanner(System.in);
        int X = reader.nextInt();
        int N = reader.nextInt();
        int i=1;
        int count =0;

        //find maximum number which is possible (i-1)
        while (Math.pow(i,N)<=X) {
            i++;
        }
        if(Math.pow(i-1,N)==X){
            count++;
        }else{
            
            int Y = X-(int)Math.pow(i-1,N);
            System.out.println(Y);
            i=1;
            while (Math.pow(i,N)<=Y) {  
               i++;
        }
        if(Math.pow(i-1,N)==Y){
            count++;
            System.out.println(i-1);
        }
        
        }
        
        
    }
    