package lxl.SortAndFind;

/**
 * Created by lanxiaoli on 2020/6/17.
 * 无序数组第k大的一个数
 * 使用快排实现
 */
public class Find_MaxK {
    public int sort(int[] num,int low,int high){
        int temp=num[low];
        if(num==null||num.length<=0){
            return 0;
        }
        while (low<high){
            while (num[high]<=temp&&high>low){//从后半部分开始扫描
               --high;
            }
            num[low]=num[high];
            while (num[low]>temp&&high>low){//从前半部分扫描
                ++low;
            }
            num[high]=num[low];
        }
        num[high]=temp;
        return high;
    }
    public void find_k(int k,int[] num,int low,int high){
        int k_temp=sort(num,low,high);
        if(k_temp==k-1){
            System.out.println("第"+k+"大的数字"+num[k_temp]);
        }else if(k_temp>k-1){
            find_k(k,num,low,k_temp-1);
        }else {
            find_k(k-k_temp,num,k_temp+1,high);
        }
    }
    public static void main(String[] args){
        int[] num={2,13,3,1,7,10,14,5};
        Find_MaxK k=new Find_MaxK();
        k.find_k(5,num,0,num.length-1);
    }

}
