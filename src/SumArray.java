import java.util.Arrays;

public class SumArray {
    public int arraySumWithoutSmallestLargest(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || i == nums.length - 1) {
                continue;
            }
            result += nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {999,1,2,3};
        SumArray sumArray = new SumArray();

        System.out.println(sumArray.arraySumWithoutSmallestLargest(nums));
    }
}
