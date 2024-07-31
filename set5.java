//Find Iternary
import java.util.*;
public class set5 {
    public static String getStart(HashMap<String,String>tickets){
        HashMap<String,String>revMap=new HashMap<>();
        //copy rev hashmap <to,from>
        for(String key:tickets.keySet()){
            revMap.put(tickets.get(key),key);
        }
        //check which key is in map1 but not in map2 that will be the start point 
        for(String key:tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        //map1 <from,to>
        HashMap<String,String>tickets=new HashMap<>();
        // tickets.put("Chennai","Bengaluru");
        // tickets.put("Mumbai","Delhi");
        // tickets.put("Goa","Chennai");
        // tickets.put("Delhi","Goa");
        tickets.put("MUC","LHR");
        tickets.put("JFK","MUC");
        tickets.put("SFO","SJC");
        tickets.put("LHR","SFO");

        String start=getStart(tickets);
        System.out.print(start);
        for(String key:tickets.keySet()){
            System.out.print("->"+tickets.get(start));
            start=tickets.get(start);
        }
    }
}
