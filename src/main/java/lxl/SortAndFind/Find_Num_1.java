package lxl.SortAndFind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lanxiaoli on 2020/6/18.
 * 找出数组中只出现了一次的数字
 */
public class Find_Num_1 {
    //重复数个数是偶数个没啥问题，为奇数就有问题了，本方法不合适
    public static Set<Integer> find_Num_1(int[] array){
        Set<Integer> set=new HashSet<>();
        if(array==null||array.length==0) return null;
        for(int i:array){
            if(!set.add(i)){//添加不成功返回false，前加上！运算符变为true
                set.remove(i);//移除集合中与这个要添加的数重复的元素
            }
        }
        if(set.size()==0){
            return null;
        }
        return set;
//                set.toArray(new Integer[set.size()])[0];//输出第一个出现了一次的数字
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
                // hashSet.add(array[i]);
            }
        }

        return 0;


    }
    private static Integer find_Num_3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= arr.length; j++) {
                //注意循环结束的条件，实际运行时j不会超出数组范围
                if (i == j)
                    continue;
                if (j == arr.length)
                    //因为这里的判断，让代码运行时在超出范围前就结束了循环
                    return arr[i];
                if (arr[i] == arr[j])
                    break;
            }
        }
        return null;//找不到则返回null
    }

    private static Integer find_num_3(int[] arr){
        int single=0;
        for(int nums:arr){
            single^=nums;
        }
        return single;
    }
    public static void main(String[] args){
        int[] array={3,2,4,2,4,1,3,1,5};
//        int a=find_Num_3(array);
        Set<Integer> set=new HashSet<>();
        set=find_Num_1(array);
        System.out.println(set);
        System.out.println(find_num_3(array));
    }

}
