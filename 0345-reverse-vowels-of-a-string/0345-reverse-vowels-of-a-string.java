class Solution {
    public static String reverseVowels(String s) {
        // Define the set of vowels
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            // Move left pointer to the next vowel
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }
            // Move right pointer to the previous vowel
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }

            // Swap vowels
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }
}