import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengcong on 2017/8/16.
 * description:给定一个数组和一个目标值，请找出数组中和等于目标值的两个元素的数组下标，用数组返回
 */
public class TwoSum {

    public int[] twoSum_mine(int[] nums, int target) {

        int res[]=new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int k=0;k<nums.length;k++){

            Integer ta = map.get(target-nums[k]);
            if(ta!=null&&ta!=k){
                res[0]=k;
                res[1]=ta;
                return res;
            }
        }
        return null;

    }


    public int[] twoSum_better(int[] nums, int target) {
        int[] map = new int[20050];
        int size = 5;
        for (int i = 0; i < nums.length; i++) {
            map[nums[i] + size] = (i + 1);
            int diff = target - nums[i + 1] + size;
            if (diff < 0) continue;
            int d = map[diff];
            if (d > 0)
                return new int[]{d - 1, i + 1};
        }
        return null;
    }

}
