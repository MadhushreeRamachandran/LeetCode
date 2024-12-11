class Solution {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stores indices of temperatures
        
        for (int i = 0; i < n; i++) {
            // While the current temperature is warmer than the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index; // Calculate days difference
            }
            stack.push(i); // Push current index onto the stack
        }
        
        // Remaining indices in the stack will have answer[i] = 0 (default)
        return answer;
    }
}