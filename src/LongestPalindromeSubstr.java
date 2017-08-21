/**
 * Created by zhengcong on 2017/8/21.
 * 寻找一个字符串中的最长回文子串
 */
public class LongestPalindromeSubstr {

    //自己的效率有点糟糕
    public String longestPalindrome(String s){

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


}
