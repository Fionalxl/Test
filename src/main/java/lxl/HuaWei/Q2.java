package lxl.HuaWei;
import java.util.LinkedList;


/**
 * Created by lanxiaoli on 2022/7/30.
 * 优先队列实现，优先级高的先输出，找到一个数，先比较后续优先级大于当前元素的数值，当前元素插入队尾
 * 输入9，3，5
 * 输出0，2，1
 * 输入1，2，2
 * 输出2，0，1
 */
public class Q2 {
    public static void main(String[] args) {
        String str = "1,2,2";
        LinkedList<PriorityNum> list = new LinkedList<>();
        String[] arr = str.split(",");
        for (int i = 0; i < arr.length; i++) {
            list.add(new PriorityNum(Integer.parseInt(arr[i]), i));
        }
        int[] index = new int[arr.length];
        int maxPriority = -1;
        StringBuilder sb = new StringBuilder();
        PriorityNum temp;
        PriorityNum first;
        int count = 0;
        while (list.size() > 0) {
            if (maxPriority == -1) {   //遍历队列，找优先级最大的
                int size = list.size();
                while (size > 0) {
                    temp = list.removeFirst();
                    maxPriority = Math.max(maxPriority, temp.num);
                    list.addLast(temp);
                    size--;
                }
            }
            first = list.removeFirst();
            // 如果当前元素是最大优先级，则输出
            if (maxPriority == first.num) {
                index[first.index] = count++;
                maxPriority = -1;
                continue;
            }
            while (list.size() > 0) {
                temp = list.removeFirst();
                if (temp.num > first.num) {
                    list.addLast(first);
                    maxPriority = maxPriority == temp.num ? -1 : maxPriority;
                    first = temp;
                    break;
                } else {
                    list.addLast(first);
                    first = temp;
                }
            }
            index[first.index] = count++;
        }
        for (int value : index) {
            sb.append(value).append(",");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }

    static class PriorityNum {
        public int num;
        public int index;

        public PriorityNum(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }



}
