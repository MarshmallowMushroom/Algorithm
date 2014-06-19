/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*/


/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length == 0)
            return 0;
        int max = 1;
        for (int i = 0; i < points.length; i++) {
            int samePoint = 0;
            int tmpMax = 1;
            Point original = points[i];
            HashMap<Double, Integer> slopeMap = new HashMap<Double, Integer>();
            for (int j = i+1; j < points.length; j++) {
                Point second = points[j];
                if (isSamePoint(original, second))
                    samePoint++;
                else {
                    double slope = getSlope(original, second);
                    if (slopeMap.containsKey(slope))
                        slopeMap.put(slope, slopeMap.get(slope) + 1);
                    else
                        slopeMap.put(slope, 2);
                    tmpMax = Math.max(tmpMax, slopeMap.get(slope));
                }
            }
            max = Math.max(max, tmpMax + samePoint);
        }
        return max;
    }
    
    private boolean isSamePoint(Point p1, Point p2) {
        return (p1.x == p2.x && p1.y == p2.y);
    }
    
    private double getSlope(Point p1, Point p2) {
        if (p1.x == p2.x)
            return Double.POSITIVE_INFINITY;
        //notice double differs +0.0 and -0.0
        if (p1.y == p2.y)
            return 0.0;
        return ((double)p1.y - (double)p2.y)/((double)p1.x - (double)p2.x);
    }
}
