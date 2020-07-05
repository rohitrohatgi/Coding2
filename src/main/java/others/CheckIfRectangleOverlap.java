package others;
/*
Java program to check if rectangles overlap

l1: Top Left coordinate of first rectangle.
r1: Bottom Right coordinate of first rectangle.
l2: Top Left coordinate of second rectangle.
r2: Bottom Right coordinate of second rectangle.

 */
public class CheckIfRectangleOverlap {
    static class Point {

        int x, y;
    }

    // Returns true if two rectangles (l1, r1) and (l2, r2) overlap
    /*
        l1: Top Left coordinate of first rectangle.
        r1: Bottom Right coordinate of first rectangle.
        l2: Top Left coordinate of second rectangle.
        r2: Bottom Right coordinate of second rectangle.

      */
    static  boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        if( l1.x >= r2.x || l2.x >= r1.x){
            return false;
        }
        if( r1.y >= l2.y || r2.y >= l1.y){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Point l1 = new Point(),r1 = new Point(),
                l2 = new Point(),r2 = new Point();
        l1.x=0;l1.y=10; r1.x=10;r1.y=0;
        l2.x=5;l2.y=5; r2.x=15;r2.y=0;

        if (doOverlap(l1, r1, l2, r2)) {
            System.out.println("Rectangles Overlap");
        } else {
            System.out.println("Rectangles Don't Overlap");
        }
    }

}
