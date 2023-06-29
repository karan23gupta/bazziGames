import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BalancedArray {

    public static int findPivotIndex(int[] nums) {
        int n = nums.length;

        // Create prefix sum array
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        // Create postfix sum array
        int[] postfixSum = new int[n];
        postfixSum[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            postfixSum[i] = postfixSum[i + 1] + nums[i];
        }

        // Find the pivot index
        for (int i = 0; i < n; i++) {
            if (prefixSum[i] == postfixSum[i]) {
                return i;
            }
        }
        // If no pivot index found, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int pivotIndex = findPivotIndex(nums);
        System.out.println("Pivot index: " + pivotIndex);
    }
}
