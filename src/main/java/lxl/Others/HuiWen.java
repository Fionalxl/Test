package lxl.Others;

/**
 * Created by lanxiaoli on 2022/8/29.
 * 1、给定串s，返回其中一个最长回文串
 * 2、返回最长回文串长度
 */
public class HuiWen {
    // * 1、给定串s，返回其中一个最长回文串
    //动态规划
    public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }
            int maxLen = 1;
            int begin = 0;
            // dp[i][j] 表示 s[i..j] 是否是回文串
            boolean[][] dp = new boolean[len][len];
            // 初始化：所有长度为 1 的子串都是回文串
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }

            char[] charArray = s.toCharArray();
            // 递推开始
            // 先枚举子串长度
            for (int L = 2; L <= len; L++) {
                // 枚举左边界，左边界的上限设置可以宽松一些
                for (int i = 0; i < len; i++) {
                    // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                    int j = L + i - 1;
                    // 如果右边界越界，就可以退出当前循环
                    if (j >= len) {
                        break;
                    }

                    if (charArray[i] != charArray[j]) {
                        dp[i][j] = false;
                    } else {
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }

                    // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + maxLen);
        }
    //中心扩展法
    // * 1、给定串s，返回其中一个最长回文串
    public String longestPalindrome1(String s) {
            if (s == null || s.length() < 1){
                return "";
            }

            // 初始化最大回文子串的起点和终点
            int start = 0;
            int end   = 0;

            // 遍历每个位置，当做中心位
            for (int i = 0; i < s.length(); i++) {
                // 分别拿到奇数偶数的回文子串长度
                int len_odd = expandCenter(s,i,i);
                int len_even = expandCenter(s,i,i + 1);
                // 对比最大的长度
                int len = Math.max(len_odd,len_even);
                // 计算对应最大回文子串的起点和终点
                if (len > end - start){
                    start = i - (len - 1)/2;
                    end = i + len/2;
                }
            }
            // 注意：这里的end+1是因为 java自带的左闭右开的原因
            return s.substring(start,end + 1);
        }

    /**
     *
     * @param s             输入的字符串
     * @param left          起始的左边界
     * @param right         起始的右边界
     * @return              回文串的长度
     */
    private int expandCenter(String s,int left,int right){
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        // 跳出循环的时候恰好满足 s.charAt(left) ！= s.charAt(right)
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        // 回文串的长度是right-left+1-2 = right - left - 1
        return right - left - 1;
    }


        /**
         * 在字符串中间填充特殊符号，遍历char数组的每个元素，以遍历到的元素为中心，开始遍历它左右的元素是否相等。
         * @param s
         * @return
         */
        //2、求最长回文长度
        public static int getSubPalindromeStrMaxLength(String s){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("&");//当然给定的字符串不能包含有这个特殊填充字符，否则就bug了
            for (char a: s.toCharArray()) {
                stringBuilder.append(a);
                stringBuilder.append("&");
            }
            int maxLen = 0;
            char[] arr = stringBuilder.toString().toCharArray();
            for (int i = 0; i < arr.length; i++) {
                maxLen = Math.max(maxLen,getLefSymmetry(arr,i));
            }

            return maxLen;
        }

        /**
         * 获取基准元素位置=i，左边n个元素和右边n个元素都相同
         * @return
         */
        public static int getLefSymmetry(char[] arr,int i){
            int len = 0;
            for (int j = 0; j <=i &&j<(arr.length-i); j++) {
                if(arr[i-j] == arr[i+j]){
                    len++;
                }else {
                    break;
                }
            }
            //原字符串的长度=(i-1)/2,左边遍历，减去一个填充就是汇文的长度
            return len-1;
        }
        public static void main(String[] args) {
            String s = "abbbhhhh";
            System.out.println(getSubPalindromeStrMaxLength(s));
        }

        
}



