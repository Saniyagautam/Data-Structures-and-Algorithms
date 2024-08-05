//Merge Sort  O(nlogn)
public class sorting6{
    public static void mergeSort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        int mid=si+(ei-si)/2;
        //divide 
        mergeSort(arr, si, mid);//divide left
        mergeSort(arr, mid+1, ei);//divide right
        merge(arr,si,mid,ei);//merge left and right
    }
    public static void merge(int arr[],int si,int mid,int ei){
        //conquer
        int temp[]=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;
        //interate on left arr and right arr
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }
            else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        //for remaining elements of left arr
        while(i<=mid){
            temp[k]=arr[i];
            i++;
            k++;
        }
        //for remaining elements of right arr
        while(j<=ei){
            temp[k]=arr[j];
            j++;
            k++;
        }
        //copy temp arr to the org arr
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }

    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String args[]){
        int arr[]={9,8,7,6,5,4,3,1,2};
        mergeSort(arr,0,arr.length-1);
        printArr(arr);
    }

}

