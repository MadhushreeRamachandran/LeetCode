class Solution {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        
        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0) {
                // Check previous and next plots
                boolean canPlant = (i == 0 || flowerbed[i - 1] == 0) &&
                                   (i == length - 1 || flowerbed[i + 1] == 0);
                
                if (canPlant) {
                    flowerbed[i] = 1; // Plant a flower
                    n--; // Decrement the number of flowers left to plant
                    
                    if (n == 0) return true; // Early exit if all flowers are planted
                }
            }
        }
        
        return n <= 0; // Check if all flowers were planted
    }
}