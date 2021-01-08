//给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 752 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Java：合并区间
public class P56MergeIntervals{
    public static void main(String[] args) {
        Solution solution = new P56MergeIntervals().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] int1, int[] int2){
                return int1[0]-int2[0];
            }
        });//这个叫什么来着？方法重载？xx表达式？
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<intervals.length;++i){//为什么是++i而不是i++,虽然i++运行结果更好。i++ 先自增，然后返回自增之前的值；++i 先自增，然后返回自增之后的值；在Java中，i++语句是需要一个临时变量去存储返回自增前的值，而++i不需要。这样就导致使用i++时系统需要先申请一段内存空间，然后将值塞入进去，最后不用了才去释放。
            int L=intervals[i][0];
            int R=intervals[i][1];
            if(list.size()==0||list.get(list.size()-1)[1]<L){//L才是最新数组，list.get(list.size()-1)返回list中存入的最后一个数组
                list.add(new int[]{L,R});
            }
            else{
                list.get(list.size()-1)[1]=Math.max(list.get(list.size()-1)[1],R);
            }
        }
        return list.toArray(new int[list.size()][2]);//ArrayList如何转变为二维数组？

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}