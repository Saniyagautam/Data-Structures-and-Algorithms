//Calculate the max activities performed by a person ( only 1 act at 1 time)
//WHEN END LIST IS NOT SORTED

import java.util.*;

public class greedyalgo2 {
    public static void main(String[] args) {
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,8,9};

        //creating a 2d arr to store i,start,end
        int Activity[][]=new int [start.length][3];
        for(int i=0;i<start.length;i++){
            Activity[i][0]=i;
            Activity[i][1]=start[i];
            Activity[i][2]=end[i];
        }
        //sort the 2d array
        Arrays.sort(Activity,Comparator.comparingDouble(o->o[2]));

        int maxAct=0;
        ArrayList<Integer>ans=new ArrayList<>();
        //1st act will always be 0th 
        maxAct=1;
        ans.add(Activity[0][0]);
        int lastEnd=Activity[0][2];
        for(int i=0;i<end.length;i++){
            if(start[i]>=lastEnd){//Not overlapping or Disjoint
                maxAct++;
                ans.add(Activity[i][0]);
                lastEnd=Activity[i][2];
            }
        }
    System.out.println("Maximum activities performed are: "+maxAct);
    for(int j=0;j<ans.size();j++){
        System.out.print("A"+ans.get(j)+" ");
    }}
}
