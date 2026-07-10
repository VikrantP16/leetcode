class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        int n = points.length;
        
        // Test every unique combination of 3 points
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    
                    // Apply the Shoelace formula
                    double area = 0.5 * Math.abs(
                        points[i][0] * (points[j][1] - points[k][1]) + 
                        points[j][0] * (points[k][1] - points[i][1]) + 
                        points[k][0] * (points[i][1] - points[j][1])
                    );
                    
                    // Update maxArea if the current area is larger
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        return maxArea;
    }
}