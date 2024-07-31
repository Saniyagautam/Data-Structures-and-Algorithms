//Calculate the max activities performed by a person ( only 1 act at 1 time)

import java.util.ArrayList;

public class greedyalgo1 {
    public static void main(String[] args) {
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,8,9};
        int maxAct=0;
        ArrayList<Integer>ans=new ArrayList<>();
        //1st act will always be 0th 
        maxAct=1;
        ans.add(0);
        int lastEnd=end[0];
        for(int i=0;i<end.length;i++){
            if(start[i]>=lastEnd){//Not overlapping or Disjoint
                maxAct++;
                ans.add(i);
                lastEnd=end[i];
            }
        }
    System.out.println("Maximum activities performed are: "+maxAct);
    for(int j=0;j<ans.size();j++){
        System.out.print("A"+ans.get(j)+" ");
    }}
}
