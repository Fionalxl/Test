package lxl.SortAndFind;

/**
 * Created by lanxiaoli on 2020/6/17.
 * 快排
 */
public class Quick_Sort {
    public static  void quickSort(int[] num,int left,int right){
        int low = left;
        int high = right;
        int key=num[left];
        if (left >= right){
            return;
        }
        while (low<high){
            while (num[high]>=key&&high>low){
                high--;
            }
            while (num[low]<key&&high>low){
                low++;
            }
            if(low<high){
                int temp=num[low];
                num[low]=num[high];
                num[high]=temp;
            }
        }
        num[left]=num[low];
        num[low]=key;
        quickSort(num,left,low-1);
        quickSort(num,low+1,right);
    }
   public static void main(String[] args){
        int[] num={1,12,2,23,34,13,4,5,3};
        quickSort(num,0,num.length-1);
        for(int i=0;i<num.length-1;i++){
            System.out.println(num[i]+" ");
        }
   }

}
