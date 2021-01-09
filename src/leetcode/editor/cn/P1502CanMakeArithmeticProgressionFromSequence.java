//给你一个数字数组 arr 。 
//
// 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。 
//
// 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,5,1]
//输出：true
//解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
// 
//
// 示例 2： 
//
// 输入：arr = [1,2,4]
//输出：false
//解释：无法通过重新排序得到等差数列。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 1000 
// -10^6 <= arr[i] <= 10^6 
// 
// Related Topics 排序 数组 
// 👍 8 👎 0

package leetcode.editor.cn;
//Java：判断能否形成等差数列
public class P1502CanMakeArithmeticProgressionFromSequence{
    public static void main(String[] args) {
        Solution solution = new P1502CanMakeArithmeticProgressionFromSequence().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        //试试自己写个冒泡排序吧。。。最大的冒到最后。
        int len=arr.length-1;
        for(int j=0;j<len;j++){ //巧妙地使用len-j，免去了for(int j=len;j>0;j--)和i<j，看起来怪别扭的
            for(int i=0;i<len-j;i++){ //i<len 即 i < arr.length-1  即 i最大=arr.length-2
                if(arr[i]>arr[i+1]){
                    int temp = arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i]=temp;
                }
            }
        }
        for(int i=1;i<len;i++){
            if(arr[i]-arr[i-1]!=arr[i+1]-arr[i]){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}