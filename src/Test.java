class Point {
    private static int count = 0;
    private Point() {
        System.out.println("New Instance Created");
    }

    public static Point getInstance() {
        if(count<2) {
            count++;
            return new Point();
        }
        else {
            return null;
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Point a = Point.getInstance();
        Point b = Point.getInstance();
        Point c = Point.getInstance();
    }
}