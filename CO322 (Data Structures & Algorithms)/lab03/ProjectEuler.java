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

/**
 * test
 */
public class ProjectEuler {

    public static void main(String[] args) {
       
    String[] names;
    ArrayList<String> listOfNames;
  //scanner creation.
        Scanner scan = new Scanner(System.in);

        int count = scan.nextInt();

        names= new String[count];

       
        for (int index = 0; index < names.length; index++) {

            String name = scan.next();
            names[index] = name;
        }

        //sort it using alphabet and convert to an array list
        Arrays.sort(names);
        listOfNames = new ArrayList<String>(Arrays.asList(names));


      
        int queries = scan.nextInt();

        //loop runs until each name is scored.
        while (queries-- > 0) {

            //name is grabbed and scoring method is called.
            String whoScore = scan.next();
            System.out.println(calculateNameScore(whoScore,listOfNames));
        }
    }

    
    public static int calculateNameScore( String givenName, ArrayList<String> listOfNames) {

        char[] ALPHABET_ENG = "abcdefghijklmnopqrstuvwxyz".toCharArray();


        int nameScore = 0;


        char[] nameScoringArray = givenName.toCharArray();
        int indexOfName = listOfNames.indexOf(givenName) + 1;

       
        for (int index = 0; index < nameScoringArray.length; index++) {
            nameScore += findCharacter(ALPHABET_ENG, Character.toLowerCase(nameScoringArray[index])) + 1;
        }

   
        return nameScore * indexOfName;
    }

   
    public static int findCharacter(char[] array, char character) {

      
        for (int index = 0; index < array.length; index++)
            if (character == array[index]) { return index; }
        return -1;
    }
}