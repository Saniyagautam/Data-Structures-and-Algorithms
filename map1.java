//Basic operation of map all operation O(1) TC
import java.util.*;
public class map1 {
    public static void main(String[] args) {
        HashMap<String,Integer>map=new HashMap<>();
        map.put("Chai",10);
        map.put("Burger",50);
        map.put("Coffee",40);
        map.put("Pizza",200);
        // System.out.println(map);
        // System.out.println(map.get("Chai"));
        // map.remove("Pizza");
        // System.out.println(map);
        // System.out.println(map.size());
        // System.out.println(map.isEmpty());
        // System.out.println(map.containsKey("Coffee"));
        //ITERATE IN HASHMAP
        Set<String>keys=map.keySet();
        System.out.println(keys);
        for(String k:keys){
            System.out.println("Key:"+k+" ,Value:"+map.get(k));
        }
    }

}
