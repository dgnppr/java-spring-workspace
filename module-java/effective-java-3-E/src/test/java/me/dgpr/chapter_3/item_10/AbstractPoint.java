package me.dgpr.chapter_3.item_10;

public abstract class AbstractPoint {
    private final int x;
    private final int y;

    public AbstractPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof AbstractPoint;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AbstractPoint)) {
            return false;
        }
        AbstractPoint other = (AbstractPoint) obj;
        return other.canEqual(this) && this.x == other.x && this.y == other.y;
    }

    // 추상 메서드: 하위 클래스에서 구현
    protected abstract boolean isEquivalent(AbstractPoint other);
}

