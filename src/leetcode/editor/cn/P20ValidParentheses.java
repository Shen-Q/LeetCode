//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 2082 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：有效的括号
public class P20ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if(s.length()%2==1){ //首先待测括号组合的必须是偶数
            return false;
        }
        Stack<Character> stack = new Stack<>();
       // Deque<Character> stack = new LinkedList<Character>(); LinkedList里面也实现了栈的方法
       // 因为Java 中的 Deuqe，即 “double ended queue” 的缩写，是 Java 中的双端队列集合类型。
       // Deque 具备普通队列 FIFO 的功能，同时它也具备了 Stack 的 LIFO 功能，并且保留了 push 和 pop 函数，
        Map<Character,Character> map = new HashMap<>(){
            {put(')','(');//前key 后value
             put(']','[');
             put('}','{');
            }
        };

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                if(stack.isEmpty()||stack.peek() != map.get(ch)){
                    return false;
                }
                stack.pop();
            }
            else
                stack.push(ch);
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}