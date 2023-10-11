/*
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                result[0] = numMap.get(complement) + 1;
                result[1] = i + 1;
                return result;
            }
            numMap.put(nums[i], i);
        }

        return result;
    }
}
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1;
    while (numbers[left] + numbers[right] != target) {
        if (numbers[left] + numbers[right] > target) {
            right--;
        }
        else {
            left++;
        }
        if (right == left) {
            return new int[]{};
        }
    }

    return new int[]{left + 1, right + 1};
    }
}
