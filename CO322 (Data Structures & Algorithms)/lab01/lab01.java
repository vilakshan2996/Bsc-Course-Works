/**
 * Simple sorting algorithms and their performance 
 * Reg: E/18/373
 *
 */

 import java.util.*;  

public class Sort {

    //create an array of given size and populate it with random data  
    static int [] create_rand_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = (int)(Math.random() * 100);
	return data; 
    }

    //create an array of given size and populate it with worst data arrangement 
    static int [] create_worst_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = data.length - i;
	return data; 
    }

    //create an array of given size and populate it with best data arrangement 
    static int [] create_best_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = i;
	return data; 
    }

    // function to swap. Would be useful since all need this 
    static void swap(int []d, int i, int j) { 
	int tmp = d[i]; 
	d[i] = d[j]; 
	d[j] = tmp;
    }

    // check if the soring worked on the array 
    static boolean isSorted(int [] data) {
	int i;
	for(i=1; i < data.length; i++)
	    if(data[i] < data[i-1]) break;
	return (i == data.length);
    }

    // If you want just display the array as well :) 
    static void display(int []data) { 
	System.out.println("=======");
	for(int i=0; i < data.length; i++) 
	    System.out.print(data[i] + "  "); 
	System.out.println("\n=======");
    }

    
    /**********************************************************
     *     Implementation of sorting algorithms               *
     *********************************************************/
    static void buble_sort(int [] data)  {
	    // Implement 
        long begin = System.currentTimeMillis();
        int n = data.length;
            for (int i = 0; i < n - 1; i++)
                for (int j = 0; j < n - i - 1; j++)
                    if (data[j] > data [j+ 1]) {
                        swap(data,j,j+1);
                    }
        long time = System.currentTimeMillis() - begin;
        System.out.println("For Bubble Sort Array is "+time);

       
        
    }

    static void selection_sort(int [] data) {
	// Implement 
        long begin = System.currentTimeMillis();
        int min_value, min_value_index=0;
        for (int i = 0; i < data.length; i++) {
            min_value = data[i];             //initially set the first element of unsorted array as minimum value
            min_value_index = i;             //store the index 
            for (int j = i+1; j < data.length; j++) {         //compare each element with other elements in the unsorted array
                if (data[j] < min_value) {       //if the element is less than the current minimum value
                    min_value = data[j];        
                    min_value_index = j;
                }
            }
            if (min_value < data[i]) {            //finally swap if the minimum value is less than the first element in unsorted array
                swap(data,i,min_value_index);
            }
        }
        long time = System.currentTimeMillis() - begin;
        System.out.println("For Selection Sort Array is "+time);
         
    }

    static void insertion_sort(int [] data) {
	// Implement
      long begin = System.currentTimeMillis();    //start the timer

        for(int i=1;i<data.length;i++){ 
            int current = data[i];         //store the value at the current index to the temperory variable
            int j= i-1;                    //compare the current value with stored data

            while(j>= 0  && data[j]>current){     //if compared data is greater than current value shift it to right
                data[j+1]=data[j];
                j--;
            }
            data[j+1]=current;     //finally place the current value at the empty index
        }
        
        long time = System.currentTimeMillis() - begin;    //find out the interval between the time
         System.out.println("For Insertion Sort Array is "+time);
        // display(data);
    }

		       
		
    
    
    

    public static void main(String [] args) {

    // create arrays of different size populate with data
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the size of the array: ");  
        int n= sc.nextInt();  

	

      System.out.println("Average Case");
      
      int [] rand_arr = create_rand_data(n);
      int [] temp = rand_arr;
      buble_sort(rand_arr);
      rand_arr = temp;
      selection_sort(rand_arr);
      rand_arr = temp;
      insertion_sort(rand_arr);
      
      System.out.println();
      System.out.println("Worst Case");
      rand_arr = create_worst_data(n);
      temp = rand_arr;
      buble_sort(rand_arr);
     rand_arr = temp;
      selection_sort(rand_arr); 
      rand_arr = temp;
      insertion_sort(rand_arr);


      System.out.println();


      System.out.println("Best Case");
      rand_arr = create_best_data(n);
      temp = rand_arr;
      buble_sort(rand_arr);
      rand_arr = temp;
      selection_sort(rand_arr);

      rand_arr = temp;
      insertion_sort(rand_arr);


      
    
	// measure the time taken by different algorithms to
	// sort the array.
	// Think about effects of caches, other apps running etc. 
    }
}