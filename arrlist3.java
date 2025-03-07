//Pairsum1 given a sorted arr list return the pair having sum equals to target value 
import java.util.ArrayList;

public class arrlist3 {
    public static boolean pairsum1( ArrayList<Integer>list,int target){
        //Brute force O(n2)
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i)+list.get(j)==target){
                    return true;
                }
            }
        }
    return false;
    }
    public static boolean optimisedMethod(ArrayList<Integer>list,int target){
        int lp=0;
        int rp=list.size()-1;
        while(lp<rp){
            if((list.get(lp)+list.get(rp))==target){
                return true;
            }
            if((list.get(lp)+list.get(rp))<target){
                lp++;
            }
            else{
                rp--;
            }
        }
    return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer>list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target=5;
        System.out.println(optimisedMethod(list, target));

    }
    
}
