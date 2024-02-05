package me.dgpr.chapter_3.item_10;


public class ConcretePoint extends AbstractPoint {
    private final Color color;

    public ConcretePoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    // 실제 동등성 비교를 수행
    @Override
    protected boolean isEquivalent(AbstractPoint other) {
        if (!(other instanceof ConcretePoint)) {
            return false;
        }
        ConcretePoint obj = (ConcretePoint) other;
        return this.color.equals(obj.color);
    }

    @Override
    protected boolean canEqual(Object obj) {
        return obj instanceof ColorPoint;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && isEquivalent((AbstractPoint) obj);
    }

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        ConcretePoint cp1 = new ConcretePoint(1, 2, Color.RED);
        ConcretePoint cp2 = new ConcretePoint(1, 2, Color.BLUE);

        System.out.println(cp1.equals(p)); // false
        System.out.println(p.equals(cp2)); // false
        System.out.println(cp1.equals(cp2)); // false
    }
}