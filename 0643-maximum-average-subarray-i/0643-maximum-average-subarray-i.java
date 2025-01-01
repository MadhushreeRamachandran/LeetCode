public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAverage;
        int windowSum = 0;
        
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        maxAverage = (double) windowSum / k;
        int currentSum = windowSum;

        for (int i = k; i < nums.length; i++) {
            currentSum += nums[i] - nums[i - k];
            maxAverage = Math.max(maxAverage, (double) currentSum / k);
        }

        return maxAverage;
    }
}