package DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        // ? array sorted
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        // ? temp arr
        for (int i : nums) {
            System.out.print(i + ",");
        }
        System.out.println();
        List<Integer> arr = new ArrayList<>();// []
        // [3, 4, 5, 10, 11, 12, 55] = (size) output should be 3
        for (int i = 0; i < nums.length; i++) { // i=
            int nextIndex = i + 1; //
            if (nextIndex == nums.length) {
                if (nums[i] == nums[i - 1] + 1) {
                    arr.add(nums[i]);
                } else {
                    arr.clear();
                }
            } else {
                int currentElement = nums[i];//
                int nextElement = nums[nextIndex];//
                if (currentElement + 1 == nextElement) {
                    arr.add(nums[i]);
                } else {
                    arr.clear();
                }
            }
        }
        return arr.size();
    }

    public static int longestConsecutiveAICorrect(int[] nums) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        for (int i : nums) {
            System.out.print(i + ",");
        }
        System.out.println();
        int maxLen = 1;
        int currLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] == nums[i - 1] + 1) {
                currLen++;
            } else {
                maxLen = Math.max(maxLen, currLen);
                currLen = 1;
            }
        }
        return Math.max(maxLen, currLen);
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 10, 11, 12, 55 };
        // System.out.println(nums[-1]);
        // System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutiveAICorrect(nums));

    }
}