//CHOCOLA PROBLEM
import java.util.*;

public class greedyalgo8 {
    public static void main(String[] args) {
        int n=4;
        int m=6;
        Integer costVer[]={2,1,3,1,4};
        Integer costHor[]={4,1,2};
        //sort in desc order
        Arrays.sort(costVer,Collections.reverseOrder());
        Arrays.sort(costHor,Collections.reverseOrder());
        //initialise the pointers
        int h=0,v=0;
        int hp=1,vp=1;
        int cost=0;
        while( h<costHor.length && v<costVer.length  ){
            if(costHor[h]<costVer[v]){//Ver is expensive
                cost+=hp*costVer[v];
                vp++;
                v++;
               
            }
            else{
                cost+=vp*costHor[h];
                hp++;
                h++;
            }
            
        }
        //for remaining pieces
        while(v<costVer.length){
            cost+=hp*costVer[v];
            v++;
            vp++;
            
        }
        while(h<costHor.length){
            cost+=vp*costHor[h];
            h++;
            hp++;
        }
        System.out.println("Total Minimum cost for cutting of peices is : "+cost);   
    }
}
