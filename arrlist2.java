//find container with most water stored using brute force O(n2) and optimised method of two pointer O(n)

import java.util.ArrayList;

public class arrlist2 {
    public static int maxWaterStored(ArrayList<Integer>height){
        //brute force O(n2)
        int maxWater=0;
        for(int i=0;i<height.size();i++){
            for(int j=i+1;j<height.size();j++){
                int ht=Math.min(height.get(i),height.get(j));
                int width=j-i;
                int currWater=ht*width;
                maxWater=Math.max(currWater,maxWater);
            }
        }
    return maxWater;
    }
    public static int optimisedmethod(ArrayList<Integer>height){
        int lp=0;
        int rp=height.size()-1;
        int maxWater=0;
        while(lp<rp){
            //calculating area of water
            int ht=Math.min(height.get(lp),height.get(rp));
            int width=rp-lp;
            int currWater=ht*width;
            maxWater=Math.max(currWater,maxWater);
            //updating pointers
            if(height.get(lp)<=height.get(rp)){
                lp++;
            }
            else{
                rp--;
            }
        }
    return maxWater;
    }
    public static void main(String[] args) {
        ArrayList<Integer>height=new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        // System.out.print(maxWaterStored(height));
        System.out.println(optimisedmethod(height));


    }
    
}
