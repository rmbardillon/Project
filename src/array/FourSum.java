package array;

import java.util.ArrayList;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int sum = 0;
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            result.add(nums[i]);
            for (int j = i + 1; j < nums.length - 2; j++) {
                result.add(nums[j]);
                for (int k = j + 1; k < nums.length - 1; k++) {
                    result.add(nums[k]);
                    for (int l = k + 1; l < nums.length; l++) {
                        result.add(nums[l]);
                        sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            results.add(new ArrayList<>(result));
                        }
                        result.remove(result.size() - 1);
                    }
                    result.remove(result.size() - 1);
                }
                result.remove(result.size() - 1
                );
            }
        }
        return results;
    }

    public static void main(String[] args) {
        FourSum fs = new FourSum();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> results = fs.fourSum(nums, target);
        for (List<Integer> result : results) {
            System.out.println(result);
        }
    }
}
