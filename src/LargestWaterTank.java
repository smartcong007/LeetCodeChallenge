/**
 * Created by zhengcong on 2017/10/19.
 * description: 给定一个非负数组,以数组下标为横坐标，对应的元素值为纵坐标形成唯一的坐标点，将所有坐标点向x轴作垂线，求两条垂线与x轴能构成最大面积
 */
public class LargestWaterTank {

    public static int maxArea(int[] height) {

        if(height.length<2){
            throw new IllegalArgumentException();
        }
        int max = 0;
        int i = 0;
        int j = height.length-1;
        while (i<j){
            if(height[i] <= height[j]){
                max = (j-i)*height[i]>max?(j-i)*height[i]:max;
                i++;
            }else {
                max = (j-i)*height[j]>max?(j-i)*height[j]:max;
                j--;
            }
        }
        return max;

    }




}
