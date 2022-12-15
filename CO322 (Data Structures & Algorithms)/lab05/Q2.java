
import java.util.*;


public class Q2
{  
    
    
    
    
    public static void main(String[] args) {
        
       
        int n =10;
        // int[] key_arrays = new int[n];
        LinkedList[] nodes = new LinkedList[n];
        HashMap<Integer,LinkedList> mapToLinkedList = new HashMap<>();
        
       
        KeyItem[] key_items = new KeyItem[6];
        key_items[0] = new KeyItem(33, "a");
        key_items[1] = new KeyItem(20, "b");
        key_items[2] = new KeyItem(11, "c");
        key_items[3] = new KeyItem(40, "d");
        key_items[4] = new KeyItem(23, "e");
        key_items[5] = new KeyItem(16, "f");


       for (KeyItem keyItem : key_items) {
            int func1 = keyItem.getKey() % n;
            if(mapToLinkedList.get(func1)==null){
                mapToLinkedList.put(func1,nodes[func1]);
                nodes[func1] = new LinkedList<Integer>();
            }
            (nodes[func1]).add(keyItem.getKey()); 
        }


        System.out.println("Success");


         
        }
    
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