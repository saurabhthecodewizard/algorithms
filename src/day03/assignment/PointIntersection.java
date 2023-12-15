package day03.assignment;

import java.util.Arrays;

public class PointIntersection {
    static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            return Integer.compare(this.x, other.x);
        }
    }

    private static int countIntersection(Point[] a, Point[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        return countIntersection(a, 0, a.length - 1, b, 0, b.length - 1);
    }

    private static int countIntersection(Point[] a, int startA, int endA, Point[] b, int startB, int endB) {
        if (startA > endA || startB > endB) {
            return 0;
        }

        int midA = (startA + endA) / 2;
        int midB = (startB + endB) / 2;

        int countLeft = countIntersection(a, startA, midA, b, startB, midB);
        int countRight = countIntersection(a, midA + 1, endA, b, midB + 1, endB);
        int countMerge = mergeAndCount(a, startA, midA, endA, b, startB, midB, endB);

        return countLeft + countRight + countMerge;
    }

    private static int mergeAndCount(Point[] a, int startA, int midA, int endA,
                                     Point[] b, int startB, int midB, int endB) {
        int count = 0;

        int i = startA, j = startB;
        while (i <= midA && j <= midB) {
            if (a[i].y < b[j].y) {
                i++;
            } else if (a[i].y > b[j].y) {
                j++;
            } else {
                count++;
                i++;
                j++;
            }
        }

        return count;
    }
}

