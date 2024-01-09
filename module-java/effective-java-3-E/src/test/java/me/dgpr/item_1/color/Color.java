package me.dgpr.item_1.color;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Color {
    private final int red;
    private final int green;
    private final int blue;

    private Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    // 정적 팩토리 메서드
    public static Color valueOf(int red, int green, int blue) {
        // 캐싱된 인스턴스가 있는지 확인
        return Cache.getColor(red, green, blue);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Color other) {
            return this.red == other.red && this.green == other.green && this.blue == other.blue;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue);
    }

    // 색상 객체를 캐시하는 내부 클래스
    private static class Cache {
        private static final Map<List<Integer>, Color> colorCache = new HashMap<>();

        static Color getColor(int red, int green, int blue) {
            List<Integer> key = Arrays.asList(red, green, blue);
            return colorCache.computeIfAbsent(key, k -> new Color(red, green, blue));
        }
    }
}

