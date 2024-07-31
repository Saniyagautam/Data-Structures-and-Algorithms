//fractional knapsack
import java.util.*;

public class greedyalgo3 {
    public static void main(String[] args) {
        int weight[]={10,20,30};
        int value[]={60,100,120};
        int w=50;//total capacity
        //creating a 2d arr
        double ratio[][]=new double[value.length][2];
        //0th for index and 1st for ratio
        for(int i=0;i<value.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=value[i]/(double)weight[i];
        }
        //asc order sorting
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));

        int capacity=w;//starting empty
        int result=0;
        for(int i=ratio.length-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            //add whole item
            if(capacity>=weight[idx]){
                result+=value[idx];
                capacity-=weight[idx];
            }
            //add fractional item 
            else{
                result+=(ratio[i][1]*capacity);
                capacity=0;
                break;
            }
        }
    System.out.println("Final Value is: "+result);
    }
}
