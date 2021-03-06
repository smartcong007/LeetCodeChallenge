/**
 * Created by zhengcong on 2017/9/1.
 */
public class ReverseInteger {

    public static int reverse(int x) {
        long res = 0;
        while (x!=0){

            res=res*10+x%10;
            x=x/10;
        }
        if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE){
            return 0;
        }else {
            return (int) res;
        }
    }

    public static void main(String[] args) {
        int a = reverse(-1234);
        System.out.println(a);
    }

}
