import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengcong on 2017/8/16.
 * description:给定一个字符串，求出不包含重复字符的最长连续子串
 */
public class NoRepeatingSubstring {

    //自己💩一样的实现
    public int lengthOfLongestSubstring_mime(String s) {

        if(s == null || s.equals("")){
            return 0;
        }

        int minLength = 0;

        char []chars = s.toCharArray();
        int length = chars.length;

        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<length;i++){
            int count = 0;
            map.put(chars[i],1);
            count++;
            for(int j=i+1;j<length;j++){
                if(map.get(chars[j])!=null){
                    break;
                }else {
                    map.put(chars[j],1);
                    count++;
                }
            }
            if(count > minLength){
                minLength = count;
            }
            map.clear();
        }
        return minLength;
    }

    //大神非常💯的实现
    public int lengthOfLongestSubstring_better(String s) {
        if (s.length() == 0) return 0;
        // for ASCII char sequence, use this as a hashmap
        int[] idx = new int[256];
        //initaize arr to -1 inorder to correct calculate interval
        for(int i = 0 ; i < idx.length; i++) {
            idx[i] = -1;
        }
        int max = 0, m = 0;
        for (int i = 0; i < s.length(); i++){
            int ascii = (int) (s.charAt(i));
            m = Math.max(idx[ascii] + 1, m);
            idx[ascii] = i;
            max = Math.max(max, i - m + 1);
        }
        return max;
    }

}
