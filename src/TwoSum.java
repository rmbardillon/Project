public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2]; // Initialize the output array with a size of 2

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) { // Start j from i + 1 to avoid using the same element twice
                if (nums[i] + nums[j] == target) {
                    output[0] = i;
                    output[1] = j;
                    return output; // Found the pair, return the output array
                }
            }
        }

        return output; // No pair found, return the output array with default values (0s)
    }
}
