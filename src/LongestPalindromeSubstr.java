/**
 * Created by zhengcong on 2017/8/21.
 * 寻找一个字符串中的最长回文子串
 */
public class LongestPalindromeSubstr {

    //自己的效率有点糟糕
    public String longestPalindrome_mime(String s){

        if (s == null || s.length()==0 || s.length()>1000){
            throw new IllegalArgumentException();
        }

        char []ss = s.toCharArray();
        String res = "";
        for(int i=0;i<s.length();i++){
            if(s.length()-i<res.length()){
                return res;
            }
            int []tes = getPalindrome(i,s.length()-1,ss);
            if(tes != null){
                if(tes[1]-tes[0]+1>res.length()){
                    res = s.substring(tes[0],tes[1]+1);
                }
            }
        }
        return s.charAt(0)+"";

    }

    public int[] getPalindrome(int i,int j,char []s){

        if(i==j){
            return null;
        }

        int k=i,m=j;
        while (k<m){
            if(s[k] == s[m]){
                k++;
                m--;
            }else {
                break;
            }
        }
        if(k<m){
            return getPalindrome(i,--j,s);
        }else {
            return new int[]{i,j};
        }

    }

    //非常高效的解法，我自己判断回文是从两边向中间逐步判断，这里先找到相等的一部分元素作为中间再向两边逐步判断，效率高了十几倍
    public String longestPalindrome_better(String s) {
        if (s.length() < 2) return s;
        char[] value = s.toCharArray();
        int maxLength = 0, maxi = 0, maxj = 0;

        for (int il = 0; il < value.length; ) {
            //其实就是寻找能作为回文子串中间部分的元素
            int ir = il + 1;
            while (ir < value.length && value[ir] == value[il]) {
                ir++;
            }
            ir--;
            //计算以il到ir位置的元素为中间元素向两边能维持回文判断的最大深度
            int dist = PalindromeDistance(value, il, ir);
            int thisLeft = il - dist, thisRight = ir + dist, len=thisRight - thisLeft;
            //update max
            if (len > maxLength) {
                maxLength=len;
                maxi=thisLeft;
                maxj=thisRight;
            }
            il = ir + 1; //寻找下一串能作为中间元素的子串
        }
        return s.substring(maxi,maxj+1);
    }
    public static int PalindromeDistance(char[] arr, int ileft,int iright){
        int maxLeft=ileft-1,maxRight=iright+1,distance=0;
        while(maxLeft>=0&&maxRight<arr.length){
            if(arr[maxLeft]==arr[maxRight]){
                distance++;
                maxLeft--;
                maxRight++;
            }
            else break;
        }
        return distance;
    }


}
