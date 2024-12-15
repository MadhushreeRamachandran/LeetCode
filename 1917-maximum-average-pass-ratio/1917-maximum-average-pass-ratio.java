import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[][] classes = {{1, 2}, {3, 5}, {2, 2}};
        int extraStudents = 2;
        System.out.println(maxAverageRatio(classes, extraStudents));  // Output: 0.78333
    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(improvement(b), improvement(a)));

        for (int[] c : classes) {
            pq.offer(new double[]{c[0], c[1]});
        }

        for (int i = 0; i < extraStudents; i++) {
            double[] c = pq.poll();
            c[0]++;
            c[1]++;
            pq.offer(c);
        }

        double totalRatio = 0;
        int n = classes.length;
        while (!pq.isEmpty()) {
            double[] c = pq.poll();
            totalRatio += c[0] / c[1];
        }

        return totalRatio / n;
    }

    private static double improvement(double[] c) {
        return (c[0] + 1) / (c[1] + 1) - c[0] / c[1];
    }
}
