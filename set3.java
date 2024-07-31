//count distinct elements in arr 
import java.util.*;
public class set3 {
    public static void main(String[] args) {
        int arr[]={1,1,1,1,2,3,4,4,3,2,1};
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        System.out.println("Distinct elements are : " +set.size());
    }
}
