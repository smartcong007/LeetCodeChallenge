import java.util.Stack;

/**
 * Created by zhengcong on 2017/8/16.
 * description:给定一个包含{}[]()的字符串，请判断它是否是有效匹配：即括号必须成对出现且保证正确的嵌套
 */
public class ValidParentheses {

    //自己的实现
    public boolean isValid_mine(String s) {

        Stack<Character> stack = new Stack<Character>();
        char array[]=s.toCharArray();
        for(int i=0;i<array.length;i++){

            if(!stack.empty()){
                if(match(stack.peek(),array[i])){
                    stack.pop();
                    continue;
                }
            }
            stack.push(array[i]);
        }
        return stack.empty();

    }

    public boolean match(char f,char l){


        if(f=='(')
            return l==')';
        else if(f=='[')
            return l==']';
        else if(f=='{')
            return l=='}';
        else
            return false;
    }


    //NB的人的实现
    public boolean isValid_better(String s) {

        if (s.isEmpty()) return true;
        char[] chars = s.toCharArray();
        char[] stack = new char[chars.length + 1];
        stack[0] = '-';
        int p = 1;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            switch(c) {
                case '(':
                    stack[p++] = ')';
                    break;
                case '[':
                    stack[p++] = ']';
                    break;
                case '{':
                    stack[p++] = '}';
                    break;
                default:
                    if (stack[--p] != c) return false;
            }
        }
        return p == 1;

    }
}