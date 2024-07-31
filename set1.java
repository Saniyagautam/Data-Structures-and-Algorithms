//Operations on Set
import java.util.HashSet;
import java.util.Iterator;
public class set1 {
    public static void main(String[] args) {
        HashSet<Integer>set=new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(1);
        set.add(2);
        // System.out.println(set);
        // if(set.contains(1)){
        //     System.out.println("Contains");
        // }
        // set.remove(1);
        // if(set.contains(1)){
        //     System.out.println("Contains");
        // }
        // System.out.println(set.isEmpty());
        Iterator itr=set.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        //advanced for loop
        for(Integer num:set){
            System.out.println(num);
        }
    }

}
