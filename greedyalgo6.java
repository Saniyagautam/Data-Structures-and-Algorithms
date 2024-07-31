//count tatal min count
import java.util.*;

public class greedyalgo6 {
    public static void main(String[] args) {
        Integer coins[]={1,2,5,10,20,50,100,500,2000};
        //sort in asc order
        Arrays.sort(coins,Comparator.reverseOrder());

        int countofcoins=0;
        int amt=590;
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<coins.length;i++){
            if(coins[i]<=amt){
                while(coins[i]<=amt){
                    countofcoins++;
                    ans.add(coins[i]);
                    amt-=coins[i];
                }
            }
        }
        System.out.println("Total minimum coins required are: "+countofcoins);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }


    }
}
