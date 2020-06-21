package lxl.SortAndFind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lanxiaoli on 2020/6/18.
 * 找出数组中只出现了一次的数字
 */
public class Find_Num_1 {
    public static int find_Num_1(int[] array){
        Set<Integer> set=new HashSet<>();
        if(array==null||array.length==0) return 0;
        for(int i:array){
            if(!set.add(i)){
                set.remove(i);
            }
        }
        if(set.size()==0){
            return 0;
        }
        return set.toArray(new Integer[set.size()])[0];
    }
    public static int find_Num_2(int[] array){
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        if(array==null||array.length==0) return 0;
        for(int i=0;i<array.length;i++){
            if(hashMap.containsKey(array[i])){
                int count=hashMap.get(array[i]);
                hashMap.put(array[i],++count);
            }
            else {
                hashMap.put(array[i],1);
            }
        }
        for(int i=0;i<hashMap.size();i++){
            if(hashMap.get(array[i])==1){
                return array[i];
            }
        }
        return 0;


    }
    public static void main(String[] args){
        int[] array={3,2,2,4,2,1,3,1};
        int a=find_Num_2(array);
        System.out.println(a);
    }

}
