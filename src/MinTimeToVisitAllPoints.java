public class MinTimeToVisitAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int minTime = 0;

        for (int i = 0; i < points.length - 1; i++) {
            int[] currentPoint = points[i];
            int[] nextPoint = points[i + 1];

            int dx = Math.abs(nextPoint[0] - currentPoint[0]);
            int dy = Math.abs(nextPoint[1] - currentPoint[1]);

            minTime += Math.max(dx, dy); // Diagonal movement takes longer, so choose the maximum of dx and dy

        }

        return minTime;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {4, 5},
                {7, 8}
        };

        int minTime = new MinTimeToVisitAllPoints().minTimeToVisitAllPoints(matrix);
        System.out.println(minTime);
    }
}
