package leetcode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Integers {
    public int[] twoSum(int[] nums, int target) {
        int current = 0;
        int[] result = new int[0];
        for (int i = 0; i < nums.length; i++) {
            current = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (current + nums[j] == target) {
                    result = new int[]{i, j};
                }
            }
        }

        return result;
    }
    public List<List<Integer>> getUniqueLists(List<List<Integer>> inputList) {
        Set<Set<Integer>> uniqueSets = new HashSet<>();
        List<List<Integer>> uniqueLists = new ArrayList<>();

        for (List<Integer> list : inputList) {
            Set<Integer> set = new HashSet<>(list); // Convert the list to a set to ignore order

            if (!uniqueSets.contains(set)) {
                uniqueSets.add(set);
                uniqueLists.add(list);
            }
        }

        return uniqueLists;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> initialResult = new ArrayList<>();
                        initialResult.add(nums[i]);
                        initialResult.add(nums[j]);
                        initialResult.add(nums[k]);
                        result.add(initialResult);
                    }
                }
            }
        }

        return getUniqueLists(result);
    }

    public int threeSumClosest(int[] nums, int target) {
        int difference = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int currentDifference = Math.abs(sum - target);
                    if(currentDifference < difference) {
                        difference = currentDifference;
                        result = sum;
                    }
                }
            }
        }
        return result;
    }
}
