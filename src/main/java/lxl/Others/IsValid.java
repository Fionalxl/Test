package lxl.Others;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by lanxiaoli on 2022/7/19.
 * 有效的括号
 */
public class IsValid {
        public boolean isValid(String s) {
            int n = s.length();
            if (n % 2 == 1) {
                return false;
            }

            Map<Character, Character> pairs = new HashMap<Character, Character>() {{
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }};
            Deque<Character> stack = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (pairs.containsKey(ch)) {
                    if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            return stack.isEmpty();
        }
    private int isValid1(String s) {
            int n=s.length();
            int count=0;
            Deque<Character> stack = new LinkedList<>();
            if(n<2){
                return 0;
            }

            for(int i=0;i<n;i++)
            {
                char ch=s.charAt(i);
                if (ch==')') {
                    if (stack.isEmpty() || stack.peek() !='(') {
                        continue;
                    }
                    count++;
                    stack.pop();

                }
                else if(ch=='('){
                    stack.push(ch);
                }
            }
            return  count;

    }

    //给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
    //输入："()(()"，输出2
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);  //存的是下标
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }


    public static void main(String[] args){
            IsValid isValid=new IsValid();
            int count=isValid.isValid1(")()(())");
            System.out.println(count);
    }

    }
