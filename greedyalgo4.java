//Min Absolute pairs
import java.util.Arrays;

public class greedyalgo4 {
    public static void main(String[] args) {
        int A[]={4,1,8,7};
        int B[]={2,3,6,5};
        //sort both the arr
        Arrays.sort(A);
        Arrays.sort(B);
        int minDiff=0;
        //find diff
        for(int i=0;i<A.length;i++){
            minDiff+=Math.abs(A[i]-B[i]);
        }
    System.out.println("Minimum Difference of pairs is : "+minDiff);
    }
}
