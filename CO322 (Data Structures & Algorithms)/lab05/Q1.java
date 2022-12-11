
import java.util.*;


public class Q1
{  
    
    public static void main(String[] args) {
       
        int n =10;
        int[] key_arrays = new int[n];
        for (int i = 0; i < key_arrays.length; i++) {
            key_arrays[i]=-1;
        }

        KeyItem[] key_items = new KeyItem[6];
        key_items[0] = new KeyItem(33, "a");
        key_items[1] = new KeyItem(20, "b");
        key_items[2] = new KeyItem(11, "c");
        key_items[3] = new KeyItem(40, "d");
        key_items[4] = new KeyItem(23, "e");
        key_items[5] = new KeyItem(16, "f");

        for (KeyItem keyItem : key_items) {
            int func1 = keyItem.getKey() % n;
            if(key_arrays[func1]==-1){
                key_arrays[func1] =keyItem.getKey();


            }else{
                int i=1;
                int func2;

                do {
                    func2 = i*(1+keyItem.getKey()%(n-1));
                    i=i+1;   
                } while (key_arrays[func2]!=-1);
                
                key_arrays[func2] =keyItem.getKey();

                
            }

            System.out.println(Arrays.toString(key_arrays));

            
        }  
        // scan.close();
    }


    
    

}

class KeyItem{
    int key;
    String value;

    KeyItem(int key,String value){
        this.key = key;
        this.value = value;

    }

    int getKey(){
        return key;
    }
}