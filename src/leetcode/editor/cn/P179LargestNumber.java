//给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 446 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//Java：最大数
public class P179LargestNumber{
    public static void main(String[] args) {
        Solution solution = new P179LargestNumber().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            s[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(s,new LargeNumberComparator());//实现comparator接口 重载compare方法
                                                    // 目的是给sort重新定义比较方法

        if(s[0].equals("0")){
            return "0";
        }
        String r = new String();
        for (String str:s) {
            r=r+str;
        }
        return r;

    }
    private class LargeNumberComparator implements Comparator<String>{

        @Override
        public int compare(String s, String t1) {
            String a = s + t1;
            String b = t1 + s;
            return b.compareTo(a); //这里必须是b.compareTo(a) 不能是a.compareTo(b)，
            //因为compare（int o1, int o2）方法 return o1 - o2 是升序，return o2 - o1 是降序
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}