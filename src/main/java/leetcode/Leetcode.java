package leetcode;

import com.test.mytest.utils.BetterMapUtils;
import com.test.mytest.utils.MapUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther yfd
 * @Date 2020-08-05 21:13
 */
public class Leetcode {


    public static void main(String[] args) {
        int[]a = {1,5,9,11,15};
        int[] ints = twoSum(a, 10);
        for (int i:ints
             ) {
        System.out.println(i);

        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[]result = new int[2];
        for (int i = 0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0] = map.get(target-nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }



    /**
     * 6. Z 字形变换
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     * 示例 1:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * 示例 2:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     *
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }

        int len = Math.min(s.length(), numRows);
        //1.定义数组长度
        String  row[] = new String[len];
        //初始化数组
        for (int i = 0; i < len; i++) row[i] = "";
        //行数
        int loc = 0;
        boolean down = false;

        for (int i = 0; i < s.length();i++){
            row[loc] += s.substring(i, i + 1);
            if(loc == 0 || loc == numRows-1){
                down = !down;
            }
            loc += down?1:-1;
        }

        String result = "";
        for (String r : row){
            result+=r;
        }
        return result;
    }

    //1111111
}
