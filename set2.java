//set nd linkedhashset nd Treeset
import java.util.*;
public class set2 {
    public static void main(String[] args) {
        HashSet<String>set=new HashSet<>();
        set.add("noida");
        set.add("delhi");
        set.add("rajasthan");
        set.add("pune");
        System.out.println(set);

        LinkedHashSet<String>ls=new LinkedHashSet<>();
        ls.add("noida");
        ls.add("delhi");
        ls.add("rajasthan");
        ls.add("pune");
        //Ordered
        System.out.println(ls);

        TreeSet<String>ts=new TreeSet<>();
        ts.add("noida");
        ts.add("delhi");
        ts.add("rajasthan");
        ts.add("pune");
        //Sorted
        System.out.println(ts);

    }
}
