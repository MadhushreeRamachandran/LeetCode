class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = 0;

        // Find the maximum number in the array for the binary search range
        for (int num : nums) {
            right = Math.max(right, num);
        }

        // Perform binary search to find the minimum penalty
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDivide(nums, mid, maxOperations)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canDivide(int[] nums, int maxPenalty, int maxOperations) {
        int operations = 0;
        for (int num : nums) {
            // Calculate the number of operations needed for the current bag
            if (num > maxPenalty) {
                operations += (num - 1) / maxPenalty;
            }
            if (operations > maxOperations) {
                return false;
            }
        }
        return true;
    }
}