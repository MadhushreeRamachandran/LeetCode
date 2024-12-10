import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int result = -1;

        
        for (int len = 1; len <= n; len++) {
            Map<String, Integer> frequencyMap = new HashMap<>();
            
            
            for (int i = 0; i <= n - len; i++) {
                String sub = s.substring(i, i + len);
                if (isSpecial(sub)) {
                    frequencyMap.put(sub, frequencyMap.getOrDefault(sub, 0) + 1);
                }
            }

            
            for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
                if (entry.getValue() >= 3) {
                    result = len;
                }
            }
        }

        return result;
    }

    
    private boolean isSpecial(String str) {
        char first = str.charAt(0);
        for (char c : str.toCharArray()) {
            if (c != first) {
                return false;
            }
        }
        return true;
    }

    
}

