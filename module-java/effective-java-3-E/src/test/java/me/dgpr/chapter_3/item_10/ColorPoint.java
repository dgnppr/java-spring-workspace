package me.dgpr.chapter_3.item_10;

public class ColorPoint {

    private final Point point;
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = color;
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ColorPoint)) {
            return false;
        }
        ColorPoint cp = (ColorPoint) obj;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        ColorPoint cp1 = new ColorPoint(1, 2, Color.RED);
        ColorPoint cp2 = new ColorPoint(1, 2, Color.BLUE);

        System.out.println(cp1.equals(p)); // false
        System.out.println(p.equals(cp2)); // false
        System.out.println(cp1.equals(cp2)); // false
    }
}
