/**
 * Created by zhengcong on 2017/8/17.
 * description:给定两个大小分别为m,n的有序数组，请求出他们的中位数，要求时间复杂度为o(lg(m+n))。
 */
public class MedianOfTwoSortedArrays {

    /**
     * 此题被定级为难题，我是在参考了别人的discuss后才写出来的解法。思想单独在MedianOfTwoSortedArrays.txt中介绍
     *
     * */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length<=nums2.length){
            return transition(nums1,nums2);
        }else {
            return transition(nums2,nums1);
        }

    }

    public double transition(int[] nums1, int[] nums2){
        int n = nums1.length;
        int m = nums2.length;
        if (m == 0){
            throw new RuntimeException("数组均为空不合法");
        }
        int half = (n+m+1)/2;
        int min = 0;
        int max = n;
        int max_of_left = 0;
        int min_of_right = 0;
        while (min<=max){
            int i = (min+max)/2;
            int j = half - i;
            if(i<n && nums2[j-1]>nums1[i]){
                min = i+1;
            }else if(i>0 && nums1[i-1]>nums2[j]){
                max = i-1;
            }else {
                if(i==0){
                    max_of_left = nums2[j-1];
                }else if(j == 0){
                    max_of_left = nums1[i-1];
                }else {
                    max_of_left = Math.max(nums1[i-1],nums2[j-1]);
                }

                if((m+n)%2==1){
                    return max_of_left;
                }
                if (i == n){
                    min_of_right = nums2[j];
                }else if(j == m){
                    min_of_right = nums1[i];
                }else {
                    min_of_right = Math.min(nums1[i],nums2[j]);
                }
                return (max_of_left+min_of_right)/2.0;
            }
        }
        return 0;
    }

}
