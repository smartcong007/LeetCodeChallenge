/**
 * Created by zhengcong on 2017/9/30.
 * description: 在不使用额外内存的情况下判断一个整数是否是回文
 */
public class PalindromeNumber {

    public boolean myMethod(int x){
        if(x<0){
            return false;
        }else if(x<10){
            return true;
        }
        int digit  = (int) Math.log10(x);
        int offsent = 1;
        while (digit>=offsent){
            int off = (int) (x%(Math.pow(10,offsent))/(Math.pow(10,offsent-1)));
            int up = (int) (x/(Math.pow(10,digit))%10);
            if(off != up){
                return false;
            }
            digit--;
            offsent++;
        }
        return true;
    }

    public boolean betterMethod(int x){

        long reverse=0;
        long remainder=0;
        // Verify provided integer is valid integer
        if(x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE)
            return false;
        // Check if integer provided is a single digit
        if(x >= 0 && x < 10)
            return true;
        long y = x;
        // Check if integer reversed equals integer provided
        while(y>0)
        {
            reverse*=10;
            remainder = y%10;
            reverse += remainder;
            y/=10;
        }

        if(x == (int)reverse)
            return true;
        return false;

    }

}
