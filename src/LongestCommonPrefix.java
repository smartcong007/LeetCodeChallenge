/**
 * Created by zhengcong on 2017/10/23.
 * description: 找出一个字符串数组中的最长公有前缀
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String shotestStr = strs[0];
        for (String s : strs) {
            while (!s.startsWith(shotestStr)) {
                shotestStr = shotestStr.substring(0, shotestStr.length() - 1);
                if(shotestStr.equals("")){
                    return shotestStr;
                }
            }
        }

        return shotestStr;
    }


}
