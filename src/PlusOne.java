import java.util.Stack;

/**
 * Created by zhengcong on 2017/8/16.
 * description:给定一个非负整数，它用一个数组表示(数组中的元素按顺序表示它的每一位)，求出该整数加1后对应的整数的数组表示
 */
public class PlusOne {

    //自己💩一样的实现
    public int[] plusOne_mime(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        for(int i:digits){
            stack.push(i);
        }
        int lastDigit = stack.pop();
        if (lastDigit + 1 < 10) {
            stack1.push(lastDigit + 1);
        } else {
            stack1.push(0);
        }
        while (!stack.empty()){
            int key = stack.pop();
            if(stack1.peek()==0){
                key++;
                if (key<10){
                    stack1.push(key);
                }else {
                    stack1.push(0);
                }
            }else {
                stack1.push(key);
                while (!stack.empty()){
                    stack1.push(stack.pop());
                }
                break;
            }
        }
        if(stack1.peek()==0){
            stack1.push(1);
        }
        int res[] = new int[stack1.size()];
        int i=0;
        while (!stack1.empty()){
            res[i]=stack1.pop();
            i++;

        }
        return res;
    }



    public int[] plusOne_better(int[] digits) {
        int n = digits.length;

        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int[n+1];
        newNumber[0] = 1;

        return newNumber;
    }


}
