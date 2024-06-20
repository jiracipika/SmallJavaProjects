/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Assignment 2, Question 3
Any and all work in this file is my own.
*/ 

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPairOfPoints {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static double closestPair(Point[] points) {
        Arrays.sort(points, Comparator.comparingInt(p -> p.x));
        return closestPairUtil(points, 0, points.length - 1);
    }

    static double closestPairUtil(Point[] points, int left, int right) {
        if (right - left <= 3) {
            return bruteForce(points, left, right);
        }

        int mid = (left + right) / 2;
        double dLeft = closestPairUtil(points, left, mid);
        double dRight = closestPairUtil(points, mid + 1, right);
        double d = Math.min(dLeft, dRight);

        return Math.min(d, stripClosest(points, left, right, mid, d));
    }

    static double bruteForce(Point[] points, int left, int right) {
        double minDist = Double.MAX_VALUE;
        for (int i = left; i <= right; ++i) {
            for (int j = i + 1; j <= right; ++j) {
                minDist = Math.min(minDist, distance(points[i], points[j]));
            }
        }
        return minDist;
    }

    static double distance(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    static double stripClosest(Point[] points, int left, int right, int mid, double d) {
        double min = d;
        for (int i = mid; i <= right; i++) {
            for (int j = mid - 1; j >= left; j--) {
                if (points[i].x - points[j].x < min) {
                    double dist = distance(points[i], points[j]);
                    if (dist < min) {
                        min = dist;
                    }
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Point[] points1 = {new Point(0, 0), new Point(1, 1), new Point(2, 2), new Point(3, 3)};
        System.out.println("Closest pair distance: " + closestPair(points1));

        Point[] points2 = {new Point(-2, -2), new Point(3, 4), new Point(0, 1), new Point(-1, 0), new Point(2, 3)};
        System.out.println("Closest pair distance: " + closestPair(points2));
    }
}
