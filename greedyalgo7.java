import java.util.*;


public class greedyalgo7 {
    //job class
    static class Jobs{
        int id;
        int profit;
        int deadline;
        public Jobs(int i,int d,int p){//constructor
            id=i;
            profit=p;
            deadline=d;
        }
    }
    public static void main(String[] args) {
        int jobInfo[][]={{4,20},{1,10},{1,40},{1,30}};//given
        //arraylist of job object
        ArrayList<Jobs>jobs=new ArrayList<>();
        //adding in arraylist
        for(int i=0;i<jobInfo.length;i++){
            jobs.add(new Jobs(i,jobInfo[i][0],jobInfo[i][1]));//creating new obj
        }
        //sort all obj in desc order
        Collections.sort(jobs,(obj1,obj2)->obj2.profit-obj1.profit);
        ArrayList<Integer>seq=new ArrayList<>();
        int time=0;
        for(int i=0;i<jobs.size();i++){
            Jobs curr=jobs.get(i);
            if(curr.deadline>time){
                seq.add(curr.id);
                time++;
            }
        }
    System.out.println("Maximum jobs : "+seq.size());
    for(int i=0;i<seq.size();i++){
        System.out.print(seq.get(i)+" ");
    }
    }
}
